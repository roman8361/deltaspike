package ru.kravchenko.deltaspike.repository;

import org.apache.deltaspike.data.api.*;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.deltaspike.entity.Cat;
import ru.kravchenko.deltaspike.entity.Project;
import ru.kravchenko.deltaspike.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
@Transactional
public interface ProjectRepository extends FullEntityRepository<Project, String> {

    @Modifying
    @Query("SELECT id FROM Project")
    List<String> findAllId();

    @Modifying
    @Query("DELETE FROM Project")
    void removeAll();

    List<Project> findByUser(@NotNull final User user);

    void removeById(final String id);

}
