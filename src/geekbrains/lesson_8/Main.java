package geekbrains.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    //Lesson_8, task: Доработать проект, который разрабатывали на уроке. Приветствуется творческий подход.

    public static void main(String[] args){
        new MainWindow();
    }

    static class MainWindow extends JFrame {
        private String firstName;
        private String midleName;
        private String surName;
        private JLabel jLabel1;
        private JLabel jLabel2;
        private JLabel jLabel3;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
            jLabel1.setText("Имя: " + firstName);
        }

        public void setMidleName(String midleName) {
            this.midleName = midleName;
            jLabel2.setText("Отчество: " + midleName);
        }

        public void setSurName(String surName) {
            this.surName = surName;
            jLabel3.setText("Фамилия: " + surName);
        }

        public MainWindow() {

            setTitle("MainWindow");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(500, 300);
            setLocationRelativeTo(null);

            JPanel panelTop = new JPanel(new GridLayout(3, 1, 15, 15));
            JPanel panelButton = new JPanel(new GridLayout(1, 2, 15, 15));

            jLabel1 = new JLabel("Имя: ");
            jLabel2 = new JLabel("Отчество: ");
            jLabel3 = new JLabel("Фамилия: ");

            JButton jbt1 = new JButton("Ввести данные");

            panelTop.add(jLabel1);
            panelTop.add(jLabel2);
            panelTop.add(jLabel3);

            panelButton.add(jbt1);

            add(panelTop, BorderLayout.NORTH);
            add(panelButton, BorderLayout.SOUTH);

            setVisible(true);

            jbt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainWindow mainWindow = (MainWindow) SwingUtilities.getRoot((JButton) e.getSource());
                    new EditWindow(mainWindow);
                }
            });
        }
    }

    static class EditWindow extends JFrame {

        public EditWindow(MainWindow mainWindow) {

            setTitle("EditWindow");
            setSize(400, 200);
            setLocationRelativeTo(null);

            JPanel panelTop = new JPanel(new GridLayout(6, 1));
            JPanel panelButton = new JPanel(new GridLayout(1, 2, 15, 15));

            panelTop.add(new JLabel("Введите имя: "));
            JTextField jTextField1 = new JTextField();
            panelTop.add(jTextField1);
            panelTop.add(new JLabel("Введите отчество: "));
            JTextField jTextField2 = new JTextField();
            panelTop.add(jTextField2);
            panelTop.add(new JLabel("Введите фамилию: "));
            JTextField jTextField3 = new JTextField();
            panelTop.add(jTextField3);

            JButton jbtOk = new JButton("Ok");
            JButton jbtCancel = new JButton("Cancel");

            panelButton.add(jbtOk);
            panelButton.add(jbtCancel);

            add(panelTop, BorderLayout.NORTH);
            add(panelButton, BorderLayout.SOUTH);

            setVisible(true);

            jbtOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainWindow.setFirstName(jTextField1.getText());
                    mainWindow.setMidleName(jTextField2.getText());
                    mainWindow.setSurName(jTextField3.getText());
                    Object o = e.getSource();
                    if (o instanceof JComponent) {
                        JComponent component = (JComponent) o;
                        Window win = SwingUtilities.getWindowAncestor(component);
                        win.dispose();
                    }
                }
            });
            jbtCancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object o = e.getSource();
                    if (o instanceof JComponent) {
                        JComponent component = (JComponent) o;
                        Window win = SwingUtilities.getWindowAncestor(component);
                        win.dispose();
                    }
                }
            });
        }
    }
}