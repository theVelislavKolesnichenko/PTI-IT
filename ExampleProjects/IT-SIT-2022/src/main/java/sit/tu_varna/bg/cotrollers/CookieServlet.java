package sit.tu_varna.bg.cotrollers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.tu_varna.bg.helpers.CookiesWorker;
import sit.tu_varna.bg.models.User;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession oldSession = request.getSession(false);
        User sessionUser = (oldSession != null)
                ? (User)oldSession.getAttribute("user")
                : null;

        if((sessionUser != null) ) {
            String welcomeCooKieValue = getWelcomeCookie(request);
            Cookie message = new Cookie("welcome", String.format("%s+%s",welcomeCooKieValue,sessionUser.getLogin().getUsername()));
            message.setMaxAge(60*60*24);
            response.addCookie(message);

            response.sendRedirect(String.format(request.getContextPath() + "/user"));
        }
        else {
            response.sendRedirect(request.getContextPath());
        }
    }

    private String getWelcomeCookie(HttpServletRequest request) {
        Cookie cookie = CookiesWorker.getWelcomeCookie(request);
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }

}
