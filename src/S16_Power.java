public class S16_Power {
    private static boolean invalidInput = false;

    /**
     * 计算一个数的n次方，n可能是0或者负数
     * 当n时负数时候，底数为0时，需要报错，我们使用全局变量invalidInput来标识是否是错误的输入
     *
     * @param base
     * @param exponent
     * @return
     */
    private static double power(double base, int exponent) {
        //0的0次方在数学上没有意义，为了方便，与其他数的0次方一样，返回1，也可特殊处理
        if (exponent == 0)
            return 1;
        if (exponent < 0) {
            if (base == 0.0) {
                //通过全局变量报错
                invalidInput = true;
                return 0;
            } else //指数为负数，底数不为0
                return 1.0 / powerWithPositiveExponent(base, -1 * exponent);
        } else //指数为正数
            return powerWithPositiveExponent(base, exponent);
    }

    //通过递归计算一个数的正数次方，时间复杂度为Log(n)
    private static double powerWithPositiveExponent(double base, int exponent) {
        if (exponent == 0)
            return 1;
        else if ((exponent & 1) == 0) {
            double temp = powerWithPositiveExponent(base, exponent >> 1);
            return temp * temp;
        } else {
            double temp = powerWithPositiveExponent(base, exponent >> 1);
            return base * temp * temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("2^3=" + power(2, 3) + "\t是否报错:" + invalidInput);
        System.out.println("2^-3=" + power(2, -3) + "\t是否报错:" + invalidInput);
        System.out.println("2^0=" + power(2, 0) + "\t是否报错:" + invalidInput);
        System.out.println("0^3=" + power(0, 3) + "\t是否报错:" + invalidInput);
        System.out.println("0^-3=" + power(0, -3) + "\t是否报错:" + invalidInput);
        System.out.println("0^0=" + power(0, 0) + "\t是否报错:" + invalidInput);
        System.out.println("-2^3=" + power(-2, -3) + "\t是否报错:" + invalidInput);
        System.out.println("-2^-3=" + power(-2, -3) + "\t是否报错:" + invalidInput);
        System.out.println("-2^0=" + power(-2, 0) + "\t是否报错:" + invalidInput);
    }
}
