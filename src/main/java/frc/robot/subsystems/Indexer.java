// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

public class Indexer extends SubsystemBase {
  private ColorSensorV3 colorSensor;
  private VictorSPX indexerMotor;
  private DigitalInput beambreakEntry;
  private DigitalInput beambreakExit;
  private ShuffleboardTab indexerTab = Shuffleboard.getTab("Indexer");
  private NetworkTableEntry beambreakEnter = indexerTab.add("beamBreakEntry", false).getEntry();
  private NetworkTableEntry beambreakExits = indexerTab.add("beamBreakExits", false).getEntry();
  private NetworkTableEntry colourSensor = indexerTab.add("colourSensor", 0).getEntry();
  /** Creates a new Indexer. */
  public Indexer() {
    colorSensor = new ColorSensorV3(I2C.Port.kMXP);
    indexerMotor = new VictorSPX(16);
    beambreakEntry = new DigitalInput(1);
    beambreakExit = new DigitalInput(0);
  }

  public void runIndexer(double indexSpeed){
    indexerMotor.set(VictorSPXControlMode.PercentOutput, indexSpeed);
  }

  public boolean getEntryBeamBreak(){
    return beambreakEntry.get();
  }
  public boolean getExitBeamBreak(){
    return beambreakExit.get();
  }


  @Override
  public void periodic() {
    beambreakEnter.setBoolean(beambreakEntry.get());
    beambreakExits.setBoolean(beambreakExit.get());
    colourSensor.setDouble(colorSensor.getRed());
  }

  public void setPower(double input){
    indexerMotor.set(VictorSPXControlMode.PercentOutput, input);
  }
}
