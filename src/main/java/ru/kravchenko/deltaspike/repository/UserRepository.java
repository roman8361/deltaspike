package ru.kravchenko.deltaspike.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Modifying;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.kravchenko.deltaspike.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
@Transactional
public interface UserRepository extends FullEntityRepository<User, String> {

    User findByLogin(final String login);

    @Modifying
    @Query("SELECT id FROM User")
    List<String> findByAllId();

    @Modifying
    @Query("SELECT login FROM User")
    List<String> loginList();

    void removeById(String id);

    @Modifying
    @Query("DELETE FROM User")
    void removeAll();

}
