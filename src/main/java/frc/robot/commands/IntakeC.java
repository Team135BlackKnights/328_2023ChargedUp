package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.intakeS;
public class IntakeC extends CommandBase {
    
    public final intakeS intake;
    boolean isFinished = false;
  double motorSpeedHandling  = .3;

    public IntakeC(intakeS subsystem) {
        intake = subsystem;
        addRequirements(subsystem);
    }
    public void initialize(){
      intakeS.IntakeEncoderReset();

      isFinished = false;
    }

    public void execute(){
      if (RobotContainer.ManipControl.getRawButtonPressed(0)) {
        //to grab cube
        while (intakeS.ManipLeftEncoder.getPosition() ) {
          
        }
      }
 
      if (RobotContainer.ManipControl.getRawButtonPressed(1)) {
      // to grab cone
      }
      if (RobotContainer.ManipControl.getRawButtonPressed(2)){
        //release
      }

}
}