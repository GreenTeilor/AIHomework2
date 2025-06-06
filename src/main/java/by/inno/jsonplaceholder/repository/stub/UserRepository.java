package by.inno.jsonplaceholder.repository.stub;

import by.inno.jsonplaceholder.entity.stub.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u JOIN FETCH u.address JOIN FETCH u.company JOIN FETCH u.address.geo WHERE u.ownerId = :OID")
    List<User> findAllWithAddressAndCompanyByOwnerId(
            @Param("OID") UUID ownerId
    );
} 