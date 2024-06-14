package org.datastructuresandalgorithms.hiskio.graph.list;

import java.util.LinkedList;
import java.util.List;

public class Graph_Adj_List_Impl_EdgeState {

    public static class EdgeState {
        public Integer i_vertex_dst;
        public Integer weight;

        EdgeState(Integer i_vertex_dst, Integer weight) {
            this.i_vertex_dst = i_vertex_dst;
            this.weight = weight;
        }
    }

    private List<EdgeState>[] adj_list; // [] 裡面是 List

    public Graph_Adj_List_Impl_EdgeState(int num_of_vertex) {
        adj_list = new List[num_of_vertex];

        for (int i_vertex_src = 0; i_vertex_src < num_of_vertex; i_vertex_src++) {
            adj_list[i_vertex_src] = new LinkedList<>();
        }
    }

    public void add_edge(int i_vertex_src, int i_vertex_dst, int weight) {
        List<EdgeState> list_src = adj_list[i_vertex_src];
        list_src.add(new EdgeState(i_vertex_dst, weight));
    }

    public EdgeState get_edge(int i_vertex_src, int i_vertex_dst) {
        List<EdgeState> list_src = adj_list[i_vertex_src];
        for (int i = 0; i < list_src.size(); i++) {
            EdgeState i_vertex_dst_state_now = list_src.get(i);
            if (i_vertex_dst_state_now.i_vertex_dst == i_vertex_dst) {
                return i_vertex_dst_state_now;
            }
        }
        return null;
    }

    public void remove_edge(int i_vertex_src, int i_vertex_dst) {
        List<EdgeState> list_src = adj_list[i_vertex_src];
        for (int i = 0; i < list_src.size(); i++) {
            EdgeState i_vertex_dst_state_now = list_src.get(i);
            if (i_vertex_dst_state_now.i_vertex_dst == i_vertex_dst) {
                list_src.remove(i);
            }
        }
    }

    public void print_edge() {
        for (int i_vertex_src = 0; i_vertex_src < adj_list.length; i_vertex_src++) {
            System.out.printf("[%d] ", i_vertex_src);
            List<EdgeState> list_src = adj_list[i_vertex_src];
            for (int i = 0; i < list_src.size(); i++) {
                EdgeState i_vertex_dst_state_now = list_src.get(i);
                System.out.printf("-> [%d %d] ", i_vertex_dst_state_now.i_vertex_dst, i_vertex_dst_state_now.weight);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph_Adj_List_Impl_EdgeState graph = new Graph_Adj_List_Impl_EdgeState(5);

        // test get_edge
        EdgeState edge_before = graph.get_edge(0, 2);
        System.out.println("edge_before:" + edge_before);

        // test set_edge
        graph.add_edge(0, 1, 1);
        graph.add_edge(0, 2, 3);

        graph.add_edge(1, 4, 7);

        graph.add_edge(2, 3, 2);
        graph.add_edge(2, 4, 2);

        graph.add_edge(3, 4, 9);

        graph.add_edge(4, 3, 9);

        // test get_edge
        EdgeState edge_after = graph.get_edge(0, 2);
        System.out.println("edge_after:" + edge_after.weight);

        graph.print_edge();

        System.out.println("test remove_edge");
        graph.remove_edge(2, 4);
        graph.print_edge();
    }
}
