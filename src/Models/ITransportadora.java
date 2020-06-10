package Models;

import java.util.List;

public interface ITransportadora {

    public double distEntrega(GPS loja, GPS utilizador);

    public double precoEntrega(GPS loja, GPS utilizador);

    public void addClassificacao(int classificacao);

    public List<Encomenda> entregaEncomenda();

    public ITransportadora clone();

    public String getId();

    public String getEmail();

    public String getPassword();

    public double getVelocidadeMedia();

    public int tempoDeIda(GPS loja);

    public int tempoDeVolta(GPS loja, GPS util);

    public boolean isLivre();

    public double getRaio();

    public double auxDist(GPS gps1, GPS gps2);

    public boolean dentroDoRaio(GPS loja, GPS util);


    public void aceitaEncomenda(Encomenda e);
}
