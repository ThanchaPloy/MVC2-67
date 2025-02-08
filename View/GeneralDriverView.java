package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Driver;

public class GeneralDriverView extends JFrame {
    private Driver driver;
    private JButton testButton;

    public GeneralDriverView(Driver driver) {
        this.driver = driver;
        setTitle("General");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel statusLabel = new JLabel("Status: " + driver.getLicenseStatus());
        add(statusLabel);

        if (driver.getLicenseStatus().equals("Normal")) {
            testButton = new JButton("Test");
            testButton.addActionListener(new ActionListener() {
                private boolean isTesting = false;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!isTesting) {
                        testButton.setText("Finist test");
                        isTesting = true;
                    } else {
                        testButton.setText("Test");
                        isTesting = false;
                    }
                }
            });
            add(testButton);
        }

        setVisible(true);
    }
}
