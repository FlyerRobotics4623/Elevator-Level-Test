// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
 
  private final SparkMax m_eleLeft = new SparkMax(2, MotorType.kBrushless);
  private final SparkMax m_eleRight = new SparkMax(3, MotorType.kBrushless);
  private final RelativeEncoder m_LEncoder = m_eleLeft.getEncoder();
  SparkMaxConfig eleLeftConfig = new SparkMaxConfig();
  SparkMaxConfig eleRightConfig = new SparkMaxConfig();

  /** Creates a new ExampleSubsystem. */
 public ElevatorSubsystem() {
     m_LEncoder.setPosition(0);
     eleLeftConfig.inverted(false);
     eleRightConfig.inverted(true).follow(m_eleLeft);
   
  }

  
 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double eleTravel(){
     double eleTicks = m_LEncoder.getPosition();
     return eleTicks;
  }

  public void setMotor(double Speed){
    m_eleLeft.set(Speed);
    m_eleRight.set(Speed);
    m_LEncoder.getPosition();
    SmartDashboard.putNumber("Relative Encoder Value in Revolutions", m_LEncoder.getPosition());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
