import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(value ="/calculator")
public class CalculatorServlet extends HttpServlet {
    HistoryServlet historyServlet = new HistoryServlet();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");


        String result = num1 + " %s " + num2 + " = %s";
        String response= switch(type) {
            case "sum" ->result.formatted("+", num1 + num2);
            case "sub" ->result.formatted("-", num1 - num2);
            case "mul" -> result.formatted("*", num1 * num2);
            case "div" -> result.formatted("/", num1 / num2);
            default -> throw new ServletException("Invalid type");
        };
        resp.getWriter().write(response);
        historyServlet.write(response);
    }
}
