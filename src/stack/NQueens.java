package stack;

import java.util.LinkedList;
import java.util.List;

/**
 * N皇后问题
 *
 * @author by Sean
 * @date 2020/5/13 21:48
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        int[] result = new int[n];
        List<List<String>> resultList = new LinkedList<>();
        dfs(result, resultList, 0, n);
        return resultList;
    }

    public static void dfs(int[] result, List<List<String>> resultList, int row, int n) {
        //所有行递归判断完成，返回结果
        if (row == n) {
            LinkedList<String> list = new LinkedList<>();
            for (int x = 0; x < n; x++) {
                StringBuilder sb = new StringBuilder();
                for (int y = 0; y < n; y++) {
                    sb.append(result[x] == y ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            resultList.add(list);
            return;
        }

        for (int column = 0; column < n; column++) {
            result[row] = column;
            boolean isValid = true;
            for (int i = row - 1; i >= 0; i--) {
                if (result[i] == column || row - i == Math.abs(result[i] - column)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) dfs(result, resultList, row + 1, n);
        }
    }

    public static List<List<String>> solveNQueens2(int n) {
        boolean[] cols = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n];
        boolean[] antiDiag = new boolean[2 * n];
        List<List<String>> resultList = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        dfs2(result, resultList, 0, n, cols, mainDiag, antiDiag);
        return resultList;
    }

    public static void dfs2(LinkedList<Integer> result, List<List<String>> resultList, int row,
                            int n, boolean[] cols, boolean[] mainDiag, boolean[] antiDiag) {

        //所有行递归判断完成，返回结果
        if (row == n) {
            LinkedList<String> list = new LinkedList<>();
            for (int x = 0; x < n; x++) {
                StringBuilder sb = new StringBuilder();
                for (int y = 0; y < n; y++) {
                    sb.append(result.get(x) == y ? "Q" : ".");
                }
                list.add(sb.toString());
            }
            resultList.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols[i] || mainDiag[row - i + n] || antiDiag[row + i]) {
                continue;
            }
            result.add(i);
            cols[i] = true;
            mainDiag[row - i + n] = true;
            antiDiag[row + i] = true;
            dfs2(result, resultList, row + 1, n, cols, mainDiag, antiDiag);
            result.removeLast();
            cols[i] = false;
            mainDiag[row - i + n] = false;
            antiDiag[row + i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens2(4);
        int num = 1;
        for (List<String> nType : lists) {
            System.out.println("第" + (num++) + "种方式");
            for (String row : nType) {
                System.out.println(row);
            }
        }
    }
}
