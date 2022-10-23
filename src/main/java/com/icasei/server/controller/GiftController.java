package com.icasei.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icasei.server.data.GiftPayload;
import com.icasei.server.model.Gift;
import com.icasei.server.repository.GiftRepository;

@RestController()
@RequestMapping(value = "/gift")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class GiftController {

    @Autowired
    private GiftRepository giftRepository;

    @GetMapping(value = "/all")
    public List<Gift> getGifts() {
        return giftRepository.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createGift(@RequestBody GiftPayload payload) {
        Gift gift = new Gift(payload);
        giftRepository.save(gift);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("Resource created.");
    }
}
