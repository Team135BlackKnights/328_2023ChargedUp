package frc.robot.commands.Macros;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import com.kauailabs.navx.frc.*;

public class gyro extends CommandBase {
public tankDriveS drive;
boolean isFinished = false;
double currentAngle = 0.0;
double desired;
double speed;
double correction;
    public gyro(tankDriveS subsystem, double desiredAngle){
        drive = subsystem;
        desired = desiredAngle;
        addRequirements(subsystem);
    }
    @Override
    public void initialize(){
        System.out.print("initializing Balancer");
    }
    @Override
    public void execute(){
        System.out.print("Executing Balancer");
        currentAngle = drive.navx.getRoll(); //
        SmartDashboard.putNumber("current Angle", currentAngle);
        correction = desired-currentAngle;
        if (Math.abs(correction)>1){
            speed = correction*.1;
            drive.tankDrive(-speed,speed);
        } else {
        drive.tankDrive(0,0);
        isFinished = true;
        }
        }
    @Override
    public boolean isFinished(){
        return isFinished;
    }
}