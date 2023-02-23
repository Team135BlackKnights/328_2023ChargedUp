package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.liftS;


public class flipDown extends CommandBase {
    
    public final liftS Drop;

    public flipDown(liftS subsystem){
        Drop = subsystem;
        addRequirements(subsystem);
    }   
    @Override
    public void initialize() {
        System.out.println("initializing flipDown");
    }
    public void execute() {
        System.out.println("running flipDown");
        if(Drop.flipMotorEncoder.getPosition() == 300 ) {
            Drop.moveLift(0.3);
        }
        else{
            end();
        }
    } 
    public void end() {
        Drop.moveLift(0.0);
    }
}

