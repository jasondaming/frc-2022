package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {
  private final TalonSRX motor;

  public Shooter() {
    this.motor = new TalonSRX(Constants.ShooterConstants.motorPort);
    this.motor.setInverted(ShooterConstants.isInverted);
  }

  public void set(double speed){
    this.motor.set(ControlMode.PercentOutput, speed);
  }

  public void stop(){
    this.motor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
   
  }
}