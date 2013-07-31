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
    public static final int MAX_BOARD_EDGE = 9;
    public final IPlayerXO[] players =
            {
                new PlayerXO('X'),
                new CompPlayerXO('O')
            };

    private Board board;
    private List<Board> history;

    public static final int DEFAULT_BOARD_EDGE = 3;
    public static final int DEFAULT_WINNER_EDGE = 3;

    private int turnNumber = 0;

    {
       board = new Board(DEFAULT_BOARD_EDGE, DEFAULT_BOARD_EDGE);
       history = new ArrayList<Board> (DEFAULT_BOARD_EDGE*DEFAULT_BOARD_EDGE);
    }

    public boolean isWinner(Cell c)
    {
        if(c.isSet())
        {
            List<Cell> list;

            list = board.horizontalLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
            {   System.out.println("horizontal");
                return true;
            }

            list = board.verticalLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
            {   System.out.println("vertical");
                return true;
            }

            list = board.leftDiaLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
            {   System.out.println("leftDia");
                return true;
            }

            list = board.rightDiaLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
            {   System.out.println("rightDia");
                return true;
            }
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, its XO game!");
        System.out.printf("Enter board's edge [default = %d, max = %d]:", DEFAULT_BOARD_EDGE, MAX_BOARD_EDGE);
        int edge = - 1;
        if(sc.hasNextInt())
        {
            edge = sc.nextInt();
        }

        if(edge > DEFAULT_BOARD_EDGE && edge <= MAX_BOARD_EDGE)
            board = new Board(edge, edge);


        redrawBoard();

        while(true)
        {
            for(IPlayerXO p: players)
            {
                history.add(new Board(board));
                boolean turnComplete = false;
                while(!turnComplete)
                {
                    System.out.println("Turn " + turnNumber);
                    System.out.println("Player " + p.Name());

                    try
                    {
                        Cell    cur = p.takeInput(board);
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
                    catch (FewTurnsBackException e)
                    {
                        int size = history.size();
                        int n = 0;

                        n = size - 1 - e.n;
                        if(n < 0)
                            n = 0;

                        if(n >= 0 && n < (size-1) )
                        {
                            List<Board> thoseTurnHistory = history.subList(0, n + 1);

                            if( (thoseTurnHistory.size() % players.length) == (history.size() % players.length))
                            {
                                System.out.println("Going N turns back");

                                turnNumber = n;
                                board = history.get(n);
                                history = thoseTurnHistory;
                            }
                            else
                            {
                                System.out.println("It was not your turn, try again");
                            }
                        }
                        else
                            System.out.printf("Revert should be in range from %d to %d", 1, size - 1);

                        redrawBoard();
                        continue;
                    }
                }
                turnNumber++;

                if(turnNumber == board.height() * board.width())
                {
                    System.out.println("It's a draw, no winner!");
                    return;
                }
            }
        }
    }
}
