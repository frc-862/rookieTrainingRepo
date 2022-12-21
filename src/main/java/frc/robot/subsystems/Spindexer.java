// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class Spindexer extends SubsystemBase {
  private VictorSP spindexMotor;

  Collector collector;

  public Spindexer(Collector collector) {
    this.collector = collector;

    spindexMotor = new VictorSP(RobotMap.SPINDEXER);

    CommandScheduler.getInstance().registerSubsystem(this);
  }

  public void setPower(double power) {
    spindexMotor.set(power);
    collector.upperBelt.set(power);
  }

  public void stop() {
    setPower(0d);
  }
}
