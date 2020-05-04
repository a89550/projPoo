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

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Loja le = (Loja) obj;
        return le.getL().equals(this.l) &&
                le.getNome().equals(this.nome) &&
                le.getGPS().equals(this.g);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Loja").append(this.l)
                .append("Nome da Loja").append(this.nome)
                .append("GPS").append(this.g);
        return sb.toString();
    }

    public Loja clone(){
        return new Loja(this);
    }
}
