import java.sql.*;

public class StudentDAO {
    private Connection conn;
    public StudentDAO(Connection conn) { this.conn = conn; }

    public void insertStudent(int id, String name) throws SQLException {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
        ps.close();
    }

    public void updateStudent(int id, String newName) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newName);
        ps.setInt(2, id);
        ps.executeUpdate();
        ps.close();
    }
}

