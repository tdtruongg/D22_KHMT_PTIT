import java.util.*;

class ComplexNumber {

    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal(){
        return real;
    }

    public void setReal(int real){
        this.real = real;
    }

    public int getImaginary(){
        return imaginary;
    }

    public void setImaginary(int imaginary){
        this.imaginary = imaginary;
    }

    public static ComplexNumber sumTwoComplex(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.real + b.real, a.imaginary + b.imaginary);
    }

    public static ComplexNumber nulTwoComplex(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.real * b.real - a.imaginary * b.imaginary, a.real * b.imaginary + b.real * a.imaginary);
    }

    public String toString(){
        String res = "";
        res += real + " ";
        if(imaginary >= 0){
            res += "+ " + imaginary +"i";
        }else{
            res += "+ " + (-imaginary) + "i";
        }
        return res;
    }

}


public class J04818_SoParc {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t--> 0){
            solution();
        }
    }
    public static void solution() {
        ComplexNumber a = new ComplexNumber(sc.nextInt(), sc.nextInt());
        ComplexNumber b = new ComplexNumber(sc.nextInt(), sc.nextInt());

        // sum = A + B
        ComplexNumber sum = ComplexNumber.sumTwoComplex(a, b);
        // C = (A + B) * A = sum * A
        ComplexNumber c = ComplexNumber.nulTwoComplex(sum, a);
        // D = (A + B) ^ 2
        ComplexNumber d = ComplexNumber.nulTwoComplex(sum, sum);
        System.out.println(c + ", " + d);
    }

}
