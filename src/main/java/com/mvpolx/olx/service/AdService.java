package com.mvpolx.olx.service;

import com.mvpolx.olx.exception.AdNotFoundException;
import com.mvpolx.olx.model.Ad;
import com.mvpolx.olx.repository.AdRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AdService {
    private final AdRepository adRepository;

    public AdService(AdRepository adRepository) {

        this.adRepository = adRepository;
    }

    public List<Ad> getAllAds() {
        return adRepository.findAll();
    }

    public Optional<Ad> getAdById(Long id) {
        return adRepository.findById(id);
    }

    public Ad saveAd(Ad ad) {
        return adRepository.save(ad);
    }

// minha parte


    public Ad  updateAd(Long id, Ad ad) {
        Ad existingAd = adRepository.findById(id)
                .orElseThrow(() -> new AdNotFoundException(id));

        if (ad.getTitle() == null || ad.getTitle().trim().isEmpty()) {
            throw new RuntimeException("O título do anúncio é obrigatório.");
        }

        if (ad.getPrice() == null || ad.getPrice() <= 0) {
            throw new RuntimeException("O preço deve ser maior que zero.");
        }

        if (ad.getCategory() == null) {
            throw new RuntimeException("A categoria é obrigatória.");
        }

        if (ad.getCondition() == null) {
            throw new RuntimeException("A condição (novo/usado) é obrigatória.");
        }
        existingAd.setTitle(ad.getTitle());
        existingAd.setDescription(ad.getDescription());
        existingAd.setPrice(ad.getPrice());
        existingAd.setCategory(ad.getCategory());
        existingAd.setStatus(ad.getStatus());
        existingAd.setCondition(ad.getCondition());
        // Adicione outros campos que desejar atualizar
        return adRepository.save(existingAd);}

        public void deleteAd(Long id) {
            adRepository.deleteById(id);
        }

    }

