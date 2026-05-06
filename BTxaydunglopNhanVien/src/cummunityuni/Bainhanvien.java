package cummunityuni;

import java.util.Scanner;

public class Bainhanvien {

    private String Ho;
    private String Ten;
    private int SoSP;
    public Bainhanvien(String ho, String ten, int soSP) {
        this.Ho = ho;
        this.Ten = ten;
        this.SoSP = (soSP < 0) ? 0 : soSP;
    }
    public String getHo()          { return Ho; }
    public void setHo(String ho)   { this.Ho = ho; }
    public String getTen()         { return Ten; }
    public void setTen(String ten) { this.Ten = ten; }
    public int getSoSP()           { return SoSP; }
    public void setSoSP(int soSP)  { this.SoSP = (soSP < 0) ? 0 : soSP; }
    public double getLuong() {
        double donGia;
        if      (SoSP <= 199) donGia = 0.5;
        else if (SoSP <= 399) donGia = 0.55;
        else if (SoSP <= 599) donGia = 0.6;
        else                  donGia = 0.65;
        return SoSP * donGia;
    }
    public boolean LonHon(Bainhanvien nv2) {
        return this.SoSP > nv2.SoSP;
    }
    public String toString() {
        return "Ho ten: " + Ho + " " + Ten
             + " | So SP: " + SoSP
             + " | Luong: " + getLuong();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Nhap nhan vien 1 ===");
        System.out.print("Ho: ");   String ho1  = sc.nextLine();
        System.out.print("Ten: ");  String ten1 = sc.nextLine();
        System.out.print("So SP: ");int sp1     = sc.nextInt(); sc.nextLine();
        System.out.println("=== Nhap nhan vien 2 ===");
        System.out.print("Ho: ");   String ho2  = sc.nextLine();
        System.out.print("Ten: ");  String ten2 = sc.nextLine();
        System.out.print("So SP: ");int sp2     = sc.nextInt(); sc.nextLine();
        Bainhanvien nv1 = new Bainhanvien(ho1, ten1, sp1);
        Bainhanvien nv2 = new Bainhanvien(ho2, ten2, sp2);
        System.out.println("\n=== LUONG ===");
        System.out.println(nv1);
        System.out.println(nv2);

        System.out.println("\n=== SO SANH (dung ham LonHon) ===");
        if (nv1.LonHon(nv2)) {
            System.out.println(nv1.getHo() + " " + nv1.getTen()
                + " co nhieu SP hon: " + (nv1.getSoSP() - nv2.getSoSP()) + " SP");
        } else if (nv2.LonHon(nv1)) {
            System.out.println(nv2.getHo() + " " + nv2.getTen()
                + " co nhieu SP hon: " + (nv2.getSoSP() - nv1.getSoSP()) + " SP");
        } else {
            System.out.println("Hai nhan vien co so SP bang nhau!");
        }
        System.out.println("\n=== SO SANH (khong dung ham LonHon) ===");
        if (nv1.getSoSP() > nv2.getSoSP()) {
            System.out.println(nv1.getHo() + " " + nv1.getTen()
                + " co nhieu SP hon: " + (nv1.getSoSP() - nv2.getSoSP()) + " SP");
        } else if (nv2.getSoSP() > nv1.getSoSP()) {
            System.out.println(nv2.getHo() + " " + nv2.getTen()
                + " co nhieu SP hon: " + (nv2.getSoSP() - nv1.getSoSP()) + " SP");
        } else {
            System.out.println("Hai nhan vien co so SP bang nhau!");
        }

        sc.close();
    }
}