

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/")
public class GameServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private GameDAO gameDAO;
	
	public void init() {
		gameDAO= new GameDAO();
	}

  
    public GameServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
	try {
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;	
			
		case "/insert":
			insertGame(request, response);
			break;	
		default:
			listGame(request, response);
			break;
		}
	} catch (SQLException ex) {
		throw new ServletException(ex);
	}
		
		
	}
	private void listGame(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
		List<Game> listGame = gameDAO.selectAllGames();
		request.setAttribute("listGame", listGame);
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("game-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertGame(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String gName = request.getParameter("name");
		String gPlatform = request.getParameter("platform");
		Game newGame = new Game(gName, gPlatform);
		
		request.setAttribute("insertGame", newGame);
		gameDAO.insertGame(newGame);		
		response.sendRedirect("/");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
