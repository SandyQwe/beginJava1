package geekbrains.java2.lesson4.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame {

    ClientWindow(){
        setTitle("Chat Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setLayout(new BorderLayout());

        //Основное меню - на будущее
        JMenuBar mainMenu = new JMenuBar();
        JMenu mainMenuFirst = new JMenu("Main");
        mainMenuFirst.setMnemonic(0);
        mainMenuFirst.add(new JMenuItem("Register..."), 0);
        mainMenuFirst.add(new JMenuItem("Login..."), 0);
        mainMenuFirst.add(new JMenuItem("Change password..."), 0);
        mainMenuFirst.add(new JMenuItem("Logout"), 1);
        mainMenuFirst.add(new JMenuItem("Exit", 2)).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenu mainMenuSecond = new JMenu("Chat");
        mainMenuSecond.setMnemonic(0);
        mainMenuSecond.add(new JMenuItem("Clear chat window"));
        mainMenuSecond.add(new JMenuItem("Save chat to file..."));
        JMenu mainMenuLast = new JMenu("Help");
        mainMenuLast.setMnemonic(0);
        mainMenu.add(mainMenuFirst);
        mainMenu.add(mainMenuSecond);
        mainMenu.add(mainMenuLast);
        add(mainMenu, BorderLayout.NORTH);


        setVisible(true);
    }

}
