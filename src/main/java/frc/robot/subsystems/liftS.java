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
   
    public void moveLift(double speed){
        flipMotor.set(speed);
    }
    }