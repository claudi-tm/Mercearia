package ListasLigadas;

import java.io.Serializable;
import java.util.Vector;

import model.Pessoa;

public class ListaLigada implements Serializable{
    private No primeiro;
    private No ultimo;
    private Integer totalElem;

    public ListaLigada() {
        this.totalElem = 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }

    public void adicionaInicio(Object elemento) throws Exception {
        No novo = new No(elemento);
        No seguinte = (No) pega(0);
        this.primeiro = novo;
        if (totalElem > 0) {
            this.primeiro.setProximo(seguinte);
        }
        totalElem++;
    }

    // adiciona elemento no inicio da lista
    public void adicionaPosicao(int posicao, Object elemento) throws Exception {
        if (!posicaoValida(posicao))
            throw new IndexOutOfBoundsException("Posicao invalida");
        No novo = new No(elemento);
        if (posicao == 0) {
            adicionaInicio(elemento);
        }
        if (posicao == totalElem) {
            adicionaFim(elemento);
        }
        else {
            No anterior = (No) this.pega(posicao - 1);
            No seguinte = anterior.getProximo();
            anterior.setProximo(novo);
            novo.setProximo(seguinte);
            totalElem++;
        }
    }

    // adiciona elemento numa dada posição
    public void adicionaFim(Object elemento) throws Exception {
        No novo = new No(elemento);
        this.ultimo = novo;
        No anterior = (No) this.pega(totalElem - 2);
        anterior.setProximo(novo);
        totalElem++;
    }

    public boolean ehVazio() {
        return (primeiro == null);
    }

    public boolean posicaoValida(int posicao) {
        if ((posicao >= 0 && posicao <= totalElem))
            return true;
        return false;
    }

    // adiciona elemento no fim da list
    public Object pega(int posicao) throws Exception {
        posicaoValida(posicao);
        No no = primeiro;
        if (posicao == 0) {
            return no;
        }
        for (int i = 0; i < posicao; i++) {
            no = no.getProximo();
        }
        return no;
    }

    // devolve elemento duma dada posicao
    public void removeInicio() {
        if (this.totalElem == 0) {
            throw new IllegalArgumentException("Estrutura Vazia");
        }
        this.primeiro = this.primeiro.getProximo();
        this.totalElem--;
        if (this.totalElem == 0) {
            this.ultimo = null;
        }
    }
    // remove elemento no inicio
    public void removePosicao(int posicao) throws Exception {
        
        if (!posicaoValida(posicao))
            throw new IndexOutOfBoundsException("Posicao invalida");
        if (posicao == 0) {
            removeInicio();
        } else if (posicao == totalElem){
                removeFim();
    
        }else {
            No anterior = (No) this.pega(posicao - 1);
            No actual = (No) pega(posicao);
            No seguinte = actual.getProximo();
            anterior.setProximo(seguinte);
            actual.setProximo(null);
            totalElem--;
        }

    }

    public void removeCode(String id) throws Exception {
        No no = primeiro;
        Pessoa pessoa;
        for (int i = 0; i < totalElem; i++) {
            pessoa = (Pessoa) no.getElemento();
            if (pessoa.getId().equals(id)) {
                removePosicao(i);
                return;
            }
            no = no.getProximo();
        }
    }

    // remove elemento duma dada posição
    public void removeFim() throws Exception {
        if (totalElem <= 1)
            this.removeInicio();
        else {
            No penultimo = (No) this.pega(totalElem - 2);
            penultimo.setProximo(null);
            ultimo = penultimo;
            totalElem--;
        }
    }

    // remove elemento no fim
    public boolean contem(Object elemento) {
        return false;

    }

    // verifica se a lista contem um dado elemento
    public int tamanho() {
        return totalElem;

    }

    public String content() throws Exception {
        String valor;
        No no;
        for (int x = 0; x < totalElem; x++) {
            no = (No) pega(x);
            no.getElemento();
            System.out.println(no.getElemento());
        }
        return null;
    }

    public Vector<Pessoa> imprimir(String criterio, String valor) {
        No no = primeiro;
        Pessoa pessoa;
        Vector<Pessoa> vector = new Vector<>();

        for (int i = 0; i < totalElem; i++) {
            pessoa = (Pessoa) no.getElemento();
            if (getCriterio(criterio, pessoa).equals(valor)) {
                vector.add(pessoa);
            } 
            no = no.getProximo();
        }
        return vector;
    }

    public Vector<Pessoa> imprimirTodos() {
        No no = primeiro;
        Pessoa pessoa;
        Vector<Pessoa> vector = new Vector<>();
        for (int i = 0; i < totalElem; i++) {
            pessoa = (Pessoa) no.getElemento();
            vector.add(pessoa);
            no = no.getProximo();
        }
        return vector;
    }

    public String getCriterio(String criterio, Pessoa obj) {
        Pessoa pessoa = obj;
        switch (criterio) {
            case "nome":
                return pessoa.getNome();
            case "idade":
                return Integer.toString(pessoa.getIdade());
            case "email":
                return pessoa.getEmail();
            case "numero":
                return pessoa.getNumeroTelefone();
            default:
                return "";
        }
    }

    // devolve o numero de elementos da listapublic void adicionaInicio(Object
    // elemento);
}