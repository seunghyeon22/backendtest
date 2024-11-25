package co.kr.metacoding.backendtest.user;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    // user 등록 repository
    public User save(User user) {
        em.persist(user);
        return user;
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(em.find(User.class, id));
    }
}
