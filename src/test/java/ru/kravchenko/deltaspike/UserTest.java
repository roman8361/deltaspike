package ru.kravchenko.deltaspike;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.deltaspike.entity.Project;
import ru.kravchenko.deltaspike.entity.User;
import ru.kravchenko.deltaspike.repository.ProjectRepository;
import ru.kravchenko.deltaspike.repository.UserRepository;

import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class UserTest {

    @Inject
    private UserRepository userRepository;

    private Lorem lorem = new LoremIpsum();

    @Test
    public void addAnyProject() {
        for (int i = 0; i < 10; i++) addOneUser();
    }

    private void addOneUser() {
        userRepository.persist(date());
    }

    private User date() {
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(lorem.getZipCode());
        return user;
    }

    @Test
    public void clearUser() {
        @Nullable final List<User> users = userRepository.findAll();
        users.forEach(userRepository::remove);
        System.out.println(users);
    }

    @Test
    public void findById() {
        System.out.println(userRepository.findBy("11652315-e242-47ff-bbe9-9764030fb791").getLogin());
    }

    @Test
    public void removeById() {
        userRepository.removeById("2fe08f53-3bfe-49f5-a045-5fb4f898bc12");
    }

    @Test
    public void removeByEntity() { //TODO
       final User user = userRepository.findBy("32e6bb71-cdfa-4621-8b9d-a532f85b7a6b");
       userRepository.remove(user);
    }

    @Test
    public void clear() {
        userRepository.removeAll();
    }

    @Test
    public void userCRUD() {
        final List<User> userList = userRepository.findAll();
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(lorem.getZipCode());
        userRepository.persist(user);

        final User catInsert = userRepository.findBy(user.getId());
        Assert.assertNotNull(catInsert);
        userRepository.removeById(catInsert.getId());
        Assert.assertNull(userRepository.findBy(user.getId()));
    }

    @Test
    public void ids() {
        List<String> ids = userRepository.findByAllId();
        System.out.println(ids);
    }

    @Test
    public void findByLogin() {
        System.out.println(userRepository.findByLogin("Gay").getPasswordHash());
    }

    @Test
    public void findLoginList() {
        for (String s: userRepository.loginList()) System.out.println(s);
    }

}

