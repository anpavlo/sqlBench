package com.sql.bench.controller;

import com.sql.bench.dto.MeasureResultDTO;
import com.sql.bench.service.SqlBenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private SqlBenchService sqlBenchService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/getMeasure")
    @ResponseBody
    public MeasureResultDTO getMeasure(@RequestParam(name="queriesQuantity", required = false, defaultValue = "1000") String queriesQuantity) {
        MeasureResultDTO measureResultDTO = sqlBenchService.runBench(Integer.parseInt(queriesQuantity));
        return measureResultDTO;
    }
}
