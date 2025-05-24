/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.*;


/**
 *
 * @author Arwa Mohamed
 */
public class CircusWorld implements World {
    State gameState=new GameRunningState();
    private static int MAXIMUM_TIME;
    private static int PLATES_SPEED; //change when strategy made
    private static int CLOWN_SPEED; //change when strategy made
    private int score=0;
    private long startTime=System.currentTimeMillis();
    private final int width;
    private final int height;
    private final List<GameObject> constant;
    private final List<GameObject> moving ;
    private final List<GameObject> control;
    private Factory factory=new Factory();
    private List<GameObject> leftObjects;
    private List<GameObject> rightObjects;



    public CircusWorld(int screenWidth, int screenHeight,Strategy s) {
        MAXIMUM_TIME=s.getTimeout()*60*1000;
        PLATES_SPEED=s.getSpeed();
        CLOWN_SPEED=s.getSpeed();
        
        this.width = screenWidth;
        this.height = screenHeight;
        this.constant = new LinkedList<GameObject>();
        this.control= new LinkedList<GameObject>();
        this.moving=new LinkedList<GameObject>();
        this.leftObjects=new ArrayList<>();
        this.rightObjects=new ArrayList<>();
        objectFormation();
    }

    public void objectFormation()
    {
        constant.add(new ImageObject(0,0,"background.jpg"));
        constant.add ( new Bar (-300, -300, "shelf.png"));
        constant.add ( new Bar (-400, -200, "shelf.png"));
        constant.add ( new Bar (900, -200, "shelf.png"));
        constant.add ( new Bar (800, -300, "shelf.png"));
        constant.add ( new Bar (-550, -100, "shelf.png"));
        constant.add ( new Bar (1040, -100, "shelf.png"));
//        for(int i=0;i<15;i++)
//        {
//             int x = (int) (Math.random() * width);
//             int y = (int) (Math.random() * height / 2);
//             int type = (int) (Math.random() * 7 + 1);
//             moving.add ( factory.create(x, y, type)); //factory design pattern
//        }// if we want raining plates

        control.add(new Clown((int)(width/2.4), (int)(height*0.668),"clown.png"));
        //upper left bar
        for(int i=-10;i<5;i++)
        {
            int type = (int) (Math.random() * 7 + 1);
            if(type==6||type==7)
            {
                moving.add (factory.create(90*i, 33, type,1));
            }
            else{
                moving.add (factory.create(90*i, 65, type,0));
            }
        }
        //lower left bar
        for(int i=-11;i<4;i++)
        {
            int type = (int) (Math.random() * 7 + 1);
            if(type==6||type==7)
            {
                moving.add (factory.create(90*i, 134, type,1));
            }
            else{
                moving.add (factory.create(90*i, 165, type,0));
            }
        }
        //lower low left
        for(int i=-13;i<2;i++)
        {
            int type = (int) (Math.random() * 7 + 1);
            if(type==6||type==7)
            {
                moving.add (factory.create(90*i, 235, type,1));
            }
            else{
                moving.add (factory.create(90*i, 265, type,0));
            }
        }
        //upper right bar
        for(int i=29;i>14;i--)
        {
            int type = (int) (Math.random() * 7 + 1);
            if(type==6||type==7)
            {
                moving.add (factory.create(75*i, 134, type,1));
            }
            else{
                moving.add (factory.create(75*i, 165, type,0));
            }
        }
        // lower right bar
        for(int i=27;i>12;i--)
        {
            int type = (int) (Math.random() * 7 + 1);
            if(type==6||type==7)
            {
                moving.add (factory.create(75*i, 33, type,1));
            }
            else{
                moving.add (factory.create(75*i, 65, type,0));
            }
        }

        //lower low right
        for(int i=30;i>15;i--)
        {
            int type = (int) (Math.random() * 7 + 1);
            if(type==6||type==7)
            {
                moving.add (factory.create(75*i, 235, type,1));
            }
            else{
                moving.add (factory.create(75*i, 265, type,0));
            }
        }

    }



    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAXIMUM_TIME; // time end and game over
        platesMotion();
        if(timeout){
        gameState=new GameOverState();
        return false;
        }
        return true;
       
        
    }
    public void platesMotion()
    {
        Iterator i=new iterator(moving);
        while (i.hasNext()){
            GameObject g= (GameObject) i.next();
            intersect(g);
            //upper left
            if (g.getX() < 360 && (g.getY() == 33 || g.getY() == 65)) {
                g.setX(g.getX() + 1);
            }
            //lower left
            else if (g.getX() < 270 && (g.getY() == 134 || g.getY() == 165)) {
                g.setX(g.getX() + 1);
            }
            //lower right
            else if (g.getX() > 945 && (g.getY() == 134 || g.getY() == 165)) {
                g.setX(g.getX() - 1);
            }
            //upper right
            else if (g.getX() > 845 && (g.getY() == 33 || g.getY() == 65)) {
                g.setX(g.getX() - 1);
            }
            //lower low left
            else if (g.getX() < 100 && (g.getY() == 235 || g.getY() == 265)) {
                g.setX(g.getX() + 1);
            }
            // lower low right
            else if (g.getX() > 1100 && (g.getY() == 235 || g.getY() == 265)) {
                g.setX(g.getX() - 1);
            }
            //out of the bar
            else {

                Random random = new Random();
                int remainingX;

                if (g.getY() == 33 || g.getY() == 65) { // Upper bar (left)
                    int randomX = random.nextInt(g.getX() + 1); // Adjust the width of the plate
                    remainingX = randomX - g.getX();
                } else { // Lower bar (right)
                    int randomX = random.nextInt(width - g.getWidth()); // Adjust the width of the plate
                    remainingX = randomX - g.getX();
                }

                int remainingY = height - g.getHeight() ;

                // Calculate the movement steps for x and y axes
                int stepsX = remainingX / 200; // Adjust this value to control the speed of descent
                int stepsY = remainingY / 200; // Adjust this value to control the speed of descent

                // Set the plate's new x and y positions based on the movement steps
                g.setX(g.getX() + stepsX);
                g.setY(g.getY() + stepsY);
            }
        }

    }

    public boolean intersect(GameObject g)
    {
        GameObject clown = control.get(0);
      
 if((Math.abs((g.getX()+g.getWidth()/2)-(clown.getX()+15+54/2))<= g.getWidth())
        &&(Math.abs((g.getY()+g.getHeight()/2)-(clown.getY()+clown.getHeight()/2))<=g.getHeight()))
 {
     return true;
 }
 else if((Math.abs((g.getX()+g.getWidth()/2)-(clown.getX()+164+54/2))<= g.getWidth())
        &&(Math.abs((g.getY()+g.getHeight()/2)-(clown.getY()+clown.getHeight()/2))<=g.getHeight()))
         {
        return true;
    }
         return false;
        
        //if(isOnLeftOrRightOfClown(g)==1)
        //{
            //return true; //+
          //  if(leftObjects.isEmpty())
            //{
               // firstIntersectClown(1,g);
               // return true;
           // }
      //  }
       /* else if (isOnLeftOrRightOfClown(g)==2)
        {
            if(rightObjects.isEmpty())
            {
                firstIntersectClown(2,g);
                return true;
            }
        }*/
       // return false  ;

    }
     //if plate  left of clown and intersects  return 1 , else plate right of clown and intersects return 2 else return 0
    // public int  isOnLeftOrRightOfClown(GameObject g)
    //{
        //GameObject clown = control.get(0);
        //left
        //plate
       // if  (Math.abs((clown.getX()+50) - g.getX()) <=g.getWidth()
              //  && g.getY() == clown.getY())
         // if(clown.getX()< (g.getX()+g.getWidth())>=(clown.getX()+50))
             // if  (Math.abs(clown.getX() - g.getX()) <= g.getWidth()+6
                     // && g.getY() == clown.getY()-3)
             // {
                  //return 1;
              //}
              //gold
              //else if  (Math.abs(clown.getX() - g.getX()) <= g.getWidth()+4
                    //  && g.getY() == clown.getY()-3)
             // {
                 // return 1;
             // }        else {
                 // return 1;
       // }
        //bomb
        //right
        //gold
       /* if  (Math.abs((clown.getX() + clown.getWidth() /1.5 ) - g.getX()) <= g.getWidth()-10
                && g.getY() == clown.getY() )
        {
            return 2;
        }
        //plate
        else if  (Math.abs((clown.getX() + clown.getWidth() /1.5) - g.getX()) <= g.getWidth()
                && g.getY() == clown.getY()+10 )
        {
            return 2;
        }*/
       // return 0;

   //}
    // 1 left ,  2 right
    /*public void firstIntersectClown(int x, GameObject g)
    {
        GameObject clown = control.get(0);
        ImageObject i=(ImageObject) g;
        if(g instanceof Plates)
        {
            Plates p= (Plates) g;
            if (p.getPlateOrGold()==0)
                i.setPlateOrGoldOrBomb(0);
            else
                i.setPlateOrGoldOrBomb(1);


        }
        else if(g instanceof Bomb)
        {
            i.setPlateOrGoldOrBomb(2);

        }

        //left
        if (x==1)
        {
            moving.remove(g);
            control.add(g);
            leftObjects.add(g);
            i.setType(x);
            i.setG((ImageObject) clown);
        }
        //right
        else if(x==2)
        {
            moving.remove(g);
            control.add(g);
            rightObjects.add(g);
            i.setType(x);
            i.setG((ImageObject) clown);
        }
    }*/

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getStatus() {
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAXIMUM_TIME - (System.currentTimeMillis()-startTime))/1000);
    }

    @Override
    public int getSpeed() {
        return PLATES_SPEED;
    }

    @Override
    public int getControlSpeed() {
        return CLOWN_SPEED;
    }
//   public void checkCollisions() {
//
//        Clown clown =(Clown) control.get(0);
//       Rectangle r3 = clown.getBounds();
//
//        for (moving alien : moving) {
//            
//            Rectangle r2 = alien.getBounds();
//
//            if (r3.intersects(r2)) {
//                
//                spaceship.setVisible(false);
//                alien.setVisible(false);
//                ingame = false;
//            }
//        }
//
//        List<Missile> ms = spaceship.getMissiles();
//
//        for (Missile m : ms) {
//
//            Rectangle r1 = m.getBounds();
//
//            for (Alien alien : aliens) {
//
//                Rectangle r2 = alien.getBounds();
//
//                if (r1.intersects(r2)) {
//                    
//                    m.setVisible(false);
//                    alien.setVisible(false);
//                }
//            }
//        }
//}

}
