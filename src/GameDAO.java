import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class GameDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/games?useTimezone=true&serverTimezone=UTC ";
	private String jdbcUsername = "root";
	private String jdbcPassword = "admin";
	
	private static final String SELECT_ALL_Games = "SELECT * FROM games.volumens";
	private static final String INSERT_Game_SQL = "INSERT INTO games.volumens" + "  (gName, gPlatform) VALUES "+ " (?, ?);";
	
	
	public GameDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connected");
		return connection;
	}
	
	public List<Game> selectAllGames() {

		
		List<Game> games = new ArrayList<>();
		
		try (Connection connection = getConnection();

				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Games);) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int gID = rs.getInt("gID");
				String gName = rs.getString("gName");
				String gPlatform = rs.getString("gPlatform");				
				games.add(new Game(gID, gName, gPlatform));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return games;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	public void insertGame(Game game) throws SQLException {
		System.out.println(INSERT_Game_SQL);
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Game_SQL)) {
			preparedStatement.setString(1, game.getgName());
			preparedStatement.setString(2, game.getgPlatform());			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
}
