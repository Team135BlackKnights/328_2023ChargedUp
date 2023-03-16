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

    drive.frontLeft.setIdleMode(IdleMode.kCoast);
    drive.frontRight.setIdleMode(IdleMode.kCoast);
    drive.backLeft.setIdleMode(IdleMode.kCoast);
    drive.backRight.setIdleMode(IdleMode.kCoast);
  }
  @Override
  public void execute() {

    SmartDashboard.putNumber("x", (drive.gyro.getAngle()%360));
  
double leftSpeed = robotContainer.DriveControl.getLeftY();
double rightSpeed = robotContainer.DriveControl.getRightY();
  
    double speedMod;
  if (robotContainer.DriveControl.getLeftBumper()){
    
    speedMod = .4;
  }

  else{/*if (robotContainer.DriveControl.getLeftBumper() == false){ */
    speedMod = 1;
  }
SmartDashboard.putNumber("Left Motor",-leftSpeed*speedMod);
SmartDashboard.putNumber("Right Motor", rightSpeed*speedMod);
drive.tankDrive(-leftSpeed*speedMod,rightSpeed*speedMod);
}
 

@Override
  public boolean isFinished() {
    return false;
  }
}
