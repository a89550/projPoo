package TrazAqui;

public class AceitaEncomenda {
    private String e;


    public AceitaEncomenda() {
        this.e = "n/a";
    }

    public AceitaEncomenda(String e) {
        this.e = e;
    }

    public AceitaEncomenda(AceitaEncomenda ae) {
        this.e = ae.getE();
    }


    public String getE() {
        return this.e;
    }

    public void setE(String e) {
        this.e = e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código da TrazAqui.Encomenda:").append(this.e);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        AceitaEncomenda ae = (AceitaEncomenda) o;
        return ae.getE().equals(this.e);
    }

    @Override
    public AceitaEncomenda clone() {
        return new AceitaEncomenda(this);
    }
}
