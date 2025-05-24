/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ADMIN
 */
public class ModerateLevel implements Strategy{

    @Override
    public int getTimeout() {
       return 1;
    }

    @Override
    public int getSpeed() {
        return 30;
    }
    
}
