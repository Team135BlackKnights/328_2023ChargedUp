package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.intakeS;

public class IntakeC extends CommandBase {
    
    public final intakeS intake;
    boolean isFinished = false;
  double motorSpeedHandling  = .3;
boolean holdSomething = false; 
    public IntakeC(intakeS subsystem) {
        intake = subsystem;
        addRequirements(subsystem);
    }
    public void initialize(){
      intakeS.IntakeEncoderReset();

      isFinished = false;
      holdSomething = false;
    }

    public void execute(){
      SmartDashboard.putBoolean("Holding Something:", holdSomething);

      if (RobotContainer.ManipControl.getAButton() & holdSomething == false) {
        holdSomething = false;
        while (intakeS.ManipUpEncoder.getPosition() == 30 ) {
        intake.InAndOut.set(motorSpeedHandling);
        }
      }
 
      if (RobotContainer.ManipControl.getAButton() & holdSomething == false) {
      holdSomething = false;
      while (intakeS.ManipUpEncoder.getPosition() == 60 ) {
        intake.InAndOut.set(motorSpeedHandling);       

      } 
      }
      if (RobotContainer.ManipControl.getAButton() & holdSomething == true){
        while (intakeS.ManipUpEncoder.getPosition() == 0) {
          intake.InAndOut.set(motorSpeedHandling);
          
        }
        holdSomething = true;
      }

      if (RobotContainer.DriveControl.getRightBumperPressed() == true) { 
          intake.LeftWheels.set(0.5);
          intake.RightWheels.set(-0.5);
      }
      else if (RobotContainer.DriveControl.getLeftBumperPressed() == true) { 
        intake.LeftWheels.set(-0.5);
        intake.RightWheels.set(0.5);
      }
      else { 
        intake.LeftWheels.set(0);
        intake.RightWheels.set(0);
      }

isFinished = true;
}
}