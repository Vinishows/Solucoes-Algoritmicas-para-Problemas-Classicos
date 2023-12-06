import java.util.ArrayList;

public class CaixeiroViajante {

    public static void main(String[] args) {
        int numCidades = 10;
        int[][] matrizDistancias = criarMatrizDistancias(numCidades);

        ArrayList<Integer> melhorCaminho = null;
        int menorDistancia = Integer.MAX_VALUE;

        ArrayList<Integer> cidades = new ArrayList<>();
        for (int i = 0; i < numCidades; i++) {
            cidades.add(i);
        }

        ArrayList<ArrayList<Integer>> permutacoes = permutacoes(cidades);
    
        for (ArrayList<Integer> caminho : permutacoes) {
            int distanciaAtual = calcularDistancia(caminho, matrizDistancias);

            
            if (distanciaAtual < menorDistancia) {
                menorDistancia = distanciaAtual;
                melhorCaminho = new ArrayList<>(caminho);

                exibirCoordenadas(melhorCaminho, matrizDistancias);
                System.out.println("Caminho parcial: " + melhorCaminho);
                System.out.println("Distância parcial: " + menorDistancia);
                System.out.println("----------------------");
            }
        }
        System.out.println("==================================================================");
        exibirCoordenadas(melhorCaminho, matrizDistancias);
        System.out.println("Melhor caminho: " + melhorCaminho);
        System.out.println("Distância: " + menorDistancia);
        System.out.println("==================================================================");
    }

    private static void exibirCoordenadas(ArrayList<Integer> caminho, int[][] matrizDistancias) {
        System.out.println("Coordenadas:");

        for (int i = 0; i < caminho.size(); i++) {
            int cidadeAtual = caminho.get(i);
            int proximaCidade = (i + 1) % caminho.size();
            System.out.println(i+1 + ". Matriz:[" + cidadeAtual + "][" + proximaCidade + "] = " +
                    matrizDistancias[cidadeAtual][proximaCidade]);
        }
    }

    private static int[][] criarMatrizDistancias(int numCidades) {
        int[][] matrizDistancias = new int[numCidades][numCidades];
        for (int i = 0; i < numCidades; i++) {
            for (int j = 0; j < numCidades; j++) {
                matrizDistancias[i][j] = (int) (Math.random() * 100);
            }
        }
        return matrizDistancias;
    }

    private static ArrayList<ArrayList<Integer>> permutacoes(ArrayList<Integer> cidades) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permutacoesRecursivo(result, cidades, 0);
        return result;
    }

    private static void permutacoesRecursivo(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> cidades, int index) {
        if (index == cidades.size() - 1) {
            result.add(new ArrayList<>(cidades));
        } else {
            for (int i = index; i < cidades.size(); i++) {
                int temp = cidades.get(index);
                cidades.set(index, cidades.get(i));
                cidades.set(i, temp);

                permutacoesRecursivo(result, cidades, index + 1);

                temp = cidades.get(index);
                cidades.set(index, cidades.get(i));
                cidades.set(i, temp);
            }
        }
    }

    private static int calcularDistancia(ArrayList<Integer> caminho, int[][] matrizDistancias) {
        int distancia = 0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            int cidadeAtual = caminho.get(i);
            int proximaCidade = caminho.get(i + 1);
            distancia += matrizDistancias[cidadeAtual][proximaCidade];
        }
        
        distancia += matrizDistancias[caminho.get(caminho.size() - 1)][caminho.get(0)];
        return distancia;
    }
}
