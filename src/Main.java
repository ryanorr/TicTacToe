public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        Mark winner = board.hasWon();

        System.out.println(winner);
        System.out.println();
        System.out.println(board);
    }
}