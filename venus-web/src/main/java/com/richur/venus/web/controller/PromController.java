package com.richur.venus.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author richur
 * @Date 2019/9/27 10:15 AM
 */
@RestController
public class PromController {
    @GetMapping("metrics/prometheus")
    public void metrics(HttpServletResponse response) throws IOException {
        response.sendRedirect("/prometheus");
    }
}
