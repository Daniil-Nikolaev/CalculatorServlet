import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(value = "/history")
public class HistoryServlet extends HttpServlet {
    File history=new File("C:\\Users\\Xiaomi\\IdeaProjects\\CalculatorServlet\\src\\main\\java\\history.txt");

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         StringBuilder stringBuilder = new StringBuilder();
         String string;
         BufferedReader br = new BufferedReader(new FileReader(history));

         while ((string = br.readLine()) != null) {
             stringBuilder.append(string);
             stringBuilder.append("\n");
         }
         resp.getWriter().write(String.valueOf(stringBuilder));
     }

    public void write(String s) throws IOException {
        OutputStream out = new FileOutputStream(history,true);
        out.write(s.getBytes());
        out.write("\n".getBytes());
    }
}
