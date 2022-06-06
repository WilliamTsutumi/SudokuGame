/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.computationlogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import sudoku.problemdomain.Coordinates;

import static sudoku.problemdomain.SudokuGame.GRID_BOUNDARY;

/**
 *
 * @author CM
 */
public class GameGenerator {
    // Retorna um novo sudoku
    public static int[][] getNewGameGrid(int[][] solved) {
        return unsolveGame(solved);
    }
    
    public static int[][] getSolvedGameGrid() {
        return getSolvedGame();
    }
    
    // Coloca zero em 40 coordenadas aleatórias enquanto não for solucionável
    // Quando é solucionável, retorna o array
    private static int[][] unsolveGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());
        
        boolean solvable = false;
        int[][] solvableArray = new int[GRID_BOUNDARY][GRID_BOUNDARY];
        
        while (solvable == false) {
            SudokuUtilities.copySudokuArrayValues(solvedGame, solvableArray);
            
            int index = 0;
            
            while (index < 40) {
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);
                
                if (solvableArray[xCoordinate][yCoordinate] != 0) {
                    solvableArray[xCoordinate][yCoordinate] = 0;
                    index++;
                }
            }
            
            int[][] toBeSolved = new int[GRID_BOUNDARY][GRID_BOUNDARY];
            SudokuUtilities.copySudokuArrayValues(solvableArray, toBeSolved);
            
            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);
        }
        
        return solvableArray;
    }
    
    // Retorna um sudoku aleatório resolvido
    // (era private, tornei public para o botão "mostrar solução")
    private static int[][] getSolvedGame() {
        Random random = new Random(System.currentTimeMillis());
        int[][] newGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        for (int value = 1; value <= GRID_BOUNDARY; value++) {
            int allocations = 0;
            int interrupt = 0;
            
            List<Coordinates> allocTracker = new ArrayList<>();
            
            int attempts = 0;
            // Aloca todas as posições em que value aparece
            while (allocations < GRID_BOUNDARY) {
                if (interrupt > 200) {
                    allocTracker.forEach(coord -> {
                       newGrid[coord.getX()][coord.getY()] = 0;
                    });
                    
                    interrupt = 0;
                    allocations = 0;
                    allocTracker.clear();
                    attempts++;
                    // Com 500 tentativas, volta às condições iniciais
                    // do for e do while
                    if (attempts > 500) {
                        clearArray(newGrid);
                        attempts = 0;
                        value = 1;
                    }
                }
                // Coloca value em uma posição aleatória do array newGrid
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);

                if (newGrid[xCoordinate][yCoordinate] == 0) {
                    newGrid[xCoordinate][yCoordinate] = value;
                    // Se value produz um sudoku inválido, retira value
                    // isso conta como uma interrupção
                    // Caso contrário, aloca a coordenada.
                    if (GameLogic.sudokuIsInvalid(newGrid)) {
                        newGrid[xCoordinate][yCoordinate] = 0;
                        interrupt++;
                    } else {
                        allocTracker.add(new Coordinates(xCoordinate, yCoordinate));
                        allocations++;
                    }
                }
            }
        }
        
        return newGrid;
    }

    private static void clearArray(int[][] newGrid) {
        for (int xIndex = 0; xIndex < GRID_BOUNDARY; xIndex++) {
            for (int yIndex = 0; yIndex < GRID_BOUNDARY; yIndex++) {
                newGrid[xIndex][yIndex] = 0;
            }
        }
    }
}
