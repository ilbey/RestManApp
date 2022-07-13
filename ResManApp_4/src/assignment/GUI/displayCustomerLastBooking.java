package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class displayCustomerLastBooking extends JDialog {
    private JPanel DCLBPage;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField customerSsnTextField;
    private boolean isPressedOk = false;

    public JTextField getCustomerSsnTextField() {
        return customerSsnTextField;
    }

    public boolean isPressedOk() {
        return isPressedOk;
    }

    public displayCustomerLastBooking() {
        this.setContentPane(this.DCLBPage);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.setSize(300,200);
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
        DCLBPage.registerKeyboardAction(new ActionListener() {
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
        displayCustomerLastBooking dialog = new displayCustomerLastBooking();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
