package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  // Declaring the Drivetrain variable that will be initilized later
  private Drivetrain drivetrain;

  // Declaring our right and left motor power suppliers
  private DoubleSupplier leftPower;
  private DoubleSupplier rightPower;

  // Constructor wich takes in the drivetrain subsystems and our left and right powers from the joysticks
  public Drive(Drivetrain drivetrain, DoubleSupplier leftPower, DoubleSupplier rightPower) {
    // Initializing all our variables that was provided in our constructor
    this.drivetrain = drivetrain;
    this.leftPower = leftPower;
    this.rightPower = rightPower;

    // Require the drivetrain so that no other command can use it
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {}

    @Override
    public void execute() {
      // Sets our right and left motor powers that came from the joystick using the method from our drivetrain class
      drivetrain.setPower(leftPower.getAsDouble(), rightPower.getAsDouble());
    }

  @Override
  public void end(boolean interrupted) {
    drivetrain.stop(); // Sets all motor power to zero to stop the robot
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
