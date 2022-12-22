// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;

public class Drivetrain extends SubsystemBase {
  private VictorSP left;
  private VictorSP right;

  public Drivetrain() {
    left = new VictorSP(RobotMap.LEFT);
    right = new VictorSP(RobotMap.RIGHT);

    left.setInverted(true);

    // Funny robot fly now
    CommandScheduler.getInstance().registerSubsystem(this);
  }

  public void setPower(double leftPower, double rightPower) {
    left.set(leftPower);
    right.set(rightPower);
  }

  public void stop() {
    setPower(0d, 0d);
  }
}
