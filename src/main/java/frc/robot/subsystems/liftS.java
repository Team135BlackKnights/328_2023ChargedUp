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
 public liftS() {
     flipMotor.setIdleMode(IdleMode.kCoast);
     flipMotor.burnFlash();
    flipMotor.enableVoltageCompensation(12);
 }
   
    public void moveLiftDown(double speed){
      if (flipMotorEncoder.getPosition() < 110) { //could be wrong
         flipMotor.set(speed);
      }
    }
    public void moveLiftUp(double speed){
      if (flipMotorEncoder.getPosition() > 5){ //could be wrong.
         flipMotor.set(speed);
      }
    }
    public void stopLift(){
       flipMotor.set(0);
    }
    public void resetEncoders() {
       flipMotorEncoder.setPosition(0);
    }
    }