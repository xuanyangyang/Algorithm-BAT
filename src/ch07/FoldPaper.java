package ch07;

import java.util.ArrayList;
import java.util.List;

/**
 * 7.11
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 * 测试样例：
 * 1
 * 返回：["down"]
 */
public class FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        List<String> temp = new ArrayList<>();
        fold(1, n, true, temp);
        int resultSize = temp.size();
        String[] result = new String[resultSize];
        resultSize--;
        while (resultSize >= 0) {
            result[resultSize] = temp.get(resultSize);
            resultSize--;
        }

        return result;
    }

    /**
     * 模拟后序遍历
     * @param level 层数
     * @param high 高度
     * @param down 是否是down
     * @param res 结果
     */
    public void fold(int level, int high, boolean down, List<String> res) {
        if (level > high)
            return;
        fold(level + 1, high, true, res);
        res.add(down ? "down" : "up");
        fold(level + 1, high, false, res);
    }

    public static void main(String[] args) {
        FoldPaper foldPaper = new FoldPaper();

        String[] result = foldPaper.foldPaper(3);

        for (String s : result)
            System.out.println(s);
    }

}
