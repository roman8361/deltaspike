package ru.kravchenko.deltaspike.bootstrap;

import ru.kravchenko.deltaspike.entity.Cat;
import ru.kravchenko.deltaspike.entity.User;
import ru.kravchenko.deltaspike.repository.CatRepository;
import ru.kravchenko.deltaspike.repository.UserRepository;

import javax.inject.Inject;

/**
 * @author Roman Kravchenko
 */

public class Bootstrap {

    @Inject
    private CatRepository catRepository;

    public void init() {
        final Cat cat = catRepository.findByName("Keller");
        catRepository.removeById(cat.getId());
    }

}
