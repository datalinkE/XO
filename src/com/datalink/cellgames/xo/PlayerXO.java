/**
 * User: datalink
 * Date: 24.07.13
 * Time: 14:18
 */

package com.datalink.cellgames.xo;

import com.datalink.cellgames.*;

import java.util.Scanner;

public class PlayerXO extends AbstractPlayerXO {

    public PlayerXO(char c)
    {
       figure = c;
    }

    public Cell takeInput(Board board)  throws FewTurnsBackException
    {
        System.out.println("Print x y values, or 'rev' to revert some turns");

        int x = -1, y = -1;
        Scanner sc = new Scanner(System.in);

        if(sc.hasNext("rev"))
        {
            sc.next();
            System.out.println("enter the number of turns you want to revert");
            int n = -1;

            while(n < 0 && sc.hasNext())
            {
                if(sc.hasNextInt())
                {
                    n = sc.nextInt();
                    if(n < 0)
                    {
                        System.out.println("N should be positive");
                        n = -1;
                    }
                    else
                        System.out.println("got N");
                }
                else
                {
                    sc.next();
                    System.out.println("bad N string, try again");
                }
            }

            throw new FewTurnsBackException( n );
        }

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
        return res;
    }
}
