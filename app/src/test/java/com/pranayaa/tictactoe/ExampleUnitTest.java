package com.pranayaa.tictactoe;


import org.junit.Test;
import static com.pranayaa.tictactoe.TicTacToeLogic.TTTElement.*;

import static com.pranayaa.tictactoe.TicTacToeLogic.getBestMove;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    @Test
    public void testTicTacToe() {
        TicTacToeLogic.TTTElement[] gameState1 =
                {X, EMPTY, EMPTY, X, O, EMPTY, EMPTY, EMPTY, EMPTY};
        TicTacToeLogic.TTTElement[] gameState2 =
                {O, O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
        TicTacToeLogic.TTTElement[] gameState3 =
                {O, O, X, X, O, X, O, X, X};
        int generated1 = getBestMove(gameState1);
        int generated2 = getBestMove(gameState2);
        int generated3 = getBestMove(gameState3);
        int expected1 = 6;
        int expected2 = 2;
        int expected3 = -1;

        assertEquals(expected1, generated1);
        assertEquals(expected2, generated2);
        assertEquals(expected3, generated3);
    }

}