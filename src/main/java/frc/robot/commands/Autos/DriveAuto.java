// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.tankDriveC;
import frc.robot.subsystems.DriveRobot;


  public class DriveAuto extends CommandBase {
  Timer timer = new Timer();
  DriveRobot tankDriveRobot;
  boolean isFinished = false;
  double DriveTime;

  public DriveAuto (DriveRobot m_drive, double i) {
    tankDriveRobot = m_drive;
    DriveTime = i;
    addRequirements(tankDriveRobot);
  }
  public void initialize() {
    timer.start();
  }

  @Override
  public void execute(){
    SmartDashboard.putNumber("Auto Timer", Timer.getMatchTime());
    
    if (timer.get() < 5){
      tankDriveRobot.tankDrive(.5, .5);
    }
    else if (timer.get() < 10){
      
    }
    else if (timer.get() > DriveTime){
      tankDriveRobot.tankDrive(0, 0);
      isFinished = true;
    }

  }
  }

