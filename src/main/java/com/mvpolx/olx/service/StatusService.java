package com.mvpolx.olx.service;


import com.mvpolx.olx.model.Status;
import com.mvpolx.olx.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    private final StatusRepository statusRepository;
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatus() { return statusRepository.findAll(); }

    public Optional<Status> getStatusById(Long id) { return statusRepository.findById(id); }

    public Status saveStatus(Status status) { return statusRepository.save(status); }

    public void deleteStatus(Long id) { statusRepository.deleteById(id); }
}
