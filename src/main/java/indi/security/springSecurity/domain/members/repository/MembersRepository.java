package indi.security.springSecurity.domain.members.repository;

import indi.security.springSecurity.domain.members.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {
    Optional<Members> findByLoginIdAndPassword(String loginId, String password);
    Optional<Members> findByLoginId (String loginId);

}
