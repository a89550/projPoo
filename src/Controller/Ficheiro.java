package Controller;

import Models.Sistema;
import Models.Utilizador;
import Models.Voluntario;
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
    public static void gravaObjeto(String nomeficheiro,Sistema s) throws IOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(nomeficheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
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
        FileReader file = new FileReader("logs.txt");
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

    public static void lerS(Sistema s, String[] logs) {
        String[] p1;
        String[] p2;
        for (String log : logs) { //le cada linha do array de strings
            if (log == null) break;
            p1 = log.split(",");
            p2 = p1[0].split(":");
            switch (p1[0]) {
                case "Utilizador":
                    //s.registaUtilizador(p2[1],p1[1],Double.parseDouble(p1[2]),Double.parseDouble(p1[3]));
                    break;

                case "Voluntario":
                    //s.registaVoluntario(p2[1],p1[1],p1[2],Double.parseDouble(p1[3]),Double.parseDouble(p1[4]));
                    break;

                case "Transportadora":
                    //s.registaTransportadora(p2[1],p1[1],Double.parseDouble(p1[2]),Double.parseDouble(p1[3]),Integer.parseInt(p1[4]),Double.parseDouble(p1[5]),Double.parseDouble(p1[6]));
                    break;

                case "Loja":
                    //s.registaLoja(p2[1],p1[1],Double.parseDouble(p1[2]),Double.parseDouble(p1[3]));
                    break;

                case "Encomenda":
                    //s.regi
            }
        }
    }
}

