package helpers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class CookieHelper {
    public static Cookie getCookie(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        Cookie cookie = null;
        for (Cookie item : cookies) {
            if ("uuid".equals(item.getName())) {
                cookie = item;
                break;
            }
        }
        return cookie;
    }
}
