/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Arwa Mohamed
 */
public class Factory {

    public ImageObject create(int x, int y, int type,int plateOrGold) {
        switch (type) {
            case 1://red plate
                return new Plates(x, y, "plate1.png",0);
            case 2://blue plate
                return new Plates(x, y, "plate2.png",0);
            case 3://green plate
                return new Plates(x, y, "plate3.png",0);
            case 4://mintgreen plate
                return new Plates(x, y, "plate4.png",0);
            case 5://yellow plate 
                return new Plates(x, y, "plate5.png",0);
            case 6://gold
                return new Plates(x, y, "gold.png",1);
            case 7://bomb 
                return new Bomb(x, y, "bomb.png");
        }
        return null;

    }

}
