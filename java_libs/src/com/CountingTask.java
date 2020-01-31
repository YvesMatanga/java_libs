/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author Yves Matanga
 */
public class CountingTask implements Runnable {
    @Override
    public void run() {
        for(int i=0; i < 10; i++){
          System.out.println("Thread "+Thread.currentThread()+
                  " prints "+i+1);
        }        
    }    
}
