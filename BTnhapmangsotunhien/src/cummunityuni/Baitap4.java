package cummunityuni;

import java.util.Scanner;

public class Baitap4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử: ");
        int n = sc.nextInt();
        int M[] = new int[n];   
        for (int i = 0; i < n; i++) {
            System.out.print("M[" + i + "] = ");
            M[i] = sc.nextInt();
        }
        System.out.print("\nDòng 1: Các số lẻ: ");
        int demLe = 0;
        for (int i = 0; i < n; i++) {
            if (M[i] % 2 != 0) {
                System.out.print(M[i] + " ");
                demLe++;
            }
        }
        System.out.println(" => Có " + demLe + " số lẻ.");
        System.out.print("Dòng 2: Các số chẵn: ");
        int demChan = 0;
        for (int i = 0; i < n; i++) {
            if (M[i] % 2 == 0) {
                System.out.print(M[i] + " ");
                demChan++;
            }
        }
        System.out.println(" => Có " + demChan + " số chẵn.");
        System.out.print("Dòng 3: Các số nguyên tố: ");
        for (int i = 0; i < n; i++) {
            int so = M[i];
            boolean laNT = true;
            if (so < 2) laNT = false;
            for (int j = 2; j <= Math.sqrt(so); j++) {
                if (so % j == 0) {
                    laNT = false;
                    break;
                }
            }
            if (laNT) System.out.print(so + " ");
        }
        System.out.println();
        System.out.print("Dòng 4: Các số không phải số nguyên tố: ");
        for (int i = 0; i < n; i++) {
            int so = M[i];
            boolean laNT = true;
            if (so < 2) laNT = false;
            for (int j = 2; j <= Math.sqrt(so); j++) {
                if (so % j == 0) {
                    laNT = false;
                    break;
                }
            }
            if (!laNT) System.out.print(so + " ");
        }
        System.out.println();
    }
}