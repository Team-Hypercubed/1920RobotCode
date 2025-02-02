/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.TankDrive;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  Spark leftFrontMotor, rightFrontMotor;
  VictorSP leftBackMotor, rightBackMotor;
  DifferentialDrive drive;
  
  public DriveTrain() {
    leftFrontMotor = new Spark(RobotContainer.frontLeftMotor);
    rightFrontMotor = new Spark(RobotContainer.frontRightMotor);
    leftBackMotor = new VictorSP(RobotContainer.backLeftMotor);
    rightBackMotor = new VictorSP(RobotContainer.backRightMotor);

    SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
    drive = new DifferentialDrive(leftSide, rightSide);
  }

  public void controllerPassthrough(double a, double b) {
    drive.tankDrive(-a,-b);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new TankDrive());
  }
}
