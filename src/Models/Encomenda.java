package Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Encomenda{
    private String id;
    private String user;
    private String loja;
    private double peso;
    private List<LinhaEncomenda> produtos;
    private LocalDateTime qPedidoAceite;
    private LocalDateTime qPedidoEntregue;
    private boolean encomendaMedica;

    /**
     * Construtor por omissão.
     */
    public Encomenda(){
        this.id = "";
        this.user = "";
        this.loja = "";
        this.peso = 0;
        this.produtos = new ArrayList<>();
        this.qPedidoAceite = LocalDateTime.now();
        this.qPedidoEntregue = LocalDateTime.now();
        this.encomendaMedica = false;
    }

    /**
     * Construtor parametrizado.
     * @param e String que representa o código de uma Encomenda.
     * @param user String que representa o código de um Utilizador.
     * @param loja String que representa o código de uma Loja.
     * @param p Double que representa o peso.
     * @param produtos Lista das linhas de encomenda.
     * @param qPedidoAceite LocalDateTime que representa o momento de quando o pedido foi aceite.
     * @param qPedidoEntregue LocalDateTime representante o momento de quando o pedido foi entregue.
     * @param encomendaMedica Boolean que verifica se uma encomenda é médica ou não.
     */
    public Encomenda(String e, String user, String loja, double p, List<LinhaEncomenda> produtos,
                     LocalDateTime qPedidoAceite, LocalDateTime qPedidoEntregue, boolean encomendaMedica){
        this.id = e;
        this.user = user;
        this.loja = loja;
        this.peso = p;
        this.produtos = new ArrayList<>();
        for(LinhaEncomenda lenc : produtos){
            this.produtos.add(lenc.clone());
        }
        this.qPedidoAceite = qPedidoAceite;
        this.qPedidoEntregue = qPedidoEntregue;
        this.encomendaMedica = encomendaMedica;
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
        this.qPedidoAceite = e.getQPedidoAceite();
        this.qPedidoEntregue = e.getQPedidoEntregue();
        this.encomendaMedica = e.getEncomendaMedica();
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
     * Método que dá o tempo em que um pedido foi aceite.
     * @return Devolve o tempo.
     */
    public LocalDateTime getQPedidoAceite() {
        return this.qPedidoAceite;
    }

    /**
     * Método que define o tempo em que um pedido foi aceite.
     * @param qPedidoAceite Recebe um LocalDateTime correspondente ao tempo.
     */
    public void setQPedidoAceite(LocalDateTime qPedidoAceite) {
        this.qPedidoAceite = qPedidoAceite;
    }

    /**
     * Método que dá o tempo que um pedido demora a ser entregue.
     * @return Devolve esse tempo.
     */
    public LocalDateTime getQPedidoEntregue() {
        return this.qPedidoEntregue;
    }

    /**
     * Método que define o tempo que um pedido demora a ser entregue.
     * @param qPedidoEntregue Recebe um LocalDateTime representante desse tempo.
     */
    public void setQPedidoEntregue(LocalDateTime qPedidoEntregue) {
        this.qPedidoEntregue = qPedidoEntregue;
    }

    /**
     * Método que verfica se uma encomenda é ou não médica.
     * @return Devolve um boolean que corresponde a essa verificação.
     */
    public boolean getEncomendaMedica() {
        return this.encomendaMedica;
    }

    /**
     * Método aue define se uma encomenda é médica.
     * @param encomendaMedica Recebe um boolean correspondente à encomenda.
     */
    public void setEncomendaMedica(boolean encomendaMedica) {
        this.encomendaMedica = encomendaMedica;
    }

    /*
    /**
     * Função que adiciona um produto à encomenda.
     * @param produto - Produto a ser adicionado.

    public void addProduto(LinhaEncomenda produto){
        this.produtos.add(produto);
    }
    */

    /**
     * Função que adiciona uma linha de encomenda à lista de linhas de encomenda.
     * @param codP String que representa o código de um produto.
     * @param desP String que corresponde à descrição de um produto.
     * @param quantP Double representante da quantidade de uma linha de encomenda.
     * @param valorU Souble correspondente ao valor unitário.
     */
    public void addProduto(String codP, String desP, double quantP, double valorU) {
        LinhaEncomenda lenc = new LinhaEncomenda(codP,desP,quantP,valorU);
        this.produtos.add(lenc);
    }

    /**
     * Função que remove um produto à encomenda.
     * @param produto Recebe uma linha de encomenda.
     */
    public void removeProduto(LinhaEncomenda produto) {
        this.produtos.remove(produto);
    }

    /**
     * Função que calcula o número total de produtos.
     * @return Devolve um Inteiro que representa o número de Produtos.
     */
    public int numeroTotalProdutos() {
        int ret = 0;
        for (int i = 0; i < this.produtos.size(); i++) ret += this.produtos.get(i).getQ();
        return ret;
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
        Encomenda e = (Encomenda) o;
        return e.getId().equals(this.id) &&
                e.getUser().equals(this.user) &&
                e.getLoja().equals(this.loja) &&
                e.getPeso()==(this.peso) &&
                e.getLE()==this.produtos &&
                e.getQPedidoAceite().equals(this.qPedidoAceite) &&
                e.getEncomendaMedica() == this.encomendaMedica;
    }

    /**
     * Função que traduz a classe Encomenda.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da TrazAqui.Encomenda:  ").append(this.id)
                .append("\nCódigo do Utilizador:  ").append(this.user)
                .append("\nCódigo da Loja:  ").append(this.loja)
                .append("\nPeso:  ").append(this.peso)
                .append("\nLinha de Encomenda:  ").append(this.produtos)
                .append("\nMomento em que um pedido foi aceite:  ").append(this.qPedidoAceite)
                .append("\nA encomenda é médica?:  ").append(this.encomendaMedica);
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
