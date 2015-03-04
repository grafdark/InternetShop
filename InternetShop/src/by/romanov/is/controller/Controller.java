package by.romanov.is.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.romanov.is.command.Command;
import by.romanov.is.command.CommandFactory;
import by.romanov.is.pool.Pool;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Controller.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		String log4jLoc = config.getInitParameter("log4jLoc");
		String path = getServletContext().getRealPath(log4jLoc);
		PropertyConfigurator.configure(path);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		perfomAction(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		perfomAction(request, response);
	}

	public void perfomAction(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		LOGGER.debug("start");
		String page = null;
		CommandFactory client = new CommandFactory();
		Command command = client.defineCommand(request);

		page = command.execute(request);
		if (page != null) {

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);

		}
	}

	@Override
	public void destroy() {
		super.destroy();
		Pool pool = Pool.getInstance();
		pool.releasePool();
	}
}
