public class Codigos {
    private String codU;
    private String codV;
    private String codT;
    private String codL;
    private String codE;
    private String codP;

    //construtor por omissao
    public Codigos() {
        this.codU = "n/a";
        this.codV = "n/a";
        this.codT = "n/a";
        this.codL = "n/a";
        this.codE = "n/a";
        this.codP = "n/a";
    }

    //construtor por parametro
    public Codigos(String codUt, String codV, String codT, String codL, String codE, String codP) {
        this.codU = codU;
        this.codV = codV;
        this.codT = codT;
        this.codL = codL;
        this.codE = codE;
        this.codP = codP;
    }

    //construtor por copia
    public Codigos(Codigos cod) {
        this.codU = cod.getCodU();
        this.codV = cod.getCodV();
        this.codT = cod.getCodT();
        this.codL = cod.getCodL();
        this.codE = cod.getCodE();
        this.codP = cod.getCodP();
    }
// metodos getters

    public String getCodU() {
        return this.codU;
    }

    public String getCodV() {
        return this.codV;
    }

    public String getCodT() {
        return this.codT;
    }

    public String getCodL() {
        return this.codL;
    }

    public String getCodE() {
        return this.codE;
    }

    public String getCodP() {
        return this.codP;
    }

    //metodos setters

    public void setCodU(String codU) {
        this.codU = codU;
    }

    public void setCodV(String codV) {
        this.codV = codV;
    }

    public void setCodT(String codT) {
        this.codU = codU;
    }

    public void setCodL(String codL) {
        this.codU = codU;
    }

    public void setCodE(String codE) {
        this.codE = codE;
    }

    public void setCodP(String codP) {
        this.codP = codP;
    }

    //metodo toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo do Utilizador: ").append(this.codU)
                .append("Codigo do Voluntario").append(this.codV)
                .append("Codigo da Transportadora").append(this.codT)
                .append("Codigo da Loja").append(this.codL)
                .append("Codigo da Encomenda").append(this.codE)
                .append("Codigo do Produto").append(this.codP);
        return sb.toString();
    }

    //metodo equals
    public boolean equals(Codigos cod) {
        return ((this.codU).equals(cod.getCodU()) &&
                (this.codV).equals(cod.getCodV()) &&
                (this.codT).equals(cod.getCodT()) &&
                (this.codL).equals(cod.getCodL()) &&
                (this.codE).equals(cod.getCodE()) &&
                (this.codP).equals(cod.getCodP()));
    }

    //metodo clone
    public Codigos clone() {
        return new Codigos(this);
    }

}
