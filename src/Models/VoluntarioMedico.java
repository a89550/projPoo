package Models;

import java.util.List;

public class VoluntarioMedico extends Voluntario {
    private boolean livreMed;

    public VoluntarioMedico(){
        super();
        this.livreMed = true;
    }

    public VoluntarioMedico(String id, String n, GPS gps, double raio, boolean livre, boolean livreMed, List<Integer> c, Encomenda encomenda){
        super(id,n,gps,raio,livre,c,encomenda);
        this.livreMed = livreMed;

    }

    /**
     * Função que verifica se o voluntário aceita encomendas de remédios no momento.
     * @return - True se puder transportar remédios no momento, false caso contrário.
     */
    public boolean aceitoTransporteMedicamentos(){
        return this.livreMed;
    }

    /**
     * Função que altera o estado do voluntário no que diz respeito ao transporte de remédios.
     * @param state - Novo estado do voluntário.
     */
    public void aceitaMedicamentos(boolean state){
        this.livreMed = state;
    }

}
