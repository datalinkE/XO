/**
 * User: datalink
 * Date: 11.07.13
 * Time: 14:43
 */

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public final char[] players = {'X', 'O'};

    private Board board;

    public static final int DEFAULT_BOARD_EDGE = 3;
    public static final int DEFAULT_WINNER_EDGE = 3;

    {
       board = new Board(DEFAULT_BOARD_EDGE, DEFAULT_BOARD_EDGE);
    }

    public Cell takeInput()
    {
        System.out.println("takeInput");

        int x = -1, y = -1;
        Scanner sc = new Scanner(System.in);
        while(x < 0 && sc.hasNext())
        {
            if(sc.hasNextInt())
            {
                x = sc.nextInt();
                if(x < 0 || x >= board.width())
                {
                    System.out.println("X not in range, try again");
                    x = -1;
                }
                else
                    System.out.println("got X");
            }
            else
            {
                sc.next();
                System.out.println("bad X string, try again");
            }
        }

        while(y < 0 && sc.hasNext())
        {
            if(sc.hasNextInt())
            {
                y = sc.nextInt();
                if(y < 0 || y >= board.height())
                {
                    System.out.println("Y not in range, try again");
                    x = -1;
                }
                else
                    System.out.println("got Y");
            }
            else
            {
                sc.next();
                System.out.println("bad Y string, try again");
            }
        }

        System.out.println("got input X=" + x + " Y=" + y);
        Cell res = board.cellAt(x, y);
        System.out.println(res);
        return res;
    }

    public boolean isWinner(Cell c)
    {
        if(c.isSet())
        {
            List<Cell> list;

            list = horizontalLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
                return true;

            list = verticalLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
                return true;

            list = leftDiaLine(c);

            if(hasWinnerEdge(list, c.getFigure()))
                return true;

            list = rightDiaLine(c);

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

    List<Cell> horizontalLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        for(int i = -DEFAULT_WINNER_EDGE; i < DEFAULT_WINNER_EDGE;    i++)
        {
            Cell resCell =  board.cellAt(x + i, y);
            if(resCell != null)
            {
                result.add(resCell);
                System.out.println(resCell);
            }
        }

        return result;
    }

    List<Cell> verticalLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        for(int i = -DEFAULT_WINNER_EDGE; i < DEFAULT_WINNER_EDGE;    i++)
        {
            Cell resCell =  board.cellAt(x, y + i);
            if(resCell != null)
            {
                result.add(resCell);
            }
        }
        return result;
    }

    List<Cell> rightDiaLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        for(int i = -DEFAULT_WINNER_EDGE; i < DEFAULT_WINNER_EDGE;    i++)
        {
            Cell resCell =  board.cellAt(x + i, y + i);
            if(resCell != null)
            {
                result.add(resCell);
            }
        }
        return result;
    }

    List<Cell> leftDiaLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        for(int i = -DEFAULT_WINNER_EDGE; i < DEFAULT_WINNER_EDGE;    i++)
        {
            Cell resCell =  board.cellAt(x - i, y + i);
            if(resCell != null)
            {
                result.add(resCell);
            }
        }
        return result;
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
}
