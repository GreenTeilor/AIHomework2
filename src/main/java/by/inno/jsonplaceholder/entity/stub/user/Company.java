package by.inno.jsonplaceholder.entity.stub.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "catch_phrase", length = Integer.MAX_VALUE)
    private String catchPhrase;

    @Column(name = "bs", length = Integer.MAX_VALUE)
    private String bs;

}