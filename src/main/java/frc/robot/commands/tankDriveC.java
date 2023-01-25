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

double finefowardSpeed = RobotContainer.DriveControl.getPOV(0);
double finebackwardSpeed = RobotContainer.DriveControl.getPOV(180);
double fineleftSpeed = RobotContainer.DriveControl.getPOV(270);
double finerightSpeed = RobotContainer.DriveControl.getPOV(90);

if (RobotContainer.DriveControl.getPOV()!=-1) {
  drive.tankDrive(-leftSpeed*.5, rightSpeed*.5);
}

else {
  drive.tankDrive(-leftSpeed, rightSpeed);
}
  }

@Override
public void end(boolean interrupted) {
  drive.tankDrive(0, 0);
}
@Override
  public boolean isFinished() {
    return false;
  }
}
