package Models;

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
        this.g = new GPS(g);
    }

    public Utilizador(Utilizador u){
        this.u = u.getU();
        this.nome = u.getNome();
        this.g = new GPS(u.getGps());
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

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Utilizador le = (Utilizador) o;
        return le.getU().equals(this.u) &&
                le.getNome().equals(this.nome) &&
                le.getGps().equals(this.g);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código de utilizador:").append(this.u)
                .append("\nNome do utlizador").append(this.nome)
                .append("\nTrazAqui.GPS").append(this.g);
        return sb.toString();
    }

    @Override
    public Utilizador clone(){
            return new Utilizador(this);
    }
}
