// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAlternateEncoder.Type;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Drivebase() {}

  private final int diamater = 100;

  //className objectName = new classConstructor(arguments);

  CANSparkMax m_leftMotor = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax m_rightMotor = new CANSparkMax(2, MotorType.kBrushless);

  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  RelativeEncoder m_leftEncoder = m_leftMotor.getAlternateEncoder(Type.kQuadrature, 20);
  RelativeEncoder m_rightEncoder = m_rightMotor.getAlternateEncoder(Type.kQuadrature, 20);

  public void arcadeDrive(double forwardOrBackwardSpeed, double turnSpeed){
    //objectName.methodName(arguments);
    m_drive.arcadeDrive(forwardOrBackwardSpeed, turnSpeed);
  }

  public void resetEncoders(){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public double getLeftDistanceInch(){
    return (m_leftEncoder.getPosition() * diamater * Math.PI);
  }

  public double getRightDistanceInch(){
    return (m_rightEncoder.getPosition() * diamater * Math.PI);
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
