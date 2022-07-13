package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class addCustomer extends JDialog {
    private JPanel addCustomerPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField customerSsnTextField;
    private JTextField customerNameTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JFormattedTextField DOBformattedTextField;
    private JFormattedTextField RDformattedTextField;
    private JTextArea creditCardDetailsTextArea;
    private boolean isPressedOK = false;

    public JTextField getCustomerSsnTextField() {
        return customerSsnTextField;
    }

    public JTextField getCustomerNameTextField() {
        return customerNameTextField;
    }

    public JRadioButton getMaleRadioButton() {
        return maleRadioButton;
    }

    public JRadioButton getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public JFormattedTextField getDOBformattedTextField() {
        return DOBformattedTextField;
    }

    public JFormattedTextField getRDformattedTextField() {
        return RDformattedTextField;
    }

    public JTextArea getCreditCardDetailsTextArea() {
        return creditCardDetailsTextArea;
    }

    public boolean isPressedOK() {
        return isPressedOK;
    }

    public addCustomer() {
        this.setContentPane(this.addCustomerPanel);
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
        addCustomerPanel.registerKeyboardAction(new ActionListener() {
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
        addCustomer dialog = new addCustomer();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
