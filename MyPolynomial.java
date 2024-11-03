public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double...coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = getDegree(); i >= 0; i--) {
            if (coeffs[i] != 0) {
                sb.append(String.format("%.2fx^%d ", coeffs[i], i));
            }
        }
        return sb.toString().trim();
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = getDegree(); i >= 0; i--) {
            result = result * x + coeffs[i];
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial other) {
        int maxDegree = Math.max(getDegree(), other.getDegree());
        double[] newCoeffs = new double[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            newCoeffs[i] = (i <= getDegree() ? coeffs[i] : 0) + (i <= other.getDegree() ? other.coeffs[i] : 0);
        }
        return new MyPolynomial(newCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial other) {
        int newDegree = getDegree() + other.getDegree();
        double[] newCoeffs = new double[newDegree + 1];
        for (int i = 0; i <= getDegree(); i++) {
            for (int j = 0; j <= other.getDegree(); j++) {
                newCoeffs[i + j] += coeffs[i] * other.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }
}
