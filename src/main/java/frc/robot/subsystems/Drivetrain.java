package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  // Creating two arrays of both our left and right motors, also using our contstants file to get our specific motor ID's
  private TalonFX[] motorsLeft = {new TalonFX(Constants.LEFT_MOTOR_1), new TalonFX(Constants.LEFT_MOTOR_2), new TalonFX(Constants.LEFT_MOTOR_3)};
  private TalonFX[] motorsRight = {new TalonFX(Constants.RIGHT_MOTOR_1), new TalonFX(Constants.RIGHT_MOTOR_2), new TalonFX(Constants.RIGHT_MOTOR_3)};

  // Setting our motor invers so that the wheels spin in the right direction when we give them positive power, also from our constants file
  public Drivetrain() {
    for(var i = 0; i < motorsLeft.length; i++) {
      motorsLeft[i].setInverted(Constants.LEFT_MOTOR_INVERTS[i]);
      motorsRight[i].setInverted(Constants.RIGHT_MOTOR_INVERTS[i]);
    }
  }

  @Override
  public void periodic() {}

  // Sets the motor powers of our left and right motors
  public void setPower(double leftPower, double rightPower) {
    for(TalonFX motor : motorsLeft) {
      motor.set(TalonFXControlMode.PercentOutput, leftPower);
    }
    for(TalonFX motor : motorsRight) {
      motor.set(TalonFXControlMode.PercentOutput, rightPower);
    }
  }

  // Stops all the motors
  public void stop() {
    setPower(0, 0);

  }
}
