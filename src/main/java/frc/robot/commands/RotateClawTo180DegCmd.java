package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class RotateClawTo180DegCmd extends CommandBase{
    
    private ClawSubsytem clawSub;

    public RotateClawTo180DegCmd(ClawSubsytem clawSub){
        this.clawSub = clawSub;
        addRequirements(clawSub);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        clawSub.rotateTo180Deg();
    }

    @Override
    public void end(boolean interrupted){
        clawSub.stopClaw();
    }

    @Override
    public boolean isFinished(){
        if (clawSub.getClawEnc() == 200){
            return true;
        } return false;
    }
}
