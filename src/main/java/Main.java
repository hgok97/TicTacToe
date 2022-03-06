import java.util.Scanner;

public class Main {





    public static void main(String[] args) {

        int M = 3;
        int N = 3;

        char player1 = 'X';
        char player2 = 'O';


        char[][] board = new char[M][N];


        // init board
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '-';
            }
        }






        // game loop

        boolean running = true;

        // false = X, true = O
        boolean playerTurn = true;

        Scanner input = new Scanner(System.in);
        while (running) {

            // print current board
            printBoard(board);
            promptPlayerTurn(playerTurn);
            int[] inputCoordinates = readInput(input);

            char c;
            if (playerTurn) {
                c = 'O';
            } else {
                c = 'X';
            }
            board[inputCoordinates[0]][inputCoordinates[1]] = c;
            // check if input is correct...
            // check if game is over / won / draw

            playerTurn = !playerTurn;
        }
    }

    private static void placeCharacterOnBoard(boolean player, char[][] board, int[] inputCoordinates) {


    }

    /**
     * Reads Input from Console
     * @param input
     * @return
     */
    private static int[] readInput(Scanner input) {

        int[] coordinates = new int[2];
        boolean okay = false;
        int x = 0;
        int y = 0;

        x = getCoordinate('X', input);
        y = getCoordinate('Y', input);


        coordinates[0] = x;
        coordinates[1] = y;

        return coordinates;
    }

    /**
     * Gets Coordinate and checks for Input Errors
     * @param coordinateChar
     * @param input
     * @return
     */
    private static int getCoordinate(char coordinateChar, Scanner input) {

        int coordinateNum = 0;
        boolean okay = false;

        do {
            promptCoordinate(coordinateChar);
            String inputCoordinateX = input.nextLine();
            if (isInputDigit(inputCoordinateX)) {
                // Alternativ kann man einfach mit chars arbeiten und abziehen von ASCII Dezimalwert bzw. vom Offset
                coordinateNum = Integer.parseInt(inputCoordinateX.charAt(0)+"");

                if (checkOutOfBounds(coordinateNum)) {
                    okay = true;
                }

            }

            if (!okay) {
                printError();
            }

        } while (!okay);

        return coordinateNum;
    }

    /**
     * Checks if the given Input String is a Digit
     * @param input
     * @return true if String is a digit
     */
    private static boolean isInputDigit(String input) {

        if (input.length() == 1) {

            char c = input.charAt(0);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param num
     * @return true if number lies within given bounds, dependend on board size..
     */
    private static boolean checkOutOfBounds(int num) {
        return num >= 0 && num <= 2;
    }

    private static void promptCoordinate(char c) {
        System.out.print("Geben Sie die -" + c + "- Koordinate ein" + ": ");
    }

    private static void printError() {
        System.out.println("Fehlerhafte Eingabe!");
    }




    private static void promptPlayerTurn(boolean playerTurn) {

        String prefix = "Player ";
        if (playerTurn) {
            System.out.println(prefix + "O:");
        } else {
            System.out.println(prefix + "X:");
        }
    }


    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);

                // ob man das besser lösen kann? ... wayne
                if (!(j == board[i].length-1)) {
                    System.out.print("|");
                }

            }
            System.out.println();
        }
    }

}
