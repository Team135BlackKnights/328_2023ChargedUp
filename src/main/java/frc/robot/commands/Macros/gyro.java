package frc.robot.commands.Macros;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import com.kauailabs.navx.frc.*;

public class gyro extends CommandBase {
public tankDriveS drive;
boolean isFinished = false;
public tankDriveS subsystem;
double gyroError = 0.0;
    public gyro(tankDriveS drive){
        drive = subsystem;
        addRequirements(subsystem);
    }
    @Override
    public void initialize(){
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
        gyroError = drive.navx.getPitch();
        SmartDashboard.putNumber(("gyro raw"),gyroError);
        gyroError = gyroError%360;
        if (gyroError >358 && gyroError<2){
        gyroError%= 30; //this is a modulus function same call as python solely exists just so it won't output anything greater than 1, gyro should keep outputting a decimal that gets closer and closer to zero, which should allow us to slow down effectively.
        drive.tankDrive(-.5*gyroError, .5*gyroError);
            SmartDashboard.putNumber("gyro alignment",gyroError);
        }else{
        drive.tankDrive(0,0);
        isFinished = true;
        }
    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
