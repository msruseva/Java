package task1;

public class Solver {
    private boolean checker;
    private int coordinateX;
    private int coordinateY;

    public Solver(boolean checker, int coordinateX, int coordinateY){
        this.checker = checker;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public boolean isChecker() {
        return checker;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setChecker(boolean checker) {
        this.checker = checker;
    }
    
    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    
    public void move(String directions){
        for (char ch : directions.toCharArray()){
            if (checker){
                switch (ch){
                    case '>': {coordinateX -= 1; break;}
                    case '<': {coordinateX += 1; break;}
                    case '^': {coordinateY += 1; break;}
                    case 'v': {coordinateY -= 1; break;}
                    case '~': {checker = false; break;}
                    
                }
            }else{
                switch (ch){
                    case '>': {coordinateX += 1; break;}
                    case '<': {coordinateX -= 1; break;}
                    case '^': {coordinateY -= 1; break;}
                    case 'v': {coordinateY += 1; break;}
                    case '~': {checker = true; break;}
                }
            }
        }
        System.out.print(coordinateX + ", " + coordinateY + '\n');
    }
}
