import java.sql.*;

public class AccountService {
    private Connection conn;
    public AccountService(Connection conn) { this.conn = conn; }

    public void transfer(int fromId, int toId, double amount) throws SQLException {
        conn.setAutoCommit(false);
        try {
            PreparedStatement debit = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debit.setDouble(1, amount);
            debit.setInt(2, fromId);
            debit.executeUpdate();

            PreparedStatement credit = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, amount);
            credit.setInt(2, toId);
            credit.executeUpdate();

            conn.commit();
            debit.close();
            credit.close();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}

