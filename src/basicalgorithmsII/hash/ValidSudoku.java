package basicalgorithmsII.hash;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /**
     * 12/1
     *
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i <= 8; i++) {
            Set<Character> visited = new HashSet<>();
            for (int j = 0; j <= 8; j++) {
                char current = board[i][j];

                if (current == '.') {
                    continue;
                }

                if (!visited.add(current)) {
                    return false;
                }
            }
        }

        for (int j = 0; j <= 8; j++) {
            Set<Character> visited = new HashSet<>();
            for (int i = 0; i <= 8; i++) {
                char current = board[i][j];
                if (current == '.') {
                    continue;
                }

                if (!visited.add(current)) {
                    return false;
                }
            }
        }


        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                Set<Character> visited = new HashSet<>();
                for (int j = 0; j <= 2; j++) {
                    for (int i = 0; i <= 2; i++) {
                        char current = board[row + i][col + j];
                        if (current == '.') {
                            continue;
                        }

                        if (!visited.add(current)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[]args){
        char[][]input=new char[9][9];
        String[]strs={".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};

        for(int i=0;i<=8;i++){
            for(int j=0;j<=8;j++){
                input[i][j]=strs[i].charAt(j);
            }
        }

        System.out.println(new ValidSudoku().isValidSudoku(input));
    }

}
