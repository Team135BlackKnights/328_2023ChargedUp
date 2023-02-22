package frc.robot.commands.Autos;
import frc.robot.subsystems.intakeS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.tankDriveS;

public class shootOutC extends CommandBase {
double seconds;
double autoSpeed;
boolean isFinished;
    public final intakeS intake;
    public final tankDriveS drive;
    Timer timeElapsed= new Timer();
    public shootOutC(tankDriveS subsystem2DriveS,intakeS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        intake = subsystem;
        drive = subsystem2DriveS;
        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
        
    }
    @Override
    public void initialize(){
        System.out.print("intializing shootOut...");
    timeElapsed.start();
    isFinished = false;
    }
    @Override
    public void execute() {
        System.out.print("Running shootOut...");
        if (timeElapsed.get() <= seconds) {
            
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
        timeElapsed.stop();
        timeElapsed.reset();
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
