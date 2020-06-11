package View;

import Controller.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewLoja {
    public void ViewLoja(){
    }

    public List<String> viewLoja(String l){
        List<String> ret = new ArrayList<>();
        System.out.println("Menu de Utlizador");
        System.out.println("Email:");
        Scanner n2 = new Scanner(System.in);
        String n1 = n2.nextLine();
        ret.add(n1);
        System.out.println("Password:");
        Scanner p = new Scanner(System.in);
        String p1 = p.nextLine();
        ret.add(p1);

        return ret;
    }
}
