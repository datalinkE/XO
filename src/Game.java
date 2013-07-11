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

    public void RedrawBoard()
    {

        for(int i = 0; i < board.Width()*2+1; i++)
            System.out.print('-');
        System.out.println();

        for(int x = 0; x < board.Height(); x++)
        {
            System.out.print('|');
            for(int y = 0; y < board.Width(); y++)
            {
                  System.out.print(board.CellAt(x,y).GetFigure());
                  System.out.print('|');
            }
            System.out.println();


            for(int i = 0; i < board.Width()*2+1; i++)
                System.out.print('-');
            System.out.println();
        }
    }
}
