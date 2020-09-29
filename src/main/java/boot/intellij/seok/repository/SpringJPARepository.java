package boot.intellij.seok.repository;

import boot.intellij.seok.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJPARepository extends JpaRepository<Member,Long>, MemberRepository {
    Optional<Member> findByName(String name);
}
