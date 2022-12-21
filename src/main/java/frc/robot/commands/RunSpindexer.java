// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Spindexer;

public class RunSpindexer extends CommandBase {
  Spindexer spindexer;
  DoubleSupplier power;

  public RunSpindexer(Spindexer spindexer, DoubleSupplier power) {
    this.spindexer = spindexer;
    this.power = power;

    addRequirements(spindexer);
  }

  @Override
  public void execute() {
    spindexer.setPower(power.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    spindexer.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
