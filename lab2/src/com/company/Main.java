package com.company;

import org.xml.sax.SAXException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        JButton deleteButton = new JButton("удалить");

        JButton saveButton = new JButton("сохранить");
        JButton uploadButton = new JButton("загрузить");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Файл");
        JMenuItem addMenuItem = new JMenuItem("добавить пациента");
        JMenuItem findMenuItem = new JMenuItem("найти пациента");
        JMenuItem deleteMenuItem = new JMenuItem("удалить пациента");
        JMenuItem saveMenuItem = new JMenuItem("сохранить");
        JMenuItem uploadMenuItem = new JMenuItem("загрузить");


        menu1.add(addMenuItem);
        menu1.add(findMenuItem);
        menu1.add(deleteMenuItem);
        menu1.add(saveMenuItem);
        menu1.add(uploadMenuItem);
        menuBar.add(menu1);

        Button butt = new Button();

        List pacientArrayList = new SAXExample().getPacients();

        JFrame container = new TablePaginator(pacientArrayList).getView();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.add(butt.addButton);



        leftPanel.add(butt.findButton);

        leftPanel.add(deleteButton);
        buttonPanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.add(uploadButton);
        centerPanel.add(saveButton);
        buttonPanel.add(centerPanel, BorderLayout.EAST);

        JPanel upPanel = new JPanel();

        buttonPanel.add(upPanel, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);

        container.setVisible(true);
        container.setBounds(100, 10, 1200, 340);
        container.setJMenuBar(menuBar);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
