package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import ListasLigadas.ListaLigada;
import ListasLigadas.No;
import controller.ControlaListaLigada;
import controller.ControlaPessoa;
import model.Pessoa;

public class Tabela extends JFrame {
    private JLabel[] labels;
    private JTextField[] arrayField;
    private JPanel[] panels;
    private JTable table;
    private JLabel label;
    String[] titles = { "Armazém: ", "Stock Minimo: ", "Quantidade: ", "Data de validade: ", "Preco: ", "Nome: ",
            "Fornecedor: ", "Categoria" };
    private JScrollPane scrollPane;
    String[][] dados;
    String[] colunas = { "ID: ", "Nome", "Idade", "Numero de Tel", "Endereço", "Email" };
    private JLabel labelvazio;

    public Tabela() {

    }

    public Tabela(String[][] dados) {
        this.dados = dados;
        labelvazio = new JLabel();
        this.setSize(958, 575);
        setLocation(150, 150);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setResizable(false);
        makeLabels();
        label = new JLabel("Pessoas regitraadas");
        table = new JTable(dados, colunas);

        table.setBounds(30, 40, 100, 50);
        // table.getSelectionModel().addListSelectionListener(this);
        scrollPane = new JScrollPane(table);
        makearrayField(5);
        makePanels(9);
        configComponents();
        addComponentsToPanel();
        addComponents();
        setVisible(true);
    }

    public void makeLabels() {

        labels = new JLabel[titles.length];
        for (int x = 0; x < labels.length; x++) {
            labels[x] = new JLabel(titles[x]);
        }
    }

    public void makearrayField(int n) {
        arrayField = new JTextField[n];
        for (int x = 0; x < n; x++) {
            arrayField[x] = new JTextField(1);
        }
    }

    public void configComponents() {
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.orange);
        arrayField[arrayField.length - 1].setColumns(20);
        panels[0].setLayout(new GridLayout(2, 1));
        panels[1].setLayout(new GridLayout(5, 2));// 5 ou 9
        panels[2].setLayout(new BorderLayout());
        panels[3].setLayout(new BorderLayout());
        panels[4].setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public void makePanels(int n) {
        panels = new JPanel[n];
        for (int x = 0; x < n; x++) {
            panels[x] = new JPanel(new FlowLayout());
        }
    }

    public void addComponentsToPanel() {
        panels[4].add(label);
        panels[0].add(panels[4]);
        panels[0].add(labelvazio);

        panels[3].add("Center", scrollPane);
    }

    public void addComponents() {
        add("North", panels[0]);
        add("Center", panels[3]);
    }

    public static void main(String[] args) {
        File file = new File("ListaLigada.bin");
        Vector<ListaLigada> vector = new Vector<>();
        try {
            ListaLigada listaLigada = new ListaLigada();
            if (file.createNewFile()) {
                Pessoa p = new Pessoa("P1", "cc", "822512163", "131414", 13, "Maputo");
                listaLigada.adicionaInicio(p);
                vector.add(listaLigada);
                ControlaListaLigada.escreverFicherio("ListaLigada.bin", vector);

            } else {
                vector = ControlaListaLigada.lerFicheiro("ListaLigada.bin");
                System.out.println(vector.size());
                listaLigada = vector.firstElement();
            }
            String[][] dados = new String[listaLigada.tamanho()][6];
            carregarDados(dados, listaLigada);
            new Tabela(dados);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void carregarDados(String[][] dados, ListaLigada listaLigada) throws Exception {
        for (int x = 0; x < dados.length; x++) {
            No no = (No) listaLigada.pega(x);
            Pessoa p1 = (Pessoa) no.getElemento();
            dados[x][0] = p1.getId();
            dados[x][1] = p1.getNome();
            dados[x][2] = Integer.toString(p1.getIdade());
            dados[x][3] = p1.getNumeroTelefone();
            dados[x][4] = p1.getEndereco();
            dados[x][5] = p1.getEmail();
        }
    }

}
