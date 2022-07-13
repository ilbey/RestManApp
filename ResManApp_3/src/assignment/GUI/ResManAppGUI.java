package assignment.GUI;

import assignment.core.ResManApp;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;

public class ResManAppGUI extends JFrame{
    private JPanel mainPanel;

    private JMenuBar mainMenu;
    private JMenu add;
    private JMenu delete;
    private JMenu show;

    private JMenuItem addStaff;
    private JMenuItem addCustomer;
    private JMenuItem addBooking;
    private JMenuItem addOrder;
    private JMenuItem addOrderOfBooking;
    private JMenuItem deleteStaff;
    private JMenuItem deleteCustomer;
    private JMenuItem listStaffDetails;
    private JMenuItem listAllStaff;
    private JMenuItem listAllStaffSalaries;
    private JMenuItem listCustomerDetails;
    private JMenuItem listAllCustomer;
    private JMenuItem listOrders;
    private JMenuItem listCustomerOrders;
    private JMenuItem customerLastBooking;
    private JButton getFromFileButton;
    private JButton exitButton;
    private JButton getDataFromFileButton;
    private JButton exportDataToFileButton;
    private JButton exportFileButton;
    private File file;

    public ResManAppGUI(){
        super("Restaurant Management Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //DISPOSE_ON_CLOSE
        this.setContentPane(this.mainPanel);
        this.setSize(400,200);
        this.pack();


        addStaff.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResManApp.addStaff();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });

        addCustomer.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResManApp.addCustomer();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        addBooking.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResManApp.addBooking();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        addOrder.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResManApp.addOrder();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });
        addOrderOfBooking.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.addOrderOfBooking();
            }
        });
        deleteStaff.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.deleteStaff();
            }
        });
        deleteCustomer.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.deleteCustomer();
            }
        });
        listStaffDetails.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.listStaffDetails();
            }
        });
        listAllStaff.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResManApp.listStaff();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        listAllStaffSalaries.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResManApp.listAllStaffSalary();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
        listCustomerDetails.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.listCustomerDetails();
            }
        });
        listAllCustomer.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.listCustomer();
            }
        });
        listOrders.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.listAllOrder();
            }
        });
        listCustomerOrders.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.listCustomerOrders();
            }
        });
        customerLastBooking.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.displayCustomerLastBooking();
            }
        });

        getDataFromFileButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    try {
                        ResManApp.fromBinFile(fileChooser.getSelectedFile());
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null,"Error! This file not imported properly.","Error",JOptionPane.ERROR_MESSAGE);
                    } catch (ClassNotFoundException classNotFoundException) {
                        JOptionPane.showMessageDialog(null,"Error! This file not imported properly.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null,"Successfully imported.");
                }
            }
        });
        exportDataToFileButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
                int returnValue = fileChooser.showSaveDialog(null);
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    try {
                        ResManApp.toBinFile(fileChooser.getSelectedFile());
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null,"Error! This file not exported properly.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null,"Successfully exported.");
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
}
