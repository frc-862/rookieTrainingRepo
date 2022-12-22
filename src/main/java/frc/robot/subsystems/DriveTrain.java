// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  TalonFX rightMotorOne;
  TalonFX rightMotorTwo;
  TalonFX rightMotorThree;
  TalonFX leftMotorOne;
  TalonFX leftMotorTwo;
  TalonFX leftMotorThree;

  // Creates a new DriveTrain.
  public DriveTrain() {
    rightMotorOne = new TalonFX(1);
    rightMotorTwo = new TalonFX(2);
    rightMotorThree = new TalonFX(3);
    leftMotorOne = new TalonFX(4);
    leftMotorTwo = new TalonFX(5);
    leftMotorThree = new TalonFX(6);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double rightSpeed, double leftSpeed) {
    //set right motors to correct speed
    rightMotorOne.set(TalonFXControlMode.PercentOutput, rightSpeed);
    rightMotorTwo.set(TalonFXControlMode.PercentOutput, rightSpeed);
    rightMotorThree.set(TalonFXControlMode.PercentOutput, rightSpeed);
    //set left motors to correct speed
    leftMotorOne.set(TalonFXControlMode.PercentOutput, leftSpeed);
    leftMotorTwo.set(TalonFXControlMode.PercentOutput, leftSpeed);
    leftMotorThree.set(TalonFXControlMode.PercentOutput, leftSpeed);
  }
}