package geekbrains.java2.chat.client;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

class ClientWindow extends JFrame {
    private Socket sock = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private boolean auth = false;
    private JTextArea mainChatText = new JTextArea(); //Поле для вывода текста чата
    private JTextField textField = new JTextField(); //Поле для ввода текста пользователем
    private PrintWriter chatTextFile = null;
    private String nick;


    ClientWindow() {
        final ActionListener sendText = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().equals("")) {
                    printMsg(textField.getText());
                    sendMsg();
                }
            }
        }; //ActionListener для отправки текста и записи его в файл, используется в текстовом поле и в кнопке

        try {
            chatTextFile = new PrintWriter(new FileWriter("chatText.txt", true), true);
        } catch (IOException e) {
            e.printStackTrace();
        } //открытие файла на запись текста чата

        setTitle("Chat Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setLayout(new BorderLayout());

        //Основное меню - на будущее
        JMenuBar mainMenu = new JMenuBar();
        JMenu mainMenuFirst = new JMenu("Main");
        mainMenuFirst.setMnemonic(KeyEvent.VK_M);
        mainMenuFirst.add(new JMenuItem("Register...", KeyEvent.VK_R));
        mainMenuFirst.add(new JMenuItem("Login...", KeyEvent.VK_L));
        mainMenuFirst.add(new JMenuItem("Change password...", KeyEvent.VK_N));
        mainMenuFirst.add(new JMenuItem("Logout", KeyEvent.VK_O));
        mainMenuFirst.add(new JMenuItem("Exit", KeyEvent.VK_X)).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenu mainMenuSecond = new JMenu("Chat");
        mainMenuSecond.setMnemonic(KeyEvent.VK_C);
        mainMenuSecond.add(new JMenuItem("Clear chat window", KeyEvent.VK_E));
        mainMenuSecond.add(new JMenuItem("Save chat to file...", KeyEvent.VK_S));
        JMenu mainMenuLast = new JMenu("Help");
        mainMenuLast.setMnemonic(KeyEvent.VK_F1);
        mainMenu.add(mainMenuFirst);
        mainMenu.add(mainMenuSecond);
        mainMenu.add(mainMenuLast);
        add(mainMenu, BorderLayout.NORTH);

        //Основное окно чата, переписка
        mainChatText.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        mainChatText.setBackground(Color.WHITE);
        mainChatText.setEditable(false);
        JScrollPane mainChatScroll = new JScrollPane(mainChatText);
        add(mainChatScroll, BorderLayout.CENTER);

        //Нижняя часть окна, область для набора текста и кнопка отправки
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        textField.addActionListener(sendText);
        JButton sendTextButton = new JButton("Send");
        sendTextButton.setMnemonic(KeyEvent.VK_ENTER);
        sendTextButton.addActionListener(sendText);
        bottomPanel.add(textField, BorderLayout.CENTER);
        bottomPanel.add(sendTextButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        textField.requestFocus();

        connect();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                chatTextFile.close();
                disconnect();
            }
        });
        //// TODO: 11.10.2016 сделать окошко авторизации

        setVisible(true);
    }

    private void sendMsg() {
        String str = textField.getText();
        try {
            out.writeUTF(str);
            out.flush();
            textField.setText("");
            textField.requestFocus();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Невозможно отослать сообщение. Проверьте сетевое подключение");
        }
    }

    private void sendAuthMsg(String login, String pass) {
        try {
            out.writeUTF("/auth " + login + " " + pass);
            out.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Невозможно произвести попытку авторизации. Проверьте сетевое подключение");
        }
    }

    public void connect() {
        try {
            if (sock == null) {
                sock = new Socket("83.221.205.67", 8189);
                in = new DataInputStream(sock.getInputStream());
                out = new DataOutputStream(sock.getOutputStream());

                new Thread(() -> {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str != null) {
                                if (str.startsWith("/authok")) { // /authok NAME
                                    setNick(str.split(" ")[1]);
                                    break;
                                }
                                if (str.startsWith("...")){
                                    printMsg(str);
                                }
                            }
                        }

                            while (true) {
                                String str = in.readUTF();
                                if (str != null) {
                                    if (str.startsWith("/")) {
                                        if (str.startsWith("/nickchanged")) {
                                            String newNick = str.split(" ")[1];
                                            setNick(newNick);
                                        }
                                        if (str.equals("/endsession")) {
                                            setNick("");
                                            break;
                                        }
                                    } else {
                                        printMsg(str);
                                    }
                                }
                            }
                        } catch(IOException e){
                            JOptionPane.showMessageDialog(null, "Обрыв соединения");
                            setNick("");
                            printMsg("Session closed...");
                        } finally{
                            try {
                                sock.close();
                                sock = null;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, "Невозможно подключиться к серверу");
            }
        }

    private void setNick(String nick) {
        this.nick = nick;
        if (!nick.isEmpty()) {
            this.setTitle("Клиент: " + nick);
//            enableAuthPanel(false);
        } else {
            this.setTitle("Клиент: не авторизован");
//            enableAuthPanel(true);
        }
    }

    private void disconnect() {
        try {
            sock.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Соединение закрыто");
        }
        setNick("");
//        enableAuthPanel(true);
    }

    private void printMsg(String message) {
        if (!nick.equals("")) {
            chatTextFile.append(message);
            chatTextFile.append("\n");
            chatTextFile.flush();
            mainChatText.append(message + "\n");
            mainChatText.setCaretPosition(mainChatText.getDocument().getLength());
        } else {
            mainChatText.append("Authorisation needed...\n");
            mainChatText.setCaretPosition(mainChatText.getDocument().getLength());
        }
    }

}