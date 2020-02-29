package frc.robot.commands;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.CANCoderFaults;
import com.ctre.phoenix.sensors.CANCoderStickyFaults;
import com.ctre.phoenix.sensors.MagnetFieldStrength;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.*;

/**
 * An example command that uses an example subsystem.
 */
public class Wheel extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  
  double spinMotor;
  
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Wheel() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_wheelSpinner);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.m_input.testController.getAButton() == true) {
        double multiplier = Robot.m_input.testController.getTriggerAxis(Hand.kRight);
        Robot.m_wheelSpinner.wheelMove(multiplier); 
      }
    if (Robot.m_input.testController.getBumper(Hand.kRight) == true && Robot.m_input.testController.getAButton() == true) {
        double multiplier = Robot.m_input.testController.getTriggerAxis(Hand.kRight);
        Robot.m_wheelSpinner.wheelMove(-multiplier);
    }
    if (Robot.m_input.testController.getAButton() == false) {
        Robot.m_wheelSpinner.wheelMove(0); 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished(){
    return false;
    }
}
