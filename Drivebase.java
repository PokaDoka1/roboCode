// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.SparkMaxAlternateEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private final int diamater = 1000; 

  CANSparkMax m_leftMotor = new CANSparkMax(0, MotorType.kBrushed);
  CANSparkMax m_rightMotor = new CANSparkMax(3, MotorType.kBrushed);

  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  public Drivebase() {
    m_leftMotor.setInverted(true);

    SparkMaxAlternateEncoder m_leftEncoder = m_leftMotor.getAlternateEncoder​(Type.kQuadrature, 20);
    SparkMaxAlternateEncoder m_rightEncoder = m_rightMotor.getAlternateEncoder​(Type.kQuadrature, 20);  
  }

  public void arcadeDrive(double xSpeed, double rotationSpeed){
    m_drive.arcadeDrive(xSpeed, rotationSpeed);
  }

  public void resetEncoders(double xSpeed, double rotationSpeed){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public double getLeftDistanceInch(){
    return m_leftEncoder.getPosition() * diameter * Math.PI;
  }

  public double getRightDistanceInch(){
    return m_rightEncoder.getPosition() * diameter * Math.PI;
  }

  public double getDistanceInch(SparkMaxAlternateEncoder encoder){
    return encoder.getPosition() * diameter * Math.PI;
  }

  public void getAverageDistanceInch(){
    ((getLeftDistanceInch() + getRightDistanceInch()) /2 ) * diameter * Math.PI;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
