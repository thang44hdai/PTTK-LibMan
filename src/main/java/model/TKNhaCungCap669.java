package model;

public class TKNhaCungCap669 {
    private NhaCungCap669 nhaCungCap;
    private int soLuongTaiLieuNhap;

    public TKNhaCungCap669() {
    }

    public TKNhaCungCap669(NhaCungCap669 a, int b) {
        this.nhaCungCap = a;
        this.soLuongTaiLieuNhap = b;
    }

    public NhaCungCap669 getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap669 nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public int getSoLuongTaiLieuNhap() {
        return soLuongTaiLieuNhap;
    }

    public void setSoLuongTaiLieuNhap(int soLuongTaiLieuNhap) {
        this.soLuongTaiLieuNhap = soLuongTaiLieuNhap;
    }
}
