/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.userinterface;

import javafx.scene.control.TextField;
/**
 *
 * @author CM
 */
public class SudokuTextField extends TextField{
    private final int x;
    private final int y;

    public SudokuTextField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public void replaceText(int i, int i1, String s) {
        if (!s.matches("[0-9]")) {
            super.replaceText(i, i1, s);
        }
//      if (Pattern.matches("[0-9]", s)) {
//          super.replaceText(i, i1, s);
//      }
    }
    
    @Override
    public void replaceSelection(String s) {
        if (!s.matches("[0-9]")) {
            super.replaceSelection(s);
        }
//        if (Pattern.matches("[0-9]", s)) {
//            super.replaceSelection(s);
//        }
    }
}
