package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class RotateClawTo90DegCmd extends CommandBase{

    private ClawSubsytem clawSub;

    public RotateClawTo90DegCmd(ClawSubsytem clawSub){
        this.clawSub = clawSub;
        addRequirements(clawSub);
    }
    
    @Override
    public void initialize(){}

    @Override
    public void execute(){
        clawSub.rotateTo90Deg();
    }

    @Override
    public void end(boolean interrupted){
        clawSub.stopClaw();
    }

    @Override
    public boolean isFinished(){
        if (clawSub.getClawEnc() == 100){
            return true;
        } return false;
    }
}
