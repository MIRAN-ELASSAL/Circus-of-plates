/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.event.KeyEvent;

/**
 *
 * @author Esraa
 */
public class Bomb extends ImageObject {
    private boolean isLeft;
//     private int dx;
//    private int dy;
    public Bomb(int x, int y, String path) {
        super(x, y, path);
    }

    public boolean isIsLeft() {
        return isLeft;
    }

    public void setIsLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }
//    public void keyPressed(KeyEvent e) {
//        if(e.getKeyCode()==KeyEvent.VK_LEFT)
//        {
//            dx=-1;
//        }
//        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
//        {
//            dx=1;
//        }
//    }
//    
//    public void keyReleased(KeyEvent e) {
//
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 0;
//        }
//    }
    
}
