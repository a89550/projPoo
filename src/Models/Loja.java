package Models;

public class Loja {
    private String l;
    private String nome;
    private GPS g;

    /**
     * Construtor por cópia.
     */
    public Loja(){
        this.l = "";
        this.nome = "";
        this.g = new GPS();
    }

    /**
     * Construtor por omissão.
     * @param l String que representa o código de uma Loja.
     * @param n String que representa o nome de uma Loja.
     * @param g Objeto da classe GPS que representa as coordenadas.
     */
    public Loja(String l, String n,GPS g){
        this.l = l;
        this.nome = n;
        this.g = new GPS(g);
    }

    /**
     * Construtor por cópia.
     * @param l Recebe um objeto da classe Loja.
     */
    public Loja(Loja l){
        this.l = l.getL();
        this.nome = l.getNome();
        this.g = new GPS(l.getGps());
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
     * Método que dá o nome de uma Loja.
     * @return Devolve uma String do nome.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Método que define o nome de uma Loja
     * @param n Recebe uma String do nome.
     */
    public void setNome(String n){
        this.nome = n;
    }

    /**
     * Método que dá o GPS.
     * @return  Devolve o GPS.
     */
    public GPS getGps(){
        return this.g;
    }

    /**
     * Método que define um GPS.
     * @param g
     */
    public void setGps(GPS g){
        this.g = g;
    }

    /**
     * Função que verifica se o objeto recebido é idêntico ao da classe Loja.
     * @param o Recebe um objeto.
     * @return Devolve um boolean com a respetiva verificação.
     */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Loja le = (Loja) o;
        return le.getL().equals(this.l) &&
                le.getNome().equals(this.nome) &&
                le.getGps().equals(this.g);
    }

    /**
     * Função que traduz a classe Loja.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da TrazAqui.Loja").append(this.l)
                .append("Nome da TrazAqui.Loja").append(this.nome)
                .append("TrazAqui.GPS").append(this.g);
        return sb.toString();
    }

    /**
     * Função que faz um clone da classe Loja.
     * @return Devolve esse clone.
     */
    @Override
    public Loja clone(){
        return new Loja(this);
    }
}
