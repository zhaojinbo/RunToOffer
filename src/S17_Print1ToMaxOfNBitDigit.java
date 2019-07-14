public class S17_Print1ToMaxOfNBitDigit {
    private static void print1ToMaxOfNBitDigit(int n) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '0';
        }
        while (!increase(chars, n)) {
            printNum(chars, n);
        }
    }

    /**
     * 打印chars数组表示的数字，从非零最高位开始打印
     */
    private static void printNum(char[] chars, int length) {
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i]!='0'){
                index = i;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < length; i++) {
            stringBuilder.append(chars[i]);
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 本函数完成两个功能，自增1和判断是否已经达到了最大值
     */
    private static boolean increase(char[] chars, int length) {
        boolean shouldStop = false;//一个标志位，用来表示是否已经自增到了最大值
        int carry = 0;
        for (int i = length - 1; i >= 0; i--) {
            int sum = chars[i] - '0' + carry;
            if (i == length - 1) {
                sum++;
            }
            if (sum == 10) {
                if (i == 0) {
                    shouldStop = true;//当i=0，也就是最高位产生了进位，即到达了最大值
                } else {
                    chars[i] = '0';
                    carry = 1;
                }
            } else {
                chars[i] = (char) ('0' + sum);
                break;
            }
        }
        return shouldStop;
    }

    public static void main(String[] args) {
        print1ToMaxOfNBitDigit(3);
    }
}
