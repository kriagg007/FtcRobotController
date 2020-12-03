package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 This is an abstract class that handles 4 drive train motors.
 */
abstract class IntakeClass extends LinearOpMode
{

    protected DcMotor intake;
    protected DcMotor shooter;
    protected DcMotor hopper;

    protected DcMotor arm;
    protected Servo clamp;


    public void runOpMode() {
        setupDriveMotors();
        runOpModeImpl();
    }

    public abstract void runOpModeImpl();

    protected void setupDriveMotors() {
        // Initialize the motor references for all the wheels
        // Initialize the hardware variables. Note that the strings used here as parameters

        updateTelemetryMessage("Initializing Motors");
        intake = hardwareMap.get(DcMotor.class, "intake");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        hopper = hardwareMap.get(DcMotor.class, "hopper");
        arm = hardwareMap.get(DcMotor.class, "arm");

        clamp = hardwareMap.get(Servo.class, "clamp");


        // Most robots need the motor on one side to be reve`rsed to drive goBackward
        // Reverse the motor that runs backwards when connected directly to the battery

        intake.setDirection(DcMotor.Direction.FORWARD);
        shooter.setDirection(DcMotor.Direction.REVERSE);
        hopper.setDirection(DcMotor.Direction.REVERSE);

        /*    */

        updateTelemetryMessage("Initialized Motors");
/*
        arm = hardwareMap.get(DcMotor.class, "Arm");
        arm.setDirection(DcMotor.Direction.FORWARD);


        rightConstruction = hardwareMap.servo.get("rightConstruction");

 */
    }

    public void stop(final String message) {
        intake.setPower(0.0);


        updateTelemetryMessage(message);
    }

    public void stopWithSleep(final String message, final long duration) {
        stop(message);
        sleep(duration);
    }

    public void stopWithSleep(final long duration) {
        stop("Stopping");
        sleep(duration);
    }



    protected void updateTelemetryMessage(String message) {
        updateTelemetryMessage("Status", message);
    }

    protected void updateTelemetryMessage(String caption, String message) {
        telemetry.addData("Status", message);
        telemetry.update();
    }



    public void intake(final double intakepower, final int duration){
        intake.setPower(intakepower);
        sleep(duration);
    }

    public void shooter(final double intakepower, final int duration){
        shooter.setPower(intakepower);
        sleep(duration);
    }

    public void hopper(final double intakepower, final int duration){
        hopper.setPower(intakepower);
        sleep(duration);
    }

    public void arm(final double armpower, final int duration){
        arm.setPower(armpower);
        sleep(duration);
    }

    public void clampdown() {
        clamp.setPosition(1);
        sleep(200);
    }

    public void clampup() {
        clamp.setPosition(0);
        sleep(200);
    }

/*
    public void armUp(final double armpower, final int duration) {
        arm.setPower(armpower);
        sleep(duration);

        updateTelemetryMessage("Arm going up");
    }

    public void armDown(final double armpower, final int duration) {
        armUp(-armpower, duration);
    }

    public void backServosDown() {
        rightConstruction.setPosition(0.43);
        leftConstruction.setPosition(0.35);

        updateTelemetryMessage("Foundation Servos Down");
    }

    public void backServosUp() {
        rightConstruction.setPosition(1);
        leftConstruction.setPosition(1);

        updateTelemetryMessage("Foundation Servos Up");
    }
*/
}