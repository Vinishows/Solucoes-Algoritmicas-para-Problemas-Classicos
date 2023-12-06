import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Projeto {
    int inicio;
    int fim;
    double lucro;

    public Projeto(int inicio, int fim, double lucro) {
        this.inicio = inicio;
        this.fim = fim;
        this.lucro = lucro;
    }
}

public class AlgoritmoGuloso {

    public static List<Projeto> selecionarProjetos(List<Projeto> projetos) {
        // Ordenar os projetos pela data de término em ordem crescente
        Collections.sort(projetos, Comparator.comparingInt(p -> p.fim));

        List<Projeto> projetosSelecionados = new ArrayList<>();
        Projeto projetoAtual = projetos.get(0);
        projetosSelecionados.add(projetoAtual);

        for (int i = 1; i < projetos.size(); i++) {
            Projeto projeto = projetos.get(i);
            // Verificar se o projeto atual não entra em conflito com o próximo projeto
            if (projeto.inicio >= projetoAtual.fim) {
                projetosSelecionados.add(projeto);
                projetoAtual = projeto;
            }
        }

        return projetosSelecionados;
    }

    public static void main(String[] args) {
        List<Projeto> listaProjetos = new ArrayList<>();
        listaProjetos.add(new Projeto(1, 3, 50));
        listaProjetos.add(new Projeto(2, 5, 20));
        listaProjetos.add(new Projeto(6, 9, 30));
        listaProjetos.add(new Projeto(3, 8, 40));

        List<Projeto> projetosSelecionados = selecionarProjetos(listaProjetos);

        System.out.println("Projetos selecionados:");
        for (Projeto projeto : projetosSelecionados) {
            System.out.println("Data Inicial: " + projeto.inicio + ", Data Final: " + projeto.fim + ", Lucro: " + projeto.lucro);
        }
    }
}
