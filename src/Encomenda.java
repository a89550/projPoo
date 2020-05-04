import java.util.ArrayList;
import java.util.List;

public class Encomenda{
    private String e;
    private String u;
    private String l;
    private double p;
    private List<LinhaEncomenda> le;

    public Encomenda(){
        this.e = "";
        this.u = "";
        this.l = "";
        this.p = -1;
        this.le = new ArrayList<>();
    }

    public Encomenda(String e, String u, String l, double p, ArrayList<LinhaEncomenda> le){
        this.e = e;
        this.u = u;
        this.l = l;
        this.p = p;
        this.le = new ArrayList<>();
        for(LinhaEncomenda lenc : le){
            this.le.add(lenc.clone());
        }
    }

    public Encomenda(Encomenda e){
        this.e = e.getE();
        this.u = e.getU();
        this.l = e.getL();
        this.p = e.getP();
        this.le = e.getLE();
    }

    public String getE(){
        return this.e;
    }

    public void setE(String e){
        this.e = e;
    }

    public String getU(){
        return this.u;
    }

    public void setU(String u){
        this.u = u;
    }

    public String getL(){
        return this.l;
    }

    public void setL(String l){
        this.l = l;
    }

    public double getP(){
        return this.p;
    }

    public void setP(double p){
        this.p = p;
    }

    public List<LinhaEncomenda> getLE(){
        return this.le;
    }

    public void setLE(ArrayList<LinhaEncomenda> le){
        this.le = le;
    }

    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Encomenda le = (Encomenda) obj;
        return le.getE().equals(this.e) &&
                le.getU().equals(this.u) &&
                le.getL().equals(this.l) &&
                le.getP()==(this.p) &&
                le.getLE()==this.le;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Encomenda").append(this.e)
                .append("\nCódigo go Utilizador").append(this.u)
                .append("\nCódigo da Loja").append(this.l)
                .append("\nPeso").append(this.p)
                .append("\nLinha de Encomenda").append(this.le);
        return sb.toString();
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }
}
