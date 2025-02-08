package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controller.Controller;
import Model.Driver;
import Model.DriverDatabase;

public class MainView {

    public JFrame frame;
    private JTextField idField;
    private JButton submitButton;
    private JTable driverTable;
    private JLabel resultLabel;
    private Controller controller;
    private DriverDatabase model;
    private DefaultTableModel tableModel;
    

    public MainView(DriverDatabase model){
        this.model = model;
        frame = new JFrame("Driver License ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        
        //enter cow code
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Enter License ID:");
        inputPanel.add(label);
        idField = new JTextField(10);
        inputPanel.add(idField);
        submitButton = new JButton("Check");
        inputPanel.add(submitButton);
        frame.add(inputPanel, BorderLayout.NORTH);

        //Driver table
        String[] columnNames = {"License ID", "License Type", "Driver Birthday", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        driverTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(driverTable);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        //represent result
        resultLabel = new JLabel("Result will appear here...");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        //load driver data to table
        loadDriverData();

        submitButton.addActionListener(e -> {
            String licenseId = idField.getText();
            if (controller != null) {
                controller.checkMethod(licenseId);
                //controller.showDriverView();
            }
        });
        
        frame.setVisible(true);
        
    }

    public void updateResult(String message) {
        SwingUtilities.invokeLater(() -> {
            resultLabel.setText(message);
        });
    }

    //load cow data from model into table
    private void loadDriverData() {
        for (Driver driver : model.getDrivers().values()) {
            tableModel.addRow(new Object[]{
                driver.getLicenseId(), 
                driver.getLicenseType(), 
                driver.getDriverBirth(), 
                driver.getLicenseStatus()});
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void updateTable() {
        SwingUtilities.invokeLater(() -> {
        tableModel.setRowCount(0); // delete old data
        loadDriverData(); // load new data
        });
    }
}