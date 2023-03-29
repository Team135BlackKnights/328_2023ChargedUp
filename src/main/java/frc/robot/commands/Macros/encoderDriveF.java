package frc.robot.commands.Macros;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveS;

public class encoderDriveF extends CommandBase{
    private static final int kEncoderCountsPerRevolution = 42; // adjust this to match your encoder
    private static final double kWheelDiameterInches = 6;
 
    double distance;
    double speed;
    double revolutions;
    double distancePerRevolution;
    int targetCounts;
    private final RelativeEncoder m_leftEncoder;
    private final RelativeEncoder m_rightEncoder;
    private final MotorControllerGroup m_drive;
    public tankDriveS drive;
    boolean isFinished;
    public encoderDriveF(tankDriveS tankDrive, double distanceInches, double speedInchesPerSecond) {
        drive = tankDrive;
        m_leftEncoder =tankDriveS.lFront;
        m_rightEncoder = tankDriveS.rFront;
        m_drive = drive.autoMotors;
        speed = speedInchesPerSecond;
        distance=distanceInches;
        addRequirements(drive);
    }
    @Override
    public void initialize(){
        drive.runStop();
        distancePerRevolution = Math.PI * kWheelDiameterInches;
        revolutions = distance / distancePerRevolution;
        targetCounts = (int)(revolutions * kEncoderCountsPerRevolution);
        m_leftEncoder.setPosition(0);
        m_rightEncoder.setPosition(0);
        System.out.println("Second Auto Start");
        isFinished = false;

    }
    @Override
    public void execute() {
        if ((m_leftEncoder.getPosition() < targetCounts) && (m_rightEncoder.getPosition() < targetCounts)) {
            double move = Math.min(speed, (targetCounts + m_leftEncoder.getPosition()) / kEncoderCountsPerRevolution);
            drive.tankDrive((move*.5), (-move*.5)); 
        }else{
            m_drive.stopMotor();//replace with actual stop tank.
            System.out.println("Second Auto End");
            isFinished = true;
        }
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}