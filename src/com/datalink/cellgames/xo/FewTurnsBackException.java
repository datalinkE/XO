package com.datalink.cellgames.xo;

/**
 * User: datalink
 * Date: 29.07.13
 * Time: 23:36
 */

public class FewTurnsBackException extends Exception {
    public int n;
    FewTurnsBackException(int n)
    {
        this.n = n;
    }
}
