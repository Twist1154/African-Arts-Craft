package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.InventoryRepository;
import za.ac.cput.domain.InventoryItem;

import java.time.LocalDate;
import java.util.List;

/**
 * InventoryServiceImply.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 06-Oct-24
 */
@Service
public class InventoryServiceImply implements InventoryService {

    @Autowired
    private InventoryRepository repository;

    @Override
    public InventoryItem create(InventoryItem InventoryItem) {
        return repository.save(InventoryItem);
    }

    @Override
    public InventoryItem read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public InventoryItem update(InventoryItem item) {
        InventoryItem existingItem = repository.findById(item.getId()).orElse(null);
        if (existingItem != null) {
            InventoryItem updatedItem = new InventoryItem.Builder()
                    .copy(existingItem)
                    .setId(existingItem.getId())
                    .setProduct(item.getProduct())
                    .setQuantity(item.getQuantity())
                    .setVendorLocation(item.getVendorLocation())
                    .setLastUpdated(LocalDate.now())
                    .build();

            return repository.save(updatedItem);
        }
        return null;
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<InventoryItem> findAll() {
        return repository.findAll();
    }
}


