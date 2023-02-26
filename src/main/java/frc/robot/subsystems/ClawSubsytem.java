package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ClawSubsytem extends SubsystemBase{

    //Variables
    private DoubleSolenoid clawSolenoid;
    private CANSparkMax clawMotor;
    private RelativeEncoder clawEnc;

    //Constructor
    public ClawSubsytem(){
        clawMotor = new CANSparkMax(15, MotorType.kBrushless);
        clawEnc = clawMotor.getEncoder();
        clawSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 8);
    }

    //Encoder Methods
    public double getClawEnc(){
        return clawEnc.getPosition();
    } //Returns the claw position of the motor

    public void resetClawEnc(){
        clawEnc.setPosition(0);
    } //Set the claw position to 0

    //Pneumatics Methods
    public void toggle(){
        clawSolenoid.toggle();
    } //if active and claw closed then stay open; if active and claw open then stay close

    //Claw Rotation Methods
    public void turnCW(){
        clawMotor.set(.3);
    } //Turns claw Clockwise
    
    public void turnCCW(){
        clawMotor.set(-.3);
    } //Turns claw Counter Clockwise

    public void stopClaw(){
        clawMotor.set(0);
    } //Stops claw

    public void manualTurning(double speed){
        clawMotor.set(speed);
    } //Manual move claw

    //Rotation Methods
    public void rotateTo0Deg(){
        if(getClawEnc() > 0){
            turnCCW();
        } else if(getClawEnc() < 0){
            turnCW();
        } stopClaw();
    } //Stops claw when ClawEnc is 0

    public void rotateTo90Deg(){
        if (getClawEnc() > 95){
            turnCCW();
        } else if (getClawEnc() < 95){
            turnCW();
        } stopClaw();
    } //Stops claw when ClawEnc is 95

    public void rotateTo180Deg(){
        if (getClawEnc() > 190){
            turnCCW();
        } else if(getClawEnc() < 190){
            turnCW();
        } stopClaw();
    } //Stops claw when ClawEnc is 190

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Claw Enc", getClawEnc());
        SmartDashboard.putBoolean("Forward Pneumatics", clawSolenoid.isFwdSolenoidDisabled());
        SmartDashboard.putBoolean("Reverse Pneumatics", clawSolenoid.isRevSolenoidDisabled());
    } //Repeatedly update SmartDashboard
}