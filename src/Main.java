import Controller.Controller;
import Models.Sistema;
import View.ViewGeral;


import javax.naming.ldap.Control;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        Sistema s = new Sistema();
        ViewGeral view = new ViewGeral();
        Controller control = new Controller(s,view);

        control.controllerStart();

        System.exit(0);
    }
}