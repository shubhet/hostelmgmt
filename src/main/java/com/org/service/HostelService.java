package com.example.hostel.service;

import com.example.hostel.entity.Hostel;
import com.example.hostel.repository.HostelRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class HostelService {

    private final HostelRepository hostelRepository;

    public HostelService(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    public Page<Hostel> fetchHostels(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return hostelRepository.findAll(pageable);
    }
}
