

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String first = request.getParameter("first");
			String op = request.getParameter("op");
			String second = request.getParameter("second");
			String type = request.getParameter("type");
			String res;
			if (type.equals("decimal")) {
				res = calculate(new BigDecimal(first), op, new BigDecimal(second));
			} else {
				res = calculate(new BigInteger(first), op, new BigInteger(second));
			}
			request.setAttribute("result", 
					first+" "+op+" "+second+" = "+res);
			request.getRequestDispatcher("Calculator.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("Fail.jsp").forward(request, response);
		}
	}
	private static String calculate(BigInteger first, String op, BigInteger second) {
		switch (op) {
		case "+":
			return first.add(second).toString();
		case "-":
			return first.subtract(second).toString();
		case "*":
			return first.multiply(second).toString();
		case "/":
			return first.divide(second).toString();
		}
		return "";
	}
	private static String calculate(BigDecimal first, String op, BigDecimal second) {
		switch (op) {
		case "+":
			return first.add(second).toString();
		case "-":
			return first.subtract(second).toString();
		case "*":
			return first.multiply(second).toString();
		case "/":
			return first.divide(second).toString();
		}
		return "";
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
