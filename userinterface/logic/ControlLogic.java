/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.userinterface.logic;

import java.io.IOException;
import java.util.Arrays;
import sudoku.computationlogic.GameLogic;
import sudoku.constants.GameState;
import sudoku.constants.Messages;
import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;
import sudoku.userinterface.IUserInterfaceContract;

/**
 *
 * @author CM
 */
public class ControlLogic implements IUserInterfaceContract.EventListener {

    private IStorage storage;
    
    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }


    @Override
    public void onSudokuInput(int x, int y, int input) {
        try {
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            int[][] gridSolution = gameData.getCopyOfSolution();
            newGridState[x][y] = input;
            
            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState,
                    gridSolution
            );
            
            storage.updateGameData(gameData);
            
            view.updateSquare(x, y, input);
            
            if(gameData.getGameState() == GameState.COMPLETE) {
                view.showDialog(Messages.GAME_COMPLETE);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick() {
        try {
            storage.updateGameData(
                    GameLogic.getNewGame()
            );
            
            view.updateBoard(storage.getGameData());
        } catch (IOException e) {
            view.showError(Messages.ERROR);
        }
    }
    
    @Override
    public void onBtnMostraSolucaoClick() {
        try {
            SudokuGame gameData   = storage.getGameData();
            int[][] gameSolution  = gameData.getCopyOfSolution();
            
            gameData = new SudokuGame(
                        GameState.ACTIVE,
                        gameSolution,
                        null
            );
            
            view.updateBoard(gameData);
            
        } catch (IOException e) {
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }
}
