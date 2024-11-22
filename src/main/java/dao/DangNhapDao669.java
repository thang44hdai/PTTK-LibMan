package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection669;
import model.NguoiDung669;
import model.NhaCungCap669;

public class DangNhapDao669 {

    public boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM tblnguoidung669 WHERE tk = ? AND mk = ?";
        try (Connection connection = DBConnection669.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public NguoiDung669 getNguoiDung(String username, String password) {
        String query = "SELECT * FROM tblnguoidung669 WHERE tk = ? AND mk = ?";
        try (Connection connection = DBConnection669.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                NguoiDung669 user = new NguoiDung669();
                user.setId(resultSet.getInt("id"));
                user.setTk(resultSet.getString("tk"));
                user.setMk(resultSet.getString("mk"));
                user.setTen(resultSet.getString("ten"));
                user.setChucvu(resultSet.getInt("chucvu"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new NguoiDung669();
    }

    NhaCungCap669 getNhaCungCapById(int nhaCungCapId, Connection connection) throws SQLException {
        String query = "SELECT * FROM tblNhaCungCap669 WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, nhaCungCapId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new NhaCungCap669(
                        resultSet.getInt("id"),
                        resultSet.getString("ten"),
                        resultSet.getString("diachi"),
                        resultSet.getString("sdt")
                );
            }
        }
        return null;
    }

    NguoiDung669 getNhanVienById(int nhanVienId, Connection connection) throws SQLException {
        String query = "SELECT * FROM tblNguoiDung669 WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, nhanVienId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new NguoiDung669(
                        resultSet.getInt("id"),
                        resultSet.getString("tk"),
                        resultSet.getString("mk"),
                        resultSet.getString("ten"),
                        resultSet.getInt("chucvu")
                );
            }
        }
        return null;
    }

}