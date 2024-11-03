 import java.math.BigInteger;

    public class TestBigInteger {
        public static void main(String[] args) {

            BigInteger number1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
            BigInteger number2 = new BigInteger("22222222222222222222222222222222222222222222222222");



            BigInteger sum = number1.add(number2);
            System.out.println("Sum: " + sum);


            BigInteger product = number1.multiply(number2);
            System.out.println("Product: " + product);
        }
}
