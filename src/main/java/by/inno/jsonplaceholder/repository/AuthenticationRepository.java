package by.inno.jsonplaceholder.repository;

import by.inno.jsonplaceholder.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, UUID> {

    Optional<Authentication> findByEmail(String email);

    boolean existsByEmail(String email);
} 