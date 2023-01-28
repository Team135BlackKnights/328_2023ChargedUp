package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakeS;
public class IntakeC extends CommandBase {
    
    public final intakeS intake;
    boolean isFinished = false;

    public IntakeC(intakeS subsystem) {
        intake = subsystem;
        addRequirements(subsystem);
    }
    

 public void execute() {        
  
    if (intakeS.Solenoid1.get() == Value.kForward ){
        intakeS.Solenoid1.set(Value.kReverse);
      } else if (intakeS.Solenoid1.get() == Value.kReverse) {
        intakeS.Solenoid1.set(Value.kForward);
      } else {
        intakeS.Solenoid1.set(Value.kReverse);
      }


      if (intakeS.Solenoid2.get() == Value.kForward ){
        intakeS.Solenoid2.set(Value.kReverse);
      } else if (intakeS.Solenoid2.get() == Value.kReverse) {
        intakeS.Solenoid2.set(Value.kForward);
      } else {
        intakeS.Solenoid2.set(Value.kReverse);
      }
      isFinished = true;


}
}
