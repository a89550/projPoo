package TrazAqui;

public class Transportadora {
    private String t;
    private String nome;
    private GPS g;
    private int nif;
    private double r;
    private double pkm;

    public Transportadora(){
        this.t = "";
        this.nome = "";
        this.g = new GPS();
        this.nif = -1;
        this.r = 0;
        this.pkm = -1;
    }

    public Transportadora(String v, String n, GPS g, int nif, double r, double pkm){
        this.t = t;
        this.nome = n;
        this.g = g;
        this.nif = nif;
        this.r = r;
        this.pkm = pkm;
    }

    public Transportadora(Transportadora t){
        this.t = t.getT();
        this.nome = t.getNome();
        this.g = t.getGps();
        this.nif = t.getNif();
        this.r = t.getR();
        this.pkm = t.getPkm();
    }

    public String getT(){
        return this.t;
    }

    public void setT(String t){
        this.t = t;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public GPS getGps(){
        return this.g;
    }

    public void setGps(GPS g){
        this.g = g;
    }

    public int getNif(){
        return this.nif;
    }

    public void setNif(int nif){
        this.nif = nif;
    }

    public double getR(){
        return this.r;
    }

    public void setR(double r){
        this.r = r;
    }

    public double getPkm(){
        return this.pkm;
    }

    public void setPkm(double pkm){
        this.pkm = pkm;
    }

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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Empresa").append(this.t)
                .append("\nNome da Empresa").append(this.nome)
                .append("\nTrazAqui.GPS").append(this.g)
                .append("\nNIF:").append(this.nif)
                .append("\nRaio").append(this.r)
                .append("\nPreço por Km").append(this.pkm);
        return sb.toString();
    }

    @Override
    public Transportadora clone(){
        return new Transportadora(this);
    }
}
