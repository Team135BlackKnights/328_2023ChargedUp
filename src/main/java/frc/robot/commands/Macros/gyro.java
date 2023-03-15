package frc.robot.commands.Macros;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;

public class gyro extends CommandBase {
public tankDriveS drive;
boolean isFinished = false;
public tankDriveS subsystem;
double gyroError = 0.0;
    public gyro(tankDriveS drive){
        drive = subsystem;
        addRequirements(subsystem);
        
    }
    public void initialize(){
        
        while(gyroError >= 358 && gyroError  <= 2){
            drive.tankDrive(-.7,.7);
            //error = gyroscope output, idk 
            SmartDashboard.putNumber("gyro alignment",gyroError);
        }
    }
    public void execute(){
        gyroError%= 30; //just so it won't output anything greater than 1, gyro should keep outputting a decimal that gets closer and closer to zero, which should allow us to slow down effectively.
        drive.tankDrive(-.5*gyroError, .5*gyroError);
            SmartDashboard.putNumber("gyro alignment",gyroError);
            
    }
}
