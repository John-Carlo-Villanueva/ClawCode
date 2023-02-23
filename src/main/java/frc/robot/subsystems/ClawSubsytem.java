package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ClawSubsytem extends SubsystemBase{

    private DoubleSolenoid clawSolenoid;
    private CANSparkMax clawMotor;
    private RelativeEncoder clawEnc;

    public ClawSubsytem(){
        clawMotor = new CANSparkMax(15, MotorType.kBrushless);
        clawEnc = clawMotor.getEncoder();
        clawSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 8);
    }

    //Encoder Methods
    public double getClawEnc(){
        return clawEnc.getPosition();
    }

    public void resetClawEnc(){
        clawEnc.setPosition(0);
    }

    //Pneumatics Methods
    public void close(){
        clawSolenoid.set(Value.kForward);
    }

    public void open(){
        clawSolenoid.set(Value.kReverse);
    }
    public void toggle(){
        clawSolenoid.toggle();
    }

    //Claw Rotation Methods
    public void turnCW(){
        clawMotor.set(.3);
    }
    
    public void turnCCW(){
        clawMotor.set(-.3);
    }

    public void stopClaw(){
        clawMotor.set(0);
    }

    public void manualTurning(double speed){
        clawMotor.set(speed);
    }

    //Rotation Methods
    public void rotateTo0Deg(){
        if(getClawEnc() > 0){
            turnCCW();
        } else if(getClawEnc() < 0){
            turnCW();
        } stopClaw();
    }

    public void rotateTo90Deg(){
        if (getClawEnc() > 100){
            turnCCW();
        } else if (getClawEnc() < 100){
            turnCW();
        } stopClaw();
    }

    public void rotateTo180Deg(){
        if (getClawEnc() > 200){
            turnCCW();
        } else if(getClawEnc() < 200){
            turnCW();
        } stopClaw();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Claw Enc", getClawEnc());
    }
}
