package Models;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sistema {
    private Map<String,GPS> gps;
    private Map<String,Utilizador> util;
    private Map<String,Voluntario> vol;
    private Map<String,Loja> loja;
    private Map<String,Transportadora> trans;
    private Map<String,LinhaEncomenda> lenc;
    private Map<String,Encomenda> enc;
    private Map<String,AceitaEncomenda> acenc;

    public Sistema() {
        this.gps = new HashMap<>();
        this.util = new HashMap<>();
        this.vol = new HashMap<>();
        this.loja = new HashMap<>();
        this.trans = new HashMap<>();
        this.lenc = new HashMap<>();
        this.enc = new HashMap<>();
        this.acenc = new HashMap<>();

    }

    public Sistema(Map<String, GPS> gps, Map<String,Utilizador> util, Map<String, Loja> loja,
                   Map<String, Encomenda> enc, Map<String, Transportadora> trans, Map<String,LinhaEncomenda> lenc) {
        this.gps = new TreeMap<>();
        (gps.entrySet()).forEach(e -> this.gps.put(e.getKey(),e.getValue().clone()));
        this.util = new TreeMap<>();
        (util.entrySet()).forEach(e -> this.util.put(e.getKey(),e.getValue().clone()));
        this.vol = new TreeMap<>();
        (vol.entrySet()).forEach(e -> this.vol.put(e.getKey(),e.getValue().clone()));
        this.loja = new TreeMap<>();
        loja.forEach((key, value) -> this.loja.put(key, value.clone()));
        this.trans = new TreeMap<>();
        (trans.entrySet()).forEach(e -> this.trans.put(e.getKey(),e.getValue().clone()));
        this.lenc = new TreeMap<>();
        (lenc.entrySet()).forEach(e -> this.lenc.put(e.getKey(),e.getValue().clone()));
        this.enc = new TreeMap<>();
        (enc.entrySet()).forEach(e -> this.enc.put(e.getKey(),e.getValue().clone()));
        this.acenc = new TreeMap<>();
        (acenc.entrySet()).forEach(e -> this.acenc.put(e.getKey(),e.getValue().clone()));
    }

    public Sistema(Sistema sys) {
        this.gps = sys.getGPS();
        this.util = sys.getUtil();
        this.vol = sys.getVol();
        this.loja = sys.getLoja();
        this.trans = sys.getTrans();
        this.lenc = sys.getLenc();
        this.enc = sys.getEnc();
        this.acenc = sys.getAcenc();
    }

    public Map<String,GPS> getGPS(){
        Map<String,GPS> ret = new TreeMap<>();
        (this.gps.entrySet()).forEach(e -> ret.put(e.getKey(),e.getValue().clone()));
        return ret;
    }

    public Map<String,Utilizador> getUtil(){
        Map<String,Utilizador> ret = new TreeMap<>();
        (this.util.entrySet()).forEach(e -> ret.put(e.getKey(),e.getValue().clone()));
        return ret;
    }

    public Map<String,Voluntario> getVol(){
        Map<String,Voluntario> ret = new TreeMap<>();
        (this.vol.entrySet()).forEach(e -> ret.put(e.getKey(),e.getValue().clone()));
        return ret;
    }

    public Map<String,Loja> getLoja() {
        Map<String,Loja> ret = new TreeMap<>();
        (this.loja.entrySet()).forEach(e -> ret.put(e.getKey(),e.getValue().clone()));
        return ret;
    }

    public Map<String,Transportadora> getTrans() {
        Map<String,Transportadora> ret = new TreeMap<>();
        (this.trans.entrySet()).forEach(e -> ret.put(e.getKey(),e.getValue().clone()));
        return ret;
    }

    public Map<String,LinhaEncomenda> getLenc() {
        Map<String,LinhaEncomenda> ret = new TreeMap<>();
        (this.lenc.entrySet()).forEach(e -> ret.put(e.getKey(),e.getValue().clone()));
        return ret;
    }

    public Map<String,Encomenda> getEnc() {
        Map<String,Encomenda> ret = new TreeMap<>();
        (this.enc.entrySet()).forEach(e -> ret.put(e.getKey(),e.getValue().clone()));
        return ret;
    }

    public Map<String,AceitaEncomenda> getAcenc() {
        Map<String, AceitaEncomenda> ret = new TreeMap<>();
        (this.acenc.entrySet()).forEach(e -> ret.put(e.getKey(), e.getValue().clone()));
        return ret;
    }

    public void setGps(Map<String,GPS> gps) {
        this.gps = new TreeMap<>();
        (gps.entrySet()).forEach(e -> this.gps.put(e.getKey(),e.getValue().clone()));
    }
    public void setUtil(Map<String,Utilizador> util) {
        this.util = new TreeMap<>();
        (util.entrySet()).forEach(e -> this.util.put(e.getKey(),e.getValue().clone()));
    }
    public void setVol(Map<String,Voluntario> vol) {
        this.vol = new TreeMap<>();
        (vol.entrySet()).forEach(e -> this.vol.put(e.getKey(),e.getValue().clone()));
    }

    public void setLoja(Map<String,Loja> loja) {
        this.loja = new TreeMap<>();
        (loja.entrySet()).forEach(e -> this.loja.put(e.getKey(),e.getValue().clone()));
    }

    public void setTrans(Map<String,Transportadora> trans) {
        this.trans = new TreeMap<>();
        (trans.entrySet()).forEach(e -> this.trans.put(e.getKey(),e.getValue().clone()));
    }

    public void setLenc(Map<String,LinhaEncomenda> lenc) {
        this.lenc = new TreeMap<>();
        (lenc.entrySet()).forEach(e -> this.lenc.put(e.getKey(),e.getValue().clone()));
    }

    public void setEnc(Map<String,Encomenda> enc) {
        this.enc = new TreeMap<>();
        (enc.entrySet()).forEach(e -> this.enc.put(e.getKey(),e.getValue().clone()));
    }

    public void setAcenc(Map<String,AceitaEncomenda> acenc) {
        this.acenc = new TreeMap<>();
        (acenc.entrySet()).forEach(e -> this.acenc.put(e.getKey(),e.getValue().clone()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GPS:").append(this.gps)
                .append("\nUtilizador:").append(this.util)
                .append("\nVoluntario:").append(this.vol)
                .append("\nLoja:").append(this.loja)
                .append("\nTransportadora:").append(this.trans)
                .append("\nLinha de Encomenda:").append(this.lenc)
                .append("\nEncomenda:").append(this.enc)
                .append("\nAceita Encomenda:").append(this.acenc);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Sistema sys = (Sistema) o;
        return this.gps.equals(sys.getGPS()) &&  this.util.equals(sys.getUtil()) &&
                this.vol.equals(sys.getVol()) &&  this.loja.equals(sys.getLoja()) &&
                this.trans.equals(sys.getTrans()) &&  this.lenc.equals(sys.getLenc()) &&
                this.enc.equals(sys.enc) && this.acenc.equals(sys.acenc);

    }

    @Override
    public Sistema clone() {
        return new Sistema(this);
    }
}


