/**
 * Created with IntelliJ IDEA.
 * User: Spectre
 * Date: 11.07.13
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private char[] players = {'X', 'O'};

    private Board board;

    {
       board = new Board(3,3);
    }

    public boolean IsWinner(char player)
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
