package com.example.servlet;

import com.example.model.CartItem;
import com.example.model.Product;
import com.example.util.DataStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = DataStore.getProductById(productId);
        if (product != null) {
            HttpSession session = request.getSession();
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }
            // Check if item already in cart
            CartItem existing = cart.stream().filter(item -> item.getProduct().getId() == productId).findFirst().orElse(null);
            if (existing != null) {
                existing.setQuantity(existing.getQuantity() + 1);
            } else {
                cart.add(new CartItem(product, 1));
            }
            session.setAttribute("cart", cart);
        }
        response.sendRedirect("home");
    }
}
