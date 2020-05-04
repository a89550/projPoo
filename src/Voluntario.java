public class Voluntario {
    private String v;
    private String nome;
    private GPS g;
    private double r;

    public Voluntario(){
        this.v = "";
        this.nome = "";
        this.g = new GPS();
        this.r = 0;
    }

    public Voluntario(String v, String n, GPS g, double r){
        this.v = v;
        this.nome = n;
        this.g = g;
        this.r = r;
    }

    public Voluntario(Voluntario v){
        this.v = v.getV();
        this.nome = v.getNome();
        this.g = v.getGps();
        this.r = v.getR();
    }

    public String getV(){
        return this.v;
    }

    public void setV(String v){
        this.v = v;
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

    public double getR(){
        return this.r;
    }

    public void setR(double r){
        this.r = r;
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Voluntario le = (Voluntario) obj;
        return le.getV().equals(this.v) &&
                le.getNome().equals(this.nome) &&
                le.getGps().equals(this.g) &&
                le.getR()==(this.r);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código do Voluntário:").append(this.v)
                .append("\nNome do Voluntário").append(this.nome)
                .append("\nGPS").append(this.g)
                .append("\nRaio:").append(this.r);
        return sb.toString();
    }

    public Voluntario clone(){
        return new Voluntario(this);
    }
}
