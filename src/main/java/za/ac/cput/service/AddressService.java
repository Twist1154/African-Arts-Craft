package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

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
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address read(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    @Override
    public Address update(Address address) {
        if (addressRepository.existsById(address.getId())) {
            return addressRepository.save(address);
        }
        return null;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }


}
