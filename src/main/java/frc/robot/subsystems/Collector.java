// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class Collector extends SubsystemBase {
  public VictorSP lowerBelt;
  public VictorSP upperBelt;
  public VictorSP spinny;

  public Collector() {
    lowerBelt = new VictorSP(RobotMap.LOWER_BELT);
    upperBelt = new VictorSP(RobotMap.UPPER_BELT);
    spinny = new VictorSP(RobotMap.SPINNY);

    CommandScheduler.getInstance().registerSubsystem(this);
  }

  public void setPower(double power) {
    lowerBelt.set(power);
    upperBelt.set(power);
    spinny.set(power);
  }

  public void stop() {
    setPower(0);
  }
}
