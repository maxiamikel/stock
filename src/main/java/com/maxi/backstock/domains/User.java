package com.maxi.backstock.domains;

import com.maxi.backstock.enums.UserStatus;
import com.maxi.backstock.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "personal_id")
    private String personalId;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "uset_type")
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;
    private String foto;

    public User() {
        super();
        this.setUserStatus(UserStatus.ENABLE);
        this.setUserType(UserType.USER);
    }

    public User(String personalId, String name, String email, UserType userType, String foto) {
        this.personalId = personalId;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.foto = foto;
    }

    public User(String personalId, String name, String email) {
        this.personalId = personalId;
        this.name = name;
        this.email = email;
    }

}
