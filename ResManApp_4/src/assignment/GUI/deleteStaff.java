package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class deleteStaff extends JDialog {
    private boolean isPressedOK = false;
    private JPanel deleteStaffPage;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField deleteStaffSsnTextField;

    public JTextField getDeleteStaffSsnTextField() {
        return deleteStaffSsnTextField;
    }

    public boolean isPressedOK() {
        return isPressedOK;
    }

    public deleteStaff() {
        this.setContentPane(this.deleteStaffPage);
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
        deleteStaffPage.registerKeyboardAction(new ActionListener() {
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
        deleteStaff dialog = new deleteStaff();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
