package interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        return coockieCheck(httpServletRequest);
    }

    private boolean coockieCheck(HttpServletRequest req){

        Cookie[] cookies = req.getCookies();

        for (Cookie cooky : cookies) {
            if ("welcome".equals(cooky.getValue())) return true;
        }
        return false;

    }
}
