package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection669;
import model.NguoiDung669;

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


}