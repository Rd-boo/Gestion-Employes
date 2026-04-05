package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import util.DBConnection;

public class AdminDAO {

    public static Admin verifierLogin(String login, String password) {
        Admin admin = null;
        String sql = "SELECT * FROM admin WHERE login = ? AND pass_word = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, login);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin();
                    admin.setIdAdmin(rs.getInt("id_adm"));
                    admin.setLogin(rs.getString("login"));
                    admin.setPassword(rs.getString("pass_word"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}