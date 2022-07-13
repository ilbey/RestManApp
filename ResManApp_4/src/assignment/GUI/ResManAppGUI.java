package assignment.GUI;

import assignment.core.ResManApp;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
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
    private JButton exitButton;
    private File file;

    public ResManAppGUI() throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
        super("Restaurant Management Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //DISPOSE_ON_CLOSE
        this.setContentPane(this.mainPanel);
        this.setSize(400,200);
        this.pack();
        ResManApp.fromMd5File();


        addStaff.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                ResManApp.addStaff();
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
                } catch (ParseException | ClassNotFoundException | IOException parseException) {
                    parseException.printStackTrace();
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
                try {
                    ResManApp.displayCustomerLastBooking();
                } catch (Exception exception) {
                    exception.printStackTrace();
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

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                try {
                    ResManApp.toTxtFile();
                    ResManApp.toMd5File();
                    Runtime.getRuntime().exec("taskkill /f /im java.exe");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
