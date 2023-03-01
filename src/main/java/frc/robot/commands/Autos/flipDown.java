package frc.robot.commands.Autos;
<<<<<<< Updated upstream

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.liftS;


public class flipDown extends CommandBase {
    
    public final liftS Drop;

    public flipDown(liftS subsystem){
        Drop = subsystem;
        addRequirements(subsystem);
    }   
    @Override
    public void initialize() {
        System.out.println("initializing flipDown");
    }
    public void execute() {
        System.out.println("running flipDown");
        if(Drop.flipMotorEncoder.getPosition() == 300 ) {
            Drop.moveLift(0.3);
        }
        else{
            end();
        }
    } 
    public void end() {
        Drop.moveLift(0.0);
    }
}

=======
import frc.robot.subsystems.intakeS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax.IdleMode;
import frc.robot.subsystems.liftS;

public class flipDown extends CommandBase {
double seconds;
double autoSpeed;
boolean isFinished;
    public final intakeS intake;
    public final liftS lift;
    Timer timeElapsed= new Timer();
    public flipDown(liftS liftS,intakeS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        intake = subsystem;
        lift = liftS;
        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
        
    }
    @Override
    public void initialize(){
        System.out.print("initializing flipDown");
    timeElapsed.start();
    isFinished = false;
    }
    @Override
    public void execute() {
        System.out.print("Running flipDown...");
        while (timeElapsed.get() <= seconds) {
            
           lift.moveLift(autoSpeed);
            
        }
        lift.flipMotor.setIdleMode(IdleMode.kCoast);
         isFinished = true;
         
        
        
    }
    @Override
    public void end(boolean interrupted) {
        lift.moveLift(0);
        timeElapsed.stop();
        timeElapsed.reset();
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
>>>>>>> Stashed changes
