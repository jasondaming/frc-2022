package frc.robot.commands.autonsEncoder;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.Arcade;

public class DriveReverseEncoders extends CommandBase {

  private static final double DECREASE_SPEED_RATE = 0.01;
  private static final double MINIMUM_SPEED = 0.25;
  private static final double ONE_METER = 1.0;

  private final Drivetrain drivetrain;
  private double meters;
  private double speed;

  public DriveReverseEncoders(double meters, double speed, Drivetrain drivetrain) {
    this.meters = meters;
    this.speed = negate(speed);
    this.drivetrain = drivetrain;

    addRequirements(this.drivetrain);
  }

  @Override
  public void initialize() {
    this.drivetrain.reset();
  }

  @Override
  public void execute() {
    if (this.isNearEnd()) {
      var speedNearEnd =  this.isSpeedAtMinimum() ? this.keep() : this.decrease();

      this.drivetrain.arcadeDrive(speedNearEnd, Arcade.noRotation());
    } else {
      this.drivetrain.arcadeDrive(this.speed, Arcade.noRotation());
    }
  }

  private boolean isNearEnd() {
    return abs(this.drivetrain.getAverageDistance()) + ONE_METER > this.meters;
  }

  private boolean isSpeedAtMinimum() {
    return this.speed >= negate(MINIMUM_SPEED);
  }

  private double keep() {
    return this.speed;
  }

  private double decrease() {
    return this.speed -= negate(DECREASE_SPEED_RATE);
  }

  @Override
  public void end(boolean interrupted) {
    this.drivetrain.arcadeDrive(Arcade.stop(), Arcade.noRotation());
    this.drivetrain.reset();
  }

  @Override
  public boolean isFinished() {
    return abs(this.drivetrain.getAverageDistance()) > this.meters;
  }

  private double abs(double value) {
    return Math.abs(value);
  }

  private double negate(double value) {
    return -value;
  }
}