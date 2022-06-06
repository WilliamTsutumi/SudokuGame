/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package sudoku;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import sudoku.userinterface.UIMainMenu;

/**
 *
 * @author CM
 */
public class SudokuApplication extends Application {
    private UIMainMenu uiImpl;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        uiImpl = new UIMainMenu(primaryStage);
//        try {
//            SudokuBuildLogic.build(uiImpl);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw e;
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
