import java.util.ArrayList;

/**
 * User: datalink
 * Date: 11.07.13
 * Time: 14:43
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

        for(int y =0; y < height; y++)
        {
            for(int x =0; x< width; x++)
            {
                cells.add(new Cell(x, y));
            }
        }
    }

    public int width()
    {
        return width;
    }

    public int height()
    {
        return height;
    }

    public Cell cellAt(int x, int y)
    {
        if(x>=0 && y>=0 && x<width() && y<height())
        {
            int pos = y*width + x;
            Cell res = cells.get(pos);

            //System.out.println("Cell at " + x + y + " " + res);
            return res;
        }
        else
            return null;
    }
}
