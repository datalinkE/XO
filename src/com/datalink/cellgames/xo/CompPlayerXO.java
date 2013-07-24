package com.datalink.cellgames.xo;

import com.datalink.cellgames.Board;
import com.datalink.cellgames.Cell;

/**
 * User: datalink
 * Date: 24.07.13
 * Time: 15:41
 */
public class CompPlayerXO extends AbstractPlayerXO {

    public CompPlayerXO(char c)
    {
        figure = c;
    }

    public String Name()
    {
        return String.format("%c (Comp)", figure);
    }

    public Cell takeInput(Board board) {
        int x = (int)(Math.random() * board.width());
        int y = (int)(Math.random() * board.height());

        System.out.println("got random input X=" + x + " Y=" + y);

        return board.cellAt(x, y);
    }
}
