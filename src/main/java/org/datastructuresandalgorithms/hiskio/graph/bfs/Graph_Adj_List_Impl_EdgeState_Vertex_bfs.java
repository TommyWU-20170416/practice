package org.datastructuresandalgorithms.hiskio.graph.bfs;

import java.util.*;

public class Graph_Adj_List_Impl_EdgeState_Vertex_bfs {

    public static class EdgeState {
        public Integer i_vertex_dst;
        public Integer weight;

        EdgeState(Integer i_vertex_dst, Integer weight) {
            this.i_vertex_dst = i_vertex_dst;
            this.weight = weight;
        }
    }

    private List<EdgeState>[] adj_list; // [] 裡面是 List
    private char[] v_states;

    public Graph_Adj_List_Impl_EdgeState_Vertex_bfs(int num_of_vertex) {
        adj_list = new List[num_of_vertex];
        v_states = new char[num_of_vertex];

        for (int i_vertex_src = 0; i_vertex_src < num_of_vertex; i_vertex_src++) {
            adj_list[i_vertex_src] = new LinkedList<>();
        }

        for (int i_vertex_src = 0; i_vertex_src < v_states.length; i_vertex_src++) {
            v_states[i_vertex_src] = (char) ('A' + i_vertex_src);
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
            System.out.printf("[%c] ", v_states[i_vertex_src]);
            List<EdgeState> list_src = adj_list[i_vertex_src];
            for (int i = 0; i < list_src.size(); i++) {
                EdgeState i_vertex_dst_state_now = list_src.get(i);
                System.out.printf("-> [%c %d] ", v_states[i_vertex_dst_state_now.i_vertex_dst], i_vertex_dst_state_now.weight);
            }
            System.out.println();
        }
    }

    public void traverse_bfs(int i_v_src) {
        System.out.print("bfs: ");
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(i_v_src);

        while (true) {
            if (q.size() == 0) break;
            Integer i_v_src_now = q.poll();
            if (visited.contains(i_v_src_now)) continue;
            visited.add(i_v_src_now);

            // main logic
            System.out.printf("%c ", v_states[i_v_src_now]);

            List<EdgeState> neighbors = adj_list[i_v_src_now];
            for (int i = 0; i < neighbors.size(); i++) {
                EdgeState edge_state = neighbors.get(i);
                q.offer(edge_state.i_vertex_dst);
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Graph_Adj_List_Impl_EdgeState_Vertex_bfs graph = new Graph_Adj_List_Impl_EdgeState_Vertex_bfs(5);

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

        EdgeState edge_after = graph.get_edge(0, 2);
        System.out.println("edge_after:" + edge_after.weight);

        System.out.println("-- test print_edge");
        graph.print_edge();

        System.out.println("-- test traverse_bfs");
        graph.traverse_bfs(0);

        System.out.println("-- test remove_edge");
        graph.remove_edge(2, 4);
        graph.print_edge();
    }
}
