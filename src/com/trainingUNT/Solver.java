package com.trainingUNT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Solver extends Object{
//    Solver(int start) {
//        this.start=start;
//        System.out.println("starting solver: "+ start);
//    }
//
//    int start;
//
//    void run() {
//        System.out.println("running solver");
//
//    }
    GameBoard startBoard;


    public Solver(String[] args) throws IOException {
        if (args.length == 0) {

            int n1,n2;
            BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in));

            System.out.println("Enter the initial position of the empty spot on the board, one coordinate per line, separated by enter key:");
            System.out.println("Possible valid coordinates are:");
            System.out.println("          0,0");
            System.out.println("       1,0  1,1");
            System.out.println("     2,0  2,1  2,2");
            System.out.println("   3,0  3,1  3,2  3,3");
            System.out.println(" 4,0  4,1  4,2  4,3  4,4");
            System.out.println("---------------------------");


            n1=Integer.parseInt( stdin.readLine());
            n2=Integer.parseInt( stdin.readLine());
            init(n1,n2);
        }
        else
            init(Integer.parseInt( args[0]),Integer.parseInt( args[1]));
    }


    private void init(int row, int col) {
        startBoard = new GameBoard(row, col);
    }

    //Depth First Search in a tree method
    public void DFS() {
        GameTree root = new GameTree(startBoard);

        for (GameBoard nextBoard : startBoard.possibleBoards()) {
            GameTree nextNode = new GameTree(nextBoard);
            if (play(nextBoard, nextNode))
                root.addChild(nextNode);
        }

        Display showGame = new Display();
        showGame.printWinningGame(root);

    }


    // go after all possible boards
    private boolean play(GameBoard gb, GameTree parent) {

        if (gb.finalBoard())	// remember this path was a winning path
            return true;

        List<GameBoard> nextBoards = gb.possibleBoards();

        boolean found = false;

        for (GameBoard nextBoard : nextBoards) {
            GameTree nextNode = new GameTree(nextBoard);
            if (play(nextBoard, nextNode)) {
                found = true;
                parent.addChild(nextNode);
            }
        }

        return found;
    }
}
