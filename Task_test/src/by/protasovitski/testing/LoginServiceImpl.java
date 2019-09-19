package by.protasovitski.testing;

public class LoginServiceImpl implements ILoginService {
    @Override
    public boolean login(String name, String password) {
        System.out.println("LOGINSERVICE!!!!!!!!!!!!!!!!!!!!!!!");
        return "bugs".equalsIgnoreCase(name)&&"bunny".equalsIgnoreCase(password);
    }
}
