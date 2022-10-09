package it.unibo.design.robot.api;

import it.unibo.design.robot.components.api.RobotPart;

public interface CommandableRobotPart extends RobotPart {

    void sendCommand(String command);

    String[] availableCommands();

}
