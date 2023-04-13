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
     public static RelativeEncoder inAndOutEncoder; 
     //public DigitalInput tooFarOut = new DigitalInput(0);
     //public DigitalInput tooFarIn = new DigitalInput(2);
     public intakeS(){
     //Sets encoder and voltage limit for the motor and writes setting in flashdrives for inAndOut
          inAndOutEncoder = inAndOut.getEncoder();
          inAndOut.setSmartCurrentLimit(12);
          inAndOut.setIdleMode(IdleMode.kBrake);
          inAndOut.burnFlash();
     }
     public static void intakeEncoderReset() {
     //Sets position of the encoder
          inAndOutEncoder.setPosition(0);
     }
     public void intakeMoveIn(double speed){
     //Depending on the position of the encoder, it sets the speed
          if(inAndOutEncoder.getPosition()>-2){
               inAndOut.set(speed);
          }
     }
     public void intakeMoveOut(double speed){
          if(inAndOutEncoder.getPosition()<5){
               inAndOut.set(speed);
          }
          }
     public void intakeStop(){
     //Sets speed to zero when stopped
     inAndOut.set(0);
     }

//
}