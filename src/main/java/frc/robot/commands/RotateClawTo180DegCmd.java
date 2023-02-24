package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class RotateClawTo180DegCmd extends CommandBase{
    
    //Variables
    private ClawSubsytem clawSub;

    //Constructor
    public RotateClawTo180DegCmd(ClawSubsytem clawSub){
        this.clawSub = clawSub;
        addRequirements(clawSub);
    }

    @Override
    public void initialize(){} //Starting action of RotateClawTo180DegCmd

    @Override
    public void execute(){
        clawSub.rotateTo180Deg();
    } //Middle action of RotateClawTo180DegCmd

    @Override
    public void end(boolean interrupted){
        clawSub.stopClaw();
    } //End action of RotateClawTo180DegCmd

    @Override
    public boolean isFinished(){
        return clawSub.getClawEnc() == 190;
    } //Method to activate end method
}
