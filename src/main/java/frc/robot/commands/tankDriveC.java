package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.robotContainer;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.networktables.NetworkTableInstance;
public class tankDriveC extends CommandBase{
    private final tankDriveS drive;
    double distance;
    Integer targetType = 0;
    Integer pipe=1;
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
    if (robotContainer.DriveControl.getYButtonPressed()){
      targetType+=1;
      targetType= targetType%2;
    }
    (tankDriveS.limelightNetworkTable.getEntry("pipeline")).setNumber(targetType);
  double x = tankDriveS.limelightNetworkTable.getEntry("tx").getDouble(0.0); 
  double y = tankDriveS.limelightNetworkTable.getEntry("ty").getDouble(0.0); 
  double area = tankDriveS.limelightNetworkTable.getEntry("ta").getDouble(0.0);
  SmartDashboard.putNumber("autoPitch", drive.navx.getPitch());
  SmartDashboard.putNumber("autoRoll",drive.navx.getRoll());
  SmartDashboard.putNumber("autoAngle",drive.navx.getAngle());

    SmartDashboard.putNumber("target area",area);
  //  SmartDashboard.putNumber("y axis rotation", drive.navx.getRoll());
  //  SmartDashboard.putNumber("x axis rotation",drive.navx.getYaw());
    //SmartDashboard.putNumber("z axis notation (what we're going to use for balance)", drive.navx.getPitch());
  
double leftSpeed = robotContainer.DriveControl.getLeftY();
double rightSpeed = robotContainer.DriveControl.getRightY();
  
    double speedMod;
  if (robotContainer.DriveControl.getLeftBumper()){
    
    speedMod = .4;
  }

  else{/*if (robotContainer.DriveControl.getLeftBumper() == false){ */
    speedMod = 1;
  }
  if (robotContainer.DriveControl.getYButton() == true){
    if (pipe==0){
      pipe=1;
    }else{
      pipe=0;
    }
    /* pipe += 1%2 */
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(pipe);
  }
drive.tankDrive(-leftSpeed*speedMod,rightSpeed*speedMod);
distance = Math.sqrt(x*x+y*y);
robotContainer.DriveControl.setRumble(RumbleType.kBothRumble, area*2);}//the two makes it vibrate more




 

@Override
  public boolean isFinished() {
    return false;
  }
}
