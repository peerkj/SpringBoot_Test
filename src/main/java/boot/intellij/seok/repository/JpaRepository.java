package boot.intellij.seok.repository;

import boot.intellij.seok.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaRepository implements MemberRepository{

    private final EntityManager entityManager;

    public JpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);

    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {

        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
