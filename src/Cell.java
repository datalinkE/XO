/**
 * User: datalink
 * Date: 11.07.13
 * Time: 14:43
 */
public class Cell {
    public final static char NOT_SET = ' ';
    private int x, y;
    private char figure  = NOT_SET;

    public Cell(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean setFigure(char player)
    {   if(isSet())
            return false;
        else
        {
            figure = player;
            return true;
        }
    }

    public char getFigure()
    {
        return figure;
    }

    public boolean isSet()
    {
         return !(figure == Cell.NOT_SET);
    }

    public void draw()
    {
        System.out.print("[");
        System.out.print(getFigure());
        System.out.print("]");
    }

    public String toString() {
        return String.format("Cell[x: %d, y: %d, figure: %c]", x, y, figure);
    }
}
