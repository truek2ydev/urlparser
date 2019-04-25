package com.example.urlparser.controller.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    /**
     * custom error page view Controller
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/error")
    public String error(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (StringUtils.equals(String.valueOf(status), String.valueOf(HttpStatus.NOT_FOUND.value()))) {
            return "errors/404";
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
