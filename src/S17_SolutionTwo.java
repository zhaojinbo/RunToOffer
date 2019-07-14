public class S17_SolutionTwo {
    /**
     * 另外一种用递归做的方法
     */
    private static void print1ToMaxOfNBitDigit(int n) {
        char[] chars = new char[n];
        traverse(chars, n, 0);
    }

    /**
     * 类似于回溯算法，遍历整个排列空间，但是不需要在回退的时候做恢复操作
     */
    private static void traverse(char[] chars, int n, int i) {
        if (i == n) {
            printNum(chars, n);
            return;
        }
        for (char j = '0'; j <= '9'; j++) {
            chars[i] = j;
            traverse(chars, n, i + 1);
        }
    }

    /**
     * 打印chars数组表示的数字，从非零最高位开始打印
     */
    private static void printNum(char[] chars, int length) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                index = i;
                break;
            }
        }
        if (index != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = index; i < length; i++) {
                stringBuilder.append(chars[i]);
            }
            System.out.println(stringBuilder.toString());
        }
    }

/*    public static void main(String[] args) {
        print1ToMaxOfNBitDigit(3);
    }*/
}
