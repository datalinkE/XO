/**
 * User: datalink
 * Date: 10.07.13
 * Time: 17:26
 */
public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        g.redrawBoard();
        while(true)
        {
            for(char p: g.players)
            {
                boolean turnComplete = false;
                while(!turnComplete)
                {
                    System.out.println("Player " + p);
                    Cell cur = g.takeInput();
                    turnComplete = cur.setFigure(p);
                    if(!turnComplete)
                        System.out.println("Cell was not free, try again");

                    g.redrawBoard();

                    if(g.isWinner(cur))
                    {
                        System.out.println("Player " + p +" wins!");
                        return;
                    }
                }
            }
        }
    }
}
