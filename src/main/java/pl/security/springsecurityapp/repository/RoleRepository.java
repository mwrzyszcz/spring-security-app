package pl.security.springsecurityapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.security.springsecurityapp.model.Role;
import pl.security.springsecurityapp.model.RoleName;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleName roleName);
}
