/**
 * Created with IntelliJ IDEA.
 * User: Spectre
 * Date: 11.07.13
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */

import java.util.Scanner;

public class Game {
    public final char[] players = {'X', 'O'};

    private Board board;

    public static final int DEFAULT_BOARD_EDGE = 3;

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
                if(x < 0 || x > board.width())
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
                if(y < 0 || y > board.height())
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
        return board.cellAt(x, y);
    }

    public boolean isWinner(char player)
    {
        return false;
    }

    public void redrawBoard()
    {
        for(int x = 0; x < board.height(); x++)
        {
            for(int y = 0; y < board.width(); y++)
            {
                  board.cellAt(x, y).draw();
            }
            System.out.println();
        }
    }
}
