public class S13_RobotMove {
    //依旧回溯
    private static int movingCount(int threshold, int rowLen, int colLen) {
        if (rowLen <= 0 || colLen <= 0 || threshold < 0)
            return 0;
        boolean[][] visitFlag = new boolean[rowLen][colLen];
        return movingCountCore(threshold, rowLen, colLen, 0, 0, visitFlag);
    }

    /**
     * 对于rowLen×colLen的一个二维矩阵来说，如果以row和col为起始点坐标，能够到达的位置的个数
     * 位置不能是已经到过的位置
     *
     * @param threshold
     * @param rowLen
     * @param colLen
     * @param row
     * @param col
     * @param visitFlag
     * @return
     */
    private static int movingCountCore(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visitFlag) {
        int count = 0;
        if (canGetIn(threshold, rowLen, colLen, row, col, visitFlag)) {
            visitFlag[row][col] = true;
            count = 1 + movingCountCore(threshold, rowLen, colLen, row - 1, col, visitFlag) +
                    movingCountCore(threshold, rowLen, colLen, row + 1, col, visitFlag) +
                    movingCountCore(threshold, rowLen, colLen, row, col - 1, visitFlag) +
                    movingCountCore(threshold, rowLen, colLen, row, col + 1, visitFlag);
        }
        return count;
    }

    private static boolean canGetIn(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visitFlag) {
        return row >= 0 && col >= 0 && row < rowLen
                && col < colLen && !visitFlag[row][col]
                && getDigitSum(row) + getDigitSum(col) <= threshold;
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(0, 3, 4)); //1
        System.out.println(movingCount(1, 3, 4)); //3
        System.out.println(movingCount(9, 2, 20)); //36
    }
}
