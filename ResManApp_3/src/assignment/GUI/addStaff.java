package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;

public class addStaff extends JDialog {
    private JPanel addStaffPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField staffSsnTextField;
    private JTextField staffNameTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JFormattedTextField DOBformattedTextField;
    private JFormattedTextField SDformattedTextField;
    private JTextField salaryYearlyTextField;
    private JRadioButton seniorRadioButton;
    private JRadioButton juniorRadioButton;
    private JTextField EEDTextField;
    private JTextField responsibleFromTextField;
    private JLabel EEDLabel;
    private JLabel resFromLabel;
    private boolean isPressedOK = false;

    public JTextField getStaffSsnTextField() {
        return staffSsnTextField;
    }

    public JTextField getStaffNameTextField() {
        return staffNameTextField;
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

    public JFormattedTextField getSDformattedTextField() {
        return SDformattedTextField;
    }

    public JTextField getSalaryYearlyTextField() {
        return salaryYearlyTextField;
    }

    public JRadioButton getSeniorRadioButton() {
        return seniorRadioButton;
    }

    public JRadioButton getJuniorRadioButton() {
        return juniorRadioButton;
    }

    public JTextField getEEDTextField() {
        return EEDTextField;
    }

    public JTextField getResponsibleFromTextField() {
        return responsibleFromTextField;
    }

    public boolean isPressedOK() {
        return isPressedOK;
    }

    public addStaff() {
        this.setContentPane(this.addStaffPanel);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.setSize(400,200);
        this.pack();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
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
        addStaffPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        juniorRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                EEDTextField.setVisible(true);
                responsibleFromTextField.setVisible(true);
                EEDLabel.setVisible(true);
                resFromLabel.setVisible(true);

            }
        });
        seniorRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                EEDTextField.setVisible(false);
                responsibleFromTextField.setVisible(false);
                EEDLabel.setVisible(false);
                resFromLabel.setVisible(false);
            }
        });
    }

    private void onOK() throws ParseException {
        this.isPressedOK = true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
    dispose();
    }

    public static void main(String[] args) {
        addStaff dialog = new addStaff();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }
}
