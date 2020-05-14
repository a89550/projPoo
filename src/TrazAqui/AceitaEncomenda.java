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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código da TrazAqui.Encomenda:").append(this.e);
        return sb.toString();
    }

    public boolean equals(AceitaEncomenda obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        AceitaEncomenda ae = (AceitaEncomenda) obj;
        return ae.getE().equals(this.e);
    }

    public AceitaEncomenda clone() {
        return new AceitaEncomenda(this);
    }
}
