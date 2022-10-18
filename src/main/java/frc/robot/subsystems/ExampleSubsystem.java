// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private final TalonFX motor;

  public ExampleSubsystem() {
    motor = new TalonFX(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void moveMotor() {
    motor.set(TalonFXControlMode.PercentOutput, 1);
  }

  public double getEncoderValue() {
   return motor.getSelectedSensorPosition();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
