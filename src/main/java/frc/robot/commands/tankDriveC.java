package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotContainer;
import frc.robot.subsystems.tankDriveS;

public class tankDriveC extends CommandBase{
    private final tankDriveS drive;

    public tankDriveC(tankDriveS subsystem) {
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
double leftSpeed = robotContainer.DriveControl.getLeftY();
double rightSpeed = robotContainer.DriveControl.getRightY();

if (robotContainer.DriveControl.getPOV() == 0) {
  drive.tankDrive(-0.7, 0.7);
}
else if (robotContainer.DriveControl.getPOV() == 90) {
  drive.tankDrive(-0.5, -0.5);
}
else if (robotContainer.DriveControl.getPOV() == 270) {
  drive.tankDrive(0.5, 0.5);
}
else {
  drive.tankDrive(-leftSpeed, rightSpeed);
}
SmartDashboard.putNumber("Left Motor",leftSpeed);
SmartDashboard.putNumber("Right Motor", rightSpeed);
}
 

@Override
  public boolean isFinished() {
    return false;
  }
}
