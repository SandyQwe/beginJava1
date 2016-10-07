package geekbrains.java2.lesson6.homework.chatClient;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

class ClientWindow extends JFrame {

    Socket sock = null;
    DataInputStream in = null;
    DataOutputStream out = null;

    private JTextArea mainChatText = new JTextArea(); //Поле для вывода текста чата
    private JTextField textField = new JTextField(); //Поле для ввода текста пользователем
    private PrintWriter chatTextFile = null;

    ClientWindow(){
        final ActionListener sendText = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().equals("")) {
                    try {
                        chatTextFile = new PrintWriter(new FileWriter("chatText.txt", true), true);
                        chatTextFile.append(textField.getText());
                        chatTextFile.append("\n");
                        chatTextFile.flush();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    mainChatText.append(textField.getText() + "\n");
                    mainChatText.setCaretPosition(mainChatText.getDocument().getLength());
                    sendMsg();
//                    textField.setText("");
//                    textField.requestFocus();
                }
            }
        }; //ActionListener для отправки текста и записи его в файл, используется в текстовом поле и в кнопке

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

        connect();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                chatTextFile.close();
                disconnect();
            }
        });

        setVisible(true);
    }

    public void sendMsg() {
        String str = textField.getText();
        textField.setText("");
        textField.requestFocus();
        try {
            out.writeUTF(str);
            out.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Connection error...");
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            sock = new Socket("83.221.205.67", 8189);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                while (true) {
                    String str = in.readUTF();
                    if(str != null) {
                        mainChatText.append(str);
                        mainChatText.append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void disconnect() {
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}