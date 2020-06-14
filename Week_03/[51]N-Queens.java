import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueens {
    boolean[] cols;
    boolean[] dia1;
    boolean[] dia2;
    char[][] cur;
    int n;

    private void _find(List<List<String>> ret, int level) {
        if (level == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(cur[i]));
            }
            ret.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols[i] || dia1[i + level] || dia2[level - i + n - 1]) {
                continue;
            }
            cur[level][i] = 'Q';
            cols[i] = true;
            dia1[i + level] = true;
            dia2[level - i + n - 1] = true;

            //go to next row
            _find(ret, level + 1);

            // go on to try other solves
            cur[level][i] = '.';
            cols[i] = false;
            dia1[i + level] = false;
            dia2[level - i + n - 1] = false;
        }
    }


    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        List<List<String>> ret = new ArrayList<>();
        cols = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        this.n = n;
        cur = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cur[i][j] = '.';
            }
        }

        _find(ret, 0);

        return ret;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(8);
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("");
        }
    }
}