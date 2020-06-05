package Models;

import java.util.ArrayList;
import java.util.List;

public class Encomenda{
    private String e;
    private String u;
    private String l;
    private double p;
    private List<LinhaEncomenda> le;

    /**
     * Construtor por omissão.
     */
    public Encomenda(){
        this.e = "";
        this.u = "";
        this.l = "";
        this.p = -1;
        this.le = new ArrayList<>();
    }

    /**
     * Construtor parametrizado.
     * @param e String que representa o código de uma Encomenda.
     * @param u String que representa o código de um Utilizador.
     * @param l String que representa o código de uma Loja.
     * @param p Double que representa o peso.
     * @param le Lista das linhas de encomenda.
     */
    public Encomenda(String e, String u, String l, double p, List<LinhaEncomenda> le){
        this.e = e;
        this.u = u;
        this.l = l;
        this.p = p;
        this.le = new ArrayList<>();
        for(LinhaEncomenda lenc : le){
            this.le.add(lenc.clone());
        }
    }

    /**
     * Construtor por cópia.
     * @param e Recebe um objeto da classe Encomenda.
     */
    public Encomenda(Encomenda e){
        this.e = e.getE();
        this.u = e.getU();
        this.l = e.getL();
        this.p = e.getP();
        this.le = e.getLE();
    }

    /**
     * Método que dá o código de uma Encomenda.
     * @return Devolve uma String do código.
     */
    public String getE(){
        return this.e;
    }

    /**
     * Método que define o código de uma Encomenda.
     * @param e Recebe uma String do código.
     */
    public void setE(String e){
        this.e = e;
    }

    /**
     * Método que dá o código de uma Utilizador.
     * @return Devolve uma String do código.
     */
    public String getU(){
        return this.u;
    }

    /**
     * Método que define o código de um Utilizador.
     * @param u Recebe uma String do código.
     */
    public void setU(String u){
        this.u = u;
    }

    /**
     * Método que dá o código de uma Loja.
     * @return Devolve uma String do código.
     */
    public String getL(){
        return this.l;
    }

    /**
     * Método que define o código de uma Loja.
     * @param l Recebe uma String do código.
     */
    public void setL(String l){
        this.l = l;
    }

    /**
     * Método que dá o valor do peso.
     * @return Devolve um double com o valor.
     */
    public double getP(){
        return this.p;
    }

    /**
     * Método que define o valor do peso.
     * @param p Recebe um double do valor.
     */
    public void setP(double p){
        this.p = p;
    }

    /**
     * Método que dá uma linha de encomenda.
     * @return Devolve uma lista de linhas de encomenda.
     */
    public List<LinhaEncomenda> getLE(){
        return this.le;
    }

    /**
     * Método que define uma linha de encomenda.
     * @param le  Recebe uma lista de linhas de encomenda.
     */
    public void setLE(List<LinhaEncomenda> le){
        this.le = le;
    }

    /**
     * Função que verifica se um objeto recebido é idêntico ao da classe Encomenda.
     * @param o Recebe um objeto.
     * @return Devolve um boolean com a respetiva verificação.
     */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Encomenda le = (Encomenda) o;
        return le.getE().equals(this.e) &&
                le.getU().equals(this.u) &&
                le.getL().equals(this.l) &&
                le.getP()==(this.p) &&
                le.getLE()==this.le;
    }

    /**
     * Função que traduz a classe Encomenda.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da TrazAqui.Encomenda").append(this.e)
                .append("\nCódigo go TrazAqui.Utilizador").append(this.u)
                .append("\nCódigo da TrazAqui.Loja").append(this.l)
                .append("\nPeso").append(this.p)
                .append("\nLinha de TrazAqui.Encomenda").append(this.le);
        return sb.toString();
    }

    /**
     * Função que faz clone da classe Encomenda.
     * @return Devolve esse clone.
     */
    @Override
    public Encomenda clone(){
        return new Encomenda(this);
    }
}
