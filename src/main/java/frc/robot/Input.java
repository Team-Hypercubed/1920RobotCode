package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.DualStick;

public class Input {
    public XboxController testController = null;
    
    public Input() {
        testController =  new XboxController(RobotContainer.testController);
    }

}