package ru.kravchenko.deltaspike.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Modifying;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.kravchenko.deltaspike.entity.Cat;
import ru.kravchenko.deltaspike.entity.Project;
import ru.kravchenko.deltaspike.entity.Session;
import ru.kravchenko.deltaspike.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
@Transactional
public interface SessionRepository extends FullEntityRepository<Session, String> {

    @Modifying
    @Query("DELETE FROM Session")
    void removeAll();

    void removeById(final String id);

    @Modifying
    @Query("SELECT id FROM Session")
    List<String> findAllId();

    List<Session> findByUser(final User user);

}
