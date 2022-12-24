// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*`Trash Trek Problem

Subsystems: 
A one-motor NEO CANSparkMax elevator is used with system height constraints of 
0 to 1000. One limit switch(to set max height constraint) is attached to 
the data port of the motor controller and one Rev throughbore encoder 
is attached to the encoder port of the motor controller. 
Use soft limits(setting physical limit with the use of an encoder) 
to set the minimum height constraint. (Rev has a class for soft limits)


Elevator:
Initialize the encoder position at 0 within the class constructor . 

Create a method using a PID Controller(P = 1, I = 0.1, D = 0.1) where the setpoint is the desired elevator height(a parameter) and the measured value is from the encoder, use a limit switches and soft limits to set the height constraint.

Display in Smartdashboard of the state of the limit switch (boolean).
Display in Smartdashboard the height of the elevator measured by the encoder.


Command:
Tele-Op:

Create a command that set the elevator to the max height up when the y button is pressed/toggled.

Create a command that set the elevator at the middle(h = 500) when the x button is pressed/toggled.

Create a command that set the elevator at the minimum height when the b button is pressed/toggled.

Auto:
Create a command to drive forward for 3 seconds 
 */
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Drivebase() {}

  CANSparkMax m_leftMaster = new CANSparkMax(0, MotorType.kBrushed);
  CANSparkMax m_leftSlave = new CANSparkMax(0, MotorType.kBrushed);

  CANSparkMax m_rightMaster = new CANSparkMax(0, MotorType.kBrushed);
  CANSparkMax m_rightSlave = new CANSparkMax(0, MotorType.kBrushed);

  DifferentialDrive m_drive = new DifferentialDrive(m_leftMaster, m_rightMaster);


  public void arcadeDrive(double xSpeed, double zAxisSpeed){
    m_drive.arcadeDrive(xSpeed, zAxisSpeed);
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
