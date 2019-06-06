package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Button {

    JButton addButton = new JButton("добавить");
    public JButton findButton = new JButton("найти");
    public JDialog fidDialog = new JDialog();

        public Button(){

            findButton.addActionListener(new FindButtonEvent());
            addButton.addActionListener(new AddButtonEvent());
        }


    class FindButtonEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JPanel findPanel = new JPanel();
            findPanel.setLayout(new GridLayout(5,1));
            JPanel fioPac = new JPanel();
            JTextField fioPacTextField = new JTextField(10);
            fioPac.add(new JLabel("фамилия пациента"));
            fioPac.add(fioPacTextField);
            JPanel adressPac = new JPanel();
            JTextField adressPacTwxtField = new JTextField(10);
            adressPac.add(new JLabel("адрес прописки"));
            adressPac.add(adressPacTwxtField);
            JPanel datePac = new JPanel();
            JTextField datePacTextField = new JTextField(10);
            datePac.add(new JLabel("дата рождения"));
            datePac.add(datePacTextField);
            JPanel fioMedic = new JPanel();
            JTextField fMedicTextField = new JTextField(5);
            JTextField iMedicTextField = new JTextField(5);
            JTextField oMedicTextField = new JTextField(5);
            fioMedic.add(new JLabel("ФИО врача"));
            fioMedic.add(fMedicTextField);
            fioMedic.add(iMedicTextField);
            fioMedic.add(oMedicTextField);
            findPanel.add(fioPac);
            findPanel.add(adressPac);
            findPanel.add(datePac);
            findPanel.add(fioMedic);

            JButton findButtonDialog = new JButton("найти");
            findButtonDialog.addActionListener(new FindButtonDialogEvent());
            findPanel.add(findButtonDialog);

            fidDialog.add(findPanel);



            fidDialog.setVisible(true);
            fidDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fidDialog.setBounds(500,100,400, 400);



//            String massage = "";
//            massage += "Text";
//            JOptionPane.showMessageDialog(null, massage, "out", JOptionPane.PLAIN_MESSAGE);

        }

        class FindButtonDialogEvent implements ActionListener{
            public void actionPerformed(ActionEvent e){

                String fiщPacFind, adressFind, dateFind, fioMeficFind;

            }
        }
    }


    class AddButtonEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JPanel deletePanel = new JPanel();
            deletePanel.setLayout(new GridLayout(7,1));
            JPanel fioPac = new JPanel();
            JTextField fPacTextField = new JTextField(5);
            JTextField iPacTextField = new JTextField(5);
            JTextField oPacTextField = new JTextField(5);
            fioPac.add(new JLabel("ФИО пациента"));
            fioPac.add(fPacTextField);
            fioPac.add(iPacTextField);
            fioPac.add(oPacTextField);
            JPanel adressPac = new JPanel();
            JTextField streetPacTextField = new JTextField(10);
            JTextField housePacTextField = new JTextField(4);
            adressPac.add(new JLabel("Улица"));
            adressPac.add(streetPacTextField);
            adressPac.add(new JLabel("дом"));
            adressPac.add(housePacTextField);
            JPanel datePac = new JPanel();
            JTextField datePacTextField = new JTextField(10);
            datePac.add(new JLabel("дата рождения"));
            datePac.add(datePacTextField);
            JPanel dateMedic = new JPanel();
            JTextField dateMedicTextField = new JTextField(10);
            dateMedic.add(new JLabel("дата приема"));
            dateMedic.add(dateMedicTextField);
            JPanel fioMedic = new JPanel();
            JTextField fMedicTextField = new JTextField(5);
            JTextField iMedicTextField = new JTextField(5);
            JTextField oMedicTextField = new JTextField(5);
            fioMedic.add(new JLabel("ФИО врача"));
            fioMedic.add(fMedicTextField);
            fioMedic.add(iMedicTextField);
            fioMedic.add(oMedicTextField);
            JPanel resume = new JPanel();
            JTextField resumeTextField = new JTextField(10);
            resume.add(new JLabel("заключение"));
            resume.add(resumeTextField);
            deletePanel.add(fioPac);
            deletePanel.add(adressPac);
            deletePanel.add(datePac);
            deletePanel.add(dateMedic);
            deletePanel.add(fioMedic);
            deletePanel.add(resume);

            JButton findButtonDialog = new JButton("добавить");
            findButtonDialog.addActionListener(new FindButtonDialogEvent());
            deletePanel.add(findButtonDialog);

            fidDialog.add(deletePanel);

            fidDialog.setVisible(true);
            fidDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fidDialog.setBounds(500,100,400, 400);

//            String massage = "";
//            massage += "Text";
//            JOptionPane.showMessageDialog(null, massage, "out", JOptionPane.PLAIN_MESSAGE);

        }

        class FindButtonDialogEvent implements ActionListener{
            public void actionPerformed(ActionEvent e){



            }
        }
    }
}
