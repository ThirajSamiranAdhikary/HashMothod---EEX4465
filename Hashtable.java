
package hashtable;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hashtable {

   
    public static void main(String[] args) {
        test t1=new test();
     
        
//        try {
//            t1.KeyWordFile();
//        } catch (FileNotFoundException ex) {
//            System.out.println("file not found");
//        }
//        t1.assignGvalue();
//        System.out.println(t1.keyword);
//        
//        System.out.println(t1.frequencyofletters);
//        t1.sum();
//        System.out.println(t1.hvalue);
//        t1.sorttable();
//      
//        System.out.println(t1.treeSet);
//        System.out.println(t1.keyword);
//        t1.calculatehvalue();
//        System.out.println(t1.frequencyofletters);
//        
//        for(String x:t1.stringlist){
//            System.out.print(x);
//            System.out.print(" ");
//        }
//                System.out.println("");
//
//        for(int i:t1.integerlist){
//            System.out.print(i);
//        }
//        System.out.println("");
//        System.out.println(t1.hashtable);
//        System.out.println(t1.frequencyofletters);
//        
//        try {
//            t1.TestFile();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Error");
//        }
//        t1.getFrequency();
//        
    t1.mainmethod();
        System.out.println(t1.frequencyofletters);
        System.out.println(t1.hashtable);
        System.out.println(t1.keyword);
    }
    
}
