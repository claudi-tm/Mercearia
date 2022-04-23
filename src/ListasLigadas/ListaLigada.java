package ListasLigadas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

import model.Pessoa;

public class ListaLigada implements Serializable {
    protected No primeiro;
    protected No ultimo;
    protected Integer totalElem;

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
        } else {
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
        } else if (posicao == totalElem) {
            removeFim();

        } else {
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
        String valor = "";
        No no;
        for (int x = 0; x < totalElem; x++) {
            no = (No) pega(x);
            no.getElemento();
            System.out.println(no.getElemento());
        }
        return valor;
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

    public String imprimirTodos() {
        No no = primeiro;
        Pessoa pessoa;
        StringBuilder toPrint = new StringBuilder();
        Vector<Pessoa> vector = new Vector<>();
        for (int i = 0; i < totalElem; i++) {
            pessoa = (Pessoa) no.getElemento();
            vector.add(pessoa);
            no = no.getProximo();
            toPrint.append("\n" + pessoa.toString());
            if (i != totalElem - 1) toPrint.append("\n====================");
        }
        return toPrint.toString();
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
            case "id":
                return pessoa.getId();
            case "endereco":
                return pessoa.getEndereco();
            default:
                return "";
        }
    }

    public ListaLigada busca(String criterio1, String valor1, String criterio2, String valor2,
            boolean interseccao) throws Exception {
        ArrayList<Pessoa> arrayList = new ArrayList<>();
        ListaLigada aux = new ListaLigada();

        for (int x = 0; x < totalElem; x++) {
            No no = (No) pega(x);
            Pessoa pessoa = (Pessoa) no.getElemento();
            if (interseccao) {
                if (getCriterio(criterio1, pessoa).contains(valor1) && getCriterio(criterio2, pessoa).contains(valor2)) {
                    arrayList.add(pessoa);
                    aux.adicionaInicio(pessoa)  ;
                }
            } else {
                if (getCriterio(criterio1, pessoa).contains(valor1) || getCriterio(criterio2, pessoa).contains(valor2)) {
                    arrayList.add(pessoa);
                    aux.adicionaInicio(pessoa);
                }
            }
        }
        return aux;
    }

    public String buscaImpressao(String criterio1, String valor1) throws Exception {
        ArrayList<Pessoa> arrayList = new ArrayList<>();
        StringBuilder toPress = new StringBuilder();
        for (int x = 0; x < totalElem; x++) {
            No no = (No) pega(x);
            Pessoa pessoa = (Pessoa) no.getElemento();
            if (getCriterio(criterio1, pessoa).contains(valor1)) {
                toPress.append("\n" + pessoa.toString());
                if (x != totalElem) toPress.append("\n================");
            }
        }
        return toPress.toString();
    }

    public Pessoa buscaPrimeiraOcorrencia(String criterio1, String valor1, String criterio2, String valor2,
            boolean interseccao) throws Exception {
        ArrayList<Pessoa> arrayList = new ArrayList<>();

        for (int x = 0; x < totalElem; x++) {
            No no = (No) pega(x);
            Pessoa pessoa = (Pessoa) no.getElemento();
            if (interseccao) {
                if (getCriterio(criterio1, pessoa).equals(valor1) && getCriterio(criterio2, pessoa).equals(valor2)) {
                    return pessoa;
                }
            } 
            }
        return null;
        }
        
    

    public String bubbleSort(String criterio, ListaLigada listaLigada) throws Exception {
        No atual, anterior, proximo;

        Pessoa p1, p2;
        for (int i = 0; i < totalElem - 1; i++) {
            for (int j = 0; j < totalElem - i - 1; j++) {

                atual = (No) pega(j);
                proximo = (No) atual.getProximo();
                p1 = (Pessoa) atual.getElemento();
                p2 = (Pessoa) proximo.getElemento();

                if (biggerThan(getCriterio(criterio, p1), getCriterio(criterio, p2))) {
                    if (atual != primeiro) {
                        anterior = (No) pega(j - 1);
                        anterior.setProximo(proximo);
                    } else {
                        primeiro = proximo;
                    }
                    if (proximo.getProximo() == null) {
                        atual.setProximo(null);
                    } else {
                        atual.setProximo(proximo.getProximo());
                    }
                    proximo.setProximo(atual);
                    //System.out.println("---------------------------" + atual);
                   
                }

            }
        }
        content();
        return imprimirTodos();
    }

    public boolean biggerThan(String firstValue, String secondValue) {
        int compare = firstValue.compareTo(secondValue);
        if (compare > 0) {
            return true;
        }
        return false;
    }

    public void editarPessoa(Pessoa p, String nome, String idade, String numeroTelefone, String email,
            String endereco, String nuit) throws Exception {
        if (!nome.trim().equals(p.getNome())) {
            p.setNome(nome);
        }
        if (!idade.trim().equals(Integer.toString(p.getIdade()))) {
            p.setIdade(Integer.parseInt(idade));
        }
        if (!numeroTelefone.trim().equals(p.getNumeroTelefone())) {
            p.setNumeroTelefone(numeroTelefone);
        }
        if (!email.trim().equals(p.getEmail())) {
            p.setEmail(email);
        }
        if (!endereco.trim().equals(p.getEndereco())) {
            p.setEndereco(endereco);
        }
        if (!nuit.trim().equals(p.getNUIT())) {
            p.setNuit(nuit);
        }

        for (int x = 0; x < totalElem; x++){
            No no = (No) pega(x);
            Pessoa pessoa = (Pessoa) no.getElemento();
            if (pessoa.getId().equals(p.getId())) no.setElemento(p);
        }
        
    }

    // devolve o numero de elementos da listapublic void adicionaInicio(Object
    // elemento);
}