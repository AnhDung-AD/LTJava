package cummunityuni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baitap1 {

    public static void main(String[] args) {
        ArrayList<String> dsSV = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n--- QUẢN LÝ SINH VIÊN ---");
            System.out.println("1. Thêm Sinh viên");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Sửa Sinh viên");
            System.out.println("4. Xóa Sinh viên");
            System.out.println("5. Tìm Sinh viên có chữ 'An'");
            System.out.println("6. Sắp xếp Sinh viên");
            System.out.println("7. Xuất số lượng Sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine(); 

            switch (chon) {
                case 1:
                    System.out.print("Nhập tên SV muốn thêm: ");
                    String ten = sc.nextLine();
                    dsSV.add(ten);
                    break;
                case 2:
                    System.out.println("Danh sách SV: " + dsSV);
                    break;
                case 3:
                    System.out.print("Nhập vị trí muốn sửa (từ 0): ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 0 && index < dsSV.size()) {
                        System.out.print("Nhập tên mới: ");
                        dsSV.set(index, sc.nextLine());
                    } else {
                        System.out.println("Vị trí không tồn tại!");
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên SV muốn xóa: ");
                    String tenXoa = sc.nextLine();
                    if (dsSV.contains(tenXoa)) {
                        dsSV.remove(tenXoa);
                        System.out.println("Đã xóa xong.");
                    } else {
                        System.out.println("Không tìm thấy tên này.");
                    }
                    break;
                case 5:
                    System.out.println("Các SV có tên chứa chữ 'An':");
                    for (String s : dsSV) {
                        if (s.toLowerCase().contains("an")) {
                            System.out.println("- " + s);
                        }
                    }
                    break;
                case 6:
                    Collections.sort(dsSV);
                    System.out.println("Đã sắp xếp danh sách.");
                    break;
                case 7:
                    System.out.println("Số lượng sinh viên là: " + dsSV.size());
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Chọn sai rồi, chọn lại đi!");
            }
        } while (chon != 0);
    }
}