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
        //when refering to desired time you can also say "seconds"
        intake = subsystem;
        //when saying intake you are refering to the subsystem intakeS
        lift = liftS;
        //when saying the word lift you are refering  to the subsystem liftS
        autoSpeed = MotorSpeed;
        //when saying the word "autoSpeed" you are refering to the motor Speed
        addRequirements(subsystem);
        
    }
    @Override
    public void initialize(){
        System.out.print("initializing flipDown");
    lift.resetEncoders();
    //resets the encoders so that they can be ready when the match starts
    timeElapsed.start();
    //starts a timer
    if(autoSpeed<0){
        flip=true;
        //if the motor speed is less than 0 the manipulator will stay up
    }else{
        flip=false;
        //if the motor speed is more than 0 the manipulator will be down
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
            while (lift.flipMotorEncoder.getPosition()<27) { 
            
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
