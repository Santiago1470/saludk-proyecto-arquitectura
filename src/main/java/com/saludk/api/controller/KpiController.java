package com.saludk.api.controller;

import com.saludk.api.domain.kpi.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/kpi")
public class KpiController {

    @Autowired
    private KpiService kpiService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerKpis() {
        return ResponseEntity.ok(kpiService.obtenerKpis());
    }
}
