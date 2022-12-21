package part02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
TODO Leetcode exercise - 886. Possible Bipartition
 */

public class PossibleBipartition {
    public static void main(String[] args) {
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        boolean result = possibleBipartition(4, dislikes);
        System.out.println(result);
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        // Cria um grafo de adjacência a partir da lista de desafetos
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        // Cria uma matriz de cores para marcar cada vértice como branco, preto ou não visitado
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1); // Inicialmente, todos são marcados como não visitados

        // Executa a busca em profundidade em cada vértice não visitado
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1 && !dfs(graph, colors, i, 0)) {
                return false; // Se a busca em profundidade retornar falso, não é possível particionar o grafo
            }
        }
        return true; // Se todas as buscas em profundidade retornarem verdadeiro, é possível particionar o grafo
    }

    // Método de busca em profundidade para verificar se é possível particionar o grafo
    private static boolean dfs(List<Integer>[] graph, int[] colors, int node, int color) {
        if (colors[node] != -1) {
            return colors[node] == color; // Se o vértice já foi visitado, verifique se está na mesma cor
        }
        colors[node] = color; // Marca o vértice com a cor atual
        for (int neighbor : graph[node]) {
            if (!dfs(graph, colors, neighbor, 1 - color)) { // Alterna a cor para o vizinho
                return false;
            }
        }
        return true;
    }
}
