package model;

import java.sql.Date;

import java.sql.Date;

public class PhieuNhapTaiLieu669 {
    private int id;
    private Date ngayNhap;
    private int nhaCungCapId;
    private int nhanVienId;

    public PhieuNhapTaiLieu669() {
    }

    public PhieuNhapTaiLieu669(int id, Date ngayNhap, int nhaCungCapId, int nhanVienId) {
        this.id = id;
        this.ngayNhap = ngayNhap;
        this.nhaCungCapId = nhaCungCapId;
        this.nhanVienId = nhanVienId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getNhaCungCapId() {
        return nhaCungCapId;
    }

    public void setNhaCungCapId(int nhaCungCapId) {
        this.nhaCungCapId = nhaCungCapId;
    }

    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

}
