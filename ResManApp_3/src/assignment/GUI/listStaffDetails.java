package assignment.GUI;

import javax.swing.*;
import java.awt.event.*;

public class listStaffDetails extends JDialog {
    private JPanel listStaffDetailsPage;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField listStaffDetailsTextField;
    private boolean isPressedOK = false;


    public listStaffDetails() {
        this.setContentPane(this.listStaffDetailsPage);
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
        listStaffDetailsPage.registerKeyboardAction(new ActionListener() {
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

    public boolean isPressedOK() {
        return isPressedOK;
    }

    public JTextField getListStaffDetailsTextField() {
        return listStaffDetailsTextField;
    }

    public static void main(String[] args) {
        listStaffDetails dialog = new listStaffDetails();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
