package ru.kravchenko.deltaspike;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.deltaspike.entity.Project;
import ru.kravchenko.deltaspike.entity.Session;
import ru.kravchenko.deltaspike.entity.User;
import ru.kravchenko.deltaspike.repository.SessionRepository;
import ru.kravchenko.deltaspike.repository.UserRepository;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class SessionTest {

    private Lorem lorem = new LoremIpsum();

    @Inject
    private SessionRepository sessionRepository;

    @Inject
    private UserRepository userRepository;

    @Test
    public void addAnySession() {
        for (int i = 0; i < 2; i++) addOneSession();
    }

    private void addOneSession() {
        sessionRepository.persist(date());
    }

    private Session date() {
    final Session session = new Session();
    session.setSignature(lorem.getUrl());
    session.setTimestamp(new Date());
    session.setUser(userRepository.findBy("8a6268f6-c9c1-4419-a6e3-584c10b7eec7"));
    return session;
    }

    @Test
    public void clear() { sessionRepository.removeAll(); }

    @Test
    public void removeById() { sessionRepository.removeById("924aef12-cade-476f-9fb1-1378b6f10d36"); }

    @Test
    public void findAllSession() {
        System.out.println(sessionRepository.findAll());
    }

    @Test
    public void findAllIds() {
        System.out.println(sessionRepository.findAllId());
    }

    @Test
    public void findById() {
        System.out.println(sessionRepository.findBy("e3994265-c9d8-49d4-862c-0073010c7da0").getUser());
    }

    @Test
    public void findOnByUserId() {
        final User user = userRepository.findBy("8a6268f6-c9c1-4419-a6e3-584c10b7eec7");
        System.out.println(sessionRepository.findByUser(user).get(0).getSignature());
    }

    @Test
    public void sessionTestCRUD() {
        final List<Session> sessionList = sessionRepository.findAll();
        final Session session = new Session();
        session.setUser(userRepository.findBy("8a6268f6-c9c1-4419-a6e3-584c10b7eec7"));
        session.setTimestamp(new Date());
        session.setSignature(lorem.getUrl());
        sessionRepository.persist(session);

        final Session projectInsert = sessionRepository.findBy(session.getId());
        Assert.assertNotNull(projectInsert);
        sessionRepository.removeById(projectInsert.getId());
        Assert.assertNull(sessionRepository.findBy(session.getId()));
    }

}
