package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.robotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
//import edu.wpi.first.wpilibj.DigitalInput;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class intakeS extends SubsystemBase { //motors for intake
     public CANSparkMax leftWheels = new CANSparkMax(robotMap.intake.INTL_ID, MotorType.kBrushless);
     public CANSparkMax rightWheels = new CANSparkMax(robotMap.intake.INTR_ID, MotorType.kBrushless);
     public CANSparkMax inAndOut = new CANSparkMax(robotMap.intake.INTU_ID, MotorType.kBrushless); 
     public static RelativeEncoder manipUpEncoder; 
     //public DigitalInput tooFarOut = new DigitalInput(0);
     //public DigitalInput tooFarIn = new DigitalInput(2);
     public intakeS(){
          manipUpEncoder = inAndOut.getEncoder();
          inAndOut.setSmartCurrentLimit(12);
          inAndOut.setIdleMode(IdleMode.kBrake);
          inAndOut.burnFlash();
     }
     public static void intakeEncoderReset() {
          manipUpEncoder.setPosition(0);
     }



}