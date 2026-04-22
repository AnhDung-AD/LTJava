package commmunityuni;

import java.util.Random;
import java.util.Scanner;

public class Baitap1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String tiepTuc;

        do {

            int soCuaMay = random.nextInt(101); 
            int soLanDoan = 0;
            int phepThuToiDa = 7;
            boolean daThang = false;

            System.out.println("\n--- GAME ĐOÁN SỐ ---");
            System.out.println("Máy đã chọn 1 số [0..100]. Bạn có 7 lượt đoán!");

            while (soLanDoan < phepThuToiDa) {
                soLanDoan++;
                System.out.print("Lượt " + soLanDoan + " - Nhập số đoán: ");
                int soNguoiDoan = scanner.nextInt();

                if (soNguoiDoan == soCuaMay) {
                    System.out.println("Chúc mừng! Bạn đã thắng!");
                    daThang = true;
                    break; 
                } else if (soNguoiDoan < soCuaMay) {
                    System.out.println("Số bạn đoán NHỎ hơn số của máy.");
                } else {
                    System.out.println("Số bạn đoán LỚN hơn số của máy.");
                }
            }

            if (!daThang) {
                System.out.println("\nGame Over nha thím! Thua rồi.");
                System.out.println("Số đúng là: " + soCuaMay);
            }

            System.out.print("\nBạn có muốn chơi tiếp không? (c/k): ");
            tiepTuc = scanner.next();

        } while (tiepTuc.equalsIgnoreCase("c"));

        System.out.println("Tạm biệt!");
        scanner.close();
    }
}