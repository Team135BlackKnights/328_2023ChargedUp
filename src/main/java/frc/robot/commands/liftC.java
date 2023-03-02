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
int POV_UP = 0;
int POV_DOWN = 180;
//boolean change =false;
public void execute(){
SmartDashboard.putNumber("lift encoder value", lift.flipMotorEncoder.getPosition());
if (robotContainer.ManipControl.getPOV() == POV_UP)  {
    /*while (lift.flipMotorEncoder.getPosition()>5-lift.changer) { 
        lift.moveLiftUp(-0.7);
   // while (robotContainer.ManipControl.getYButton() == true){
   }
   */
  lift.moveLiftUp(-0.7);
}//
    //}
    // }
else if (robotContainer.ManipControl.getPOV() == POV_DOWN) {
    lift.moveLiftDown(0.7);
    /*while (lift.flipMotorEncoder.getPosition()<95+lift.changer) { 
        lift.moveLiftDown(0.7);
     }
     */
     /*change=true;
     if (change==true){
        lift.changer = 20;
     }*/

    // while (robotContainer.ManipControl.getXButton() == true){
    }
//  }
else{
        lift.stopLift();
    }
    
}
}
