package task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        //System.out.println("Input name:");
        //Scanner input = new Scanner(System.in);
        
        char[][] testTable = new char[][] {{'i','v','a','n'},
                                           {'e','v','n','h'},
                                           {'i', 'n', 'a', 'v'},
                                           {'m', 'v', 'v', 'n'},
                                           {'q', 'r', 'i', 't'}};
        String name = "ivan";
        Finder test = new Finder(testTable, name);
        
        //test.moveRow(testTable, name, 0, 0, 0);
        test.getCounter();
    }
    
}
