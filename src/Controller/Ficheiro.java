package Controller;

import Models.*;
import jdk.jshell.execution.Util;

import java.io.*;

public class Ficheiro {

    /**
     * Grava o estado da aplicação num determinado ficheiro.
     *
     * @param nomeficheiro Recebe o nome do ficheiro.
     * @throws IOException           Exception.
     * @throws FileNotFoundException Exception.
     */
    public void gravaObjeto(String nomeficheiro) throws IOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(nomeficheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    /**
     * Iniciar a aplicação com o estado guardado num determinado ficheiro.
     *
     * @param nomeficheiro Recebe o nome do ficheiro.
     * @return Devolve a aplicação inciada.
     * @throws IOException            Exception.
     * @throws ClassNotFoundException Exception.
     * @throws FileNotFoundException  Exception.
     */
    public static Sistema leObjeto(String nomeficheiro) throws IOException, ClassNotFoundException, FileNotFoundException {
        FileInputStream fos = new FileInputStream(nomeficheiro);
        ObjectInputStream ois = new ObjectInputStream(fos);
        Sistema newSystem = (Sistema) ois.readObject();
        ois.close();
        return newSystem;
    }

    /**
     * Método que lê do ficheiro logs e escreve cada linha desse numa String que depois é adicionada a um array de Strings.
     *
     * @return Devolve o array de Strings.
     * @throws IOException Exception.
     */
    public static String[] lerLogs() throws IOException {
        String[] logs = new String[1500];
        FileReader file = new FileReader("/home/joao/Desktop/logs.txt");
        BufferedReader lerLogs = new BufferedReader(file);
        String linha = lerLogs.readLine();
        int i = 0;
        while (linha != null) {
            logs[i] = linha;
            i++;
            linha = lerLogs.readLine();
        }
        return logs;
    }

    /**
     * Função que lê linha a linha e regista os várias classes pertencentes ao Sistema.
     * @param s Recebe um Sistema.
     * @param logs Recebe um array de Strings.
     */
    public void lerS(Sistema s, String[] logs) {
        String[] p1;
        String[] p2;
        for (String log : logs) { //lê cada linha do array de strings.
            if (log == null) break;
            p1 = log.split(",");
            p2 = p1[0].split(":");
            switch (p1[0]) {
                case "Utilizador":
                    s.registaUtilizador(p2[1],p1[1],Double.parseDouble(p1[2]),Double.parseDouble(p1[3]));
                    break;

                case "Voluntario":
                    s.registaVoluntario(p2[1],p1[1],Double.parseDouble(p1[2]),Double.parseDouble(p1[3]),Double.parseDouble(p1[4]));
                    break;

                case "Transportadora":
                    s.registaTransportadora(p2[1],p1[1],Double.parseDouble(p1[2]),Double.parseDouble(p1[3]),Integer.parseInt(p1[4]),Double.parseDouble(p1[5]),Double.parseDouble(p1[6]));
                    break;

                case "Loja":
                    s.registaLoja(p2[1],p1[1],Double.parseDouble(p1[2]),Double.parseDouble(p1[3]));
                    break;

                case "Encomenda":
                    Encomenda e = s.fazerEncomenda(p2[1],p1[1],Double.parseDouble(p1[2]),false);
                    for (int i = 3; p1[i+4] != null; i++)
                    e.addProduto(p1[i],p1[i+1],Double.parseDouble(p1[i+2]),Double.parseDouble(p1[i+3]));
                    s.finalizarEncomenda(e);

                case "AceitaEncomenda":
                    Voluntario v = s.aceitaEncomendaV(p2[1]);
                    if (v != null) {
                        s.entregaEncomenda(v);
                    }
                    else {
                        Transportadora t = s.aceitaEncomendaT(p2[1]);
                        s.entregaEncomenda(t);
                    }
            }
        }
    }
}

