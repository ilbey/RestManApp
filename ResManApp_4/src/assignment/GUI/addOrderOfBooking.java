package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class addOrderOfBooking extends JDialog {
    private JPanel addOOBPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField customerSsnTextField;
    private JTextField OOBBookingIDTextField;
    private JTextField OOBOrderIDTextField;
    private JTextField OOBODformattedTextField;
    private JTextField OOBDetailsTextField;
    private JTextField extraNotesTextField;
    private JTextField tableNumTextField;
    private boolean isPressedOK = false;

    public JTextField getCustomerSsnTextField() {
        return customerSsnTextField;
    }

    public JTextField getOOBBookingIDTextField() {
        return OOBBookingIDTextField;
    }

    public JTextField getOOBOrderIDTextField() {
        return OOBOrderIDTextField;
    }

    public JTextField getOOBODformattedTextField() {
        return OOBODformattedTextField;
    }

    public JTextField getOOBDetailsTextField() {
        return OOBDetailsTextField;
    }

    public JTextField getExtraNotesTextField() {
        return extraNotesTextField;
    }

    public JTextField getTableNumTextField() {
        return tableNumTextField;
    }

    public boolean isPressedOK() {
        return isPressedOK;
    }

    public addOrderOfBooking() {
        this.setContentPane(this.addOOBPanel);
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
        addOOBPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        this.isPressedOK = true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        addOrderOfBooking dialog = new addOrderOfBooking();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
