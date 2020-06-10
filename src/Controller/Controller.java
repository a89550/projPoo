package Controller;

import Models.Sistema;
import Models.Transportadora;
import View.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Sistema s;
    private ViewGeral v;

    public Controller(Sistema s, ViewGeral v){
        this.s = s;
        this.v = v;
    }

    public Sistema getS() {
        return s;
    }

    public void setS(Sistema s) {
        this.s = s;
    }

    public ViewGeral getV() {
        return v;
    }

    public void setV(ViewGeral v) {
        this.v = v;
    }

    public void controllerStart(){
        int n1 = v.viewGeral();
        switch(n1) {
            case 1:
                controllerLog();
                break;
            case 2:
                controllerSign();
                v.signup();
                break;
            case 0:
                v.finish();
                break;
        }
    }

    public void controllerLog() {
        int n1 = v.login();
        switch (n1) {
            case 1:
                ViewUtilizador u = new ViewUtilizador();
                u.viewUtil("u");
                break;
            case 2:
                ViewVoluntario vol = new ViewVoluntario();
                vol.viewVolun("v");
                break;
            case 3:
                ViewTransportadora t = new ViewTransportadora();
                t.viewTransp("t");
                break;
            case 4:
                ViewLoja l = new ViewLoja();
                l.viewLoja("l");
                break;
            case 0:
                v.finish();
                break;
        }
    }

    public void controllerSign() {
        List<String> ret = new ArrayList<>();
        int n1 = v.signup();
        switch(n1) {
            case 1:
                ret = v.registaUtil();
                double x = Double.parseDouble(ret.get(3));
                double y = Double.parseDouble(ret.get(4));

                String id = s.getNewId("u");
                s.registaUtilizador(id,ret.get(2),ret.get(0),ret.get(1),x,y);
                break;
            case 2:
                ret = v.registaVolun();
                x = Double.parseDouble(ret.get(3));
                y = Double.parseDouble(ret.get(4));
                double r = Double.parseDouble(ret.get(5));
                double vm = Double.parseDouble(ret.get(6));
                double tf = Double.parseDouble(ret.get(7));
                boolean tf1;
                if(tf==1)
                    tf1 = true;
                else (tf==0)//aqui tem de haver exeption
                    tf1 = false;

                id = s.getNewId("t");
                s.registaVoluntario(id,ret.get(2),ret.get(0),ret.get(1),x,y,r,vm,tf1);
                break;
            case 3:
                ret = v.registaTransp();
                x = Double.parseDouble(ret.get(3));
                y = Double.parseDouble(ret.get(4));
                r = Double.parseDouble(ret.get(5));
                double nif = Double.parseDouble(ret.get(6));
                double pkm = Double.parseDouble(ret.get(7));
                double nenc = Double.parseDouble(ret.get(8));
                vm = Double.parseDouble(ret.get(9));
                tf = Double.parseDouble(ret.get(10));
                boolean tf2;
                if(tf==1)
                    tf2 = true;
                else if(tf==0)
                    tf2 = false;

                id = s.getNewId("t");
                s.registaTransportadora(id,ret.get(2),ret.get(0),ret.get(1),x,y,r,nif,pkm,nenc,vm,tf2);
                break;
            case 4:
                ret = v.registaLoja();
                x = Double.parseDouble(ret.get(3));
                y = Double.parseDouble(ret.get(4));
                double tm = Double.parseDouble(ret.get(5));
                double tf = Double.parseDouble(ret.get(6));

                id = s.getNewId("l");
                if(tf==1) {
                    double f = Double.parseDouble(ret.get(7));
                    s.registaLoja(id,ret.get(2),ret.get(0),ret.get(1),x,y,tm,f);
                } else s.registaLoja(id,ret.get(2),ret.get(0),ret.get(1),x,y,tm);
                break;
        }
    }
}
