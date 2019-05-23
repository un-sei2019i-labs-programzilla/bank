import java.util.*;

public class algoritmo {

    public static int Nto1 (int n) {
        int sum = 0;
        while (n != 0) {
            sum += n;
            n--;
        }
        return sum;
    }

    public static int MCD (int A, int B) {
        // Máximo Común Divisor
    }

    public static int MCM (int A, int B) {
        // Mínimo Común Múltiplo
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("1: N to 1");
        System.out.println("2: MCD");
        System.out.println("3: MCM");

        int x = s.nextInt();

        int n = 0;
        int A = 0;
        int B = 0;

        if (x == 1){
            System.out.println("Ingrese n");
            n = s.nextInt();
        }else{
            System.out.println("Ingrese A y B");
            A = s.nextInt();
            B = s.nextInt();
        }

        int r;
        switch (x) {
            case 1:
                r = Nto1(n);
                System.out.println("Resultado: " + r);
            break;
            case 2:
                r = MCD(A,B);
                System.out.println("Resultado: " + r);
            break;
            case 3:
                r = MCM(A,B);
                System.out.println("Resultado: " + r);
            break;
            default:
            break;
        }
    }

}
