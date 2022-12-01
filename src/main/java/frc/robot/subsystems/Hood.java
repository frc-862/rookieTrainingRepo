// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hood extends SubsystemBase {
  public VictorSPX hoodMotor;
  private ShuffleboardTab hoodTab = Shuffleboard.getTab("encoder");
  private NetworkTableEntry encoderOutputTab = hoodTab.add("encoderOutput", 0).getEntry();
  private NetworkTableEntry motorOutputTab = hoodTab.add("motorOutput", 0).getEntry();
  private NetworkTableEntry inputAngleTab = hoodTab.add("angleInput", 0).getEntry();
  private NetworkTableEntry pTab = hoodTab.add("kP", 0).getEntry();
  private NetworkTableEntry iTab = hoodTab.add("kI", 0).getEntry();
  private NetworkTableEntry dTab = hoodTab.add("kD", 0).getEntry();
  /** Creates a new Hood. */
  public Hood() {
    hoodMotor = new VictorSPX(13);
    hoodMotor.configSelectedFeedbackSensor(FeedbackDevice.Analog);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    encoderOutputTab.setDouble(getEncoderOutput());
    motorOutputTab.setDouble(hoodMotor.getMotorOutputPercent());

    setGains(pTab.getDouble(0), iTab.getDouble(0), dTab.getDouble(0));
    setTarget(inputAngleTab.getDouble(0));
  }

  public void setTarget(double input){
    hoodMotor.set(VictorSPXControlMode.Position, input);
  }

  public void setPower(double input){
    hoodMotor.set(VictorSPXControlMode.PercentOutput, input);
    motorOutputTab.setDouble(input);
  }

  public double getEncoderOutput(){
    return hoodMotor.getSelectedSensorPosition();
  }
  
  public void setGains(double kP, double kI, double kD){
    hoodMotor.config_kP(0, kP);
    hoodMotor.config_kI(0, kI);
    hoodMotor.config_kD(0, kD);
  }
}
