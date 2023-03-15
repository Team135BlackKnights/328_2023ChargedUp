package frc.robot.commands.Macros;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;

public class gyroBalanceAuto extends CommandBase {
public tankDriveS drive;
boolean isFinished = false;
public tankDriveS subsystem;
double error = 0.0;
    public gyroBalanceAuto(tankDriveS drive){
        //standard initialization of command in constructor. Basically when run makes subsystem readable by commands.
        drive = subsystem;
        addRequirements(subsystem);

    }
    public void initialize(){
        // please add gyro (we havent gotten it in yet, but we're just going to take the "y" axis as error)
        while(error >= 358 && error  <= 2){
            //error = gyroscope output, we'll compensate for that (put) 
            //goes straight while it's within a degree of 358~2 just to allocate of if a field is SLIGHTLY slanted
            
            drive.tankDrive(-.7,.7);

            SmartDashboard.putNumber("gyro alignment",error);
        }
    }
    public void execute(){
        
    }
}
