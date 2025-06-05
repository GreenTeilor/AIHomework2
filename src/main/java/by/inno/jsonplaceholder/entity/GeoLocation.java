package by.inno.jsonplaceholder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "geo_locations")
@Getter
@Setter
public class GeoLocation {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "lat", nullable = false, length = Integer.MAX_VALUE)
    private String lat;

    @Column(name = "lng", nullable = false, length = Integer.MAX_VALUE)
    private String lng;
}