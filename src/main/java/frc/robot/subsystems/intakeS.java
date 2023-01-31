package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.Encoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class intakeS extends SubsystemBase {
     CANSparkMax ManipLeft = new CANSparkMax(RobotMap.Intake.INTL_ID, MotorType.kBrushless);
     CANSparkMax ManipRight = new CANSparkMax(RobotMap.Intake.INTR_ID, MotorType.kBrushless);
     CANSparkMax ManipUp = new CANSparkMax(RobotMap.Intake.INTU_ID, MotorType.kBrushless); 
     public static RelativeEncoder ManipLeftEncoder, ManipRightEncoder, ManipUpEncoder; 

     public intakeS(){
          ManipLeftEncoder = ManipLeft.getEncoder();
          ManipRightEncoder = ManipLeft.getEncoder();
          ManipUpEncoder = ManipUp.getEncoder();

     }
     public static void IntakeEncoderReset() {
          ManipLeftEncoder.setPosition(0);
          ManipRightEncoder.setPosition(0);
          ManipUpEncoder.setPosition(0);
     
     }



}