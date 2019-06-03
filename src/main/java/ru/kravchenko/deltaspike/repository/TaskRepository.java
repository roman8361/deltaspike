package ru.kravchenko.deltaspike.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Modifying;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.deltaspike.entity.Cat;
import ru.kravchenko.deltaspike.entity.Project;
import ru.kravchenko.deltaspike.entity.Task;
import ru.kravchenko.deltaspike.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
@Transactional
public interface TaskRepository extends FullEntityRepository<Task, String> {

    @Modifying
    @Query("SELECT id FROM Task")
    List<String> findAllId();

    @Modifying
    @Query("DELETE FROM Task")
    void removeAll();

    void removeById(final String id);

    List<Task> findByUser(@NotNull final User user);

}
