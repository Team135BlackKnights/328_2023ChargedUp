package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.TankDriveS;

public class TankDriveC extends CommandBase{
    private final TankDriveS drive;

    public TankDriveC(TankDriveS subsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        drive = subsystem;
        addRequirements(subsystem);
      }
      @Override
  public void initialize() {
    // drive.navx.calibrate();
    drive.FrontLeft.setIdleMode(IdleMode.kCoast);
    drive.FrontRight.setIdleMode(IdleMode.kCoast);
    drive.BackLeft.setIdleMode(IdleMode.kCoast);
    drive.BackRight.setIdleMode(IdleMode.kCoast);
  }
  @Override
  public void execute() {
double leftSpeed = RobotContainer.DriveControl.getLeftY();
double rightSpeed = RobotContainer.DriveControl.getRightY();

if (RobotContainer.DriveControl.getPOV() == 0) {
  drive.tankDrive(-0.7, 0.7);
}
else if (RobotContainer.DriveControl.getPOV() == 90) {
  drive.tankDrive(-0.5, -0.5);
}
else if (RobotContainer.DriveControl.getPOV() == 270) {
  drive.tankDrive(0.5, 0.5);
}
else {
  drive.tankDrive(-leftSpeed, rightSpeed);
}
  }
@Override
  public boolean isFinished() {
    return false;
  }
}
