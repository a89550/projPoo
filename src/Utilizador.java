public class Utilizador {
    private String u;
    private String nome;
    private GPS g;

    public Utilizador(){
        this.u = "";
        this.nome = "";
        this.g = new GPS();
    }

    public Utilizador(String u, String n, GPS g){
        this.u = u;
        this.nome = n;
        this.g = g;
    }

    public Utilizador(Utilizador u){
        this.u = u.getU();
        this.nome = u.getNome();
        this.g = u.getGps();
    }

    public String getU(){
        return this.u;
    }

    public void setU(String u){
        this.u = u;
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

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Utilizador le = (Utilizador) obj;
        return le.getU().equals(this.u) &&
                le.getNome().equals(this.nome) &&
                le.getGps().equals(this.g);
    }

    public String toString(){
        String s = "Utilizador:" + this.u + "," + this.nome + "," + this.g;
        return s;
    }
}
