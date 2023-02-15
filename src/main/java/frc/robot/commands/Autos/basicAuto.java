package frc.robot.commands.Autos;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class basicAuto extends CommandBase {
long timeStart;
double seconds;
double autoSpeed;
    public final tankDriveS drive;
    Timer timeElapsed= new Timer();
    public basicAuto(tankDriveS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        drive = subsystem;
        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
        
    }
    public void initialize(){
        System.out.print("Running basicAuto...");
    timeElapsed.start();
    }
    public void execute() {

        if (timeElapsed.get() <= seconds) {
            
            drive.tankDrive(-autoSpeed*1.0375,autoSpeed);
            
        }
    
        
    }
    public void end() {
        drive.tankDrive(0,0);
        drive.runStop();
    }
}
