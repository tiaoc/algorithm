package com.base;

import java.util.Comparator;
import java.util.PriorityQueue;

public class dijstra {
    //假设起点为src, 终点为dst, 图以二维矩阵的形式存储，若graph[i][j] == 0, 代表i,j不相连
//visit[i] == 0,代表未访问,visit[0] == -1代表已访问
    public int Dijkstra(int src, int dst, int[][] graph,int[] visit){
        //节点个数
        int n = graph.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        //将起点加入pq
        pq.add(new Node(src, 0));
        while (!pq.isEmpty()){
            Node t = pq.poll();
            //当前节点是终点，即可返回最短路径
            if(t.node == dst)
                return t.cost;
            //t节点表示还未访问
            if (visit[t.node]==0){
                //将节点设置为已访问
                visit[t.node] = -1;
                //将当前节点相连且未访问的节点遍历
                for (int i = 0; i < n; i++) {
                    if (graph[t.node][i]!=0 && visit[i]==0) {
                        pq.add(new Node(i, t.cost + graph[t.node][i]));
                    }
                }
            }
        }
        return -1;
    }
    //定义一个存储节点和离起点相应距离的数据结构
    class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node(){}

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compare(Node node1, Node node2){
            return node1.cost-node2.cost;
        }
    }
}
