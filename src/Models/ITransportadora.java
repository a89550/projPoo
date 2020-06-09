package Models;

import java.util.List;

public interface ITransportadora {

    public double distEntrega(GPS loja, GPS utilizador);

    public double precoEntrega(GPS loja, GPS utilizador);

    public void addClassificacao(int classificacao);

    public List<Encomenda> entregaEncomenda();


}
