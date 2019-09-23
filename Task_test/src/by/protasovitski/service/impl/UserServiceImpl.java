package by.protasovitski.service.impl;

import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.repository.UserRepository;
import by.protasovitski.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Named
@RequestScoped
public class UserServiceImpl implements UserService {


    @Inject
    private UserRepository userRepository;



    @Override
    public Optional<User> save(User user) {
        try{
            return Optional.of(userRepository.save(user)) ;
        }catch (Exception e){
            e.getMessage();
        }
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
        try{
            userRepository.remove(id);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public List<User> findAll() {
        try{
            return userRepository.findAll();
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        try{
            return userRepository.findById(id);
        }catch (Exception e){
            e.getMessage();
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> login(String login, byte[] password) {
        try {
            return userRepository.findByLoginAndPassword(login,password);
        }catch (RepositoryException e){
           e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Map<User,Long> findAllWithCountTasks() {
        try{
            return userRepository.findAllWithCountTasks();
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public List<User> findAllHaveTasksWithTotalTimeMore(Long totalTime) {
        try{
            return userRepository.findAllHaveTasksWithTotalTimeMore(totalTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
