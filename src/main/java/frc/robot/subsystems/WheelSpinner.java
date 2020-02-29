package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.RobotContainer;
import frc.robot.commands.Wheel;

public class WheelSpinner extends SubsystemBase {

  private WPI_TalonSRX spinMotor;

  
    public WheelSpinner() {
      spinMotor = new WPI_TalonSRX(RobotContainer.spinner);
      spinMotor.configFactoryDefault();
    }
  
    public void wheelMove(double a) {
      spinMotor.set(a);
    }
 
    @Override
    public void periodic(){
         setDefaultCommand(new Wheel());
    }
}
