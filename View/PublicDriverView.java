package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Driver;
import java.util.Random;

public class PublicDriverView extends JFrame {
    private Driver driver;
    private JButton trainingButton, testButton;
    private int complaints;

    public PublicDriverView(Driver driver) {
        this.driver = driver;
        this.complaints = new Random().nextInt(11); // สุ่มค่าการร้องเรียนระหว่าง 0-10

        setTitle("คนขับรถสาธารณะ");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel statusLabel = new JLabel("Status: " + driver.getLicenseStatus());
        JLabel complaintsLabel = new JLabel("Compain count: " + complaints);
        add(statusLabel);
        add(complaintsLabel);

        if (complaints > 5) {
            driver.setLicenseStatus("Temporarily suspended");
            trainingButton = new JButton("Train");
            trainingButton.addActionListener(new ActionListener() {
                private boolean isTraining = false;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!isTraining) {
                        trainingButton.setText("Finish train");
                        isTraining = true;
                    } else {
                        trainingButton.setText("Train");
                        driver.setLicenseStatus("Normal");
                        statusLabel.setText("Status: " + driver.getLicenseStatus());
                        addTestButton();
                        trainingButton.setEnabled(false);
                    }
                }
            });
            add(trainingButton);
        } else {
            addTestButton();
        }

        setVisible(true);
    }

    private void addTestButton() {
        testButton = new JButton("Test");
        testButton.addActionListener(new ActionListener() {
            private boolean isTesting = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTesting) {
                    testButton.setText("Finish test");
                    isTesting = true;
                } else {
                    testButton.setText("Test");
                    isTesting = false;
                }
            }
        });
        add(testButton);
    }
}
