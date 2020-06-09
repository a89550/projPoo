package Models;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Sistema {
    private Map<String, GPS> gps;
    private Map<String, Utilizador> utilizadores; //aqui estarão os utilizadores do sistema
    private Map<String, Voluntario> vol;
    private Map<String, Loja> lojas;
    private Map<String, Transportadora> trans;
    private Map<String, LinhaEncomenda> lenc;
    private Map<String, Encomenda> enc;
    private Map<String, AceitaEncomenda> acenc;
    private Utilizador utilizador;
    private Loja loja;


    /**
     * Construtor por omissão.
     */
    public Sistema() {
        this.gps = new HashMap<>();
        this.utilizadores = new HashMap<>();
        this.vol = new HashMap<>();
        this.lojas = new HashMap<>();
        this.trans = new HashMap<>();
        this.lenc = new HashMap<>();
        this.enc = new HashMap<>();
        this.acenc = new HashMap<>();

    }

    /**
     * Construtor parametrizado.
     *
     * @param gps          Map em que a chave correponde a uma String e o valor à classe GPS.
     * @param utilizadores Map em que a chave corresponde a uma String e o valor à classe Utilizador.
     * @param lojas         Map em que a chave corresponde a uma String e o valor à classe Loja.
     * @param enc          Map em que a chave corresponde a uma String e o valor à classe Encomenda.
     * @param trans        Map em que a chave corresponde a uma String e o valor à classe Transportadora.
     * @param lenc         Map em que a chave corresponde a uma String e o valor à classe LinhaEncomenda.
     */
    public Sistema(Map<String, GPS> gps, Map<String, Utilizador> utilizadores, Map<String, Loja> lojas,
                   Map<String, Encomenda> enc, Map<String, Transportadora> trans, Map<String, LinhaEncomenda> lenc) {

        this.gps = new TreeMap<>();
        for (Map.Entry<String, GPS> e : (gps.entrySet())) {
            this.gps.put(e.getKey(), e.getValue().clone());
        }

        this.utilizadores = new TreeMap<>();
        for (Map.Entry<String, Utilizador> e : (utilizadores.entrySet())) {
            this.utilizadores.put(e.getKey(), e.getValue().clone());
        }

        this.vol = new TreeMap<>();
        for (Map.Entry<String, Voluntario> e : (vol.entrySet())) {
            this.vol.put(e.getKey(), e.getValue().clone());
        }

        this.lojas = new TreeMap<>();
        lojas.forEach((key, value) -> this.lojas.put(key, value.clone()));

        this.trans = new TreeMap<>();
        for (Map.Entry<String, Transportadora> e : (trans.entrySet())) {
            this.trans.put(e.getKey(), e.getValue().clone());
        }

        this.lenc = new TreeMap<>();
        for (Map.Entry<String, LinhaEncomenda> e : (lenc.entrySet())) {
            this.lenc.put(e.getKey(), e.getValue().clone());
        }

        this.enc = new TreeMap<>();
        for (Map.Entry<String, Encomenda> e : (enc.entrySet())) {
            this.enc.put(e.getKey(), e.getValue().clone());
        }

        this.acenc = new TreeMap<>();
        for (Map.Entry<String, AceitaEncomenda> e : (acenc.entrySet())) {
            this.acenc.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Construtor por cópia.
     *
     * @param sys
     */
    public Sistema(Sistema sys) {
        this.gps = sys.getGPS();
        this.utilizadores = sys.getUtilizadores();
        this.vol = sys.getVol();
        this.lojas = sys.getLojas();
        this.trans = sys.getTrans();
        this.lenc = sys.getLenc();
        this.enc = sys.getEnc();
        this.acenc = sys.getAcenc();
    }

    /**
     * Método de que dá um GPS.
     *
     * @return Devolve um GPS.
     */
    public Map<String, GPS> getGPS() {
        Map<String, GPS> ret = new TreeMap<>();
        for (Map.Entry<String, GPS> e : (this.gps.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que dá um Utilizador.
     *
     * @return Devolve um Utilizador.
     */
    public Map<String, Utilizador> getUtilizadores() {
        Map<String, Utilizador> ret = new TreeMap<>();
        for (Map.Entry<String, Utilizador> e : (this.utilizadores.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que dá um Voluntário.
     *
     * @return Devolve um Voluntário.
     */
    public Map<String, Voluntario> getVol() {
        Map<String, Voluntario> ret = new TreeMap<>();
        for (Map.Entry<String, Voluntario> e : (this.vol.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que dá uma Loja.
     *
     * @return Devolve uma Loja.
     */
    public Map<String, Loja> getLojas() {
        Map<String, Loja> ret = new TreeMap<>();
        for (Map.Entry<String, Loja> e : (this.lojas.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que dá uma Transportadora.
     *
     * @return Devolve uma Transportadora.
     */
    public Map<String, Transportadora> getTrans() {
        Map<String, Transportadora> ret = new TreeMap<>();
        for (Map.Entry<String, Transportadora> e : (this.trans.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que dá uma LinhaEncomenda.
     *
     * @return Devolve uma LinhaEncomenda.
     */
    public Map<String, LinhaEncomenda> getLenc() {
        Map<String, LinhaEncomenda> ret = new TreeMap<>();
        for (Map.Entry<String, LinhaEncomenda> e : (this.lenc.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que dá uma Encomenda.
     *
     * @return Devolve uma Encomenda.
     */
    public Map<String, Encomenda> getEnc() {
        Map<String, Encomenda> ret = new TreeMap<>();
        for (Map.Entry<String, Encomenda> e : (this.enc.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que dá uma AceitaEncomenda.
     *
     * @return Devolve uma AceitaEncomenda.
     */
    public Map<String, AceitaEncomenda> getAcenc() {
        Map<String, AceitaEncomenda> ret = new TreeMap<>();
        for (Map.Entry<String, AceitaEncomenda> e : (this.acenc.entrySet())) {
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }

    /**
     * Método que define um GPS.
     *
     * @param gps Recebe um GPS.
     */
    public void setGps(Map<String, GPS> gps) {
        this.gps = new TreeMap<>();
        for (Map.Entry<String, GPS> e : (gps.entrySet())) {
            this.gps.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Método que define um Utilizador.
     *
     * @param utilizadores Recebe um Utilizador.
     */
    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = new TreeMap<>();
        for (Map.Entry<String, Utilizador> e : (utilizadores.entrySet())) {
            this.utilizadores.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Método que define um Voluntário.
     *
     * @param vol Recebe um Voluntário.
     */
    public void setVol(Map<String, Voluntario> vol) {
        this.vol = new TreeMap<>();
        for (Map.Entry<String, Voluntario> e : (vol.entrySet())) {
            this.vol.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Método que define uma Loja.
     *
     * @param lojas Recebe uma loja.
     */
    public void setLojas(Map<String, Loja> lojas) {
        this.lojas = new TreeMap<>();
        for (Map.Entry<String, Loja> e : (lojas.entrySet())) {
            this.lojas.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Método que define uma Transportadora.
     *
     * @param trans Recebe uma Transportadora.
     */
    public void setTrans(Map<String, Transportadora> trans) {
        this.trans = new TreeMap<>();
        for (Map.Entry<String, Transportadora> e : (trans.entrySet())) {
            this.trans.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Método que define uma LinhaEncomenda.
     *
     * @param lenc Recebe uma LinhaEncomenda.
     */
    public void setLenc(Map<String, LinhaEncomenda> lenc) {
        this.lenc = new TreeMap<>();
        for (Map.Entry<String, LinhaEncomenda> e : (lenc.entrySet())) {
            this.lenc.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Método que define uma Encomenda.
     *
     * @param enc Recebe uma Encomenda.
     */
    public void setEnc(Map<String, Encomenda> enc) {
        this.enc = new TreeMap<>();
        for (Map.Entry<String, Encomenda> e : (enc.entrySet())) {
            this.enc.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Método que define um AceitaEncomenda.
     *
     * @param acenc Recebe um AceitaEncomenda.
     */
    public void setAcenc(Map<String, AceitaEncomenda> acenc) {
        this.acenc = new TreeMap<>();
        for (Map.Entry<String, AceitaEncomenda> e : (acenc.entrySet())) {
            this.acenc.put(e.getKey(), e.getValue().clone());
        }
    }

    /**
     * Função que traduz a classe Sistema.
     *
     * @return Devolve uma String com a respetiva tradução.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GPS:").append(this.gps)
                .append("\nUtilizador:").append(this.utilizadores)
                .append("\nVoluntario:").append(this.vol)
                .append("\nLoja:").append(this.lojas)
                .append("\nTransportadora:").append(this.trans)
                .append("\nLinha de Encomenda:").append(this.lenc)
                .append("\nEncomenda:").append(this.enc)
                .append("\nAceita Encomenda:").append(this.acenc);
        return sb.toString();
    }

    /**
     * Função que verifica se um objeto recebido é idêntico ao da classe Sistema.
     *
     * @param o Recebe um objeto.
     * @return Devolve um boolean com a respetiva verificação.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Sistema sys = (Sistema) o;
        return this.gps.equals(sys.getGPS()) && this.utilizadores.equals(sys.getUtilizadores()) &&
                this.vol.equals(sys.getVol()) && this.lojas.equals(sys.getLojas()) &&
                this.trans.equals(sys.getTrans()) && this.lenc.equals(sys.getLenc()) &&
                this.enc.equals(sys.enc) && this.acenc.equals(sys.acenc);

    }

    /**
     * Função que faz um clone da classe Sistema.
     *
     * @return Devolve esse clone.
     */
    @Override
    public Sistema clone() {
        return new Sistema(this);
    }

    /**
     * Função que classifica um Voluntário.
     *
     * @param cod           Recebe uma String que representa o código de um Voluntário.
     * @param classificacao Recebe um Inteiro representante da classificação.
     */
    public void classificarVoluntario(String cod, int classificacao) {
        this.vol.get(cod).addClassificacao(classificacao);
    }

    /**
     * Função que classifica uma Transportadora.
     *
     * @param cod           Recebe uma String que representa o código de uma Transportadora.
     * @param classificacao Recebe um Inteiro representante da classificação.
     */
    public void classificarTransportadora(String cod, int classificacao) {
        this.trans.get(cod).addClassificacao(classificacao);
    }

    /**
     * Função que aceita um pedido.
     *
     * @param cod       Recebe uma String que representa o código de um utilizador.
     * @param encomenda Recebe uma encomenda.
     */
    public void aceitaPedido(String cod, Encomenda encomenda) {
        this.utilizadores.get(cod).addEncomenda(encomenda);
    }

    /**
     * Função de início de sessão da aplicação de um utilizador.
     * @param email    Recebe um email de um Utilizador.
     * @param password Recebe uma password de um Utilizador.
     */
    public void iniciaSessaoUtil(String email, String password) {
        if (this.utilizador == null) {  //se o utilizador não existir.
            if (utilizadores.containsKey(email)) {
                Utilizador u = this.utilizadores.get(email);
                if (password.equals(u.getPassword()))
                    this.utilizador = u;
            }
        }
    }

    /**
     * Função de início de sessão da aplicação de uma loja.
     * @param email Recebe um email de uma Loja.
     * @param password Recebe uma password de uma Loja.
     */
    public void iniciaSessaoLoja(String email, String password) {
        if (this.loja == null) {
            if (lojas.containsKey(email)) {
                Loja l = this.lojas.get(email);
                if (password.equals(l.getPassword()))
                    this.loja = l;
            }
        }
    }

    /**
     * Função que permite fechar/terminar a sessão.
     */
    public void terminaSessao() {
       this.utilizador = null;
       this.loja = null;
    }


}
