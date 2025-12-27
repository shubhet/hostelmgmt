package com.example.hostel.controller;

import com.example.hostel.dto.ApiResponse;
import com.example.hostel.dto.PageResponse;
import com.example.hostel.entity.Hostel;
import com.example.hostel.service.HostelService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hostels")
public class HostelController {

    private final HostelService hostelService;

    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<Hostel>>> getHostels(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {

        Page<Hostel> hostelPage =
                hostelService.fetchHostels(page, size, sortBy, direction);

        PageResponse<Hostel> pageResponse = new PageResponse<>(
                hostelPage.getContent(),
                hostelPage.getNumber(),
                hostelPage.getSize(),
                hostelPage.getTotalElements(),
                hostelPage.getTotalPages(),
                hostelPage.isLast()
        );

        ApiResponse<PageResponse<Hostel>> response =
                new ApiResponse<>(
                        "SUCCESS",
                        "Hostel data fetched successfully",
                        pageResponse
                );

        return ResponseEntity.ok(response);
    }
}
