package com.videostream.app.videostream.entity;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name="user_password")
    private String password;

    private LocalDateTime createdDate  = LocalDateTime.now();

    private LocalDateTime modifiedDate;

}
