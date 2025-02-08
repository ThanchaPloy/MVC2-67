package Controller;

import Model.Driver;

import Model.DriverDatabase;
import View.GeneralDriverView;
import View.MainView;
import View.NewDriverView;
import View.PublicDriverView;

public class Controller {
    
    private DriverDatabase model;
    private MainView view;
    private Driver driver;
    
    public Controller(DriverDatabase model, MainView view){
        this.model = model;
        this.view = view;
        
    }

    public void checkMethod(String licenseId){
        Driver driver = model.getDriver(licenseId);

        if(driver == null){
            view.updateResult("License ID not found");
            view.frame.dispose();
            //showDriverView();
        }else if(!driver.isValidId()){
            view.updateResult("License ID is invalid or Error");
            //view.frame.dispose();
            //showDriverView();
        }else {
            view.updateResult("Found: " + driver.getLicenseId() + ", Type: " + driver.getLicenseType());
            //view.frame.dispose();
            //showDriverView();
        }

        
    }

    public void showDriverView() {
        switch (driver.getLicenseType()) {
            case "General":
                new GeneralDriverView(driver);
                break;
            case "New Driver":
                new NewDriverView(driver);
                break;
            case "Public Driver":
                new PublicDriverView(driver);
                break;
            default:
                System.out.println("Error");
        }
    }
    
}
