package cummunityuni;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai4 {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;
    public Bai4(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber      = partNumber;
        this.partDescription = partDescription;
        this.quantity        = (quantity <= 0) ? 0 : quantity;
        this.pricePerItem    = (pricePerItem <= 0) ? 0.0 : pricePerItem;
    }
    public String getPartNumber()                { return partNumber; }
    public void setPartNumber(String p)          { this.partNumber = p; }

    public String getPartDescription()           { return partDescription; }
    public void setPartDescription(String p)     { this.partDescription = p; }

    public int getQuantity()                     { return quantity; }
    public void setQuantity(int q)               { this.quantity = (q <= 0) ? 0 : q; }

    public double getPricePerItem()              { return pricePerItem; }
    public void setPricePerItem(double p)        { this.pricePerItem = (p <= 0) ? 0.0 : p; }
    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }
    public String toString() {
        return String.format("| %-10s | %-20s | %8d | %12.2f | %15.2f |",
                partNumber, partDescription, quantity, pricePerItem, getInvoiceAmount());
    }
    static ArrayList<Bai4> danhSach = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== MENU HOA DON ==========");
            System.out.println("1. Nhap danh sach Invoice");
            System.out.println("2. Xuat thong tin mot Invoice");
            System.out.println("3. Sap xep theo Ma mat hang (Bubble Sort)");
            System.out.println("4. Sap xep theo So luong (Insertion Sort)");
            System.out.println("5. Tim kiem Invoice theo ma mat hang");
            System.out.println("6. Xoa Invoice theo ma mat hang");
            System.out.println("7. Xuat tat ca danh sach");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            luaChon = sc.nextInt(); sc.nextLine();

            switch (luaChon) {
                case 1 -> nhapDanhSach();
                case 2 -> xuatMotInvoice();
                case 3 -> bubbleSort();
                case 4 -> insertionSort();
                case 5 -> timKiem();
                case 6 -> xoaInvoice();
                case 7 -> xuatTatCa();
                case 0 -> System.out.println("Tam biet!");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);
    }
    static void nhapDanhSach() {
        System.out.print("Nhap so luong Invoice (it nhat 10): ");
        int n = sc.nextInt(); sc.nextLine();
        if (n < 10) { System.out.println("Phai nhap it nhat 10!"); return; }

        for (int i = 0; i < n; i++) {
            System.out.println("--- Invoice " + (i + 1) + " ---");
            String ma;
            while (true) {
                System.out.print("Ma mat hang: ");
                ma = sc.nextLine();
                if (timTheoMa(ma) == -1) break;
                System.out.println("Ma da ton tai, nhap lai!");
            }
            System.out.print("Mo ta: ");    String moTa = sc.nextLine();
            System.out.print("So luong: "); int sl      = sc.nextInt(); sc.nextLine();
            System.out.print("Don gia: ");  double gia  = sc.nextDouble(); sc.nextLine();
            danhSach.add(new Bai4(ma, moTa, sl, gia));
        }
        System.out.println("Nhap thanh cong " + n + " Invoice!");
    }
    static void xuatMotInvoice() {
        if (danhSach.isEmpty()) { System.out.println("Danh sach trong!"); return; }
        System.out.print("Nhap ma mat hang can xuat: ");
        String ma = sc.nextLine();
        int idx = timTheoMa(ma);
        if (idx == -1) { System.out.println("Khong tim thay!"); return; }
        inHeader();
        System.out.println(danhSach.get(idx));
    }
    static void bubbleSort() {
        int n = danhSach.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (danhSach.get(j).getPartNumber()
                        .compareTo(danhSach.get(j + 1).getPartNumber()) > 0) {
                    Bai4 tmp = danhSach.get(j);
                    danhSach.set(j, danhSach.get(j + 1));
                    danhSach.set(j + 1, tmp);
                }
        System.out.println("Da sap xep theo Ma mat hang (Bubble Sort)!");
        xuatTatCa();
    }
    static void insertionSort() {
        int n = danhSach.size();
        for (int i = 1; i < n; i++) {
            Bai4 key = danhSach.get(i);
            int j = i - 1;
            while (j >= 0 && danhSach.get(j).getQuantity() > key.getQuantity()) {
                danhSach.set(j + 1, danhSach.get(j));
                j--;
            }
            danhSach.set(j + 1, key);
        }
        System.out.println("Da sap xep theo So luong (Insertion Sort)!");
        xuatTatCa();
    }
    static void timKiem() {
        System.out.print("Nhap ma mat hang can tim: ");
        String ma = sc.nextLine();
        int idx = timTheoMa(ma);
        if (idx == -1) System.out.println("Khong tim thay!");
        else { inHeader(); System.out.println(danhSach.get(idx)); }
    }
    static void xoaInvoice() {
        System.out.print("Nhap ma mat hang can xoa: ");
        String ma = sc.nextLine();
        int idx = timTheoMa(ma);
        if (idx == -1) { System.out.println("Khong tim thay!"); return; }
        danhSach.remove(idx);
        System.out.println("Da xoa Invoice co ma: " + ma);
    }
    static void xuatTatCa() {
        if (danhSach.isEmpty()) { System.out.println("Danh sach trong!"); return; }
        inHeader();
        for (Bai4 iv : danhSach) System.out.println(iv);
        System.out.println("-".repeat(75));
    }
    static int timTheoMa(String ma) {
        for (int i = 0; i < danhSach.size(); i++)
            if (danhSach.get(i).getPartNumber().equalsIgnoreCase(ma)) return i;
        return -1;
    }
    static void inHeader() {
        System.out.println("-".repeat(75));
        System.out.printf("| %-10s | %-20s | %8s | %12s | %15s |%n",
                "Ma MH", "Mo ta", "So luong", "Don gia", "Thanh tien");
        System.out.println("-".repeat(75));
    }
}