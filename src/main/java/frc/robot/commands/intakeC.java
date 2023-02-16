package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.robotContainer;
import frc.robot.robotMap;
import frc.robot.subsystems.intakeS;

public class intakeC extends CommandBase {
    
    public final intakeS intake;
    // a boolean is a true false statement
    boolean isFinished = false;
  double motorSpeedHandling  = .2;
boolean holdSomething = false; 
    public intakeC(intakeS subsystem) {
        intake = subsystem;
        addRequirements(subsystem);
    }
    public void initialize(){
      intakeS.intakeEncoderReset();

      isFinished = false;
      
    }

    public void execute(){
  
      if (robotContainer.ManipControl.getAButton() == true) {
        //while (intakeS.ManipUpEncoder.getPosition() != 30/42 ) {
        //intake.inAndOut.set(motorSpeedHandling);
        //closes the arms to a 30 degree angle
        intake.inAndOut.set(-motorSpeedHandling);
        
      }
 
      else if (robotContainer.ManipControl.getBButton() == true) {
      //holdSomething = false;
     // while (intakeS.ManipUpEncoder.getPosition() != 60/42 ) {
        //intake.inAndOut.set(motorSpeedHandling); 
             //closes the arms to a 60 degree angle
             intake.inAndOut.set(motorSpeedHandling);
      
     }
      else {
        intake.inAndOut.set(0);
      }

      if (robotContainer.ManipControl.getRightBumper() == true) { 
          intake.leftWheels.set(0.5);
          intake.rightWheels.set(-0.5);
          //Takes stuff in with wheels
      }
      else if (robotContainer.ManipControl.getLeftBumper() == true) { 
        intake.leftWheels.set(-0.5);
        intake.rightWheels.set(0.5);
        //Pushes things out with wheels
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