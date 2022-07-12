package main;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amana
 */
public class stuff {
    public static int problemID = 0;
    public int RR(){
        Random rand = new Random();
        int id = rand.nextInt(9000000);
        id+=1000001;
        return id;
    }
}
