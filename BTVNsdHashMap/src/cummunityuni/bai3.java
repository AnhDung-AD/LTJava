package cummunityuni;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bai3 {

    public static void main(String[] args) {
        HashMap<Integer, String> danhSachSach = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- NHẬP DANH SÁCH CUỐN SÁCH ---");
        System.out.print("Bạn muốn nhập bao nhiêu cuốn sách? ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập mã sách (số nguyên): ");
            int ma = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nhập tên cuốn sách: ");
            String ten = scanner.nextLine();
            danhSachSach.put(ma, ten); 
        }
        System.out.println("\n--- DANH SÁCH SÁCH ĐANG CÓ ---");
        for (Map.Entry<Integer, String> entry : danhSachSach.entrySet()) {
            System.out.println("Mã: " + entry.getKey() + " | Tên sách: " + entry.getValue());
        }
        System.out.print("\nNhập mã sách bạn muốn sửa tên: ");
        int maSua = scanner.nextInt();
        scanner.nextLine();
        if (danhSachSach.containsKey(maSua)) {
            System.out.print("Nhập tên mới cho sách: ");
            String tenMoi = scanner.nextLine();
            danhSachSach.put(maSua, tenMoi); 
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Không tìm thấy mã sách này.");
        }
        System.out.print("\nNhập mã sách muốn xóa khỏi danh sách: ");
        int maXoa = scanner.nextInt();
        if (danhSachSach.containsKey(maXoa)) {
            danhSachSach.remove(maXoa);
            System.out.println("Đã xóa sách mã " + maXoa);
        } else {
            System.out.println("Mã sách không tồn tại.");
        }
        System.out.print("\nNhập mã sách cần tìm kiếm: ");
        int maTim = scanner.nextInt();
        if (danhSachSach.containsKey(maTim)) {
            System.out.println("Kết quả tìm kiếm: Mã " + maTim + " là sách: " + danhSachSach.get(maTim));
        } else {
            System.out.println("Rất tiếc, mã sách này không có trong hệ thống.");
        }
    }
}