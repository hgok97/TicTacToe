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

    private static int[] readInput(Scanner input) {

        int[] coordinates = new int[2];
        coordinates[0] = input.nextInt();
        coordinates[1] = input.nextInt();

        return coordinates;
    }

    private static void promptPlayerTurn(boolean playerTurn) {

        String prefix = "Player ";
        String postfix = "Geben Sie zwei Integer-Werte für die 2D-Matrix ein. [0-2] [0-2]";
        if (playerTurn) {
            System.out.println(prefix + "O:\t" + postfix);
        } else {
            System.out.println(prefix + "X:\t" + postfix);
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
