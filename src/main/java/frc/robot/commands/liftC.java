package frc.robot.commands;
import frc.robot.subsystems.liftS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.robotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class liftC extends CommandBase {
    public final liftS lift;
    public liftC(liftS subsystem){
        lift = subsystem;
    addRequirements(subsystem);
}
public void initialize() {
    
}
public void execute(){
SmartDashboard.putNumber("lift encoder value", lift.flipMotorEncoder.getPosition());
if (robotContainer.ManipControl.getXButton()) {
   // while (robotContainer.ManipControl.getYButton() == true){
        lift.moveLift(-0.7);
   }
    //}
    // }
else if (robotContainer.ManipControl.getYButton()) {
   // while (robotContainer.ManipControl.getXButton() == true){
        lift.moveLift(0.7);
    }
//  }
else{
        lift.moveLift(0);
    }
    
}
}

