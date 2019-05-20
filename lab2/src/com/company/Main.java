package com.company;

import org.xml.sax.SAXException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;
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
        JComboBox colStrok = new JComboBox();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Файл");
        JMenuItem addMenuItem = new JMenuItem("добавить пациента");
        JMenuItem findMenuItem = new JMenuItem("найти пациента");
        JMenuItem deleteMenuItem = new JMenuItem("удалить пациента");
        JMenuItem saveMenuItem = new JMenuItem("сохранить");
        JMenuItem uploadMenuItem = new JMenuItem("загрузить");

        JDialog addDialog = new JDialog();

        JTable table = new JTable(0,0);
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        JFrame container = new JFrame() {};
        container.setVisible(true);
        container.setBounds(100, 10, 1200, 330);
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
        model.addColumn("ФИО пациента");
        model.addColumn("Адрес прописки");
        model.addColumn("Дата рождения");
        model.addColumn("Дата приёма");
        model.addColumn("ФИО врача");
        model.addColumn("Заключение");
        table.getColumnModel().getColumn(0).setPreferredWidth(80);

        ArrayList<Pacient> pacientArrayList = new SAXExample().getPacients();
        ArrayList<Medic> medicArrayList = new SAXExample().getMedics();


        for (Medic medic : medicArrayList) {
            for (Pacient pacient : pacientArrayList) {
                    model.addRow(new Object[]{pacient.getFullName(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(),medic.getMedicFullName(), pacient.getResume()});
            }
        }


        container.add(scrollPane, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.add(addButton);
        addButton.addActionListener(new addButtonEvent());
        leftPanel.add(findButton);
        leftPanel.add(deleteButton);
        buttonPanel.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel();
        rightPanel.add(firstPageButton);
        rightPanel.add(backButton);
        rightPanel.add(forwardButton);
        rightPanel.add(lastPageButton);
        buttonPanel.add(rightPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.add(uploadButton);
        centerPanel.add(saveButton);
        buttonPanel.add(centerPanel, BorderLayout.EAST);

        JPanel upPanel = new JPanel();
        // сделать нормальые странички
        JPanel uprightPanel = new JPanel();
        uprightPanel.add(new JLabel(" страница "));
        uprightPanel.add(new JLabel("1"));
        uprightPanel.add(new JLabel(" из "));
        uprightPanel.add(new JLabel("5"));
        JPanel upLeftPanel = new JPanel();
        upLeftPanel.add(new Label("строк в таблице:"));
        upLeftPanel.add(colStrok);
        upPanel.add(upLeftPanel, BorderLayout.WEST);
        upPanel.add(uprightPanel, BorderLayout.EAST);
        buttonPanel.add(upPanel, BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);
    }

    class addButtonEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JDialog dialog = new JDialog();
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setSize(180, 90);

        }
    }
}
