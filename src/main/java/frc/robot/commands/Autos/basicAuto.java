package frc.robot.commands.Autos;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class basicAuto extends CommandBase {
long timeStart;
double seconds;
boolean isFinished;
double autoSpeed;
    public final tankDriveS drive;
    Timer timeElapsed= new Timer();
    public basicAuto(tankDriveS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        drive = subsystem;
        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
        
    }
    @Override
    public void initialize(){
        System.out.print("Running basicAuto...");
    timeElapsed.start();
    isFinished = false;
    }
    @Override
    public void execute() {

        if (timeElapsed.get() <= seconds) {
            
            drive.tankDrive(-autoSpeed, autoSpeed);
            
        } else{
            isFinished = true;
        }
        
    }
    @Override
    public void end(boolean interrupted) {
        drive.tankDrive(0,0);
        drive.runStop();
        timeElapsed.stop();
        timeElapsed.reset();

    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
