package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsytem;

public class RotateClawTo90DegCmd extends CommandBase{

    //Variables
    private ClawSubsytem clawSub;

    //Constructor
    public RotateClawTo90DegCmd(ClawSubsytem clawSub){
        this.clawSub = clawSub;
        addRequirements(clawSub);
    }
    
    @Override
    public void initialize(){} //Starting action of RotateClawTo90DegCmd

    @Override
    public void execute(){
        clawSub.rotateTo90Deg();
    } //Middle action of RotateClawTo90DegCmd

    @Override
    public void end(boolean interrupted){
        clawSub.stopClaw();
    } //End action of RotateClawTo90DegCmd

    @Override
    public boolean isFinished(){
        return clawSub.getClawEnc() == 95;
    } //Method to activate end method
}
