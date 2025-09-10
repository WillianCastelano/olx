package com.mvpolx.olx.repository;


import com.mvpolx.olx.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//minha parte
public interface AdRepository extends JpaRepository<Ad, Long> {
}
