package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.robotContainer;
import frc.robot.subsystems.intakeS;

public class intakeC extends CommandBase {
    
    public final intakeS intake;
    // a boolean is a true false statement
    boolean isFinished = false;
  double motorSpeedHandling  = .1;
boolean holdSomething = false; 
    public intakeC(intakeS subsystem) {
        intake = subsystem;
        addRequirements(subsystem);
    }
    public void initialize(){

      isFinished = false;
      
    }

    public void execute(){
      //Puts number for the associated key
      SmartDashboard.putNumber("in and out value", intakeS.inAndOutEncoder.getPosition());
<<<<<<< HEAD
      SmartDashboard.putNumber("claw current", intake.inAndOut.getOutputCurrent());
      SmartDashboard.putNumber("left wheels current", intake.leftWheels.getOutputCurrent());
      SmartDashboard.putNumber("right wheels current", intake.rightWheels.getOutputCurrent());
      //
=======
      
>>>>>>> 2bbd180a4948b2551e3443da1bda153b7e2c6977
      
       if (robotContainer.ManipControl.getAButton() == true) {
        //while (intakeS.ManipUpEncoder.getPosition() != 30/42 ) {
        //intake.inAndOut.set(motorSpeedHandling);
        //closes the arms to a 30 degree angle
          intake.intakeMoveIn(-motorSpeedHandling);
      }
 
      else if (robotContainer.ManipControl.getBButton() == true) {
      //holdSomething = false;
     // while (intakeS.ManipUpEncoder.getPosition() != 60/42 ) {
        //intake.inAndOut.set(motorSpeedHandling); 
             //closes the arms to a 60 degree angle
             if (intakeS.inAndOutEncoder.getPosition()<5){
              intake.intakeMoveOut(motorSpeedHandling);
             }            
     }
      else {
        intake.intakeStop();
      }

      if (robotContainer.ManipControl.getRightBumper() == true) { 
          intake.leftWheels.set(0.5);
          intake.rightWheels.set(-0.5);
          //Takes stuff in with wheels
      }
      else if (robotContainer.ManipControl.getLeftBumper() == true) { 
        intake.leftWheels.set(-0.328);
        intake.rightWheels.set(0.328);
        //Pushes things out with wheels
      }
      else if (robotContainer.ManipControl.getRightTriggerAxis() >= .69){
        intake.leftWheels.set(1.0);
       intake.rightWheels.set(-1.0);
        //Pushes faster
      }
        
      else { 
        intake.leftWheels.set(0);
        intake.rightWheels.set(0);
      }
isFinished = true;
}
@Override
public boolean isFinished(){
  return false;
}
}