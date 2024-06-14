package org.datastructuresandalgorithms.hiskio.graph.list;

import java.util.LinkedList;
import java.util.List;

public class Graph_Adj_List_Impl {
    private List<Integer>[] adj_list; // [] 裡面是 List

    public Graph_Adj_List_Impl(int num_of_vertex) {
        adj_list = new List[num_of_vertex];

        for (int i_vertex_src = 0; i_vertex_src < num_of_vertex; i_vertex_src++) {
            adj_list[i_vertex_src] = new LinkedList<>();
        }
    }

    public void add_edge(int i_vertex_src, int i_vertex_dst) {
        List<Integer> list_src = adj_list[i_vertex_src];
        list_src.add(i_vertex_dst);
    }

    public Integer get_edge(int i_vertex_src, int i_vertex_dst) {
        List<Integer> list_src = adj_list[i_vertex_src];
        for (int i = 0; i < list_src.size(); i++) {
            Integer i_vertex_src_now = list_src.get(i);
            if (i_vertex_src_now == i_vertex_dst) {
                return i_vertex_src_now;
            }
        }
        return null;
    }

    public void remove_edge(int i_vertex_src, int i_vertex_dst) {
        List<Integer> list_src = adj_list[i_vertex_src];
        for (int i = 0; i < list_src.size(); i++) {
            Integer i_vertex_dst_now = list_src.get(i);
            if (i_vertex_dst_now == i_vertex_dst) {
                list_src.remove(i);
            }
        }
    }

    public void print_edge() {
        for (int i_vertex_src = 0; i_vertex_src < adj_list.length; i_vertex_src++) {
            System.out.printf("[%d] ", i_vertex_src);
            List<Integer> list_src = adj_list[i_vertex_src];
            for (int i = 0; i < list_src.size(); i++) {
                Integer i_vertex_dst_now = list_src.get(i);
                System.out.printf("-> %d ", i_vertex_dst_now);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph_Adj_List_Impl graph = new Graph_Adj_List_Impl(5);

        // test get_edge
        Integer edge_before = graph.get_edge(0, 2);
        System.out.println("edge_before:" + edge_before);

        // test set_edge
        graph.add_edge(0, 1);
        graph.add_edge(0, 2);

        graph.add_edge(1, 4);

        graph.add_edge(2, 3);
        graph.add_edge(2, 4);

        graph.add_edge(3, 4);

        graph.add_edge(4, 3);

        // test get_edge
        Integer edge_after = graph.get_edge(0, 2);
        System.out.println("edge_after:" + edge_after);

        graph.print_edge();

        System.out.println("test remove_edge");
        graph.remove_edge(2, 4);
        graph.print_edge();
    }
}
