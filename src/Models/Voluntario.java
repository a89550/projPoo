package Models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Voluntario implements Serializable {
    private String id;
    private String nome;
    private String email;
    private String password;
    private GPS gps;
    private double raio;
    private boolean livre;
    private List<Integer> classif;
    private List<Encomenda> historico;
    private double velocidadeMedia;
    private boolean medica;
    private boolean livreMed;

    /**
     * Construtor por omissão.
     */
    public Voluntario() {
        this.id = "";
        this.nome = "";
        this.email = "";
        this.password = "";
        this.gps = new GPS();
        this.raio = 0;
        this.livre = true;
        this.classif = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.velocidadeMedia = 0;
        this.medica = false;
        this.livreMed = false;
    }

    /**
     * Construtor parametrizado.
     *
     * @param id String que corresponde ao código de um Voluntário.
     * @param n String correspondente ao nome de um Voluntário.
     * @param gps Objeto da classe GPS que representa as coordenadas de um Voluntário.
     * @param raio Double representante do raio.
     * @oaram c Lista de Integer representante da lista de classificações.
     */
    public Voluntario(String id, String n, String email, String password, GPS gps, double raio, boolean livre,
                      List<Integer> c, List<Encomenda> historico, double vel, boolean med, boolean livreMed) {
        this.id = id;
        this.nome = n;
        this.email = email;
        this.password = password;
        this.gps = new GPS(gps);
        this.raio = raio;
        this.livre = livre;
        this.historico = new ArrayList<>();
        for(Encomenda e : historico) this.historico.add(e.clone());
        this.classif = new ArrayList<>();
        for (Integer i : c)
            this.classif.add(i);
        this.velocidadeMedia = vel;
        this.medica = med;
        this.livreMed = livreMed;
    }

    /**
     * Construtor por cópia.
     *
     * @param v Recebe um objeto da classe Voluntário.
     */
    public Voluntario(Voluntario v) {
        this.id = v.getId();
        this.nome = v.getNome();
        this.gps = new GPS(v.getGps());
        this.raio = v.getRaio();
        this.livre = v.isLivre();
        this.historico = new ArrayList<>();
        for(Encomenda e : v.getHistorico()) this.historico.add(e.clone());
        this.classif = new ArrayList<>();
        for(Integer i : v.getClassif()) this.classif.add(i);
        this.velocidadeMedia = v.getVelocidadeMedia();
        this.medica = v.aceitoTransporteMedicamentos();
        this.livreMed = v.getLivreMed();
    }


    /**
     * Função que verifica se o voluntário está livre para transportar encomendas médicas.
     * @return - True se estiver livre para transportar medicamentos, false caso contrário.
     */
    public boolean getLivreMed(){
        return this.livreMed;
    }

    /**
     * Método que dá o código de um Voluntário.
     *
     * @return Devolve esse código.
     */
    public String getId() {
        return this.id;
    }


    /**
     * Método que dá o nome de um Voluntário.
     * @return String que representa o nome.
     */
    public String getNome() {
        return this.nome;
    }


    /**
     * Método que dá a as coordenadas de um Voluntário.
     * @return Devolve essas coordenadas.
     */
    public GPS getGps() {
        return this.gps;
    }


    /**
     * Método que dá o raio de um Voluntário.
     * @return Devolve um double que representa o valor do raio.
     */
    public double getRaio() {
        return this.raio;
    }


    /**
     * Método que dá a lista das classificações.
     * @return Devolve uma lista de Integer representante da lista de classificações.
     */
    public List<Integer> getClassif() {
        List<Integer> ret = new ArrayList<>();
        for (Integer i : ret)
            ret.add(i);
        return ret;
    }

    /**
     * Função que verifica se o voluntário está ou não livre para ir buscar uma encomenda.
     * @return - True se estiver livre, false caso contrário
     */
    public boolean isLivre() {
        return livre;
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
        Voluntario v = (Voluntario) o;
        return v.getId().equals(this.id) &&
                v.getNome().equals(this.nome) &&
                v.getGps().equals(this.gps) &&
                v.getRaio()==(this.raio) &&
                v.getClassif().equals(this.classif);
    }

    /**
     * Função que traduz a classe Voluntário.
     * @return Devolve uma String que corresponde à tradução.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código do Voluntário:  ").append(this.id)
                .append("\nNome do Voluntário:  ").append(this.nome)
                .append("\nEmail: ").append(this.email)
                .append("\nPassword: ").append(this.password)
                .append("\nGPS:  ").append(this.gps)
                .append("\nRaio:  ").append(this.raio)
                .append("\nEstá livre: ").append(this.livre)
                .append("\nTransporta remédios: ").append(this.livreMed)
                .append("\nVelocidade média: ").append(this.velocidadeMedia)
                .append("\nHistórico: ").append(this.historico)
                .append("\nLista de Classificações:  ").append(this.classif);
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

    /**
     * Função que adiciona uma classificação à lista de classificações.
     * @param classificacao Recebe um Inteiro que representa o valor da classificação.
     */
    public void addClassificacao(int classificacao) {
        this.classif.add(classificacao);
    }

    /**
     * Função que retorna a encomenda que o voluntário está a transportar.
     * @return - Encomenda a transportar.
     */
    public List<Encomenda> getHistorico(){
        List<Encomenda> ret = new ArrayList<>();
        for(Encomenda e : this.historico) ret.add(e.clone());
        return ret;
    }



    /**
     * Função que aceita uma encomenda.
     * @param enc - Encomenda a aceitar.
     */
    public void aceitaEncomenda(Encomenda enc){
        this.livre = false;
        aceitaMedicamentos(false);
        this.historico.add(enc);
    }



    /**
     * Função auxiliar que calcula a distância entre duas coordenadas GPS.
     * @param gps1 - Primeira coordenada.
     * @param gps2 - Segunda coordenada.
     * @return - Distância entre os dois pontos.
     */
    public double auxDist(GPS gps1, GPS gps2){
        double d1 = Math.pow((gps2.getX() - gps1.getX()),2);
        double d2 = Math.pow((gps2.getY() - gps2.getY()),2);
        return Math.sqrt(d1+d2);
    }


    /**
     * Função que verifica se uma loja e um utilizador estão dentro do raio de ação do voluntário.
     * @param loja - Coordenadas gps da loja.
     * @param util - Coordenadas gps do utilizador.
     * @return - True se pertencer, false caso contrário.
     */
    public boolean dentroDoRaio(GPS loja, GPS util){
        boolean ret = false;
        if(auxDist(this.gps,loja) <= this.raio && auxDist(this.gps,util) <= this.raio) ret = true;
        return ret;
    }

    /**
     * Função que calcula o tempo que se demora a ir da loja até á casa do utilizador.
     * @param loja - Coordenadas gps da loja.
     * @param util - Coordenadas gps do utilizador.
     * @return - Tempo calculado.
     */
    public int tempoDeVolta(GPS loja, GPS util){
        double d = auxDist(loja,util);
        double t = d/this.velocidadeMedia;
        return (int)t;
    }

    /**
     * Função que calcula o tempo que se demora a ir do local da transportadora até à loja.
     * @param loja - Coordenadas gps da loja.
     * @return - Tempo calculado.
     */
    public int tempoDeIda(GPS loja){
        double d = auxDist(this.gps,loja);
        double t = d/this.velocidadeMedia;
        return (int)t;
    }

    /**
     * Função que retorna a velocidade média do voluntário.
     * @return - Velocidade média do voluntário.
     */
    public double getVelocidadeMedia() {
        return this.velocidadeMedia;
    }

    /**
     * Função que retorna a password do voluntário.
     * @return - Password do voluntário.
     */
    public String getPassword() {
        return this.password;
    }


    /**
     * Função que retorna o email do voluntário.
     * @return - Email do voluntário.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Função que verifica se o voluntário aceita encomendas de remédios no momento.
     * @return - True se puder transportar remédios no momento, false caso contrário.
     */
    public boolean aceitoTransporteMedicamentos(){
        return this.medica;
    }

    /**
     * Função que altera o estado do voluntário no que diz respeito ao transporte de remédios.
     * @param state - Novo estado do voluntário.
     */
    public void aceitaMedicamentos(boolean state){
        this.livreMed = state;
    }

    /**
     * Função que torna um voluntário livre para transportar encomendas.
     */
    public void tornaLivre(){
        this.livre = true;
        if(this.medica) this.livreMed = true;
    }
}
