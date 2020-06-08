package Models;

import java.util.ArrayList;
import java.util.List;

public class Encomenda{
    private String id;
    private String user;
    private String loja;
    private double peso;
    private List<LinhaEncomenda> produtos;

    /**
     * Construtor por omissão.
     */
    public Encomenda(){
        this.id = "";
        this.user = "";
        this.loja = "";
        this.peso = 0;
        this.produtos = new ArrayList<>();
    }

    /**
     * Construtor parametrizado.
     * @param e String que representa o código de uma Encomenda.
     * @param user String que representa o código de um Utilizador.
     * @param loja String que representa o código de uma Loja.
     * @param p Double que representa o peso.
     * @param produtos Lista das linhas de encomenda.
     */
    public Encomenda(String e, String user, String loja, double p, List<LinhaEncomenda> produtos){
        this.id = e;
        this.user = user;
        this.loja = loja;
        this.peso = p;
        this.produtos = new ArrayList<>();
        for(LinhaEncomenda lenc : produtos){
            this.produtos.add(lenc.clone());
        }
    }

    /**
     * Construtor por cópia.
     * @param e Recebe um objeto da classe Encomenda.
     */
    public Encomenda(Encomenda e){
        this.id = e.getId();
        this.user = e.getUser();
        this.loja = e.getLoja();
        this.peso = e.getPeso();
        this.produtos = e.getLE();
    }

    /**
     * Método que dá o código de uma Encomenda.
     * @return Devolve uma String do código.
     */
    public String getId(){
        return this.id;
    }

    /**
     * Método que define o código de uma Encomenda.
     * @param id Recebe uma String do código.
     */
    public void setId(String id){
        this.id = id;
    }

    /**
     * Método que dá o código de uma Utilizador.
     * @return Devolve uma String do código.
     */
    public String getUser(){
        return this.user;
    }

    /**
     * Método que define o código de um Utilizador.
     * @param user Recebe uma String do código.
     */
    public void setUser(String user){
        this.user = user;
    }

    /**
     * Método que dá o código de uma Loja.
     * @return Devolve uma String do código.
     */
    public String getLoja(){
        return this.loja;
    }

    /**
     * Método que define o código de uma Loja.
     * @param loja Recebe uma String do código.
     */
    public void setLoja(String loja){
        this.loja = loja;
    }

    /**
     * Método que dá o valor do peso.
     * @return Devolve um double com o valor.
     */
    public double getPeso(){
        return this.peso;
    }

    /**
     * Método que define o valor do peso.
     * @param peso Recebe um double do valor.
     */
    public void setPeso(double peso){
        this.peso = peso;
    }

    /**
     * Método que dá uma linha de encomenda.
     * @return Devolve uma lista de linhas de encomenda.
     */
    public List<LinhaEncomenda> getLE(){
        return this.produtos;
    }

    /**
     * Método que define uma linha de encomenda.
     * @param le  Recebe uma lista de linhas de encomenda.
     */
    public void setLE(List<LinhaEncomenda> le){
        this.produtos = le;
    }

    /**
     * Função que adiciona um produto à encomenda.
     * @param produto - Produto a ser adicionado.
     */
    public void addProduto(LinhaEncomenda produto){
        this.produtos.add(produto);
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
        return le.getId().equals(this.id) &&
                le.getUser().equals(this.user) &&
                le.getLoja().equals(this.loja) &&
                le.getPeso()==(this.peso) &&
                le.getLE()==this.produtos;
    }

    /**
     * Função que traduz a classe Encomenda.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da TrazAqui.Encomenda").append(this.id)
                .append("\nCódigo go TrazAqui.Utilizador").append(this.user)
                .append("\nCódigo da TrazAqui.Loja").append(this.loja)
                .append("\nPeso").append(this.peso)
                .append("\nLinha de TrazAqui.Encomenda").append(this.produtos);
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
