package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;

public class autoBalancing extends CommandBase {
public tankDriveS drive;
boolean isFinished = false;
public tankDriveS subsystem;
double error = 0.0;
    public autoBalancing(tankDriveS drive){
        drive = subsystem;
        addRequirements(subsystem);

    }
    public void initialize(){
        while(error >= 358 && error  <= 2){
            drive.tankDrive(-.7,.7);
            //error = gyroscope output, idk 
            SmartDashboard.putNumber("gyro alignment",error);
        }
    }
    public void execute(){

    }
}
