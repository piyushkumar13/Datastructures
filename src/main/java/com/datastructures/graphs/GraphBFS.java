/*
 *  Copyright (c) 2022 GoTo
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO GOTO
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Piyush Kumar.
 * @since 01/10/22.
 */
public class GraphBFS {

    private static ArrayList<Integer>[] getAdjacencyList() {
        ArrayList<Integer>[] adjList = new ArrayList[4];

        adjList[0] = new ArrayList<>();
        adjList[0].add(2);
        adjList[0].add(1);

        adjList[1] = new ArrayList<>();
        adjList[1].add(0);
        adjList[1].add(2);

        adjList[2] = new ArrayList<>();
        adjList[2].add(0);
        adjList[2].add(1);
        adjList[2].add(3);


        adjList[3] = new ArrayList<>();
        adjList[3].add(2);

        return adjList;
    }

    public static void traverseConnectedGraph(ArrayList<Integer>[] adjList, int start, boolean[] visited) {


        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            Integer vertex = queue.poll();
            System.out.print(vertex);

            for (Integer edge : adjList[vertex]) {

                if (!visited[edge]) {
                    visited[edge] = true;
                    queue.add(edge);
                }
            }
        }
    }

    public static void traverseUnconnectedGraph(ArrayList<Integer>[] adjList, boolean[] visited) {

        for (int vertex = 0; vertex < adjList.length; vertex++) {

            if (!visited[vertex]) {
                traverseConnectedGraph(adjList, vertex, visited);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer>[] adjList = getAdjacencyList();
        boolean[] visited1 = new boolean[adjList.length];

        traverseConnectedGraph(adjList, 0, visited1);

        System.out.println("");
        boolean[] visited2 = new boolean[adjList.length];
        traverseUnconnectedGraph(adjList, visited2);
    }
}
