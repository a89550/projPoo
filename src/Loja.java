public class Loja {
    private String l;
    private String nome;

    public Loja(){
        this.l = "";
        this.nome = "";
    }

    public Loja(String l, String n){
        this.l = l;
        this.nome = n;
    }

    public Loja(Loja l){
        this.l = l.getL();
        this.nome = l.getNome();
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

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Loja le = (Loja) obj;
        return le.getL().equals(this.l) &&
                le.getNome().equals(this.nome);
    }

    public String toString(){
        String s = "Loja:" + this.l + "," + this.nome;
        return s;
    }

    public Loja clone(){
        return new Loja(this);
    }
}
