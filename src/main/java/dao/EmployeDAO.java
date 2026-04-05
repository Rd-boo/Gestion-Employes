package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employe;
import util.DBConnection;

public class EmployeDAO {

	public void insertEmploye(Employe employe) {
	    String sql = "INSERT INTO employe (nom, email, poste, salaire) VALUES (?, ?, ?, ?)";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, employe.getNom());
	        ps.setString(2, employe.getEmail());
	        ps.setString(3, employe.getPoste());
	        ps.setDouble(4, employe.getSalaire());
	        ps.executeUpdate();
	    } catch (SQLException e) { e.printStackTrace(); }
	}

    public List<Employe> selectAllEmployes() {
        List<Employe> employes = new ArrayList<>();
        String sql = "SELECT * FROM employe";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Employe e = new Employe();
                e.setId(rs.getInt("id_emp"));
                e.setNom(rs.getString("nom"));
                e.setEmail(rs.getString("email"));
                e.setPoste(rs.getString("poste"));
                e.setSalaire(rs.getDouble("salaire"));
                employes.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employes;
    }

    public Employe selectEmploye(int id) {
        String sql = "SELECT * FROM employe WHERE id_emp = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employe e = new Employe();
                    e.setId(rs.getInt("id_emp"));
                    e.setNom(rs.getString("nom"));
                    e.setEmail(rs.getString("email"));
                    e.setPoste(rs.getString("poste"));
                    e.setSalaire(rs.getDouble("salaire"));
                    return e;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateEmploye(Employe employe) {
        String sql = "UPDATE employe SET nom = ?, email = ?, poste = ?, salaire = ? WHERE id_emp = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employe.getNom());
            ps.setString(2, employe.getEmail());
            ps.setString(3, employe.getPoste());
            ps.setDouble(4, employe.getSalaire());
            ps.setInt(5, employe.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmploye(int id) {
        String sql = "DELETE FROM employe WHERE id_emp = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employe> rechercherEmploye(String critere) {
        List<Employe> employes = new ArrayList<>();
        String sql = "SELECT * FROM employe WHERE nom LIKE ? OR email LIKE ? OR poste LIKE ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            String valeur = "%" + critere + "%";
            ps.setString(1, valeur);
            ps.setString(2, valeur);
            ps.setString(3, valeur);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Employe e = new Employe();
                    e.setId(rs.getInt("id_emp"));
                    e.setNom(rs.getString("nom"));
                    e.setEmail(rs.getString("email"));
                    e.setPoste(rs.getString("poste"));
                    e.setSalaire(rs.getDouble("salaire"));
                    employes.add(e);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return employes;
    }
}