/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CircusWorld;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Esraa
 */
public class Circus { 
    Image image;
    Graphics graphics;
    public static void main(String[] args) {
     //   GameEngine.start("Circus World",new CircusWorld(1250,750));
        JMenuBar menuTab = new JMenuBar() ;
       JMenu menu = new JMenu(  "Game Settings");
       JMenuItem newGame = new JMenuItem(  "New Game");
       JMenuItem pauseGame = new JMenuItem(  "Pause Game") ;
       JMenuItem resumeGame = new JMenuItem(  "Resume");
       menu. add ( newGame);
       menu. addSeparator();
       menu. add ( pauseGame);
       menu. add ( resumeGame);
       menuTab.add(menu);

    }
    
   
}
