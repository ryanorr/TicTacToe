import java.util.ArrayList;
import java.util.Random;

public class Board {
    private Mark[][] board;

    Board() {
        Random r = new Random();
        Mark[][] matrix = new Mark[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = convertIntToPiece(r.nextInt(3));
            }
        }

        board = matrix;
    }

    Mark hasWon() {
        if (board.length != board[0].length) return Mark.None;
        int size = board.length;

        ArrayList<LocationIterator> tests = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            tests.add(new LocationIterator(new Location(0, i), 1, 0, size));
            tests.add(new LocationIterator(new Location(i, 0), 0, 1, size));
        }

        // Diagonal
        tests.add(new LocationIterator(new Location(0,0),1,1,size));
        tests.add(new LocationIterator(new Location(0,2),1,-1,size));

        for (LocationIterator test : tests) {
            Mark winner = hasWon(test);
            if (winner != Mark.None) {
                return winner;
            }
        }

        return Mark.None;
    }

    private Mark hasWon(LocationIterator iterator) {
        Location firstLocation = iterator.next();
        Mark first = board[firstLocation.row][firstLocation.col];
        while (iterator.hasNext()) {
            Location location = iterator.next();
            if (board[location.row][location.col] != first) {
                return Mark.None;
            }
        }
        return first;
    }

    private static Mark convertIntToPiece(int i) {
        if (i == 1) {
            return Mark.X;
        } else if (i == 2) {
            return Mark.O;
        } else {
            return Mark.None;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Mark[] row: board) {
            for (Mark val: row) {
                switch (val) {
                    case None:
                        output.append(" _");
                        break;
                    case X:
                        output.append(" X");
                        break;
                    case O:
                        output.append(" O");
                }
            }
            output.append("\n");
        }
        return output.toString();
    }
}
