package model;

import java.sql.Date;
import java.util.List;

public class PhieuNhapChiTiet669 {
    private NguoiDung669 nguoiDung;
    private NhaCungCap669 nhaCungCap;
    private Date ngayNhap;
    private List<TaiLieu669> danhSachTaiLieu;

    public PhieuNhapChiTiet669() {}

    public PhieuNhapChiTiet669(NguoiDung669 nguoiDung, NhaCungCap669 nhaCungCap, Date ngayNhap, List<TaiLieu669> danhSachTaiLieu) {
        this.nguoiDung = nguoiDung;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.danhSachTaiLieu = danhSachTaiLieu;
    }

    public NguoiDung669 getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung669 nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public NhaCungCap669 getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap669 nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public List<TaiLieu669> getDanhSachTaiLieu() {
        return danhSachTaiLieu;
    }

    public void setDanhSachTaiLieu(List<TaiLieu669> danhSachTaiLieu) {
        this.danhSachTaiLieu = danhSachTaiLieu;
    }
}
