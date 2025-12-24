import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Restaurant extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int choice = Integer.parseInt(request.getParameter("choice"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            String itemName = "";
            double pricePerUnit = 0;

            switch (choice) {
                case 1: itemName = "Pizza"; pricePerUnit = 250; break;
                case 2: itemName = "Burger"; pricePerUnit = 150; break;
                case 3: itemName = "Pasta"; pricePerUnit = 200; break;
                case 4: itemName = "Coffee"; pricePerUnit = 100; break;
                default:
                    out.println("<p>Invalid choice!</p>");
                    return;
            }

            double total = pricePerUnit * quantity;

            out.println("<html><body>");
            out.println("<h2>Order Successful!</h2>");
            out.println("<p>Item: <strong>" + itemName + "</strong></p>");
            out.println("<p>Quantity: <strong>" + quantity + "</strong></p>");
            out.println("<p>Price per item: ₹" + pricePerUnit + "</p>");
            out.println("<p><strong>Total Bill: ₹" + total + "</strong></p>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<p>Invalid input! Please enter numbers only.</p>");
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            out.close();
        }
    }
}
