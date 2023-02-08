package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.robotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class intakeS extends SubsystemBase { //motors for intake
     public CANSparkMax LeftWheels = new CANSparkMax(robotMap.Intake.INTL_ID, MotorType.kBrushless);
     public CANSparkMax RightWheels = new CANSparkMax(robotMap.Intake.INTR_ID, MotorType.kBrushless);
     public CANSparkMax InAndOut = new CANSparkMax(robotMap.Intake.INTU_ID, MotorType.kBrushless); 
     public static RelativeEncoder ManipUpEncoder; 

     public intakeS(){
          ManipUpEncoder = InAndOut.getEncoder();
     }
     public static void IntakeEncoderReset() {
          ManipUpEncoder.setPosition(0);
     }



}