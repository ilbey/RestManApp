package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class listCustomerOrders extends JDialog {
    private JPanel listCustomerOrdersPage;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField CustomerSsnTextField;
    private boolean isPressedOk = false;

    public JTextField getCustomerSsnTextField() {
        return CustomerSsnTextField;
    }

    public boolean isPressedOk() {
        return isPressedOk;
    }

    public listCustomerOrders() {
        setContentPane(listCustomerOrdersPage);
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
        listCustomerOrdersPage.registerKeyboardAction(new ActionListener() {
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
        listCustomerOrders dialog = new listCustomerOrders();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
