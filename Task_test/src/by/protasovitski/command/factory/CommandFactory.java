package by.protasovitski.command.factory;


import by.protasovitski.command.Command;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;

@Named
@RequestScoped
public class CommandFactory {
    @Inject@Any
    private Instance<Command> commandInstance;


    public Command create(String command) {
        command = command.toUpperCase();
        CommandType commandEnum = CommandType.valueOf(command);

        Instance<Command> result = CDI.current().select(Command.class, new TypeQualifier(commandEnum));
        return result.get();
    }
}
