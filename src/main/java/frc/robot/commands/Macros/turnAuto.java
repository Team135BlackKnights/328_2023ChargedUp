package frc.robot.commands.Macros;
import frc.robot.subsystems.tankDriveS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class turnAuto extends CommandBase {
long timeStart;
double seconds;
double autoSpeed;
    public final tankDriveS drive;
    Timer timeElapsed= new Timer();
    public turnAuto(tankDriveS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        drive = subsystem;
         //when you use the word "drive" you are refering to the subsystem tankDriveS
        autoSpeed = MotorSpeed;
         //when using the word "autoSpeed" you are refering to the motor speed
        addRequirements(subsystem);
        
    }
    public void initialize(){
        System.out.print("Running turnAuto...");
    timeElapsed.start();
    }
    public void execute() {

        if (timeElapsed.get() <= seconds) {
            //if time elapsed is less than the desired time then it turns 
            drive.tankDrive(autoSpeed,autoSpeed);
            
        }
    }
    public void end() {
        drive.tankDrive(0,0);
        //stops the robot
        drive.runStop();
        timeElapsed.stop();
        //stops the timer
        timeElapsed.reset();
        //resets the timer

    }
    }

