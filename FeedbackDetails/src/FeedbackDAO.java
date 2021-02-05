import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {
	public int FeedbackInsert(FeedbackBean sb) throws ClassNotFoundException, SQLException{
		Connection con=DBConn.DBConnection();
		String sql="insert into feedb values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, sb.getR1());
		ps.setString(2, sb.getR2());
		ps.setString(3, sb.getR3());
		ps.setString(4, sb.getR4());
		ps.setString(5, sb.getR5());
		int i=ps.executeUpdate();
		return i;
	}
}