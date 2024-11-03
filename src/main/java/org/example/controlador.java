package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
public class controlador {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/linearsearch")
    @ResponseBody

    public String linearSearchResponse(@RequestParam(value = "list") String list, @RequestParam(value = "value") String value) throws IOException {
        return HttpConnectionExample.getResponse(value, "/lineal", list); // Implementa esta función según sea necesario
    }

    @GetMapping("/binarysearch")
    @ResponseBody

    public String binarySearchResponse(@RequestParam(value = "list") String list, @RequestParam(value = "value") String value) throws IOException {
        return HttpConnectionExample.getResponse(value, "/binary",list); // Implementa esta función según sea necesario
    }

}