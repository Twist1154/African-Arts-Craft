package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * User.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
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
        this.user_id = builder.user_id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.first_name = builder.first_name;
        this.last_name = builder.last_name;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "User ID: " + user_id +
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
        private long user_id;
        private String username;
        private String password;
        private String email;
        private String first_name;
        private String last_name;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setUser_id(long user_id) {
            this.user_id = user_id;
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
            this.user_id = user.getUser_id();
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
