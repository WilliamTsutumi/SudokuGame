/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.buildlogic;

import java.io.IOException;
import sudoku.computationlogic.GameLogic;
import sudoku.persistence.LocalStorageImpl;
import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;
import sudoku.userinterface.IUserInterfaceContract;
import sudoku.userinterface.logic.ControlLogic;

/**
 *
 * @author William-UEM
 */
public class SudokuBuildLogic {
    
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();
        
        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }
        
        IUserInterfaceContract.EventListener uiLogic
                = new ControlLogic(storage, userInterface);
        
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
    
    public static void buildNewSudoku(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState = null;
        IStorage storage = new LocalStorageImpl();
        
        try {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        IUserInterfaceContract.EventListener uiLogic
                = new ControlLogic(storage, userInterface);
        
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
