package controller;

import java.util.ArrayList;
import java.util.Vector;

import ListasLigadas.ListaLigada;
import ListasLigadas.No;
import model.Pessoa;
import view.Tabela;

public class ControlaTabela {
    public static void carregarDados(String[][] dados, ListaLigada listaLigada) throws Exception {
        for (int x = 0; x < dados.length; x++) {
            No no = (No) listaLigada.pega(x);
            Pessoa p1 = (Pessoa) no.getElemento();
            dados[x][0] = Integer.toString(x + 1);
            dados[x][1] = p1.getId();
            dados[x][2] = p1.getNome();
            dados[x][3] = Integer.toString(p1.getIdade());
            dados[x][4] = p1.getNumeroTelefone();
            dados[x][5] = p1.getEndereco();
            dados[x][6] = p1.getEmail();
            dados[x][7] = p1.getSexo();
        }
        System.out.println(listaLigada.content());
    }

    public static Tabela newTabela(ListaLigada listaLigada) {
        try {
            // listaLigada.adicionaInicio(pessoa);
            String dados[][] = new String[listaLigada.tamanho()][8];
            ControlaTabela.carregarDados(dados, listaLigada);
            System.out.println(listaLigada.content());
            return new Tabela(dados);
            // new Tabela();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /*
     * public static Tabela newTabela2(ArrayList<Pessoa> arrayList){
     * try {
     * //listaLigada.adicionaInicio(pessoa);
     * String dados[][] = new String[arrayList.size()][8];
     * ControlaTabela.carregarDados(dados, listaLigada);
     * System.out.println(listaLigada.content());
     * return new Tabela(dados);
     * //new Tabela();
     * } catch (Exception e) {
     * // TODO Auto-generated catch block
     * e.printStackTrace();
     * }
     * return null;
     * }
     */

}
