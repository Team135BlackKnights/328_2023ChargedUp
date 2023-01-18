package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveRobot;

public class tankDriveC extends CommandBase{
    private final DriveRobot drive;

    public tankDriveC(DriveRobot subsystem) {
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
double leftSpeed = RobotContainer.XboxController.getLeftY();
double rightSpeed = RobotContainer.XboxController.getRightY();

   drive.tankDrive(-leftSpeed, rightSpeed);
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
