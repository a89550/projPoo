package Controller;

import Models.*;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.ArrayList;

public class registos {
    private Sistema s = new Sistema();
    public registos(){
    }

    // Função que regista um utilizador
    public void contrRegUtil(String mail, String pass, String nome, double x, double y){

        String id = s.getNewId("u");

        s.registaUtilizador(id,nome,mail,pass,x,y);
    }
    // Função que regista um voluntario
    public void contrRegVol(String mail, String pass, String nome, double x, double y, double r){

        String id = s.getNewId("v");

        s.registaUtilizador(id,nome,mail,pass,x,y);
    }
    // Função que regista uma transportadora
    public void contrRegTrans(String nome, double x, double y, double r, int nif, double pkm){
        Transportadora t = new Transportadora();
        GPS g = new GPS();
        t.setNome(nome);
        g.setX(x);
        g.setY(y);
        t.setGps(g);
        t.setRaio(r);
        t.setNif(nif);
        t.setTaxaKm(pkm);
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

   //public Utilizador loginUtil(String email,String pass){



}
