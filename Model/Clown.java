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
public class Clown extends ImageObject{
//    private int dx;
//    private int dy;
    
    public Clown(int x, int y, String path) {
        super(x, y, path);
    }

    @Override
    public void setY(int y) {
        
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
//public void move() {
//
//        setX(getX()+dx);
//        setY(getY()+dy);
//
//        if (getX() < 1) {
//            setX(1);
//        }
//
//        if (getY() < 1) {
//            setY(1);
//        }
//     }
}
