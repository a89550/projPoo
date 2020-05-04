public class LinhaEncomenda {
    private String p;
    private String nome;
    private double q;
    private double u;

    public LinhaEncomenda(){
        this.p = "";
        this.nome = "";
        this.q = -1;
        this.u = -1;
    }

    public LinhaEncomenda(String p, String n, double q, double u){
        this.p = p;
        this.nome = n;
        this.q = q;
        this.u = u;
    }

    public LinhaEncomenda(LinhaEncomenda l){
        this.p = l.getP();
        this.nome = l.getNome();
        this.q = l.getQ();
        this.u = l.getU();
    }

    public String getP(){
        return this.p;
    }

    public void setV(String p){
        this.p = p;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        this.nome = n;
    }

    public double getQ(){
        return this.q;
    }

    public void setQ(double q){
        this.q = q;
    }

    public double getU(){
        return this.u;
    }

    public void setU(double u){
        this.u = u;
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        LinhaEncomenda le = (LinhaEncomenda) obj;
        return le.getP().equals(this.p) &&
                le.getNome().equals(this.nome) &&
                le.getQ()==(this.q) &&
                le.getU()==(this.u);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código do produto").append(this.p)
                .append("\nDescrição").append(this.nome)
                .append("\nQuantidade").append(this.q)
                .append("\nValor Unitário").append(this.u);
        return sb.toString();
    }

    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }
}
