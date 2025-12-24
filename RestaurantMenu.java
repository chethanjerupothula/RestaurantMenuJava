import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Restaurant extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int choice = Integer.parseInt(request.getParameter("choice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double total = 0;

        switch (choice) {
            case 1: total = quantity * 250; break;
            case 2: total = quantity * 150; break;
            case 3: total = quantity * 200; break;
            case 4: total = quantity * 100; break;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Order Successful</h2>");
        out.println("<p>Total Bill: ₹" + total + "</p>");
    }
}
