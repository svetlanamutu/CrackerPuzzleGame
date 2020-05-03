package com.trainingUNT;

public class Display {
//    Display() {
//        System.out.println("will display");
//    }
//
//    void show() {
//        System.out.println("displaying");
//    }

    // print game board at each node on the way down the tree, removing the printed child on the way up
    public void printWinningGame(GameTree parent) {
        System.out.println(parent.getGameBoard());

        if (parent.numChildren() > 0) {
            GameTree nextNode = parent.getFirstChild();
            printWinningGame(nextNode);				// recursive call
            if (nextNode.numChildren() == 0)
                parent.removeFirstChild();
        } else {
            System.out.println("--------Done----------");
        }
    }
}
