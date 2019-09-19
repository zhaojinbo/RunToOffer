public class S21_ReorderEvenOdd {
    public int[] sortArrayByParity(int[] A) {
        if (A.length < 2) {
            return A;
        }
        //定义两个指针
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && isEven(A[i])) {
                i++;
            }
            while (i < j && !isEven(A[j])) {
                j--;
            }
            if (i < j) {
                //交换
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

    //判断是否为偶数
    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}
