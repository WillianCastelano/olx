package com.mvpolx.olx.controller;


import com.mvpolx.olx.exception.AdNotFoundException;
import com.mvpolx.olx.model.Ad;
import com.mvpolx.olx.service.AdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdController {
    private final AdService adService;
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public List<Ad> getAllAds() { return adService.getAllAds(); }

    @GetMapping("/{id}")
    public ResponseEntity<Ad> getAdById(@PathVariable Long id) {
        return adService.getAdById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

 //minha parte
    @PutMapping("/{id}")
    public ResponseEntity<Ad> updateAd(@PathVariable Long id, @RequestBody Ad ad) {
        try {
            Ad updateAd = adService.updateAd(id, ad);
            return ResponseEntity.ok(updateAd);
        } catch (AdNotFoundException e) {
                return ResponseEntity.notFound().build();
            }

    }


    @PostMapping
    public Ad createAd(@RequestBody Ad ad) { return adService.saveAd(ad); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
      return ResponseEntity.noContent().build();
    }
}
