package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {

  // Creating our Drivetrain subsystem
  private Drivetrain drivetrain = new Drivetrain();

  // Creating left and right joysticks
  private Joystick leftDrive = new Joystick(0);
  private Joystick rightDrive = new Joystick(1);

  public RobotContainer() {
    configureButtonBindings();
    configureDefaultCommands();
  }


  // Setting our Drivetrain subsystems default command to our drive command
  private void configureDefaultCommands() {
    drivetrain.setDefaultCommand(new Drive(drivetrain, () -> leftDrive.getY(), () -> rightDrive.getY()));
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return null;
  }
}
