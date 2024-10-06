package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter; // Added for setter method if needed

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Entity
public class InventoryItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    private int quantity;
    private String vendorLocation;
    private LocalDate lastUpdated;

    public InventoryItem() {
    }

    public InventoryItem(Builder builder) {
        this.id = builder.id;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.vendorLocation = builder.vendorLocation;
        this.lastUpdated = builder.lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryItem that = (InventoryItem) o;
        return quantity == that.quantity &&
                Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(vendorLocation, that.vendorLocation) &&
                Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity, vendorLocation, lastUpdated);
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "InventoryService ID: " + id +
                ", PRODUCT NAME: " + (product != null ? product.getName() : "N/A") +
                ", QUANTITY: " + quantity +
                ", VENDOR LOCATION: '" + vendorLocation + '\'' +
                ", LAST UPDATED: " + lastUpdated +
                '}';
    }

    public static class Builder {
        private Long id;
        private Product product;
        private int quantity;
        private String vendorLocation;
        private LocalDate lastUpdated;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setVendorLocation(String vendorLocation) {
            this.vendorLocation = vendorLocation;
            return this;
        }

        public Builder setLastUpdated(LocalDate lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Builder copy(InventoryItem inventory) {
            this.id = inventory.getId();
            this.product = inventory.getProduct();
            this.quantity = inventory.getQuantity();
            this.vendorLocation = inventory.getVendorLocation();
            this.lastUpdated = inventory.getLastUpdated();
            return this;
        }

        public InventoryItem build() {
            return new InventoryItem(this);
        }
    }
}
