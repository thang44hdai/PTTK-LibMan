package model;

import java.sql.Date;

public class TheBanDoc669 {

    private int tblBanDoc669tblNguoiDung669id;
    private Date ngayDangKi;
    private Date ngayHetHan;

    public TheBanDoc669() {
    }

    // Constructor có tham số
    public TheBanDoc669(int tblBanDoc669tblNguoiDung669id, Date ngayDangKi, Date ngayHetHan) {
        this.tblBanDoc669tblNguoiDung669id = tblBanDoc669tblNguoiDung669id;
        this.ngayDangKi = ngayDangKi;
        this.ngayHetHan = ngayHetHan;
    }


    public int getTblBanDoc669tblNguoiDung669id() {
        return tblBanDoc669tblNguoiDung669id;
    }

    public void setTblBanDoc669tblNguoiDung669id(int tblBanDoc669tblNguoiDung669id) {
        this.tblBanDoc669tblNguoiDung669id = tblBanDoc669tblNguoiDung669id;
    }

    public Date getNgayDangKi() {
        return ngayDangKi;
    }

    public void setNgayDangKi(Date ngayDangKi) {
        this.ngayDangKi = ngayDangKi;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

}
