package com.company;

import org.xml.sax.SAXException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class Main {




    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {



        JButton addButton = new JButton("добавить");
        JButton findButton = new JButton("найти");
        JButton deleteButton = new JButton("удалить");

        JButton forwardButton = new JButton("►");
        JButton backButton = new JButton("◄");
        JButton firstPageButton = new JButton("◄◄");
        JButton lastPageButton = new JButton("►►");

        JButton saveButton = new JButton("сохранить");
        JButton uploadButton = new JButton("загрузить");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Файл");
        JMenuItem addMenuItem = new JMenuItem("добавить пациента");
        JMenuItem findMenuItem = new JMenuItem("найти пациента");
        JMenuItem deleteMenuItem = new JMenuItem("удалить пациента");
        JMenuItem saveMenuItem = new JMenuItem("сохранить");
        JMenuItem uploadMenuItem = new JMenuItem("загрузить");

        String[] columnNames = {
                "ФИО пациента",
                "Адрес прописки",
                "Дата рождения",
                "Дата приёма",
                "ФИО врача",
                "Заключение"
        };
        String[][] data = {
        };

        JTable table = new JTable(data, columnNames);
     //   DefaultTableModel model = (DefaultTableModel) table.getModel();

        SAXExample app = new SAXExample();
        app.getPacients();



        JFrame container = new JFrame() {};
        container.setVisible(true);
        container.setBounds(150, 10, 1000, 300);
        container.setJMenuBar(menuBar);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu1.add(addMenuItem);
        menu1.add(findMenuItem);
        menu1.add(deleteMenuItem);
        menu1.add(saveMenuItem);
        menu1.add(uploadMenuItem);
        menuBar.add(menu1);

        container.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(
                new Dimension(
                        table.getPreferredScrollableViewportSize().width,
                        10 * table.getRowHeight()
                ));
 /*       model.addColumn("ФИО пациента");
        model.addColumn("Адрес прописки");
        model.addColumn("Дата рождения");
        model.addColumn("Дата приёма");
        model.addColumn("ФИО врача");
        model.addColumn("Заключение");
*/
//        model.addRow(data);
/*
        ArrayList<Hospital> pacientArrayList = new SAXExample().getPacients();
        System.out.println(pacientArrayList);
*/
        container.add(scrollPane, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout());
        leftPanel.add(addButton);
        leftPanel.add(findButton);
        leftPanel.add(deleteButton);
        buttonPanel.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout());
        rightPanel.add(firstPageButton);
        rightPanel.add(backButton);
        rightPanel.add(forwardButton);
        rightPanel.add(lastPageButton);
        buttonPanel.add(rightPanel, BorderLayout.EAST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(uploadButton);
        centerPanel.add(saveButton);
        buttonPanel.add(centerPanel);

        container.add(buttonPanel, BorderLayout.SOUTH);

    }


}
