/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.string;

/**
 *
 * @author Yves Matanga
 */
public class MyString {
   /**
    * Put the first letter of a string in upper case
    * @param Word
    * @return 
    */
   public static String FirstLetterCase(String Word){
       return Word.substring(0,1).toUpperCase() + Word.substring(1);
   } 
}