import ListasLigadas.ListaLigada;
import model.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa p1 = new Pessoa("Claudio", "cc", "822512163", "131414", 10, "Maputo");
        Pessoa p2 = new Pessoa("Ana", "cA", "822512163", "131414", 30, "Tete");
        Pessoa p3 = new Pessoa("Ze", "cB", "822512163", "131414", 20, "Nampula");

        ListaLigada listaLigada = new ListaLigada();
        listaLigada.adicionaInicio(p1);
        listaLigada.adicionaFim(p2);
        listaLigada.adicionaPosicao(1, p3);
        listaLigada.content();
        System.out.println("-----------------");
        // listaLigada.removeCode(p3.getId());
        //System.out.println(listaLigada.imprimir("idade", "13"));
        //System.out.println(listaLigada.imprimirTodos());
        //System.out.println("-------BUSCA----------");
        // System.out.println(listaLigada.busca("nome", "P1", "idade", "13", true));
        listaLigada.content();
        
        listaLigada.content();
        System.out.println("--------ORDENACAO---------");
        listaLigada.bubbleSort("nome", listaLigada);
    }
}
