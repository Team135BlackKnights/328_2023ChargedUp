package frc.robot.commands.Autos;
import frc.robot.subsystems.intakeS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class shootOut extends CommandBase {
    public final intakeS intake;
    double autoSpeed;
    double timeRan;
    Timer timeRunning = new Timer();
    public  shootOut(intakeS subsystem, double MotorSpeed, double timeRan ){

        intake = subsystem;
    
        addRequirements(subsystem);
        
    }
    public void initialize(){
        System.out.print("Running shootOut...");
    }
    public void execute(double timeRan, double motorSpeed) {

        if (timeRunning.get() <= timeRan) {
            intake.leftWheels.set(motorSpeed);
            intake.rightWheels.set(-motorSpeed);
            
        }
        
    }
    public void end() {
        intake.rightWheels.set(0);
        intake.leftWheels.set(0);
    }
}

