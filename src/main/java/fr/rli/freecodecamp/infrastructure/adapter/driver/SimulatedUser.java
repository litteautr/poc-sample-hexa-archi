package fr.rli.freecodecamp.infrastructure.adapter.driver;

import fr.rli.freecodecamp.boundary.port.driver.IReactToCommands;
import fr.rli.freecodecamp.command.AskForPoem;

public class SimulatedUser {
    private IReactToCommands driverPort;

    public SimulatedUser(IReactToCommands driverPort) {
        this.driverPort = driverPort;
    }

    public void run() {
        driverPort.reactTo(new AskForPoem("en"));
        driverPort.reactTo(new AskForPoem("de"));
    }
}