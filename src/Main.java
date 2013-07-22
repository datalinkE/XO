/**
 * Created with IntelliJ IDEA.
 * User: Spectre
 * Date: 10.07.13
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        g.redrawBoard();
        while(true)
        {
            for(char p: g.players)
            {
                System.out.println("Player " + p);
                Cell cur = g.takeInput();
                cur.setFigure(p);
                g.redrawBoard();
            }
        }
    }
}
