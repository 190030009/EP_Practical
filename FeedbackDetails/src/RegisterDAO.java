import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public int RegisterInsert(RegisterBean sb) throws ClassNotFoundException, SQLException{
		Connection con=DBConn.DBConnection();
		String sql="insert into feedback values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, sb.getRegno());
		ps.setString(2, sb.getName());
		ps.setString(3, sb.getEmail());
		ps.setString(4, sb.getPasswd());
		ps.setInt(5, sb.getYear());
		ps.setInt(6, sb.getSec());
		int i=ps.executeUpdate();
		return i;
	}
}