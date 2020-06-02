package View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNavigator {
    public static void main(String[] args) {
        Navigator nav = new Navigator();
        List<String> test = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        nav.tamPages(2);
        nav.setPosicao(4);
        nav.setNav(test);
        //System.out.println(nav.InitialPage());
        //System.out.println(nav.SamePage());
        //System.out.println(nav.NextPage());
        //System.out.println(nav.BackPage());
        //System.out.println(nav.ChoosePage(4));
        System.out.println(nav.WhereIs("5"));
    }
}
