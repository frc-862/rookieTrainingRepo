// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class Shooter extends SubsystemBase {
  public VictorSP flywheel;

  public Shooter() {
    flywheel = new VictorSP(RobotMap.FLYWHEEL);

    CommandScheduler.getInstance().registerSubsystem(this);
  }

  public void setPower(double power) {
    flywheel.set(power);
  }

  public void stop() {
    setPower(0);
  }
}
