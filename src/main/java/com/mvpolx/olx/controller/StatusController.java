package com.mvpolx.olx.controller;


import com.mvpolx.olx.model.Status;
import com.mvpolx.olx.service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;
    public StatusController(StatusService statusService) { this.statusService = statusService; }

    @GetMapping
    public List<Status> getAllStatus() { return statusService.getAllStatus(); }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
        return statusService.getStatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Status createStatus(@RequestBody Status status) { return statusService.saveStatus(status); }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) { statusService.deleteStatus(id); }
}
