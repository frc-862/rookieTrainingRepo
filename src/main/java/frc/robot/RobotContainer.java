// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.RunCollector;
import frc.robot.commands.RunShooter;
import frc.robot.commands.RunSpindexer;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Spindexer;

public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final Collector collector = new Collector();
  private final Spindexer spindexer = new Spindexer(collector);
  private final Shooter shooter = new Shooter();

  private final XboxController controller = new XboxController(0);
  public RobotContainer() {
    configureButtonBindings();
    drivetrain.setDefaultCommand(new TankDrive(drivetrain, () -> controller.getLeftY(), () -> controller.getRightY()));
  }
  //TEST EDIT
  private void configureButtonBindings() {
    (new Button(() -> controller.getAButton())).whileHeld(new RunShooter(shooter, () -> 1d));
    (new Button(() -> controller.getBButton())).whileHeld(new RunCollector(collector, () -> 1d));
    (new Button(() -> controller.getLeftBumper())).whileHeld(new RunSpindexer(spindexer, () -> -1d));
    (new Button(() -> controller.getRightBumper())).whileHeld(new RunSpindexer(spindexer, () -> 1d));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
