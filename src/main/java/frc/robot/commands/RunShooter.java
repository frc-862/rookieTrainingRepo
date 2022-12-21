// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class RunShooter extends CommandBase {
  Shooter shooter;
  DoubleSupplier power;

  public RunShooter(Shooter shooter, DoubleSupplier power) {
    this.shooter = shooter;
    this.power = power;

    addRequirements(shooter);
  }

  @Override
  public void execute() {
    shooter.setPower(power.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    shooter.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
