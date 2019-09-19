package by.protasovitski.testing;

import javax.enterprise.inject.Alternative;

@Alternative
public class StubLoginService implements ILoginService {
    @Override
    public boolean login(String name, String password) {
        return true;
    }
}
