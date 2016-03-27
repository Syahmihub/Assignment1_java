/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1_2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author syahmizakir
 */
public class Assignment1_2 {

private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static void main(String[] args) throws FileNotFoundException {
        FileWriter out = null;
        
        String name;
        String address;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please Enter Your Name: ");
        name = in.nextLine();
        
        System.out.println("Please Enter Your Address: ");
        address = in.nextLine();
        System.lineSeparator();
        System.out.println("Yourname: "+name);
        System.out.println("Address: "+address);
        
        //write file to Yourname.txt
        try {
            out = new FileWriter("SyahmiZakir.txt");
            out.write("Yourname: "+name);
            out.write(System.lineSeparator());
            out.write("Address: "+address);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Assignment1_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        //read file from Yourname.txt
        File file = new File("SyahmiZakir.txt");
        
        Scanner sc = new Scanner(file);
        String binToString = "";
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            byte[] bytes = line.getBytes(UTF_8);
            for(byte b : bytes){
                binToString += Integer.toBinaryString(b & 127 | 128).substring(1);
            }
            binToString += System.lineSeparator();
        }
        //write in binary to Yourname.bin
        try {
            out = new FileWriter("SyahmiZakir.bin");
            out.write(binToString);
            System.out.println("Your Binary Number : " + binToString);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Assignment1_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        //read from Yourname.bin
        
        File file2 = new File("SyahmiZakir.bin");
        
        Scanner sc2 = new Scanner(file2);
        
        String StoB = "";
        while(sc2.hasNextLine()){
            String line = sc2.nextLine();
            int interval = 7;
            int arrayLength = (int) Math.ceil(((line.length()/(double)interval)));
            String[] result = new String[arrayLength];
            
            int j = 0;
            int lastIndex = result.length - 1;
            for(int i = 0; i<=lastIndex; i++){
                result[i] = line.substring(j, j+interval);
                StoB +=  (char)Integer.parseInt( result[i], 2 );
                j += interval;
            }
            result[lastIndex] = line.substring(j);
            StoB += System.lineSeparator();
        }
        //write the binary to text to Last.txt
        try {
            out = new FileWriter("SyahmiZakir_2.txt");
            out.write(StoB);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Assignment1_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}