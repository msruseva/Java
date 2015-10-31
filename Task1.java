package task1;

import java.util.Scanner;

public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting point: ");
        Scanner input = new Scanner(System.in);

        int x, y;
        String directions;
        
        System.out.print("Input first coordinate x: ");
        x = input.nextInt();
        System.out.print("Input second coordinate y: ");
        y = input.nextInt();
        input.nextLine();
        System.out.print("Input string:  ");
        directions = input.nextLine();
        
        Solver solver = new Solver(false, x, y);
        solver.move(directions);
    }
    
}
