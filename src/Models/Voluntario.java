package Models;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class Voluntario {
    private String id;
    private String nome;
    private GPS gps;
    private double raio;
    private boolean livre;
    private boolean certiftMed;
    private boolean livreMed;
    private List<Integer> classif;
    private LocalDateTime recolha;
    private LocalDateTime entrega;
    private Encomenda encomenda;

    /**
     * Construtor por omissão.
     */
    public Voluntario() {
        this.id = "";
        this.nome = "";
        this.gps = new GPS();
        this.raio = 0;
        this.livre = true;
        this.certiftMed = false;
        this.livreMed = false;
        this.recolha = LocalDateTime.now();

        this.classif = new ArrayList<>();
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
    public Voluntario(String id, String n, GPS gps, double raio, boolean livre, boolean certiftMed, boolean livreMed, List<Integer> c, Encomenda encomenda) {
        this.id = id;
        this.nome = n;
        this.gps = new GPS(gps);
        this.raio = raio;
        this.livre = livre;
        this.certiftMed = certiftMed;
        this.livreMed = livreMed;
        this.encomenda = encomenda.clone();
        this.classif = new ArrayList<>();
        for (Integer i : c)
            this.classif.add(i);
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
        this.certiftMed = v.getCertifMed();
        this.livreMed = aceitoTransporteMedicamentos();
        this.encomenda = v.getEncomenda();
        this.classif = v.getClassif();
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
     * Método que define o código de um Voluntário.
     *
     * @param id String que representa o código.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método que dá o nome de um Voluntário.
     * @return String que representa o nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que define o nome de um Voluntário.
     * @param n String que representa o nome.
     */
    public void setNome(String n) {
        this.nome = n;
    }

    /**
     * Método que dá a as coordenadas de um Voluntário.
     * @return Devolve essas coordenadas.
     */
    public GPS getGps() {
        return this.gps;
    }

    /**
     * Método que define as coordenadas de um Voluntário.
     * @param g Devolve essas coordenadas.
     */
    public void setGps(GPS g) {
        this.gps = g;
    }

    /**
     * Método que dá o raio de um Voluntário.
     * @return Devolve um double que representa o valor do raio.
     */
    public double getRaio() {
        return this.raio;
    }

    /**
     * Método que define o raio de um Voluntário.
     * @param raio Devolve o double com o valor do raio.
     */
    public void setRaio(double raio) {
        this.raio = raio;
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
     * Método aue define uma lista de classificações.
     * @param classif Recebe uma lista de Integer representante da lista de classificações.
     */
    public void setClassif(List<Integer> classif) {
        this.classif = classif;
    }

    /**
     * Função que verifica se o voluntário está ou não livre para ir buscar uma encomenda.
     * @return - True se estiver livre, false caso contrário
     */
    public boolean isLivre() {
        return livre;
    }

    /**
     * Função que verifica se o voluntário aceita encomendas de remédios no momento.
     * @return - True se puder transportar remédios no momento, false caso contrário.
     */
    public boolean aceitoTransporteMedicamentos(){
        return this.livreMed;
    }

    /**
     * Função que altera o estado do voluntário no que diz respeito ao transporte de remédios.
     * @param state - Novo estado do voluntário.
     */
    public void aceitaMedicamentos(boolean state){
        this.certiftMed = state;
    }

    /**
     * Função que retorna o boolean que diz se o voluntário possui certificado para transportar remédios ou não.
     * @return - True se tiver certificado, false caso contrário.
     */
    public boolean getCertifMed(){
        return this.certiftMed;
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código do Voluntário:  ").append(this.id)
                .append("\nNome do Voluntário:  ").append(this.nome)
                .append("\nGPS:  ").append(this.gps)
                .append("\nRaio:  ").append(this.raio)
                .append("\nLista de Classificações:  ").append(this.classif);
        return sb.toString();
    }

    /**
     * Função que calcula o tempo demorado a fazer a entrega.
     * @return - Tempo calculado.
     */
    public long tempoDeEntrega(){
        return this.recolha.until(LocalDateTime.now(), ChronoUnit.MINUTES);
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
    public void addClassificacaoV(int classificacao) {
        this.classif.add(classificacao);
    }

    /**
     * Função que retorna a encomenda que o voluntário está a transportar.
     * @return - Encomenda a transportar.
     */
    public Encomenda getEncomenda(){
        return this.encomenda.clone();
    }

    public void setEncomenda(Encomenda enc){
        this.encomenda = enc.clone();
    }

    public void aceitaEncomenda(Encomenda enc){
        this.livre = false;
        this.recolha = LocalDateTime.now();
        this.livreMed = false;
        setEncomenda(enc);
    }
}
