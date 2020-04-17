

import java.util.Arrays;

public class BranchAndBound {

    public static final int NO_OF_QUEENS = 4;
    private static boolean validMove(char[][] mat, int r, int c)
    {
        for (int i = 0; i < r; i++)
            if (mat[i][c] == 'Q')
                return false;
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if (mat[i][j] == 'Q')
                return false;
        for (int i = r, j = c; i >= 0 && j < NO_OF_QUEENS; i--, j++)
            if (mat[i][j] == 'Q')
                return false;
        return true;
    }

    private static void nQueen(char mat[][], int r)
    {
        if (r == NO_OF_QUEENS)
        {
            for (int i = 0; i < NO_OF_QUEENS; i++)
            {
                for (int j = 0; j < NO_OF_QUEENS; j++)
                    System.out.print(mat[i][j] + " ");
                System.out.println();
            }
            System.out.println();

            return;
        }
        for (int i = 0; i < NO_OF_QUEENS; i++)
        {
            if (validMove(mat, r, i))
            {
                mat[r][i] = 'Q';
                nQueen(mat, r + 1);
                mat[r][i] = '-';
            }
        }
    }

    public static void main(String[] args)
    {
        char[][] mat = new char[NO_OF_QUEENS][NO_OF_QUEENS];
        for (int i = 0; i < NO_OF_QUEENS; i++) {
            Arrays.fill(mat[i], '-');
        }
        nQueen(mat, 0);
    }
}
