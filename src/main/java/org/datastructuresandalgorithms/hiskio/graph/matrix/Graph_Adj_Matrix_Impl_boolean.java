package org.datastructuresandalgorithms.hiskio.graph.matrix;

public class Graph_Adj_Matrix_Impl_boolean {
    private boolean adj_matrix[][];

    public Graph_Adj_Matrix_Impl_boolean(int num_of_vertice) {
        adj_matrix = new boolean[num_of_vertice][num_of_vertice];

        // init
        for (int row = 0; row < adj_matrix.length; row++) {
            for (int col = 0; col < adj_matrix[row].length; col++) {
                adj_matrix[row][col] = false;
            }
        }
    }

    public void set_edge(int i_vertex_src, int i_vertex_dst, boolean is_exist) {
        adj_matrix[i_vertex_src][i_vertex_dst] = is_exist;
    }

    public boolean get_edge(int i_vertex_src, int i_vertex_dst) {
        return adj_matrix[i_vertex_src][i_vertex_dst];
    }

    public void print_edge() {
        for (int row = 0; row < adj_matrix.length; row++) {
            for (int col = 0; col < adj_matrix[row].length; col++) {
                if (adj_matrix[row][col]) {
                    System.out.print("T" + " ");
                } else {
                    System.out.print("F" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph_Adj_Matrix_Impl_boolean graph = new Graph_Adj_Matrix_Impl_boolean(5);

        // test get_edge
        boolean edge_before = graph.get_edge(0, 2);
        System.out.println("edge_before:" + edge_before);

        // test set_edge
        graph.set_edge(0, 0, true);
        graph.set_edge(0, 1, true);
        graph.set_edge(0, 2, true);

        graph.set_edge(1, 1, true);
        graph.set_edge(1, 4, true);

        graph.set_edge(2, 2, true);
        graph.set_edge(2, 3, true);
        graph.set_edge(2, 4, true);

        graph.set_edge(3, 3, true);
        graph.set_edge(3, 4, true);

        graph.set_edge(4, 4, true);
        graph.set_edge(4, 3, true);

        boolean edge_after = graph.get_edge(0, 2);
        System.out.println("edge_after:" + edge_after);

        graph.print_edge();
    }
}
