package br.com.app.inovate_barber.domain.model.entity;

import br.com.app.inovate_barber.domain.model.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseModel {
    @Column(name = "firebase_id", nullable = false, unique = true)
    private String firebaseId;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(name = "active")
    private boolean active = true;
}
