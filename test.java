package hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {

    ArrayList<String> keyword = new ArrayList<String>();
    ArrayList<String> paragraph = new ArrayList<String>();
    ArrayList<Character> letters = new ArrayList<Character>();
    Hashtable<String, Integer> hvalue = new Hashtable<String, Integer>();
    Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
    Scanner input = new Scanner(System.in);
    Hashtable<Character, Integer> frequencyofletters = new Hashtable<Character, Integer>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    HashSet<Integer> uniquelist = new HashSet<Integer>();
    TreeSet<Integer> treeSet;
    String[] stringlist = new String[10];
    int[] integerlist = new int[10];
    int h;

    public void KeyWordFile() throws FileNotFoundException {
        input = new Scanner(new File("C:\\Users\\Adikari\\Documents\\NetBeansProjects\\MiniProject\\src\\miniproject\\KeyWord.txt"));
        System.out.println("File keyword open");

        while (input.hasNext()) {
            String x = input.next();
            keyword.add(x);
        }
        input.close();
    }

    public void assignGvalue() {
        int n = 0;
        while (n < keyword.size()) {
            letters.add(keyword.get(n).charAt(0));
            letters.add(keyword.get(n).charAt((keyword.get(n).length()) - 1));
            n += 1;
        }
        for (char i : letters) {
            int freq = 0;
            for (char j : letters) {
                if (i == j) {
                    freq = freq + 1;
                }
            }
            frequencyofletters.put(i, freq);
        }
    }

    public void sum() {
        for (String x : keyword) {
            int fl = frequencyofletters.get(x.charAt(0));
            int ll = frequencyofletters.get(x.charAt(x.length() - 1));

            int sum = fl + ll;
            hvalue.put(x, sum);
        }
    }

    //create keyword list in order according to values
    public void sorttable() {
        for (String x : hvalue.keySet()) {
            list.add(hvalue.get(x));
        }
        Collections.sort(list, Collections.reverseOrder());

        for (int x : list) {
            uniquelist.add(x);
        }
        treeSet = new TreeSet<Integer>(Collections.reverseOrder());
        treeSet.addAll(uniquelist);
        keyword.clear();
        for (int j : treeSet) {
            for (String x : hvalue.keySet()) {
                if (j == hvalue.get(x)) {
                    keyword.add(x);

                }
            }

        }

    }

    public void calculatehvalue() {
        //give 0 to all letters
        for (Character x : frequencyofletters.keySet()) {
            frequencyofletters.put(x, 0);
        }

        for (int i = 0; i < keyword.size(); i++) {
            int firstletter = frequencyofletters.get(keyword.get(i).charAt(0));
            int lastletter = frequencyofletters.get(keyword.get(i).charAt(keyword.get(i).length() - 1));

            h = (keyword.get(i).length() + firstletter + lastletter) % keyword.size();
//            stringlist[i] = keyword.get(i);
//            integerlist[i] = h;

            if (!(hashtable.containsKey(h))) {
                hashtable.put(h, keyword.get(i));
            } 
            else {
                
                //int x = 1;
                while (true) {
                    
                    firstletter = firstletter + 1;
                    h = (keyword.get(i).length() + firstletter + lastletter) % keyword.size();
                    if (!(hashtable.containsKey(h))) {
                        hashtable.put(h, keyword.get(i));
                        frequencyofletters.put(keyword.get(i).charAt(0), firstletter);
                        break;
                    } 

                   // x++;
                    
                }
                
                
                
                
                
            }

        }

    }
    
     public void TestFile() throws FileNotFoundException {
        input = new Scanner(new File("C:\\Users\\Adikari\\Documents\\NetBeansProjects\\MiniProject\\src\\miniproject\\testFile.txt"));
        System.out.println("File keyword open");

        while (input.hasNext()) {
            String x = input.next();
            paragraph.add(x);
        }
        input.close();
    }
     
   
     
     // calculate h values of testfile file
     public void getFrequency(){
        int noise=0;
        int frequency=0;
        int effect=0;
        int influence=0;
        int ToF=0;
        int defined=0;
        int range=0;
        int the=0;
        int jitter=0;
        int AMCW=0;
        int fleter=0;
        int lletter=0;
        
         for(String x:paragraph){
           int length=x.length();
           
           if(frequencyofletters.containsKey(x.charAt(0))){
             fleter=frequencyofletters.get(x.charAt(0));}
           
           else{
                fleter=0;
           }
           
//           if(frequencyofletters.containsKey(x.charAt(x.length()-1))){
//                lletter=frequencyofletters.get(x.charAt(x.length()-1));
//           }
//           else{
//                lletter=0;
//           }
           
            
           
           h=(length + fleter+lletter)% keyword.size();
          
          switch(h){
              case 7:
                  if(x.equals("noise"))
                  {noise=noise+1;}
                  break;
                  
              case 9:
                  if(x.equals("influence"))
                  {influence=influence+1;}
                  break;
                  
             case 2:
                  if(x.equals("AMCW")) 
                  {AMCW=AMCW+1;}
                  break;
                  
             case 6:
                  if(x.equals("effect")) 
                  {effect=effect+1;}
                  break;
                  
            case 4:
                  if(x.equals("ToF")) 
                  {ToF=ToF+1;}
                  break;
            case 5:
                  if(x.equals("range"))
                  {range=range+1;}
                  break;
            case 8:
                  if(x.equals("defined")) 
                  {defined=defined+1;}
                  break;
            case 3:
                  if(x.equals("the")) 
                  {the=the+1;}
                  break;
                  
             case 1:
                  if(x.equals("frequency")) 
                  {frequency=frequency+1;}
                  break;
                  
             case 0:
                  if(x.equals("jitter")) 
                  {jitter=jitter+1;}
                  break;
               
          }
         
        }
         System.out.println("noise ="+noise);
          System.out.println("frequency = "+frequency);
          System.out.println("effect = "+effect);
          System.out.println("influence = "+influence);
          System.out.println("the = "+the);
          System.out.println("tof = "+ToF);
          System.out.println("defined = "+defined);
          System.out.println("jitter = "+jitter);
          System.out.println("AMCW = "+AMCW);
           
    }
    
    public void mainmethod(){
        try {
            KeyWordFile();
        } catch (FileNotFoundException ex) {
            System.out.println("No File Found - keywordfile");
        }
        
        assignGvalue();
        sum();
        sorttable();
        calculatehvalue();
        try {
            TestFile();
        } catch (FileNotFoundException ex) {
            System.out.println("No File Found - main paragraph");
        }
        getFrequency();
        
    }
    
    

}
