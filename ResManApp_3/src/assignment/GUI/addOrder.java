package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class addOrder extends JDialog {
    private JPanel addOrderPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField customerSsnTextField;
    private JTextField orderIDTextField;
    private JTextField ODformattedTextField;
    private JTextArea orderDetailsTextArea;
    private JTextArea extraNotesTextArea;
    private JRadioButton onlineRadioButton;
    private JRadioButton restRadioButton;
    private JTextField tableNumTextField;
    private JTextField juniorSSNTextField;
    private JRadioButton cashRadioButton;
    private JRadioButton creditCardRadioButton;
    private JLabel tableNumLabel;
    private JLabel paymentTypeLabel;
    private JLabel juniorSSNLabel;
    private boolean isPressedOK = false;

    public JTextField getCustomerSsnTextField() {
        return customerSsnTextField;
    }

    public JTextField getOrderIDTextField() {
        return orderIDTextField;
    }

    public JTextField getODformattedTextField() {
        return ODformattedTextField;
    }

    public JTextArea getOrderDetailsTextArea() {
        return orderDetailsTextArea;
    }

    public JTextArea getExtraNotesTextArea() {
        return extraNotesTextArea;
    }

    public JRadioButton getOnlineRadioButton() {
        return onlineRadioButton;
    }

    public JRadioButton getRestRadioButton() {
        return restRadioButton;
    }

    public JTextField getTableNumTextField() {
        return tableNumTextField;
    }

    public JTextField getJuniorSSNTextField() {
        return juniorSSNTextField;
    }

    public boolean isPressedOK() {
        return isPressedOK;
    }

    public JRadioButton getCashRadioButton() {
        return cashRadioButton;
    }

    public addOrder() {
        this.setContentPane(this.addOrderPanel);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        this.setSize(400,200);
        this.pack();

        tableNumLabel.setVisible(false);
        tableNumTextField.setVisible(false);

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
        addOrderPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        restRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tableNumLabel.setVisible(true);
                tableNumTextField.setVisible(true);

                paymentTypeLabel.setVisible(false);
                cashRadioButton.setVisible(false);
                creditCardRadioButton.setVisible(false);

                juniorSSNLabel.setVisible(false);
                juniorSSNTextField.setVisible(false);
            }
        });
        onlineRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                tableNumLabel.setVisible(false);
                tableNumTextField.setVisible(false);

                paymentTypeLabel.setVisible(true);
                cashRadioButton.setVisible(true);
                creditCardRadioButton.setVisible(true);

                juniorSSNLabel.setVisible(true);
                juniorSSNTextField.setVisible(true);
            }
        });
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
        addOrder dialog = new addOrder();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
