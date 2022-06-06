/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.userinterface;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sudoku.buildlogic.SudokuBuildLogic;
import sudoku.computationlogic.GameLogic;
import sudoku.persistence.LocalStorageImpl;
import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;
import static sudoku.problemdomain.SudokuGame.GRID_BOUNDARY;

/**
 *
 * @author William-UEM
 */
//public class UIMainMenu implements UIMainMenuContract.View,
//        EventHandler<MouseEvent>{
public class UIMainMenu {

    private final Stage stage;
    private final Group root;

    private UserInterfaceImpl uiImpl;

//    private UIMainMenuContract.EventListener listener;

    public static final double WINDOW_Y = 732;
    public static final double WINDOW_X = 668;

    public static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);

    public static final String SUDOKU = "Sudoku";

    public UIMainMenu(Stage stage) {
        this.stage = stage;
        this.root = new Group();
        initializeMainMenu();
    }

    private void initializeMainMenu() {
        iniciaJanela(root);
        escreveTitulo(root, 50, 80);
        btnNovoSudoku(root);
        btnContinuar(root);
        btnSair(root);
        stage.show();
    }

    private void iniciaJanela(Group root) {
        Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
        scene.setFill(WINDOW_BACKGROUND_COLOR);
        stage.setScene(scene);
    }

    private void escreveTitulo(Group root, int x, int y) {
        Text title = new Text(x, y, SUDOKU);
        title.setFill(Color.WHITE);
        Font titlefont = new Font(100);
        title.setFont(titlefont);
        root.getChildren().add(title);
    }

    private void btnNovoSudoku(Group root) {
        Button btn = new Button("Novo Jogo");
        btn.setLayoutX(50);
        btn.setLayoutY(100);

        root.getChildren().add(btn);

        btn.setOnAction((ActionEvent event) -> {
            uiImpl = new UserInterfaceImpl(this.stage);
            try {
                SudokuBuildLogic.buildNewSudoku(uiImpl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void btnContinuar(Group root) {
        Button btn = new Button("Continuar");
        btn.setLayoutX(50);
        btn.setLayoutY(150);

        root.getChildren().add(btn);

        btn.setOnAction((event) -> {
            uiImpl = new UserInterfaceImpl(this.stage);
            try {
                SudokuBuildLogic.build(uiImpl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void btnSair(Group root) {
        Button btn = new Button("Sair");
        btn.setLayoutX(50);
        btn.setLayoutY(200);

        root.getChildren().add(btn);

        btn.setOnAction((event) -> {
            stage.close();
        });
    }

//    A intenção era fazer uma implementação da ação do botão
//    igual à do SudokuTextField, mas não pareceu conveniente
//    para um botão, que possui o método onClick()
//    Para o SudokuTextField parece necessário pois precisa-se
//    criar um método para saber qual quadrado foi alterado,
//    checar se o jogo terminou e atualizar o view.
//    @Override
//    public void setListener(UIMainMenuContract.EventListener listener) {
//        this.listener = listener;
//    }
//    @Override
//    public void handle(MouseEvent event) {
//        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
//            Object source = event.getSource();
//            if ((Button) source) == btn)
//            );
//        }
//    }
}
