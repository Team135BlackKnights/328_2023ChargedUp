// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.tankDriveS;
import frc.robot.subsystems.intakeS;
import frc.robot.subsystems.liftS;

  public class driveAuto extends SequentialCommandGroup {
  public driveAuto(tankDriveS drive, intakeS intake, liftS lift){
    basicAuto basicAutoL = new basicAuto(drive, 4.828 , .4);
    
   // otherAuto otherAutoL = new otherAuto(drive, 10, .4);
   encoderDriveC encoderDriveL = new encoderDriveC(drive, 19,4);
    shootOutC shootOutL = new shootOutC(drive,intake,1,.65);
    flipDown flipDownL = new flipDown(lift, intake, 3, .7);
    flipDown flipDownU = new flipDown(lift,intake,3,-.7);
    System.out.print("Initializing driveAuto...");
    addCommands(flipDownL,shootOutL,basicAutoL,flipDownU);
   //addCommands(new basicAuto(drive,5.328,.4));
 
  }
}


