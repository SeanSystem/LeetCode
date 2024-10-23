package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                List<Integer> preList = res.get(i - 1);
                list.add(preList.get(j - 1) + preList.get(j));
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        generate.generate(3);
    }

}
