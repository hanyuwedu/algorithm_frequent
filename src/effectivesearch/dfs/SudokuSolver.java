package effectivesearch.dfs;

import java.util.*;

public class SudokuSolver {
    /**
     * 12/14
     * DFS with check result boolean
     *
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    public void solveSudoku(int[][] board) {
        boolean[][] rowHas = new boolean[10][9];
        boolean[][] colHas = new boolean[10][9];
        boolean[][][] setHas = new boolean[10][3][3];

        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                int num = board[i][j];
                if (num != 0) {
                    rowHas[num][i] = colHas[num][j] = setHas[num][i / 3][j / 3] = true;
                }
            }
        }

        dfs(0, board, rowHas, colHas, setHas);
    }

    private boolean dfs(int index, int[][] board, boolean[][] rowHas, boolean[][] colHas, boolean[][][] setHas) {
        if (index == 81) {
            return true;
        }

        int i = index / 9, j = index % 9;

        if (board[i][j] != 0) {
            return dfs(index + 1, board, rowHas, colHas, setHas);
        }

        for (int num = 1; num <= 9; num++) {
            if (rowHas[num][i] || colHas[num][j] || setHas[num][i / 3][j / 3]) {
                continue;
            }

            rowHas[num][i] = colHas[num][j] = setHas[num][i / 3][j / 3] = true;
            board[i][j] = num;

            if (dfs(index + 1, board, rowHas, colHas, setHas)) {
                return true;
            }

            board[i][j] = 0;
            rowHas[num][i] = colHas[num][j] = setHas[num][i / 3][j / 3] = false;
        }

        return false;
    }


    /**
     * 12/12
     * DFS
     *
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    public void solveSudoku_dummy(int[][] board) {
        Map<Integer, List<Integer>> row = getRow(), col = getCol(), subgrid = getSubgrid();
        int[][] ans = new int[9][9];

        dfs(0, board, ans, row, col, subgrid);
        deepCopy(board, ans);
    }

    private void dfs(int index, int[][] board, int[][] ans, Map<Integer,List<Integer>> row, Map<Integer,List<Integer>> col, Map<Integer,List<Integer>> subgrid) {
        if (index == 81) {
            deepCopy(ans, board);
            return;
        }

        int val = board[index / 9][index % 9];
        if (val != 0) {
            dfs(index + 1, board, ans, row, col, subgrid);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isDuplicate(i, board, index, row) || isDuplicate(i, board, index, col) || isDuplicate(i, board, index, subgrid)) {
                    continue;
                }

                board[index / 9][index % 9] = i;
                dfs(index + 1, board, ans, row, col, subgrid);
                board[index / 9][index % 9] = val;
            }
        }
    }

    private void deepCopy(int[][] copy, int[][] target) {
        int m = target.length, n = target[0].length;

        for (int i = 0; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                copy[i][j] = target[i][j];
            }
        }
    }

    private boolean isDuplicate(int val, int[][] board, int index, Map<Integer,List<Integer>> group) {
        for (int i : group.get(index)) {
            if (i != index && board[i / 9][i % 9] == val) {
                return true;
            }
        }

        return false;
    }


    private Map<Integer, List<Integer>> getRow() {
        Map<Integer, List<Integer>> row = new HashMap<>();
        for (int i = 0; i < 81; i+=9) {
            List<Integer> singleRow = new ArrayList<>();
            for (int j = i; j < i + 9; j++) {
                singleRow.add(j);
            }

            for (Integer r : singleRow) {
                row.put(r, singleRow);
            }
        }

        return row;
    }

    private Map<Integer, List<Integer>> getCol() {
        Map<Integer, List<Integer>> col = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            List<Integer> singleCol = new ArrayList<>();
            for (int j = i; j < i+73; j+=9) {
                singleCol.add(j);
            }

            for (Integer c : singleCol) {
                col.put(c, singleCol);
            }
        }

        return col;
    }

    private Map<Integer, List<Integer>> getSubgrid() {
        Map<Integer, List<Integer>> subgrid = new HashMap<>();

        for (int i = 0; i < 81; i+=27) {
            for (int j = i; j < i + 9; j+=3) {
                List<Integer> grid = new ArrayList<>();
                for (int k = j; k < j + 27; k+=9) {
                    grid.add(k);
                    grid.add(k + 1);
                    grid.add(k + 2);
                }

                for (Integer g: grid) {
                    subgrid.put(g, grid);
                }
            }
        }

        return subgrid;
    }

    public static void main(String[] args) {

        int[][] sudo = {{0,0,9,7,4,8,0,0,0}, {7,0,0,0,0,0,0,0,0}, {0,2,0,1,0,9,0,0,0}, {0,0,7,0,0,0,2,4,0}, {0,6,4,0,1,0,5,9,0}, {0,9,8,0,0,0,3,0,0}, {0,0,0,8,0,3,0,2,0}, {0,0,0,0,0,0,0,0,6}, {0,0,0,2,7,5,9,0,0}};
        print(sudo);
        System.out.println();

        new SudokuSolver().solveSudoku(sudo);

        System.out.println();
        print(sudo);

//        System.out.println(new SudokuSolver().getCol().get(23));
//        int[][] a = {{1, 2}, {3, 4}};
//        int[][] b = new SudokuSolver().deepCopy(a);
//        a[0][0] = 0;
//
//        print(a);
//        print(b);

    }

    public static void print(int[][] board) {
        for (int i = 0; i <= board.length - 1; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
