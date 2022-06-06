/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.problemdomain;

import java.io.Serializable;
import java.util.Arrays;
import sudoku.computationlogic.SudokuUtilities;
import sudoku.constants.GameState;

/**
 *
 * @author CM
 */
public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;
    private final int[][] solucao;
    
    public static final int GRID_BOUNDARY = 9;

    public SudokuGame(GameState gameState, int[][] gridState, int[][] solucao) {
        this.gameState = gameState;
        this.gridState = gridState;
        this.solucao = solucao;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }
    
    public int[][] getCopyOfSolution() {
        return SudokuUtilities.copyToNewArray(solucao);
    }

    @Override
    public String toString() {
        System.out.println("Game State: " + this.gameState);
        System.out.println("Grid State: " + Arrays.toString(this.gridState));
        System.out.println("Solução   : " + Arrays.toString(this.solucao));
        return null;
    }
    
    
}
