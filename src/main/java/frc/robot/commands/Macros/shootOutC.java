package frc.robot.commands.Macros;
import frc.robot.subsystems.intakeS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.tankDriveS;

public class shootOutC extends CommandBase {
double seconds;
double autoSpeed;
    public final intakeS intake;
    public final tankDriveS drive;
    Timer timeElapsed= new Timer();
    boolean isFinished;
    public shootOutC(tankDriveS subsystem2DriveS,intakeS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        //when using the word "seconds" you are refering to the desired time
        intake = subsystem;
        //when uing the word "intake" you are mentioning the subsystem intakeS
        drive = subsystem2DriveS;
        //when using the word "drive" you are refering to the subsytem tankDriveS
        autoSpeed = MotorSpeed;
        //when using the word "autoSpeed" you're refering to the motor speed
        addRequirements(subsystem);
    }
    @Override 
    public void initialize(){
        System.out.print("intializing shootOut...");
    intakeS.intakeEncoderReset();
    //this resets the encoder(a thing used to show how much a motor has moved)
    timeElapsed.start();
    //starts a timer 
    isFinished = false;
    }
    @Override
    public void execute() {
        System.out.print("Running shootOut...");
        if (timeElapsed.get() <= seconds) {
            //if the time elapsed is less than the time desired the robot shoots a cube if not the robot doesn't shoot anything
            intake.leftWheels.set(autoSpeed);
            intake.rightWheels.set(-autoSpeed);
        } else {
            isFinished = true;
        }

        
    }
    @Override
    public void end(boolean interrupted) {
        intake.rightWheels.set(0);
        intake.leftWheels.set(0);
        //stops the robot from moving
        timeElapsed.stop();
        //stops timer
        timeElapsed.reset();
        //resets the timer
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
