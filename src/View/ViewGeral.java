package View;

import Models.*;

import java.util.Scanner;


public class ViewGeral {
    public int n1;
    public ViewGeral(){
    }
/*
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
*/
    public void login(){
        System.out.println("Código:");
        Scanner n2 = new Scanner(System.in);
        String n3 = n2.nextLine();

        switch(n3.substring(0, 1)){
            case "u":
                ViewUtilizador u = new ViewUtilizador();
                u.viewUtil(n3);
                break;
            case "v":
                ViewVoluntario v = new ViewVoluntario();
                v.viewVolun(n3);
                break;
            case "t":
                ViewTransportadora t = new ViewTransportadora();
                t.viewTransp(n3);
                break;
            case "l":
                ViewLoja l = new ViewLoja();
                l.viewLoja(n3);
                break;
         }
    }
/*
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
        Utilizador u = new Utilizador();
        System.out.println("Nome de ultilizador");
        Scanner n2 = new Scanner(System.in);
        String n3 = n2.nextLine();
        u.setNome(n3);
        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();
        GPS g = new GPS();
        g.setX(x);
        g.setY(y);
        u.setGps(g);
    }

    /*
    public void registaVolun(){
        Voluntario v = new Voluntario();
        System.out.println("Nome de voluntario");
        Scanner n2 = new Scanner(System.in);
        String n3 = n2.nextLine();
        v.setNome(n3);
        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();
        GPS g = new GPS();
        g.setX(x);
        g.setY(y);
        v.setGps(g);
        System.out.println("Raio:");
        Scanner r1 = new Scanner(System.in);
        double r = r1.nextDouble();
        v.setR(r);
    }

    public void registaTransp(){
        Transportadora t = new Transportadora();
        System.out.println("Nome de transportadora");
        Scanner n2 = new Scanner(System.in);
        String n3 = n2.nextLine();
        t.setNome(n3);
        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();
        GPS g = new GPS();
        g.setX(x);
        g.setY(y);
        t.setGps(g);
        System.out.println("Raio:");
        Scanner r1 = new Scanner(System.in);
        double r = r1.nextDouble();
        t.setR(r);
        System.out.println("Nif:");
        Scanner nif1 = new Scanner(System.in);
        int nif = nif1.nextInt();
        t.setNif(nif);
        System.out.println("Preço por kilometro:");
        Scanner pkm1 = new Scanner(System.in);
        double pkm = pkm1.nextDouble();
        t.setPkm(pkm);
    }


    public void registaLoja(){
        Loja l = new Loja();
        System.out.println("Nome de loja");
        Scanner n2 = new Scanner(System.in);
        String n3 = n2.nextLine();
        l.setNome(n3);
        System.out.println("GPS\nCoordenada x:");
        Scanner n1 = new Scanner(System.in);
        double x = n1.nextDouble();
        System.out.println("GPS\nCoordenada y:");
        Scanner n4 = new Scanner(System.in);
        double y = n4.nextDouble();
        GPS g = new GPS();
        g.setX(x);
        g.setY(y);
        l.setGps(g);
    }
    */
}
