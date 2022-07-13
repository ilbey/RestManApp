package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class listCustomerDetails extends JDialog {
    private JPanel listCustomerDetailsPage;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField listCustomerDetailsTextField;
    private boolean isPressedOK = false;

    public JTextField getListCustomerDetailsTextField() {
        return listCustomerDetailsTextField;
    }

    public boolean isPressedOK() {
        return isPressedOK;
    }

    public listCustomerDetails() {
        setContentPane(listCustomerDetailsPage);
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
        listCustomerDetailsPage.registerKeyboardAction(new ActionListener() {
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
        listCustomerDetails dialog = new listCustomerDetails();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
