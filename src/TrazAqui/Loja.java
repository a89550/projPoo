package TrazAqui;

public class Loja {
    private String l;
    private String nome;
    private GPS g;

    public Loja(){
        this.l = "";
        this.nome = "";
        this.g = new GPS();
    }

    public Loja(String l, String n,GPS g){
        this.l = l;
        this.nome = n;
        this.g = g;
    }

    public Loja(Loja l){
        this.l = l.getL();
        this.nome = l.getNome();
        this.g = l.getGPS();
    }

    public String getL(){
        return this.l;
    }

    public void setL(String l){
        this.l = l;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public GPS getGPS(){
        return this.g;
    }

    public void setGPS(GPS g){
        this.g = g;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Loja le = (Loja) o;
        return le.getL().equals(this.l) &&
                le.getNome().equals(this.nome) &&
                le.getGPS().equals(this.g);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da TrazAqui.Loja").append(this.l)
                .append("Nome da TrazAqui.Loja").append(this.nome)
                .append("TrazAqui.GPS").append(this.g);
        return sb.toString();
    }

    @Override
    public Loja clone(){
        return new Loja(this);
    }
}
