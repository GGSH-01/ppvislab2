package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class TablePaginator {
    private int currentPage;
    private int recordsOnPage = 10;
    private List<Pacient> pacients;
    private List<List<Pacient>> pages = new ArrayList<>();
    private JTable table = new JTable(0,0);
    private DefaultTableModel model = (DefaultTableModel) table.getModel();
    private JLabel nowPageNum = new JLabel("1");
    private JLabel lastPageNum = new JLabel();
    private JTextField viborColStr = new JTextField(5);


    TablePaginator(List<Pacient> pacients) {
        this.pacients = pacients;
        if (!pacients.isEmpty()) {
            for (int i = 0; i < pacients.size(); i+=recordsOnPage) {
                pages.add(pacients.subList(i, Math.min(pacients.size(), i + recordsOnPage)));
            }

            this.pacients = pacients;
            this.currentPage = 0;
        }
    }


    public JFrame getView() {
        JButton forwardButton = new JButton("►");
        JButton backButton = new JButton("◄");
        JButton firstPageButton = new JButton("◄◄");
        JButton lastPageButton = new JButton("►►");



        JFrame container = new JFrame() {};

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

        for (Pacient pacient : pages.get(currentPage)) {
            model.addRow(new Object[]{pacient.getFullName(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(), pacient.getMedic().getMedicFullName(), pacient.getResume()});
        }

        JPanel uprightPanel = new JPanel();

        uprightPanel.add(new JLabel(" страница "));

        uprightPanel.add(nowPageNum);

        uprightPanel.add(new JLabel(" из "));

        lastPageNum.setText(Integer.toString(pages.size()));
        uprightPanel.add(lastPageNum);

        JPanel upLeftPanel = new JPanel();
        upLeftPanel.add(new Label("строк в таблице:"));
        upLeftPanel.add(viborColStr);
        JButton colStrInTable = new JButton("установить");
        colStrInTable.addActionListener(new ColStrInTableEvent());
        upLeftPanel.add(colStrInTable);

        JPanel rightPanel = new JPanel();
        firstPageButton.addActionListener(new FitstPageButtonEvent());
        rightPanel.add(firstPageButton);

        backButton.addActionListener(new BackButtonEvent());
        rightPanel.add(backButton);

        forwardButton.addActionListener(new ForwardButtonEvent());
        rightPanel.add(forwardButton);

        lastPageButton.addActionListener(new LastPageButtonEvent());
        rightPanel.add(lastPageButton);

        container.add(rightPanel);
        container.add(upLeftPanel, BorderLayout.WEST);
        container.add(uprightPanel, BorderLayout.EAST);
        container.add(scrollPane, BorderLayout.NORTH);

        return container;
    }


    class FitstPageButtonEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (currentPage<1){}
            else {
                currentPage = 0;
                model.setRowCount(0);
                for (Pacient pacient : pages.get(currentPage)) {
                    model.addRow(new Object[]{pacient.getFullName(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(), pacient.getMedic().getMedicFullName(), pacient.getResume()});
                }
            }
            nowPageNum.setText(Integer.toString(currentPage+1));
        }
    }

    class ForwardButtonEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (currentPage==pages.size()-1){}
            else {
                currentPage += 1;

                model.setRowCount(0);

                for (Pacient pacient : pages.get(currentPage)) {
                    model.addRow(new Object[]{pacient.getFullName(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(), pacient.getMedic().getMedicFullName(), pacient.getResume()});
                }
                nowPageNum.setText(Integer.toString(currentPage+1));
            }
        }
    }

    class BackButtonEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (currentPage<1){}
            else {
                currentPage -= 1;
                model.setRowCount(0);

                for (Pacient pacient : pages.get(currentPage)) {
                    model.addRow(new Object[]{pacient.getFullName(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(), pacient.getMedic().getMedicFullName(), pacient.getResume()});
                }
            }
            nowPageNum.setText(Integer.toString(currentPage+1));

        }
    }

    class LastPageButtonEvent implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            currentPage = pages.size() - 1;
            model.setRowCount(0);
            for (Pacient pacient : pages.get(currentPage)) {
                model.addRow(new Object[]{pacient.getFullName(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(), pacient.getMedic().getMedicFullName(), pacient.getResume()});
            }
            nowPageNum.setText(Integer.toString(currentPage+1));

        }
    }

    class ColStrInTableEvent implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            recordsOnPage = Integer.parseInt(viborColStr.getText());
            if (recordsOnPage < 1 || recordsOnPage > 10) {
                JOptionPane.showMessageDialog(new JFrame(), "введите количество строк от 1 до 10", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                pages.clear();
                model.setRowCount(0);
                for (int i = 0; i < pacients.size(); i += recordsOnPage) {
                    pages.add(pacients.subList(i, Math.min(pacients.size(), i + recordsOnPage)));
                }
                for (Pacient pacient : pages.get(currentPage)) {
                    model.addRow(new Object[]{pacient.getFullName(), pacient.getAddress(), pacient.getDOB(), pacient.getDER(), pacient.getMedic().getMedicFullName(), pacient.getResume()});
                }
                lastPageNum.setText(Integer.toString(pages.size()));
            }
        }
    }

}
