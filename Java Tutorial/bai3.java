import java.util.Scanner;

class DaThuc {
    private int n;
    private double[] a;

    public DaThuc() {
    }

    public DaThuc(double[] a) {
        this.n = a.length - 1;
        this.a = a;
    }

    public int getBac() {
        return n;
    }

    public double[] getA() {
        return a;
    }

    public void input(Scanner in) {
        n = in.nextInt();
        a = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = in.nextDouble();
        }
    }

    public void out() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(a[i]).append(" * X^").append(i);
            if (i < n) {
                sb.append(" + ");
            }
        }
        System.out.println(sb.toString());
    }

    public DaThuc cong(DaThuc b) {
        int maxBac = Math.max(this.n, b.getBac());
        double[] result = new double[maxBac + 1];

        for (int i = 0; i <= maxBac; i++) {
            double heSoA = (i <= this.n) ? this.a[i] : 0;
            double heSoB = (i <= b.getBac()) ? b.getA()[i] : 0;
            result[i] = heSoA + heSoB;
        }

        return new DaThuc(result);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x[] = {1, 1, 1};
        DaThuc a = new DaThuc();
        a.input(in);
        a.out();
        DaThuc d = new DaThuc(x);
        DaThuc e = d.cong(a);
        e.out();
    }
}