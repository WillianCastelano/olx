package com.mvpolx.olx.service;


import com.mvpolx.olx.model.Address;
import com.mvpolx.olx.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() { return addressRepository.findAll(); }

    public Optional<Address> getAddressById(Long id) { return addressRepository.findById(id); }

    public Address saveAddress(Address address) { return addressRepository.save(address); }

    public void deleteAddress(Long id) { addressRepository.deleteById(id); }
}
