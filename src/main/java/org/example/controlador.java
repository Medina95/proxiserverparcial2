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

    public lineal linearSearchResponse(@RequestParam(value = "list") String list, @RequestParam(value = "value") String value) throws IOException {
        String ouput =  HttpConnectionExample.getResponse(value, "/lineal", list);
        return new lineal("busqueda lineal",list,value,ouput);

    }

    @GetMapping("/binarysearch")
    @ResponseBody

    public binary binarySearchResponse(@RequestParam(value = "list") String list, @RequestParam(value = "value") String value) throws IOException {
        String ouput =  HttpConnectionExample.getResponse(value, "/binary", list);
        return new binary("busqueda binaria",list,value,ouput);
    }

}