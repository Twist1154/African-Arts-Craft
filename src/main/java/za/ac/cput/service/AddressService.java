package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Addresses;
import za.ac.cput.repository.AddressRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * AddressService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 27-Jul-24
 */


@Service
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Addresses create(Addresses address) {
        return addressRepository.save(address);
    }

    @Override
    public Addresses read(Long id) {
        Optional<Addresses> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    @Override
    public Addresses update(Addresses address) {
        if (addressRepository.existsById(address.getAddress_id())) {
            return addressRepository.save(address);
        }
        return null;
    }

    @Override
    public List<Addresses> findAll() {
        return addressRepository.findAll();
    }


    public List<Addresses> findByCity(String city) {
        return addressRepository.findByCity(city);
    }


    @Override
    public List<Addresses> findByPostal_code(String postalCode) {
        return addressRepository.findByPostal_code(postalCode);
    }

    @Override
    public List<Addresses> findByCreated_atAfter(LocalDate date) {
        return addressRepository.findByCreated_atAfter(date);
    }

    public List<Addresses> findByPostalCode(String postalCode) {
        return addressRepository.findByPostal_code(postalCode);
    }

    public List<Addresses> findByCreatedAtAfter(LocalDate date) {
        return addressRepository.findByCreated_atAfter(date);
    }

    public List<Addresses> findAddressesByProvince(String province) {
        return addressRepository.findAddressesByProvince(province);
    }

    public Optional<Addresses> findByUser(Addresses user_id) {
        return null;
    }
}
