package frc.robot.commands.Macros;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import com.kauailabs.navx.frc.*;

public class gyro extends CommandBase {
public tankDriveS drive;
boolean isFinished = false;
public tankDriveS subsystem;
double currentAngle = 0.0;
double desired;
    public gyro(tankDriveS drive){
        drive = subsystem;
        addRequirements(subsystem);
    }
    @Override
    public void initialize(double desiredAngle){
        desired = desiredAngle;
        System.out.print("initializing Balancer");
        /*while(gyroError >= 358 && gyroError  <= 2){
            gyroError = drive.navx.getPitch();
            gyroError = gyroError%360;
            drive.tankDrive(-.7,.7);
            SmartDashboard.putNumber("gyro alignment",gyroError);
        }
        */
    }
    @Override
    public void execute(){
        System.out.print("Executing Balancer");
        currentAngle = drive.navx.getPitch(); //
        SmartDashboard.putNumber("current Angle", currentAngle);
        correction = desired-currentAngle;
        if (Math.abs(correction)>.5){
            speed = correction*.1;
            drive.tankDrive(-speed,speed);
        }else{
        drive.tankDrive(0,0);
        isFinished = true;
        }
        }
    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
