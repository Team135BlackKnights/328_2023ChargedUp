package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class intakeS extends SubsystemBase {
    
     public static DoubleSolenoid Solenoid1 = new DoubleSolenoid(2, PneumaticsModuleType.REVPH, RobotMap.Intake.Sol1_ID, RobotMap.Intake.Sol2_ID);
     public static DoubleSolenoid Solenoid2 = new DoubleSolenoid(2, PneumaticsModuleType.REVPH, RobotMap.Intake.Sol3_ID, RobotMap.Intake.Sol4_ID);

}

