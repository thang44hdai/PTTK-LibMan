package dao;

import database.DBConnection669;
import model.TheBanDoc669;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

public class RegisterReaderDao669 {

    // Lưu thông tin thẻ bạn đọc vào cơ sở dữ liệu
    public boolean saveRegisterReader(TheBanDoc669 theBanDoc669) {
        String query = "INSERT INTO tblthebandoc669 (tblBanDoc669tblNguoiDung669id, ngayDangKi, ngayHetHan) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection669.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, theBanDoc669.getTblBanDoc669tblNguoiDung669id());
            preparedStatement.setDate(2, theBanDoc669.getNgayDangKi());
            preparedStatement.setDate(3, theBanDoc669.getNgayHetHan());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    // Lấy thông tin thẻ bạn đọc theo ID
//    public TheBanDoc669 getRegisterReaderById(int id) {
//        String query = "SELECT * FROM tblTheBanDoc669 WHERE tblBanDoc669tblNguoiDung669id = ?";
//        try (Connection connection = DBConnection669.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                TheBanDoc669 reader = new TheBanDoc669(
//                        resultSet.getInt("tblBanDoc669tblNguoiDung669id"),
//                        resultSet.getDate("ngayDangKi").toLocalDate(),
//                        resultSet.getDate("ngayHetHan").toLocalDate()
//                );
//                return reader;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null; // Không tìm thấy thẻ bạn đọc
//    }
}
