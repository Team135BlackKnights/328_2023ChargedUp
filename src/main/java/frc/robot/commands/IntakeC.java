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
      SmartDashboard.putNumber("Left Claw:", intakeS.ManipLeftEncoder.getPosition());
      SmartDashboard.putNumber("Right Claw",intakeS.ManipRightEncoder.getPosition());

      if (RobotContainer.ManipControl.getRawButtonPressed(0) & holdSomething == false) {
        //to grab cube
        holdSomething = false;
        while (intakeS.ManipLeftEncoder.getPosition() == 30 ) {
          intake.LeftClaw.set(motorSpeedHandling);
          intake.RightClaw.set(-motorSpeedHandling);          

        }
      }
 
      if (RobotContainer.ManipControl.getRawButtonPressed(1) & holdSomething == false) {
      // to grab cone
      holdSomething = false;
      while (intakeS.ManipLeftEncoder.getPosition() == 60 ) {
        intake.LeftClaw.set(motorSpeedHandling);
        intake.RightClaw.set(-motorSpeedHandling);          

      }
      }
      if (RobotContainer.ManipControl.getRawButtonPressed(2) & holdSomething == true){
        //release
        while (intakeS.ManipLeftEncoder.getPosition() == 0) {
          intake.LeftClaw.set(-motorSpeedHandling);
          intake.RightClaw.set(motorSpeedHandling);
          
        }
        holdSomething = true;
      }
isFinished = true;
}
}