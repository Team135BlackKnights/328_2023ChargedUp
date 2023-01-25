package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeEx1S extends SubsystemBase{
    public CANSparkMax IntakeL = new CANSparkMax(RobotMap.Intake.INTL_ID, MotorType.kBrushless);
    public CANSparkMax IntakeR = new CANSparkMax(RobotMap.Intake.INTR_ID, MotorType.kBrushless);
    public CANSparkMax IntakeUpDown = new CANSparkMax(RobotMap.Intake.INTU_ID, MotorType.kBrushless);

    public IntakeEx1S(){
            IntakeL.enableVoltageCompensation(12);
            IntakeR.enableVoltageCompensation(12);
            IntakeUpDown.enableVoltageCompensation(12);

    }

}
