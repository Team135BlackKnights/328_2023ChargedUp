package frc.robot.commands.Macros;
import frc.robot.subsystems.intakeS;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax.IdleMode;
import frc.robot.subsystems.liftS;

public class manipMove extends CommandBase {
double seconds;
double autoSpeed;
boolean flip;
boolean isFinished;
    public final intakeS intake;
    public final liftS lift;
    
    Timer timeElapsed= new Timer();
    public manipMove(liftS liftS,intakeS subsystem, double desiredTime, double MotorSpeed ){
        seconds = desiredTime;
        intake = subsystem;
        lift = liftS;
        autoSpeed = MotorSpeed;
        addRequirements(subsystem);
        
    }
    @Override
    public void initialize(){
        System.out.print("initializing flipDown");
    lift.resetEncoders();
    timeElapsed.start();
    if(autoSpeed<0){
        flip=true;
    }else{
        flip=false;
    }
    isFinished = false;    
    }
    @Override
    public void execute() {
        System.out.print("Running flipDown...");
        if (flip==true){
            while (lift.flipMotorEncoder.getPosition()<0) { 
            
                lift.moveLiftUp(autoSpeed);
                 
             }
        }else{
            while (lift.flipMotorEncoder.getPosition()<40) { 
            
                lift.moveLiftDown(autoSpeed);
                 
             }
        }
        
        lift.flipMotor.setIdleMode(IdleMode.kCoast);
         isFinished = true;
         
        
        
    }
    @Override
    public void end(boolean interrupted) {
        lift.stopLift();
        timeElapsed.stop();
        timeElapsed.reset();
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
