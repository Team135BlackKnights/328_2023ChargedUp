package frc.robot.commands.Macros;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class forwardDriveAuto extends CommandBase {
long timeStart;
double seconds;
double autoSpeed;
    public final tankDriveS drive;
    Timer timeElapsed= new Timer();
    public forwardDriveAuto(tankDriveS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        drive = subsystem;
        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
        
    }
    public void initialize(){
        System.out.print("Running forwardDriveAuto...");
    timeElapsed.start();
    }
    public void execute() {

        if (timeElapsed.get() <= seconds) {
            
            drive.tankDrive((-autoSpeed-.01), autoSpeed);
            
        }
    }
    public void end() {
        drive.tankDrive(0,0);
        drive.runStop();
        timeElapsed.stop();
        timeElapsed.reset();

    }
    }

