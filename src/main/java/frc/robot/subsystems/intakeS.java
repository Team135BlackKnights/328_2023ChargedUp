package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class intakeS extends SubsystemBase {
     public CANSparkMax LeftClaw = new CANSparkMax(RobotMap.Intake.INTL_ID, MotorType.kBrushless);
     public CANSparkMax RightClaw = new CANSparkMax(RobotMap.Intake.INTR_ID, MotorType.kBrushless);
     public CANSparkMax ArmUp = new CANSparkMax(RobotMap.Intake.INTU_ID, MotorType.kBrushless); 
     public static RelativeEncoder ManipLeftEncoder, ManipRightEncoder, ManipUpEncoder; 

     public intakeS(){
          ManipLeftEncoder = LeftClaw .getEncoder();
          ManipRightEncoder = RightClaw.getEncoder();
          ManipUpEncoder = ArmUp.getEncoder();

     }
     public static void IntakeEncoderReset() {
          ManipLeftEncoder.setPosition(0);
          ManipRightEncoder.setPosition(0);
          ManipUpEncoder.setPosition(0);
     
     }



}