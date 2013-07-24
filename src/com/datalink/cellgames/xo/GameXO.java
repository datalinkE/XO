package com.datalink.cellgames.xo; /**
 * User: datalink
 * Date: 11.07.13
 * Time: 14:43
 */

import com.datalink.cellgames.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameXO {
    public final IPlayerXO[] players =
            {
                new PlayerXO('X'),
                new PlayerXO('O')
            };

    private Board board;

    public static final int DEFAULT_BOARD_EDGE = 3;
    public static final int DEFAULT_WINNER_EDGE = 3;

    {
       board = new Board(DEFAULT_BOARD_EDGE, DEFAULT_BOARD_EDGE);
    }

    public boolean isWinner(Cell c)
    {
        if(c.isSet())
        {
            List<Cell> list;

            list = board.horizontalLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
                return true;

            list = board.verticalLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
                return true;

            list = board.leftDiaLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
                return true;

            list = board.rightDiaLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
                return true;
        }

        return false;
    }

    boolean hasWinnerEdge(List<Cell> list, char figure)
    {
        int winCounter = 0;

        for(Cell c : list)
        {
            if(c.getFigure() == figure)
                winCounter++;
            else
                winCounter = 0;
        }

        return winCounter >= DEFAULT_WINNER_EDGE;
    }

    public void redrawBoard()
    {
        System.out.print("  ");
        for(int x = 0; x < board.width(); x++)
            System.out.print(" " + x + " ");

        System.out.println();

        for(int y = 0; y < board.height(); y++)
        {
            System.out.print(y + " ");
            for(int x = 0; x < board.width(); x++)
            {
                  board.cellAt(x, y).draw();
            }
            System.out.println();
        }
    }

    public void play()
    {
        redrawBoard();

        while(true)
        {
            for(IPlayerXO p: players)
            {
                boolean turnComplete = false;
                while(!turnComplete)
                {
                    System.out.println("Player " + p.Name());
                    Cell cur = p.takeInput(board);
                    turnComplete = cur.setFigure(p.Figure());
                    if(!turnComplete)
                        System.out.println("Cell was not free, try again");

                    redrawBoard();

                    if(isWinner(cur))
                    {
                        System.out.println("Player " + p.Name() +" wins!");
                        return;
                    }
                }
            }
        }
    }
}
