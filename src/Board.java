import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Spectre
 * Date: 11.07.13
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class Board {
    private ArrayList<Cell> cells;
    private int width;
    private int height;

    {
        cells = new ArrayList<Cell>(9);
    }

    public Board(int width, int height)
    {
        this.width = width;
        this.height = height;

        for(int i =0; i< width; i++)
        {
            for(int j =0; j< height; j++)
            {
                cells.add(new Cell(i,j));
            }
        }
    }

    public int Width()
    {
        return width;
    }

    public int Height()
    {
        return height;
    }

    public Cell CellAt(int x, int y)
    {
        int pos = y*width + x;
        return cells.get(pos);
    }

    public Cell GetRight(Cell c)
    {
         return null;
    }

    public Cell GetRBot(Cell c)
    {
        return null;
    }

    public Cell GetBot(Cell c)
    {
        return null;
    }

    public Cell GetLBot(Cell c)
    {
        return null;
    }
}
