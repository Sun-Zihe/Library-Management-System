package com.fc.controller;

import com.fc.service.ReaderInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReaderInfoController {
    private ReaderInfoService readerInfoService;

    @GetMapping("/readerIndex")
    public String readerIndex () {
        return "reader/readerIndex";
    }
}
