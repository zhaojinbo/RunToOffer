public class S15_NumberOf1InBinary {
    private static int numberOfOne1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0)
                count++;
            n >>>= 1;
        }
        return count;
    }

    private static int numberOfOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag <<= 1;
        }
        return count;
    }

    private static int numberOfOne3(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfOne1(3));
        System.out.println(numberOfOne1(-3));
        System.out.println(numberOfOne2(3));
        System.out.println(numberOfOne2(-3));
        System.out.println(numberOfOne3(3));
        System.out.println(numberOfOne3(-3));
    }
}
