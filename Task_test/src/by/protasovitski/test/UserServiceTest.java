package by.protasovitski.test;

import by.protasovitski.entity.User;
import by.protasovitski.service.UserService;
import by.protasovitski.service.impl.UserServiceImpl;
import by.protasovitski.util.HashPasswordImpl;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@EnableWeld
public class UserServiceTest {

//    @WeldSetup
//    public WeldInitiator weld =WeldInitiator.from(UserService.class).;
    private   UserService userService;


    private HashPasswordImpl hashPassword;



    @Test
    public void testSaveRecord() {
        User newUser = new User();
        newUser.setName("Дмиртий Протасовицкий");
        newUser.setPassword(hashPassword.getHash("123456"));
        newUser.setLogin("dpro");
        User user = userService.save(newUser).get();
    }

    @Test
    public void testUpdateRecord() {
        User user = userService.findById(3L).get();
        user.setName("Руслан Протасовицкий");
        user.setPassword(hashPassword.getHash("654321"));
        user.setLogin("dpro");
        userService.save(user);
        System.out.println(user.toString());
    }

    @Test
    public void testFindOneRecord() {
        User user = userService.findById(2L).get();
        System.out.println(user.toString());
    }


    @Test
    public void testFindAllRecords() {
        List<User> users = userService.findAll();
        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }

    @Test
    public void testFindOneRecordByLoginAndPassword() {
        String login = "dpro";
        byte[] password = hashPassword.getHash("123456");
        Optional<User> user = userService.login(login, password);
        Assert.assertTrue(user.isPresent());
    }

    @Test
    public void testFindAllWithCountTasks() {
        List<Map<User, Integer>> users = userService.findAllWithCountTasks();
        if (!users.isEmpty()) {
            for (Map<User, Integer> maps : users) {
                for (Map.Entry<User, Integer> entry : maps.entrySet()) {
                    System.out.print(entry.getKey());
                    System.out.println("=" + entry.getValue());
                }
            }
        }
    }
    @Test
    public void testFindAllHaveTasksWithTotalTimeMore(){
        Long totalTime = 100L;
        List<User> users = userService.findAllHaveTasksWithTotalTimeMore(totalTime);
        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }
}
