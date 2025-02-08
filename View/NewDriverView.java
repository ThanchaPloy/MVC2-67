package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Driver;

public class NewDriverView extends JFrame {
    private Driver driver;
    private JButton writtenTestButton;
    private JButton practicalTestButton;
    private boolean writtenTestDone = false;
    private boolean practicalTestDone = false;

    public NewDriverView(Driver driver) {
        this.driver = driver;
        setTitle("New driver");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel statusLabel = new JLabel("Status: " + driver.getLicenseStatus());
        add(statusLabel);

        if (driver.getLicenseStatus().equals("Normal")) {
            writtenTestButton = new JButton("Writing test");
            practicalTestButton = new JButton("Practice test");

            writtenTestButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    writtenTestDone = !writtenTestDone;
                    writtenTestButton.setText(writtenTestDone ? "Finish writing test" : "Writing test");
                    checkUpgrade();
                }
            });

            practicalTestButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    practicalTestDone = !practicalTestDone;
                    practicalTestButton.setText(practicalTestDone ? "Finish practice test" : "Practice test");
                    checkUpgrade();
                }
            });

            add(writtenTestButton);
            add(practicalTestButton);
        }

        setVisible(true);
    }

    private void checkUpgrade() {
        if (writtenTestDone && practicalTestDone) {
            JOptionPane.showMessageDialog(this, "Pass! Change to General");
            driver.setLicenseType("General");
            dispose();
            new GeneralDriverView(driver);
        }
    }
}
