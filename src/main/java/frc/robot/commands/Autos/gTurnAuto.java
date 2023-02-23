package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.Timer;

public class gTurnAuto extends CommandBase {
    
    public final tankDriveS drive;
    double neededTime;
    public gTurnAuto(tankDriveS subsystem, double timeExpected){
        drive = subsystem;
        addRequirements(subsystem);
        neededTime = timeExpected;
    }   
    @Override
    public void initialize() {
        System.out.println("initializing TurnAuto");
        Timer timeElapsed = new Timer();
      timeElapsed.start();
        
    }
    public void execute( Timer timeElapsed) {
        System.out.println("running TurnAuto");
        if(timeElapsed.get() >= neededTime) {
            drive.tankDrive(0.4,0.4);
        }
        else{
            end();
        }
    } 
    public void end() {
        drive.tankDrive(0,0);
    }
}
