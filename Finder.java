package task2;

public class Finder {

    private char[][] matrix;
    private String name;
    private int counter;

    public Finder(char[][] matrix, String name) {
        this.matrix = matrix;
        this.name = name;
        this.counter = 0;

    }

    public int findName() {
        Character firstLetter = name.charAt(0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[j].length; j++) {
                if (firstLetter.equals(matrix[i][j])) {
                    this.moveRow();
                    System.out.println(matrix[i][j]);
                }
            }
        }
        return counter;
    }

    public int moveRow(char[][] matrix, String name, int counter, int coordinateX, int coordinateY) {
        // rows - right
        int k = 1;
        for (int j = coordinateY; j < name.length(); j++){
             if (coordinateY >= matrix[coordinateX].length){
                 break;
             }
             else{
                 while (k < name.length()){
                     Character kLetter = name.charAt(k);
                     if(kLetter.equals(matrix[coordinateX][coordinateY])){
                         k++;
                         System.out.print(kLetter);
                     }
                     counter++;
                     coordinateY++;
                 } 
             }
        }
        
        return counter;
    }

    public void moveColums() {
        // colums
        int k = 1;
        for (int j = 0; j < name.length() - 1; j++) {
            for (int i = 0; i < name.length() - 1; i++) {
                if (matrix[i][j] == name.charAt(k)) {
                    k++;
                }
            }
            counter += 1;
        }
    }

    public void moveDiagonals() {
        // first diagonal
        int k = 1;
        for (int i = 0; i < name.length() - 1; i++) {
            for (int j = 0, y = i; y <= name.length() - 1; j++, y++) {
                if (matrix[i][j] == name.charAt(k)) {
                    k++;
                }
            }
            counter += 1;
        }

        // second diagonal
        for (int i = name.length() - 1; i > 0; i--) {
            for (int j = 0, x = i; x < name.length(); j++, x++) {
                if (matrix[i][j] == name.charAt(k)) {
                    k++;
                }
            }
            counter += 1;
        }
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    void moveRow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
