package com.mvpolx.olx.controller;


import com.mvpolx.olx.model.Address;
import com.mvpolx.olx.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService) { this.addressService = addressService; }

    @GetMapping
    public List<Address> getAllAddresses() { return addressService.getAllAddresses(); }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) { return addressService.saveAddress(address); }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) { addressService.deleteAddress(id); }
}
