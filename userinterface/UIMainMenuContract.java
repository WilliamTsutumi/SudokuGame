/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sudoku.userinterface;

/**
 *
 * @author William-UEM
 */
public interface UIMainMenuContract {
    interface EventListener {
        void onBtnClick(int x, int y);
    }
    
    interface View {
        void setListener(UIMainMenuContract.EventListener listener);
        // Por enquanto a tela inicial não possui nada a atualizar
    }
}
