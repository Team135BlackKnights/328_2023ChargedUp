package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.tankDriveS;
import frc.robot.subsystems.intakeS;
import frc.robot.subsystems.liftS;

public class balanceScoreAuto extends SequentialCommandGroup {
    public balanceScoreAuto(tankDriveS tank, intakeS intake, liftS lift){
        shootOutC shootOutL = new shootOutC(tank,intake,2,.65);
    flipDown flipDownL = new flipDown(lift, intake, 3, .7);
    encoderDriveC encoderDriveL = new encoderDriveC(tank, 12,24);
    addCommands(flipDownL, shootOutL,encoderDriveL);
    }
}
