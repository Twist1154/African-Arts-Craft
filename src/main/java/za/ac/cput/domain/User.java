package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * User.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */
@Getter
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Address> address;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private LocalDate created_at;
    private LocalDate updated_at;

    public User() {
    }

    public User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.first_name = builder.first_name;
        this.last_name = builder.last_name;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }


    @Override
    public String toString() {
        return "User{" +
                "User ID: " + id +
                ", USERNAME: '" + username + '\'' +
                ", PASSWORD: '" + password + '\'' +
                ", EMAIL: '" + email + '\'' +
                ", FIRST NAME: '" + first_name + '\'' +
                ", LAST NAME: '" + last_name + '\'' +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private Long id;
        private List<Address> address;
        private String username;
        private String password;
        private String email;
        private String first_name;
        private String last_name;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setId(long user_id) {
            this.id = user_id;
            return this;
        }

        public Builder setAddress(List<Address> address) {
            this.address = address;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFirst_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public Builder setLast_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public Builder setCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder setUpdated_at(LocalDate updated_at) {
            this.updated_at = updated_at;
            return this;
        }

        public Builder copy(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.email = user.getEmail();
            this.first_name = user.getFirst_name();
            this.last_name = user.getLast_name();
            this.created_at = user.getCreated_at();
            this.updated_at = user.getUpdated_at();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
