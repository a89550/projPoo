package View;

import java.util.ArrayList;
import java.util.List;

public class Navigator {
    //variável de instância que indica a posição onde me situo.
    private int posicao;
    //variável de instância que indica o número de strings que irei imprimir.
    private int numStrings;
    //variável de instância que imprime as strings.
    private List<String> nav;

    //construtor por omissão
    public Navigator() {
        this.posicao = 0;
        this.numStrings = 0;
        this.nav = new ArrayList<>();
    }

    //construtor parametrizado
    public Navigator(int posicao, int numStrings, List<String> nav) {
        this.posicao = posicao;
        this.numStrings = numStrings;
        this.nav = new ArrayList<>();
        for (String n : nav)
            this.nav.add(n);
    }

    //construtor por cópia
    public Navigator(Navigator oneNav) {
        this.posicao = oneNav.getPosicao();
    }

    public int getPosicao() {
        return this.posicao;
    }
}
