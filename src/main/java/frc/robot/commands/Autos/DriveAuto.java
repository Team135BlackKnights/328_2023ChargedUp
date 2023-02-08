// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.tankDriveS;


  public class driveAuto extends CommandBase {
  Timer timer = new Timer();
  tankDriveS tankTankDriveS;
  boolean isFinished = false;
  double DriveTime;

  public driveAuto (tankDriveS m_drive, double i) {
    tankTankDriveS = m_drive;
    DriveTime = i;
    addRequirements(tankTankDriveS);
  }
  public void initialize() {
    timer.start();
  }
  
  @Override
  public void execute(){
    SmartDashboard.putNumber("Auto Timer", Timer.getMatchTime());
    
    if (timer.get() < 5){
      tankTankDriveS.tankDrive(.5, .5);
    }
    else if (timer.get() < 10){
      tankTankDriveS.tankDrive(.5, .5);
    }
    else if (timer.get() > DriveTime){
      tankTankDriveS.tankDrive(0, 0);
      isFinished = true;
    }

  }
  }

