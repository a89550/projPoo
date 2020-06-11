package Controller;

import Models.*;
import View.*;
import jdk.jshell.execution.Util;

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
        List<String> ret = new ArrayList<>();
        switch (n1) {
            case 1:
                ViewUtilizador u = new ViewUtilizador();
                ret = u.viewUtil("u");
                Utilizador u1 = s.loginU(ret.get(0),ret.get(1));
                if(u1==null) {
                    v.erroDeIdent();
                    controllerLog();
                } else {
                    int t = u.menuU();
                    menuUtil(t,u1);
                }
                break;
            case 2:
                ViewVoluntario vol = new ViewVoluntario();
                ret = vol.viewVolun("v");
                Voluntario volu = s.loginV(ret.get(0),ret.get(1));
                if(volu==null) {
                    v.erroDeIdent();
                    controllerLog();
                } else {
                    int t = vol.menuV();
                    menuVol(t,volu);
                }
                break;
            case 3:
                ViewTransportadora trans = new ViewTransportadora();
                ret = trans.viewTransp("t");
                Transportadora t1 = s.loginE(ret.get(0),ret.get(1));
                if(t1==null) {
                    v.erroDeIdent();
                    controllerLog();
                } else {
                    int t = trans.menuT();
                    menuTrans(t,t1);
                }
                break;
            case 4:
                ViewLoja l = new ViewLoja();
                ret = l.viewLoja("l");
                Loja l1 = s.loginL(ret.get(0),ret.get(1));
                if(l1==null) {
                    v.erroDeIdent();
                    controllerLog();
                } else {
                    int t = l.menuL();
                    menuLoja(t,l1);
                }
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

                ViewUtilizador u = new ViewUtilizador();
                ret = u.viewUtil("u");
                Utilizador u1 = s.loginU(ret.get(0),ret.get(1));
                int t = u.menuU();
                menuUtil(t,u1);
                break;
            case 2:
                ret = v.registaVolun();
                x = Double.parseDouble(ret.get(3));
                y = Double.parseDouble(ret.get(4));
                double r = Double.parseDouble(ret.get(5));
                double vm = Double.parseDouble(ret.get(6));
                boolean tf1 = false;
                if(ret.get(7).equals("1"))
                    tf1 = true;

                id = s.getNewId("v");
                s.registaVoluntario(id,ret.get(2),ret.get(0),ret.get(1),x,y,r,vm,tf1);

                ViewVoluntario v1 = new ViewVoluntario();
                ret = v1.viewVolun("v");
                Voluntario v2 = s.loginV(ret.get(0),ret.get(1));
                t = v1.menuV();
                menuVol(t,v2);
                break;
            case 3:
                ret = v.registaTransp();
                x = Double.parseDouble(ret.get(3));
                y = Double.parseDouble(ret.get(4));
                r = Double.parseDouble(ret.get(5));
                int nif = Integer.parseInt(ret.get(6));
                double pkm = Double.parseDouble(ret.get(7));
                int nenc = Integer.parseInt(ret.get(8));
                vm = Double.parseDouble(ret.get(9));
                double tf = Double.parseDouble(ret.get(10));
                boolean tf2 = false;
                if(tf==1) tf2 = true;
                else tf2 = false;

                id = s.getNewId("t");
                s.registaTransportadora(id,ret.get(2),ret.get(0),ret.get(1),x,y,nif,r,pkm,nenc,vm,tf2);

                ViewTransportadora t1 = new ViewTransportadora();
                ret = t1.viewTransp("t");
                Transportadora t2 = s.loginE(ret.get(0),ret.get(1));
                t = t1.menuT();
                menuTrans(t,t2);
                break;
            case 4:
                ret = v.registaLoja();
                x = Double.parseDouble(ret.get(3));
                y = Double.parseDouble(ret.get(4));
                int tm = Integer.parseInt(ret.get(5));
                tf = Double.parseDouble(ret.get(6));

                id = s.getNewId("l");
                if(tf==1) {
                    int f = Integer.parseInt(ret.get(7));
                    s.registaLoja(id,ret.get(2),ret.get(0),ret.get(1),x,y,tm,f);
                } else s.registaLoja(id,ret.get(2),ret.get(0),ret.get(1),x,y,tm);

                ViewLoja l1 = new ViewLoja();
                ret = l1.viewLoja("l");
                Loja l2 = s.loginL(ret.get(0),ret.get(1));
                t = l1.menuL();
                menuLoja(t,l2);
                break;
        }
    }

    public void menuUtil(int t, Utilizador u){
        switch (t) {
            case 0:
                v.finish();
                break;
            case 1:

                break;
            case 2:
                int cla = v.classificaçao();
                int e1 = u.getEncomendas().size()-1;
                String id = u.getEncomendas().get(e1).getId();

                s.classificarTransportadora(id,cla);
                menuUtil(t,u);
                break;
            case 3:
                v.printEncomendas(u.getEncomendas());
                menuUtil(t,u);
                break;
        }
    }

    public void menuVol(int t, Voluntario vol){
        switch (t) {
            case 0:
                v.finish();
                break;
            case 1:
                v.printEncomendas(vol.getHistorico());
                break;
        }
    }

    public void menuLoja(int t, Loja l){
        switch (t) {
            case 0:
                v.finish();
                break;
            case 1:
                int f = v.atualizafila();
                l.setFilaDeEspera(f);
                break;
            case 2:
                v.showFila(l.getFilaDeEspera());
                break;
        }
    }

    public void menuTrans(int a, Transportadora t){
        switch (a) {
            case 0:
                v.finish();
                break;
            case 1:
                v.showS(s.totalFaturadoEmpresa(t.getId()));
                break;
            case 2:
                v.showTop(t.top10Empresas());
                break;
            case 3:
                v.printEncomendas(t.getEncomendasFeitas());
                break;
        }
    }
}
