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
     * Construtor parametrizado.
     * @param l String que representa o código de uma Loja.
     * @param n String representante do nome de uma Loja.
     * @param g Objeto da classe GPS, representa as coordenadas de uma Loja.
     */
    public Loja(String l, String n,GPS g){
        this.l = l;
        this.nome = n;
        this.g = new GPS(g);
    }

    /**
     * Construtor por cópia.
     * @param l Objeto da classe Loja.
     */
    public Loja(Loja l){
        this.l = l.getL();
        this.nome = l.getNome();
        this.g = new GPS(l.getGPS());
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
     * Método que define o nome de uma Loja.
     * @param n Recebe uma String do nome.
     */
    public void setNome(String n){
        this.nome = n;
    }

    /**
     * Método que dá as coordenadas de uma Loja.
     * @return Devolve as coordenadas.
     */
    public GPS getGPS(){
        return this.g;
    }

    /**
     * Método que define as coordenadas de uma Loja.
     * @param g Recebe um objeto da classe GPS.
     */
    public void setGPS(GPS g){
        this.g = g;
    }

    /**
     * Função que verifica se o objeto recebido é indêntico ao da classe Loja.
     * @param o Recebe um objeto.
     * @return Devolve um boolean que corresponde à verificação.
     */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Loja le = (Loja) o;
        return le.getL().equals(this.l) &&
                le.getNome().equals(this.nome) &&
                le.getGPS().equals(this.g);
    }

    /**
     * Função que traduz a classe Loja.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Loja").append(this.l)
                .append("\nNome da Loja").append(this.nome)
                .append("\nGPS").append(this.g);
        return sb.toString();
    }

    @Override
    public Loja clone(){
        return new Loja(this);
    }
}
