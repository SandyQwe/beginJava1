package geekbrains.java2.lesson4.homework;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ClientWindow extends JFrame {

    ClientWindow(){
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
        JTextArea mainChatText = new JTextArea();
        mainChatText.setBorder(new LineBorder(Color.DARK_GRAY, 1));
        mainChatText.setBackground(Color.WHITE);
        mainChatText.setEditable(false);
        JScrollPane mainChatScroll = new JScrollPane(mainChatText);
        add(mainChatScroll, BorderLayout.CENTER);
        mainChatText.setText("Text");

        //Нижняя часть окна, область для набора текста и кнопка отправки
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        JTextField textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().equals("")) {
                    mainChatText.append(textField.getText() + "\n");
                    mainChatText.setCaretPosition(mainChatText.getDocument().getLength());
                    textField.setText("");
                    textField.requestFocus();
                }
            }
        });
        JButton sendTextButton = new JButton("Send");
        sendTextButton.setMnemonic(KeyEvent.VK_ENTER);
        sendTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().equals("")) {
                    mainChatText.append(textField.getText() + "\n");
                    mainChatText.setCaretPosition((mainChatText.getDocument().getLength()));
                    textField.setText("");
                    textField.requestFocus();
                }
            }
        });
        bottomPanel.add(textField, BorderLayout.CENTER);
        bottomPanel.add(sendTextButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

}