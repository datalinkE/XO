package com.datalink.cellgames;

import java.util.ArrayList;
import java.util.List;

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
            return res;
        }
        else
            return null;
    }


    public List<Cell> horizontalLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        int deltaX = width();
        for(int i = -deltaX; i < deltaX;    i++)
        {
            Cell resCell =  cellAt(x + i, y);
            if(resCell != null)
            {
                result.add(resCell);
            }
        }

        return result;
    }

    public List<Cell> verticalLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        int deltaY = height();
        for(int i = -height(); i < height();    i++)
        {
            Cell resCell =  cellAt(x, y + i);
            if(resCell != null)
            {
                result.add(resCell);
            }
        }
        return result;
    }

    public List<Cell> rightDiaLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        int deltaDia = (int) Math.round(Math.sqrt( x*x +y*y));
        for(int i = -deltaDia; i < deltaDia;    i++)
        {
            Cell resCell =  cellAt(x + i, y + i);
            if(resCell != null)
            {
                result.add(resCell);
            }
        }
        return result;
    }

    public List<Cell> leftDiaLine(Cell c)
    {
        List<Cell> result = new ArrayList<Cell>();
        int x = c.getX();
        int y = c.getY();
        int deltaDia = (int) Math.round(Math.sqrt( x*x +y*y));
        for(int i = -deltaDia; i < deltaDia;    i++)
        {
            Cell resCell =  cellAt(x - i, y + i);
            if(resCell != null)
            {
                result.add(resCell);
            }
        }
        return result;
    }
}
