package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.robotMap.lift;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;


public class liftS extends SubsystemBase{
   public CANSparkMax flipMotor = new CANSparkMax(lift.flipMotor_ID, MotorType.kBrushless);
    public RelativeEncoder flipMotorEncoder = flipMotor.getEncoder();
    public int changer;
 public liftS() {
     flipMotor.setIdleMode(IdleMode.kCoast);
    flipMotor.enableVoltageCompensation(12);
    //flipMotor.setSmartCurrentLimit(30, 80);
    flipMotor.burnFlash();
 }
   
    public void moveLiftDown(double speed){
     // if (flipMotorEncoder.getPosition() < 95+changer/*-changer*/) { //could be wrong
         flipMotor.set(speed);
     /* }
      else{
         stopLift();
      }
      */
      
    }
    public void moveLiftUp(double speed){
     // if (flipMotorEncoder.getPosition() > 5-changer/*-changer*/){ //could be wrong. -147 PERHAPS
         flipMotor.set(speed);
     /* }
      else{
         stopLift();
      }
      */
    }
    public void stopLift(){
       flipMotor.set(0);
    }
    public void resetEncoders() {
       flipMotorEncoder.setPosition(0);
    }
    }