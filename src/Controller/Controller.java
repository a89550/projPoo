package Controller;

import Models.*;
import View.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Controller.Ficheiro.*;

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

    public void controllerStart() throws IOException, ClassNotFoundException {
        int n1 = v.viewGeral();
        switch(n1) {
            case 1:
                controllerLog();
                break;
            case 2:
                controllerSign();
                break;
            case 3:
                lerS(this.s,lerLogs());
                this.s.freeAll();
                controllerStart();

                break;
            case 4:
                this.s = Sistema.carrega("teste");
                v.limpa();
                controllerStart();
                break;
            case 0:
                v.finish();
                s.grava("teste");
                break;
        }
    }

    public void controllerLog() throws IOException, ClassNotFoundException {
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
                    System.out.println(u1);
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
                System.out.println(ret);
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
                s.grava("teste");
                break;
        }
    }

    public void controllerSign() throws IOException, ClassNotFoundException {
        List<String> ret;
        int n1 = v.signup();
        switch(n1) {
            case 1:
                ret = v.registaUtil();
                double x = Double.parseDouble(ret.get(3));
                double y = Double.parseDouble(ret.get(4));

                ViewUtilizador u = new ViewUtilizador();
                String id = s.getNewId("u");
                Utilizador u1 =s.registaUtilizador(id,ret.get(2),ret.get(0),ret.get(1),x,y);

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
                Loja l2 = s.loginL(ret.get(0),ret.get(1));
                t = l1.menuL();
                menuLoja(t,l2);
                break;
        }
    }

    public void menuUtil(int t, Utilizador u) throws IOException, ClassNotFoundException {
        switch (t) {
            case 0:
                v.finish();
                this.s.freeAll();
                s.grava("teste");
                break;
            case 1:
                List<String> ret = new ArrayList<>();
                for(Loja l : s.getLojas()){
                    ret.add(l.toString2());
                }
                int i = v.fazEncom(ret);
                Loja sb = s.getLojas().get(i-1);
                Encomenda e = s.fazerEncomenda(u.getId(),sb.getId(),v.fazEncom1(),v.fazEncom2());
                ret = v.escolherProduto();
                e.addProduto(ret.get(0),ret.get(1),Double.parseDouble(ret.get(2)),Double.parseDouble(ret.get(3)));
                while (v.addMaisProduto()==1){
                    ret = v.escolherProduto();
                    e.addProduto(ret.get(0),ret.get(1),Double.parseDouble(ret.get(2)),Double.parseDouble(ret.get(3)));
                }
                s.finalizarEncomenda(e);
                if(s.aceitaEncomendaV(e.getId()) == null) s.aceitaEncomendaT(e.getId());

                ViewUtilizador u1 = new ViewUtilizador();
                int t1 = u1.menuU();
                menuUtil(t1,u);
                break;
            case 2:
                int cla = v.classificaçao();
                int e1 = u.getEncomendas().size()-1;
                String id = u.getEncomendas().get(e1).getId();

                s.classificarTransportadora(id,cla);

                u1 = new ViewUtilizador();
                t1 = u1.menuU();
                menuUtil(t1,u);
                break;
            case 3:
                for(Encomenda d : u.getEncomendas()){
                    v.printEncomendas(d.toString());
                }

                u1 = new ViewUtilizador();
                t1 = u1.menuU();
                menuUtil(t1,u);
                break;
            case 4:
                v.showTop(s.top10Utilizador());
                u1 = new ViewUtilizador();
                t1 = u1.menuU();
                menuUtil(t1,u);
                break;
        }
    }

    public void menuVol(int t, Voluntario vol) throws IOException, ClassNotFoundException {
        switch (t) {
            case 0:
                v.finish();
                this.s.freeAll();
                s.grava("teste");

                break;
            case 1:
                for(Encomenda e : vol.getHistorico()){
                    v.printEncomendas(e.toString());
                }
                ViewVoluntario v1 = new ViewVoluntario();
                int t1 = v1.menuV();
                menuVol(t1,vol);
                break;
        }
    }

    public void menuLoja(int t, Loja l) throws IOException, ClassNotFoundException {
        switch (t) {
            case 0:
                v.finish();
                this.s.freeAll();
                s.grava("teste");
                break;
            case 1:
                int f = v.atualizafila();
                l.setFilaDeEspera(f);

                ViewLoja l1 = new ViewLoja();
                int t1 = l1.menuL();
                menuLoja(t1,l);
                break;
            case 2:
                v.showFila(l.getFilaDeEspera());

                l1 = new ViewLoja();
                t1 = l1.menuL();
                menuLoja(t1,l);
                break;
        }
    }

    public void menuTrans(int a, Transportadora t) throws IOException, ClassNotFoundException {
        switch (a) {
            case 0:
                v.finish();
                this.s.freeAll();
                s.grava("teste");
                break;
            case 1:
                v.showS(s.totalFaturadoEmpresa(t.getId()));

                ViewTransportadora t1 = new ViewTransportadora();
                int t12 = t1.menuT();
                menuTrans(t12,t);
                break;
            case 2:
                v.showTop(s.top10Empresas());

                t1 = new ViewTransportadora();
                t12 = t1.menuT();
                menuTrans(t12,t);
                break;
            case 3:
                for(Encomenda e : t.getEncomendasFeitas()){
                    v.printEncomendas(e.toString());
                }

                t1 = new ViewTransportadora();
                t12 = t1.menuT();
                menuTrans(t12,t);
                break;
        }
    }
}
