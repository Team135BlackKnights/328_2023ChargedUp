package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.robotMap.lift;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DigitalInput;
public class liftS extends SubsystemBase{
    public static CANSparkMax flipMotor = new CANSparkMax(lift.flipMotor_ID, MotorType.kBrushless);
    public static RelativeEncoder flipMotorEncoder = flipMotor.getEncoder();
    public static DigitalInput tooFarOut = new DigitalInput(0);
    public static DigitalInput tooFarIn = new DigitalInput(1);
    }