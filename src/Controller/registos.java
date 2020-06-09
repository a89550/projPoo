package Controller;

import Models.*;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.ArrayList;

public class registos {
    public registos(){
    }
    // Função que regista um utilizador
    public void contrRegUtil(String nome, double x, double y){
        Utilizador u = new Utilizador();
        GPS g = new GPS();
        u.setNome(nome);
        g.setX(x);
        g.setY(y);
        u.setGps(g);
    }
    // Função que regista um voluntario
    public void contrRegVol(String nome, double x, double y, double r){
        Voluntario v = new Voluntario();
        GPS g = new GPS();
        v.setNome(nome);
        g.setX(x);
        g.setY(y);
        v.setGps(g);
        v.setRaio(r);
    }
    // Função que regista uma transportadora
    public void contrRegTrans(String nome, double x, double y, double r, int nif, double pkm){
        Transportadora t = new Transportadora();
        GPS g = new GPS();
        t.setNome(nome);
        g.setX(x);
        g.setY(y);
        t.setGps(g);
        t.setR(r);
        t.setNif(nif);
        t.setPkm(pkm);
    }
    // Função que regista uma loja
    public void contrRegLoj(String nome, double x, double y){
        Loja l = new Loja();
        GPS g = new GPS();
        l.setNome(nome);
        g.setX(x);
        g.setY(y);
        l.setGps(g);
    }

    public Utilizador loginUtil(String email,String pass) throws IOException {

        /*if (utilizadores.containsKey(email)) {
            Utilizador u = this.utilizadores.get(email);
            if (password.equals(u.getPassword()))
                this.utilizador = u;
        }
        */
    }

    //Sistema s = new Sistema();
    //s.iniciaSessaoVol(n1,p1);
    //System.out.println("Menu de Voluntario");
}
