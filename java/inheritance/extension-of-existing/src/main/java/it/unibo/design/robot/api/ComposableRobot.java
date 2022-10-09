package it.unibo.design.robot.api;

import it.unibo.design.robot.components.api.RobotPart;

public interface ComposableRobot extends Robot {

    void attachComponent(RobotPart robotPart);

    void detachComponent(RobotPart robotPart);

    void doCycle();

}
