import java.util.Objects;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {

    }

    public MyComplex(double real, double imag) {
        this.imag = imag;
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "MyComplex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }

    public boolean isAreal() {
        return (real == 0);
    }

    public boolean isImaginary() {
        return (imag == 0);
    }

    public boolean equals(double real, double imag){
        return (this.real == real && this.imag == imag);
    }

    public boolean equals(MyComplex another){
        return (this.real == another.real && this.imag == another.imag);
    }

    public double magnitude(){
        return Math.sqrt(real*real+imag*imag);
    }

    public double argument(){
        return Math.atan2(imag, real);
    }

    public MyComplex subtract(MyComplex right){
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex addInto(MyComplex right){
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.imag + right.imag);
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.real, this.imag - right.imag);
    }

    public MyComplex multiply(MyComplex right) {
        double newReal = this.real * right.real - this.imag * right.imag;
        double newImag = this.real * right.imag + this.imag * right.real;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double divisor = right.real * right.real + right.imag * right.imag;
        double newReal = (this.real * right.real + this.imag * right.imag) / divisor;
        double newImag = (this.imag * right.real - this.real * right.imag) / divisor;
        this.real = newReal;
        this.imag = newImag;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, -this.imag);
    }
}



