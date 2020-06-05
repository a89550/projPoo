package Models;

public class Transportadora {
    private String t;
    private String nome;
    private GPS g;
    private int nif;
    private double r;
    private double pkm;

    /**
     * Construtor por omissão.
     */
    public Transportadora(){
        this.t = "";
        this.nome = "";
        this.g = new GPS();
        this.nif = -1;
        this.r = 0;
        this.pkm = -1;
    }

    /**
     * Construtor parametrizado.
     * @param t String que representa o código da empresa.
     * @param n String representante do nome da empresa.
     * @param g objeto da classe GPs que representa as coordenadas de uma Transportadora.
     * @param nif Double representante do número de identificação fiscal.
     * @param r Double que representa o raio de uma Transportadora.
     * @param pkm Double represetante do preço por km de uma Transportadora.
     */
    public Transportadora(String t, String n, GPS g, int nif, double r, double pkm){
        this.t = t;
        this.nome = n;
        this.g = g;
        this.nif = nif;
        this.r = r;
        this.pkm = pkm;
    }

    /**
     * Construtor por cópia.
     * @param t Objeto da classe Transportadora.
     */
    public Transportadora(Transportadora t){
        this.t = t.getT();
        this.nome = t.getNome();
        this.g = t.getGps();
        this.nif = t.getNif();
        this.r = t.getR();
        this.pkm = t.getPkm();
    }

    /**
     * Método que dá o código de uma empresa.
     * @return Devolve esse código.
     */
    public String getT(){
        return this.t;
    }

    /**
     * Método que define o código de uma empresa.
     * @param t String que representa esse código.
     */
    public void setT(String t){
        this.t = t;
    }

    /**
     * Método que dá o nome de uma empresa.
     * @return Devolve uma String com o nome.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Método que define o nome de uma empresa.
     * @param n Recebe uma String que corresponde ao nome.
     */
    public void setNome(String n){
        this.nome = n;
    }

    /**
     * Método que dá as coordenadas de uma Transportadora.
     * @return Devolve as coordenadas.
     */
    public GPS getGps(){
        return this.g;
    }

    /**
     * Método que define as coordenadas de uma Transportadora.
     * @param g Recebe um objeto da classe GPS
     */
    public void setGps(GPS g){
        this.g = g;
    }

    /**
     * Método que dá o número de identificação fiscal.
     * @return Devolve o nif.
     */
    public int getNif(){
        return this.nif;
    }

    /**
     * Método que define o número de identificação fiscal.
     * @param nif Devolve o nif.
     */
    public void setNif(int nif){
        this.nif = nif;
    }

    /**
     * Método que dá o raio de uma Transportadora.
     * @return Devolve esse raio.
     */
    public double getR(){
        return this.r;
    }

    /**
     * Método que define o raio de uma Transportadora.
     * @param r Double representante do raio.
     */
    public void setR(double r){
        this.r = r;
    }

    /**
     * Método que dá o preço por km de uma Transportadora.
     * @return Devolve esse preço.
     */
    public double getPkm(){
        return this.pkm;
    }

    /**
     * Método que define o preço por km de uma Transportadora.
     * @param pkm Devolve esse preço.
     */
    public void setPkm(double pkm){
        this.pkm = pkm;
    }

    /**
     * Função que verfica se o objeto recebido é idêntico ao da classse Transportadora.
     * @param o Recebe um objeto.
     * @return Devolve um boolean que corresponde a essa verificação.
     */
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Transportadora le = (Transportadora) o;
        return le.getT().equals(this.t) &&
                le.getNome().equals(this.nome) &&
                le.getGps().equals(this.g) &&
                le.getNif()==(this.nif) &&
                le.getR()==(this.r) &&
                le.getPkm()==(this.pkm);
    }

    /**
     * Função que traduz a classe Transportadora.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Empresa: ").append(this.t)
                .append("\nNome da Empresa: ").append(this.nome)
                .append("\nGPS: ").append(this.g)
                .append("\nNIF: ").append(this.nif)
                .append("\nRaio: ").append(this.r)
                .append("\nPreço por Km: ").append(this.pkm);
        return sb.toString();
    }

    /**
     * Função que faz um clone da classe Transportadora.
     * @return Devolve esse clone.
     */
    @Override
    public Transportadora clone(){
        return new Transportadora(this);
    }
}
