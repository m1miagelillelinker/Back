package myapp.service.impl;

import myapp.repository.StatusRepository;
import myapp.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
}
