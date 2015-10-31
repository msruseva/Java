package tasksecond;

import java.util.Scanner;

public class TaskSecond {

    public static void main(String[] args) {
        //System.out.println("Input name:");
        //Scanner input = new Scanner(System.in);
        int wordCounter = 0;
        char[][] testTable = new char[][]{{'i', 'v', 'a', 'n'},
                                            {'e', 'v', 'n', 'h'},
                                            {'i', 'n', 'a', 'v'},
                                            {'m', 'v', 'v', 'n'},
                                            {'q', 'r', 'i', 't'}};

        String name = "ivan";
        wordCounter += rows(testTable, name, wordCounter);
        wordCounter += colums(testTable, name, 0);
        wordCounter += diagonals(testTable, name, 0);
        
        System.out.println(wordCounter);
        
    }

    public static int rows(char[][] matrix, String name, int counter) {
        String temp = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                temp = temp + matrix[i][j];
            }
            if (temp.equals(name)) {
                counter++;
            }
            if (reverse(temp).equals(name)){
                counter++;
            }
            temp = "";
        }
        return counter;
    }

    public static int colums(char[][] matrix, String name, int counter) {
        String temp = "";
        for (int j = 0; j < matrix[j].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                temp = temp + matrix[i][j];
            }
            if (temp.contains(name)) {
                counter++;
            }
            if (reverse(temp).contains(name)){
                counter++;
            }
            temp = "";
        }
        return counter;
    }

    public static int diagonals(char[][] matrix, String name, int counter) {
        String temp = "";
        for (int i = 0; i < name.length(); i++) {
            temp = temp + matrix[i][i];
            if (temp.equals(name)) {
                counter++;
            }
            if (reverse(temp).equals(name)){
                counter++;
            }
        }
        temp = "";

        int j = 0;
        for (int i = matrix.length - 1; i > 0; i--) {
            temp = temp + matrix[i][j];
            j++;
            if (temp.equals(name)) {
                counter++;
            }
            if (reverse(temp).equals(name)){
                counter++;
            }
        }
        temp = "";

        j = 0;
        for (int k = matrix.length - 1; k > 0; k--) {
            temp = temp + matrix[k][j];
            j++;
            if (temp.equals(name)) {
                counter++;
            }
            if (reverse(temp).equals(name)){
                counter++;
            }
        }
        temp = "";
        
        j = matrix[matrix.length - 1].length - 1;
        for (int i = matrix.length - 1; i > 0; i--) {
            temp = temp + matrix[i][j];
            j--;
            if (temp.equals(name)) {
                counter++;
            }
            if (reverse(temp).equals(name)){
                counter++;
            }
        }
        return counter;
    }

    public static String reverse(String s) {
         String result = new StringBuffer(s).reverse().toString();
         return result;
    }

}
