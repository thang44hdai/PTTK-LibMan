package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection669;
import model.*;

public class XemChiTietHoaDonNhapDao669 {
    private DangNhapDao669 userDao = new DangNhapDao669();

    // Lấy thông tin phiếu nhập chi tiết (bao gồm tài liệu, nhà cung cấp, nhân viên)
    public PhieuNhapChiTiet669 getChiTietPhieuNhapById(int phieuNhapId) {
        PhieuNhapChiTiet669 chiTietPhieuNhap = new PhieuNhapChiTiet669();

        try (Connection connection = DBConnection669.getConnection()) {
            // Truy vấn thông tin phiếu nhập từ bảng tblPhieuNhapTaiLieu669
            String queryPhieuNhap = "SELECT * FROM tblPhieuNhapTaiLieu669 WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(queryPhieuNhap)) {
                preparedStatement.setInt(1, phieuNhapId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // Gán thông tin phiếu nhập
                    PhieuNhapTaiLieu669 phieuNhap = new PhieuNhapTaiLieu669();
                    phieuNhap.setId(resultSet.getInt("id"));
                    phieuNhap.setNgayNhap(resultSet.getDate("ngayNhap"));
                    phieuNhap.setNhaCungCapId(resultSet.getInt("tblNhaCungCap669id"));
                    phieuNhap.setNhanVienId(resultSet.getInt("tblNhanVien669tblNguoiDung669id"));

                    chiTietPhieuNhap.setNgayNhap(phieuNhap.getNgayNhap());

                    // Lấy thông tin nhà cung cấp
                    chiTietPhieuNhap.setNhaCungCap(userDao.getNhaCungCapById(phieuNhap.getNhaCungCapId(), connection));

                    // Lấy thông tin nhân viên
                    chiTietPhieuNhap.setNguoiDung(userDao.getNhanVienById(phieuNhap.getNhanVienId(), connection));
                }
            }

            // Lấy danh sách tài liệu trong phiếu nhập từ bảng tblPhieuNhapTaiLieuChiTiet669
            List<TaiLieu669> danhSachTaiLieu = getDanhSachTaiLieuByPhieuNhapId(phieuNhapId);
            chiTietPhieuNhap.setDanhSachTaiLieu(danhSachTaiLieu);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chiTietPhieuNhap;
    }

    // Lấy danh sách tài liệu trong phiếu nhập
    private List<TaiLieu669> getDanhSachTaiLieuByPhieuNhapId(int phieuNhapId) throws SQLException {
        List<TaiLieu669> danhSachTaiLieu = new ArrayList<>();

        try (Connection connection = DBConnection669.getConnection()) {
            String query = "SELECT tl.* FROM tblPhieuNhapTaiLieuChiTiet669 pntc "
                    + "JOIN tblTaiLieu669 tl ON pntc.tblTaiLieu669id = tl.id "
                    + "WHERE pntc.tblPhieuNhapTaiLieu669id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, phieuNhapId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    TaiLieu669 taiLieu = new TaiLieu669();
                    taiLieu.setId(resultSet.getInt("id"));
                    taiLieu.setTen(resultSet.getString("ten"));
                    taiLieu.setTacgia(resultSet.getString("tacgia"));
                    taiLieu.setNamXB(resultSet.getInt("namXB"));

                    danhSachTaiLieu.add(taiLieu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachTaiLieu;
    }
}
