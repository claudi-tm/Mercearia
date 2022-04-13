import ListasLigadas.ListaLigada;
import model.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa p1 = new Pessoa("P1", "cc", "822512163", "131414", 13, "Maputo");
        Pessoa p2 = new Pessoa("P2", "cA", "822512163", "131414", 13, "Tete");
        Pessoa p3 = new Pessoa("P3", "cB", "822512163", "131414", 20, "Nampula");

        ListaLigada listaLigada = new ListaLigada();
        listaLigada.adicionaInicio(p1);
        listaLigada.adicionaFim(p2);
        listaLigada.adicionaPosicao(1, p3);
        listaLigada.content();
        System.out.println("-----------------");
        //listaLigada.removeCode(p3.getId());
        System.out.println(listaLigada.imprimir("idade", "13"));
        System.out.println(listaLigada.imprimirTodos());
        // listaLigada.content();

    }
}
