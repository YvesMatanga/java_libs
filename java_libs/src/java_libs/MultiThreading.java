/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_libs;

/**
 *
 * @author Yves Matanga
 */
public class MultiThreading {
    public static void main(String[] args){
         
        Thread Thread1 = new Thread(new CountingTask());
        
        Thread Thread2 = new Thread(new CountingTask());
         
    }
}
