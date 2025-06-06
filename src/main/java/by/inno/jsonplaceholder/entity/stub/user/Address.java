package by.inno.jsonplaceholder.entity.stub.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "street", nullable = false, length = Integer.MAX_VALUE)
    private String street;

    @Column(name = "suite", length = Integer.MAX_VALUE)
    private String suite;

    @Column(name = "city", nullable = false, length = Integer.MAX_VALUE)
    private String city;

    @Column(name = "zipcode", nullable = false, length = Integer.MAX_VALUE)
    private String zipcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geo_id")
    private GeoLocation geo;
}