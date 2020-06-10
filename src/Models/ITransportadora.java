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
}
