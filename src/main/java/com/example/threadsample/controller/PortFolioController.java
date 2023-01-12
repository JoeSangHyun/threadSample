package com.example.threadsample.controller;

import com.example.threadsample.data.dto.PortFolioDto;
import com.example.threadsample.data.entity.PortFolio;
import com.example.threadsample.service.impl.PortFolioImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PortFolioController {
    private final PortFolioImpl portFolioService;

    @GetMapping("/test")
    public List<PortFolioDto> getAllData() {
        return portFolioService.getAllDataList();
    }

    @GetMapping("/testOne")
    public PortFolioDto getOneData(@RequestParam(name="idx") Long idx) {
        return portFolioService.getOneData(idx);
    }

    @GetMapping("/")
    public String hello(@RequestParam(name = "n") Integer n, @RequestParam(name = "str") String string) throws InterruptedException {
        portFolioService.print(n, string);
        return "ok";
    }
}
