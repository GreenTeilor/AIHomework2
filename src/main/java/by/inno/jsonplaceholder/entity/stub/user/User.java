package by.inno.jsonplaceholder.entity.stub.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String website;

    @Column(nullable = false)
    private UUID addressId;

    @Column(nullable = false)
    private UUID companyId;

    @Column(nullable = false)
    private UUID ownerId;

    @OneToOne
    @JoinColumn(name = "addressId", nullable = false, insertable = false, updatable = false)
    private Address address;

    @OneToOne
    @JoinColumn(name = "companyId", nullable = false, insertable = false, updatable = false)
    private Company company;
}