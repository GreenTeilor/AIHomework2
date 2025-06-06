package by.inno.jsonplaceholder.repository.stub;

import by.inno.jsonplaceholder.entity.stub.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
} 