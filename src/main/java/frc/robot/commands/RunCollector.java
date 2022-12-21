// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class RunCollector extends CommandBase {
  Collector collector;
  DoubleSupplier power;

  public RunCollector(Collector collector, DoubleSupplier power) {
    this.collector = collector;
    this.power = power;

    addRequirements(collector);
  }

  @Override
  public void execute() {
    collector.setPower(power.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    collector.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
