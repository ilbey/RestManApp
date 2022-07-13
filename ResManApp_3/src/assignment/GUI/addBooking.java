package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class addBooking extends JDialog {
    private JPanel addBookingPage;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField customerIDTextField;
    private JTextField bookingIDTextField;
    private JTextField bookingDateTextField;
    private boolean isPressedOk = false;

    public JTextField getCustomerIDTextField() {
        return customerIDTextField;
    }

    public JTextField getBookingIDTextField() {
        return bookingIDTextField;
    }

    public JTextField getBookingDateTextField() {
        return bookingDateTextField;
    }

    public boolean isPressedOk() {
        return isPressedOk;
    }

    public addBooking() {
        setContentPane(addBookingPage);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setSize(400,200);
        this.pack();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        addBookingPage.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        this.isPressedOk = true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        addBooking dialog = new addBooking();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
