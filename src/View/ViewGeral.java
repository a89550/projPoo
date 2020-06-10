package View;

import Controller.*;
import java.util.Scanner;

public class ViewGeral {
    public int n1;
    public ViewGeral(){
    }

    public void viewGeral(){
        System.out.println("    Bem Vindo ao TrazAqui!\n\n\nNome de utilizador(1)\nQueres aderir ao TrazAqui! ?(2)\nSair(0)");
        Scanner n2 = new Scanner(System.in);
        n1 = n2.nextInt();

        switch(n1) {
            case 1:
                for (int i = 0; i < 50; ++i) System.out.println();
                login();
                break;
            case 2:
                for (int i = 0; i < 50; ++i) System.out.println();
                signup();
                break;
            case 0:
                System.out.println("Obrigado!");
                break;
        }
    }

    public void login(){
        System.out.println("Iniciar conta como:\n  Utilizador(1)\n  Voluntario(2)\n  Transportadora(3)\n  Loja(4)");
        Scanner n3 = new Scanner(System.in);
        n1 = n3.nextInt();

        switch(n1){
            case 1:
                ViewUtilizador u = new ViewUtilizador();
                u.viewUtil("u");
                break;
            case 2:
                ViewVoluntario v = new ViewVoluntario();
                v.viewVolun("v");
                break;
            case 3:
                ViewTransportadora t = new ViewTransportadora();
                t.viewTransp("t");
                break;
            case 4:
                ViewLoja l = new ViewLoja();
                l.viewLoja("l");
                break;
        }
    }

    public void signup(){
        System.out.println("Criar conta como:\n  Utilizador(1)\n  Voluntario(2)\n  Transportadora(3)\n  Loja(4)");
        Scanner n2 = new Scanner(System.in);
        n1 = n2.nextInt();

        switch(n1) {
            case 1:
                for (int i = 0; i < 50; ++i) System.out.println();
                registaUtil();
                for (int i = 0; i < 50; ++i) System.out.println();
                break;
            case 2:
                for (int i = 0; i < 50; ++i) System.out.println();
                registaVolun();
                for (int i = 0; i < 50; ++i) System.out.println();
                break;
            case 3:
                for (int i = 0; i < 50; ++i) System.out.println();
                registaTransp();
                for (int i = 0; i < 50; ++i) System.out.println();
                break;
            case 4:
                for (int i = 0; i < 50; ++i) System.out.println();
                registaLoja();
                for (int i = 0; i < 50; ++i) System.out.println();
                break;
        }
    }

    public void registaUtil(){
        System.out.println("Nome de ultilizador");
        Scanner n2 = new Scanner(System.in);
        String n = n2.nextLine();

        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();

        registos u = new registos();
        u.contrRegUtil(n,x,y);
    }

    public void registaVolun(){
        System.out.println("Nome de voluntario");
        Scanner n2 = new Scanner(System.in);
        String v = n2.nextLine();

        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();

        System.out.println("Raio:");
        Scanner r1 = new Scanner(System.in);
        double r = r1.nextDouble();

        registos u = new registos();
        u.contrRegVol(v,x,y,r);
    }

    public void registaTransp(){
        System.out.println("Nome de transportadora");
        Scanner n2 = new Scanner(System.in);
        String t = n2.nextLine();

        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();

        System.out.println("Raio:");
        Scanner r1 = new Scanner(System.in);
        double r = r1.nextDouble();

        System.out.println("Nif:");
        Scanner nif1 = new Scanner(System.in);
        int nif = nif1.nextInt();

        System.out.println("Preço por kilometro:");
        Scanner pkm1 = new Scanner(System.in);
        double pkm = pkm1.nextDouble();

        registos t1 = new registos();
        t1.contrRegTrans(t,x,y,r,nif,pkm);
    }


    public void registaLoja() {
        System.out.println("Nome de loja");
        Scanner n2 = new Scanner(System.in);
        String l = n2.nextLine();

        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();

        registos t1 = new registos();
        t1.contrRegLoj(l,x,y);
    }
}
