package jva;

import java.util.ArrayList;

class PadNode {
    public String number;
    public boolean active = true;
    public ArrayList<PadNode> connections;

    public PadNode(String number) {
        this.number = number;
    }

    public PadNode(String number, ArrayList<PadNode> connections) {
        this.number = number;
        this.connections = connections;
    }

    public ArrayList<PadNode> getConnections() {
        return this.connections;
    }

    public void setConnections(ArrayList<PadNode> connections) {
        this.connections = connections;
    }

    public String convertConnectionsToString() {
        String output = "{";
        for (int i = 0; i < this.connections.size(); i++) {
            output += this.connections.get(i).number + ", ";
        }
        output = output.substring(0, output.length() - 2);
        output += "}";

        return output;
    }

    public void pruneInactiveNodes() {
        for (int i = 0; i < this.connections.size(); i++) {
            if (!this.connections.get(i).active) {
                this.connections.remove(i);
            }
        }
    }

    public String toString() {
        return this.number + " -> " + convertConnectionsToString();
    }
}

public class Answer879 {
    public long count = 0;

    public static boolean padCanReach(int startX, int startY, int endX, int endY) {
        if (startX == endX) return Math.abs(endY - startY) < 2;
        if (startY == endY) return Math.abs(endX - startX) < 2;

        return Math.abs(endX - startX) < 2 || Math.abs(endY - startY) < 2;
    }
    
    /* 
    public static plotBranchingPath(PadNode node, String running) {
        node.pruneInactiveNodes();
        if (node.connections.size() == 0) {
            
        }
    }
    */

    public static void main(String[] args) {
        int[][] numbers = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        PadNode[][] nodeGraph = new PadNode[4][4];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                nodeGraph[i][j] = new PadNode(Integer.toString(numbers[i][j]));
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                ArrayList<PadNode> connections = new ArrayList<PadNode>();

                for (int x = 0; x < numbers.length; x++) {
                    for (int y = 0; y < numbers[i].length; y++) {
                        if (i != x || j != y) {
                            if (padCanReach(i, j, x, y)) connections.add(nodeGraph[x][y]);
                        }
                    }   
                }

                nodeGraph[i][j].setConnections(connections);
            }   
        }

        for (int i = 0; i < nodeGraph.length; i++) {
            for (int j = 0; j < nodeGraph[i].length; j++) {
                System.out.println(nodeGraph[i][j]);
            }
        }
    }
}
