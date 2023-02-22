// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.tankDriveS;
import frc.robot.subsystems.intakeS;


  public class driveAuto extends SequentialCommandGroup {
  public driveAuto(tankDriveS drive, intakeS intake){
    basicAuto basicAutoL = new basicAuto(drive, 5.328 , .4);
   // otherAuto otherAutoL = new otherAuto(drive, 10, .4);
 //   encoderDriveC encoderDriveL = new encoderDriveC(drive, 10.0);
    shootOutC shootOutL = new shootOutC(drive,intake,2,.5);
    flipAutoC flipAutoL = new flipAutoC(drive,.4,180);
    System.out.print("Initializing driveAuto...");
    addCommands(shootOutL,basicAutoL,flipAutoL);
   //addCommands(new basicAuto(drive,5.328,.4));

  }
}


