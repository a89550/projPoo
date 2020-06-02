package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.numStrings = oneNav.getNumStrings();
        this.nav = oneNav.getNav();

    }
    //função que dá o valor da posição.
    public int getPosicao() {
        return this.posicao;
    }

    //função que dá o número de strings a imprimir.
    public int getNumStrings() {
        return this.numStrings;
    }

    //função que dá a lista de strings a imprimir.
    public List<String> getNav() {
        List<String> ret = new ArrayList<>();
        for(String n : ret)
            ret.add(n);
        return ret;
    }

    /*
    public void setNumStrings(int numStrings) {
        this.numStrings = numStrings;
    }
     */

    //função que define o valor da posição.
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void setNav(List<String> nav) {
        this.nav = nav;
    }

    //Função que traduz a classe Navigator.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posição;").append(this.posicao)
                .append("Número de Strings imprimir:").append(this.numStrings)
                .append("Lista de Strings a imprimir").append(this.nav);
        return sb.toString();
    }

    //FUnção que verifica se um objeto recebido é idêntico ao Navigator da classe.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Navigator nav = (Navigator) o;
        return this.posicao == nav.posicao &&
                this.numStrings == nav.numStrings &&
                this.nav.equals(nav);
    }

    //Função que cria um clone do Navigator.
    @Override
    public Navigator clone() {
        return new Navigator(this);
    }

    //função que define o numero de páginas a imprimir, um set basicamente.
    public void tamPages(int numero) {
        this.numStrings = numero;
    }

    //função que fornece a página inicial
    public List<String> InitialPage() {
        List<String> ret = new ArrayList<>();
        this.posicao = 0;
        int i;
        for(i = 0; i < this.numStrings; i++) {
            String s;
            s = nav.get(i);
            ret.add(s);
        }
        return ret;
    }

    //função que fornece a mesma página.
    public List<String> SamePage() {
        List<String> ret = new ArrayList<>();
        this.posicao = this.posicao - this.numStrings;
        int i;
        for(i = this.posicao; i < this.posicao + this.numStrings && i < this.nav.size(); i++) {
            String s;
            s = nav.get(i);
            ret.add(s);
        }
        this.posicao += this.numStrings;
        return ret;
    }

    //função que fornce a página seguinte.
    public List<String> NextPage() {
        List<String> ret = new ArrayList<>();
        if (this.posicao < this.nav.size()) {
            int i;
            for (i = this.posicao; i < this.posicao + this.numStrings && i < this.nav.size(); i++) {
                String s;
                s = nav.get(i);
                ret.add(s);
            }
            this.posicao += this.numStrings;
            return ret;
            //caso a posiçao onde estou seja igual ao tamanho da lista de strings,
            //não posso andar para as proximas paginas, pois estas não existem,
            //logo, nesse caso, devolvemos a mesma pagina.
        } else {
            //se a posição for maior ou igual que o tamanho da lista, dá se retorno da mesma página.
            ret = SamePage();
            return ret;
        }
    }

    //função que permite ir para a página anterior.
    public List<String> BackPage() {
        List<String> ret = new ArrayList();
        if(this.posicao > this.numStrings) {
            this.posicao = this.posicao - 2 * this.numStrings;
            int i;
            for (i = this.posicao; i < this.posicao + this.numStrings && i < this.nav.size(); i++) {
                String s;
                s = nav.get(i);
                ret.add(s);
            }
            this.posicao += this.numStrings;
            return ret;
        } else {
            this.posicao = 0;
            ret = NextPage();
            return ret;
        }
    }

    //função que fornece a página desejada.
    public List<String> ChoosePage(int numero) {
        List<String> ret = new ArrayList<>();
        if (this.numStrings * (numero-1)  < this.nav.size()) {
            this.posicao = numStrings * (numero-1);
            int i;
            for (i = this.posicao; i < this.posicao + this.numStrings && i < this.nav.size(); i++) {
                String s;
                s = nav.get(i);
                ret.add(s);
            }
            this.posicao += this.numStrings;
        }
        return ret;
    }

    //Função dada uma String devolve a página onde a mesma se encontra.
    public List<String> WhereIs(String s) {
        List<String> ret = new ArrayList<>();
        int i;
        for (i = 0; i < this.nav.size(); i++) {
            if (s.equals(nav.get(i))) {
                ret = ChoosePage((i / this.numStrings) + 1);
                return ret;
            }
        }
        ret = ChoosePage((i / this.numStrings) + 1);
        return ret;
    }

}
