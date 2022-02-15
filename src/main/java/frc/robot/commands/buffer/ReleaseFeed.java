package frc.robot.commands.buffer;

import frc.robot.subsystems.Buffer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ReleaseFeed extends CommandBase {
  private final Buffer buffer;

  public ReleaseFeed(Buffer buffer) {
    this.buffer = buffer;

    addRequirements(this.buffer);
  }

  @Override
  public void execute() {
    this.buffer.set(-1);
  }

  @Override
  public void end(boolean interrupted) {
    this.buffer.stop();
  }

}
