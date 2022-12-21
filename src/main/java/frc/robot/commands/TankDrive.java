// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  Drivetrain drivetrain;
  DoubleSupplier leftPower;
  DoubleSupplier rightPower;

  public TankDrive(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
    this.drivetrain = drivetrain;
    this.leftPower = left;
    this.rightPower = right;

    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    drivetrain.setPower(leftPower.getAsDouble(), rightPower.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
