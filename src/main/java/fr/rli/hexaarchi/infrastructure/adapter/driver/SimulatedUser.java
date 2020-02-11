package fr.rli.hexaarchi.infrastructure.adapter.driver;

import fr.rli.hexaarchi.boundary.port.driver.IReactToCommands;
import fr.rli.hexaarchi.command.AskForPoem;

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