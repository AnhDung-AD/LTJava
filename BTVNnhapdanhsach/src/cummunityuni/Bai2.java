package cummunityuni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai2 {

    public static void main(String[] args) {
        ArrayList<Integer> danhSach = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử muốn thêm:");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + ": ");
            int value = scanner.nextInt();
            danhSach.add(value); 
        }
        System.out.println("Danh sách vừa nhập: " + danhSach);
        System.out.print("\nNhập vị trí (index) muốn sửa (từ 0 đến " + (danhSach.size()-1) + "): ");
        int indexSua = scanner.nextInt();
        if (indexSua >= 0 && indexSua < danhSach.size()) {
            System.out.print("Nhập giá trị mới: ");
            int giaTriMoi = scanner.nextInt();
            danhSach.set(indexSua, giaTriMoi); 
            System.out.println("Danh sách sau khi sửa: " + danhSach);
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
        System.out.print("\nNhập vị trí muốn xóa: ");
        int indexXoa = scanner.nextInt();
        if (indexXoa >= 0 && indexXoa < danhSach.size()) {
            danhSach.remove(indexXoa); 
            System.out.println("Danh sách sau khi xóa: " + danhSach);
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
        System.out.print("\nNhập số cần tìm trong danh sách: ");
        int soCanTim = scanner.nextInt();
        if (danhSach.contains(soCanTim)) {
            System.out.println("Tìm thấy số " + soCanTim + " tại vị trí số: " + danhSach.indexOf(soCanTim));
        } else {
            System.out.println("Không tìm thấy số " + soCanTim + " trong danh sách.");
        }

        Collections.sort(danhSach); 
        System.out.println("\nDanh sách sau khi sắp xếp tăng dần: " + danhSach);

    }
}