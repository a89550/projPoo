package Models;

public class Voluntario {
    private String v;
    private String nome;
    private GPS g;
    private double r;

    /**
     * Construtor por omissão.
     */
    public Voluntario(){
        this.v = "";
        this.nome = "";
        this.g = new GPS();
        this.r = 0;
    }

    /**
     * Construtor parametrizado.
     * @param v String que corresponde ao código de um Voluntário.
     * @param n String correspondente ao nome de um Voluntário.
     * @param g Objeto da classe GPS que representa as coordenadas de um Voluntário.
     * @param r Double representante do raio.
     */
    public Voluntario(String v, String n, GPS g, double r){
        this.v = v;
        this.nome = n;
        this.g = new GPS(g);
        this.r = r;
    }

    /**
     * Construtor por cópia.
     * @param v Recebe um objeto da classe Voluntário.
     */
    public Voluntario(Voluntario v){
        this.v = v.getV();
        this.nome = v.getNome();
        this.g = new GPS(v.getGps());
        this.r = v.getR();
    }

    /**
     * Método que dá o código de um Voluntário.
     * @return Devolve esse código.
     */
    public String getV(){
        return this.v;
    }

    /**
     * Método que define o código de um Voluntário.
     * @param v String que representa o código.
     */
    public void setV(String v){
        this.v = v;
    }

    /**
     * Método que dá o nome de um Voluntário.
     * @return String que representa o nome.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Método que define o nome de um Voluntário.
     * @param n String que representa o nome.
     */
    public void setNome(String n){
        this.nome = n;
    }

    /**
     * Método que dá a as coordenadas de um Voluntário.
     * @return Devolve essas coordenadas.
     */
    public GPS getGps(){
        return this.g;
    }

    /**
     * Método que define as coordenadas de um Voluntário.
     * @param g Devolve essas coordenadas.
     */
    public void setGps(GPS g){
        this.g = g;
    }

    /**
     * Método que dá o raio de um Voluntário.
     * @return Devolve um double que representa o valor do raio.
     */
    public double getR(){
        return this.r;
    }

    /**
     * Método que define o raio de um Voluntário.
     * @param r Devolve o double com o valor do raio.
     */
    public void setR(double r){
        this.r = r;
    }

    /**
     * Função que verifica se o objeto recebido é idêntico ao da classe Voluntário.
     * @param o Recebe um objeto.
     * @return Devolve um boolean que representa a verificação.
     */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Voluntario le = (Voluntario) o;
        return le.getV().equals(this.v) &&
                le.getNome().equals(this.nome) &&
                le.getGps().equals(this.g) &&
                le.getR()==(this.r);
    }

    /**
     * Função que traduz a classe Voluntário.
     * @return Devolve uma String que corresponde à tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código do Voluntário:").append(this.v)
                .append("\nNome do Voluntário").append(this.nome)
                .append("\nTrazAqui.GPS").append(this.g)
                .append("\nRaio:").append(this.r);
        return sb.toString();
    }

    /**
     * Função que fornece um clone da classe Voluntário.
     * @return Devolve esse clone.
     */
    @Override
    public Voluntario clone(){
        return new Voluntario(this);
    }
}
