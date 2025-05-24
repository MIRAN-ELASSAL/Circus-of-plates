/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.event.KeyEvent;

/**
 *
 * @author Arwa Mohamed
 */
public class Plates extends ImageObject {
    private int dx;
    private int dy;
    
    private int plateOrGold; //0 for plate , 1 for gold
  
    public Plates(int x, int y, String path ,int plateOrGold) {
        super(x, y, path);
        this.plateOrGold=plateOrGold;
    }


    public int getPlateOrGold() {
        return plateOrGold;
    }

    public void setPlateOrGold(int plateOrGold) {
        this.plateOrGold = plateOrGold;
    }

//   public void keyPressed(KeyEvent e) {
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
