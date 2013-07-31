package com.datalink.cellgames.xo;

import com.datalink.cellgames.Board;
import com.datalink.cellgames.Cell;

/**
 * User: datalink
 * Date: 24.07.13
 * Time: 14:55
 */
public interface IPlayerXO {

    public String Name();
    public char Figure();
    public Cell takeInput(Board board) throws FewTurnsBackException;
}
