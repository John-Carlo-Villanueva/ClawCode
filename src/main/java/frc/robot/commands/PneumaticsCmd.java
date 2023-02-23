package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class PneumaticsCmd extends CommandBase{
    
    private ClawSubsytem clawSub;

    public PneumaticsCmd(ClawSubsytem clawSub){
        this.clawSub = clawSub;
    }

    @Override
    public void initialize(){
        clawSub.toggle();
    }

    @Override
    public void execute(){}

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return true;
    }
}
