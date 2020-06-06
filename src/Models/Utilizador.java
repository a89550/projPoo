package Models;

import java.util.List;

public class Utilizador {

    private String u;
    private String nome;
    private GPS g;

    /**
     * Construtor por cópia.
     */
    public Utilizador() {
        this.u = "";
        this.nome = "";
        this.g = new GPS();
    }

    /**
     * Construtor parametrizado.
     *
     * @param u String correspondente ao código de um Utilizador.
     * @param n String que corresponde ao nome de um Utilizador.
     * @param g objeto da classe GPS corresponde às coordenadas.
     */
    public Utilizador(String u, String n, GPS g) {
        this.u = u;
        this.nome = n;
        this.g = new GPS(g);
    }

    /**
     * Construtor por cópia.
     *
     * @param u Recebe um objeto da classe Utilizador.
     */
    public Utilizador(Utilizador u) {
        this.u = u.getU();
        this.nome = u.getNome();
        this.g = new GPS(u.getGps());
    }

    /**
     * Método que dá o código de um Utilizador.
     *
     * @return String que representa o código.
     */
    public String getU() {
        return this.u;
    }

    /**
     * Método que define o código de um Utilizador.
     *
     * @param u String representante do código de um Utilizador.
     */
    public void setU(String u) {
        this.u = u;
    }

    /**
     * Método que dá o nome de um Utilizador.
     *
     * @return Devolve uma String que representa o nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método que define o nome de um Utilizador.
     *
     * @param n String representante do nome.
     */
    public void setNome(String n) {
        this.nome = n;
    }

    /**
     * Método que dá as coordenadas de um Utilizador.
     *
     * @return Devolve GPS que corrresponde às coordenadas.
     */
    public GPS getGps() {
        return this.g;
    }

    /**
     * Método que define as coordenadas de um Utilizador.
     *
     * @param g Recebe um objeto da classe GPS.
     */
    public void setGps(GPS g) {
        this.g = g;
    }

    /**
     * Função que verifica se o objeto recebido é idêntico ao da classe Utilizador.
     *
     * @param o Recebe o objeto.
     * @return Devolve um boolean que corresponde à verificação.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Utilizador le = (Utilizador) o;
        return le.getU().equals(this.u) &&
                le.getNome().equals(this.nome) &&
                le.getGps().equals(this.g);
    }

    /**
     * Função que traduz a classe Utilizador.
     *
     * @return Devolve uma String que representa a tradução.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código de utilizador:").append(this.u)
                .append("\nNome do utlizador").append(this.nome)
                .append("\nTrazAqui.GPS").append(this.g);
        return sb.toString();
    }

    /**
     * Função que faz um clone da classe Utilizador.
     *
     * @return Devolve esse clone.
     */
    @Override
    public Utilizador clone() {
        return new Utilizador(this);
    }

}
