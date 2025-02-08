package Main;

import Controller.Controller;
import Model.DriverDatabase;
import View.MainView;

public class Main {
    public static void main(String[] args) {

        DriverDatabase model = new DriverDatabase();
        MainView view = new MainView(model);
        Controller controller = new Controller(model, view);
        view.setController(controller);
    }
}
