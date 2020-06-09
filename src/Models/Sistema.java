package Models;

import java.util.*;


public class Sistema {

    private List<Utilizador> utilizadores;
    private List<ITransportadora> transportes;
    private List<Loja> lojas;
    private List<Encomenda> historicoEncomendas;
    private List<Encomenda> encomendasPorEnviar;
    private List<AceitaEncomenda> encomendasAceites;


    /**
     * Construtor por omissão.
     */
    public Sistema() {
        this.utilizadores = new ArrayList<>();
        this.transportes = new ArrayList<>();
        this.lojas = new ArrayList<>();
        this.historicoEncomendas = new ArrayList<>();
        this.encomendasPorEnviar = new ArrayList<>();
        this.encomendasAceites = new ArrayList<>();

    }

    /**
     * Construtor parametrizado.
     */
    public Sistema(List<Utilizador> utilizadores, List<ITransportadora> transportes, List<Loja> loja,
                   List<Encomenda> historicoEncomendas, List<Encomenda> encomendasPorEnviar, List<AceitaEncomenda> encomendasAceites) {

        this.utilizadores = new ArrayList<>();
        for(Utilizador u : utilizadores) this.utilizadores.add(u.clone());
        this.transportes = new ArrayList<>();
        for(ITransportadora t : transportes) this.transportes.add(t.clone());
        this.lojas = new ArrayList<>();
        for(Loja l : loja) this.lojas.add(l.clone());
        this.historicoEncomendas = new ArrayList<>();
        for(Encomenda e : historicoEncomendas) this.historicoEncomendas.add(e.clone());
        this.encomendasPorEnviar = new ArrayList<>();
        for(Encomenda en : encomendasPorEnviar) this.encomendasPorEnviar.add(en.clone());
        this.encomendasAceites = new ArrayList<>();
        for(AceitaEncomenda enc : encomendasAceites) this.encomendasAceites.add(enc.clone());

    }

    /**
     * Construtor por cópia.
     * @param - Sistema a copiar.
     */
    public Sistema(Sistema s) {
        this.utilizadores = s.getUtilizadores();
        this.transportes = s.getTransportes();
        this.lojas = s.getLojas();
        this.historicoEncomendas = s.getHistorico();
        this.encomendasPorEnviar = s.getPorEnviar();
        this.encomendasAceites = s.getAceites();
    }

    /**
     * Método que dá a lista do utilizadores.
     * @return - Lista de utilizadores do sistema.
     */
    public List<Utilizador> getUtilizadores(){
        List<Utilizador> ret = new ArrayList<>();
        for (Utilizador u : this.utilizadores) ret.add(u.clone());
        return ret;
    }

    /**
     * Método que dá a lista de transportadoras do sistema (voluntários e empresas).
     * @return - Lista de transportadoras do sistema.
     */
    public List<ITransportadora> getTransportes(){
        List<ITransportadora> ret = new ArrayList<>();
        for(ITransportadora t : this.transportes) ret.add(t.clone());
        return ret;
    }

    /**
     * Método que dá a lista de lojas do sistema.
     * @return - Lojas do sistema.
     */
    public List<Loja> getLojas() {
        List<Loja> ret = new ArrayList<>();
        for (Loja l : this.lojas) ret.add(l.clone());
        return ret;
    }

    /**
     * Método que dá a lista do histórico de encomendas.
     * @return - Lista do histórico de encomendas.
     */
    public List<Encomenda> getHistorico() {
        List<Encomenda> ret = new ArrayList<>();
        for( Encomenda e : this.historicoEncomendas) ret.add(e.clone());
        return ret;
    }

    /**
     * Método que dá a lista de encomendas por enviar.
     * @return - Lista de encomendas por enviar.
     */
    public List<Encomenda> getPorEnviar() {
        List<Encomenda> ret = new ArrayList<>();
        for( Encomenda e : this.encomendasPorEnviar) ret.add(e.clone());
        return ret;
    }

    /**
     * Método que dá a lista de encomendas aceites, ou seja, a serem processadas.
     * @return - Lista de encomendas aceites.
     */
    public List<AceitaEncomenda> getAceites() {
        List<AceitaEncomenda> ret = new ArrayList<>();
        for( AceitaEncomenda a : this.encomendasAceites) ret.add(a.clone());
        return ret;
    }


    /**
     * Função que traduz a classe Sistema.
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString() {
        return "Sistema{" +
                "utilizadores=" + utilizadores +
                ", transportes=" + transportes +
                ", lojas=" + lojas +
                ", historicoEncomendas=" + historicoEncomendas +
                ", encomendasPorEnviar=" + encomendasPorEnviar +
                ", encomendasAceites=" + encomendasAceites +
                '}';
    }

    /**
     * Função que verifica se um objeto recebido é idêntico ao da classe Sistema.
     * @param o Recebe um objeto.
     * @return Devolve um boolean com a respetiva verificação.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sistema sistema = (Sistema) o;
        return Objects.equals(utilizadores, sistema.utilizadores) &&
                Objects.equals(transportes, sistema.transportes) &&
                Objects.equals(lojas, sistema.lojas) &&
                Objects.equals(historicoEncomendas, sistema.historicoEncomendas) &&
                Objects.equals(encomendasPorEnviar, sistema.encomendasPorEnviar) &&
                Objects.equals(encomendasAceites, sistema.encomendasAceites);
    }

    /**
     * Função que faz um clone da classe Sistema.
     * @return Devolve esse clone.
     */
    @Override
    public Sistema clone() {
        return new Sistema(this);
    }

    /**
     * Função que classifica um Voluntário.
     * @param cod Recebe uma String que representa o código de um Voluntário.
     * @param classificacao Recebe um Inteiro representante da classificação.
     */
    public void classificarTransportadora(String cod, int classificacao){
        for(ITransportadora t : this.transportes){
            if(t.getId() == cod) t.addClassificacao(classificacao);
        }
    }

    public void criaUtilizador(String id, String nome, String email, String password, double x, double y){
        List<Encomenda> vazia = new ArrayList<>();
        GPS gps = new GPS(x,y);
        Utilizador user = new Utilizador(id,nome,gps,vazia,email,password);
        this.utilizadores.add(user.clone());
    }



}


