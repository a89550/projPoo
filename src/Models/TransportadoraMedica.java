package Models;

import java.time.LocalDateTime;
import java.util.List;

public class TransportadoraMedica extends Transportadora{
    private boolean livreMed;

    public TransportadoraMedica(){
        super();
        this.livreMed = true;
    }

    public TransportadoraMedica(String t, String n, String email, String password, GPS gps, int nif, double raio,
                                boolean livre, double taxaKm, int numeroEnc, List<Integer> classif, List<Encomenda> encomendasFeitas, double km,
                                double vel, LocalDateTime recolha, List<Encomenda> encomendasATransportar, boolean livreMed){
        super(t,n,email,password,gps,nif,raio,livre,taxaKm,numeroEnc,classif,encomendasFeitas,km,vel,recolha,encomendasATransportar);
        this.livreMed = livreMed;

    }

    public TransportadoraMedica(TransportadoraMedica t){
        super(t);
        this.livreMed = t.aceitoTransporteMedicamentos();
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

    public TransportadoraMedica clone(){
        return new TransportadoraMedica(this);
    }
}
