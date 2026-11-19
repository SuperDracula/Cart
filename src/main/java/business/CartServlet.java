package business;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.Cart;
import model.LineItem;
import model.Product;

public class CartServlet extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String url = "/cart.jsp";
        if (action == null) {
            action = "join";  // default action
        } if (action.equals("join")) {
            url="/index.html";
        } else if (action.equals("checkout")) {
            url="/checkout.jsp";
        } else if (action.equals("add")) {
            String productID = request.getParameter("productID");
            String strPrice = request.getParameter("price");
            String description = request.getParameter("description");
            double price = Double.parseDouble(strPrice);

            HttpSession session = request.getSession();

            Product product = new Product(productID, price, description);
            
            Cart cart = (Cart) session.getAttribute("cart");
            int quantity = 1;
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            LineItem item = new LineItem(product, quantity);
            cart.addItems(item);
        } else if (action.equals("update")) {
            HttpSession session = request.getSession();
            String productID = request.getParameter("productID");
            String strQuantity = request.getParameter("quantity").trim();
            int quantity = Integer.parseInt(strQuantity);

            Cart cart = (Cart) session.getAttribute("cart");
            cart.updateItems(productID, quantity);
        } else if (action.equals("remove")) {
            String productID = request.getParameter("productID");
            HttpSession session = request.getSession();

            Cart cart = (Cart) session.getAttribute("cart");
            cart.removeItems(productID);
        }

        request.getRequestDispatcher(url).forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
