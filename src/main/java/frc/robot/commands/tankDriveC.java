package frc.robot.commands;
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
  }
  @Override
  public void execute() {
  double x = tankDriveS.limelightNetworkTable.getEntry("tx").getDouble(0.0); 
  double y = tankDriveS.limelightNetworkTable.getEntry("ty").getDouble(0.0); 
  double area = tankDriveS.limelightNetworkTable.getEntry("ta").getDouble(0.0); 
    SmartDashboard.putNumber("x distance from target",x);
    SmartDashboard.putNumber("y distance from target",y);
    SmartDashboard.putNumber("target area",area);
    SmartDashboard.putNumber("y axis rotation", drive.navx.getRoll());
    SmartDashboard.putNumber("x axis rotation",drive.navx.getYaw());
    SmartDashboard.putNumber("z axis notation (what we're going to use for balance)", drive.navx.getPitch());
  
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
