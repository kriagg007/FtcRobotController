package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="DriverControl", group="Linear Opmode")
public class DriverControl extends Movement {
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpModeImpl() {
        // TODO Set up frontServo in movement

        waitForStart();
        runtime.reset();


        while(opModeIsActive()) {
            while(true) {
                // Gamepad 1 controls:

                // Left trigger - to move left sideways
                strafeRight(-gamepad1.right_trigger, 0);

                // Right trigger - to move right sideways
                strafeLeft(-gamepad1.left_trigger, 0);

                /*shooter.setPower(1);*/

                // Left stick y - to go forward or backward
                double drive = -gamepad1.left_stick_y;

                // Right stick x - to turn left or right
                double turn  = gamepad1.right_stick_x;


                double leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
                double rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

                leftFront.setPower(leftPower);
                leftBack.setPower(leftPower);
                rightFront.setPower(rightPower);
                rightBack.setPower(rightPower);

                // left bumper - to close claw (front servo)



                if (gamepad2.dpad_left) {

                    clamp.setPosition(1);
                    sleep(100);
                    telemetry.addData("front servo closed", "clawposition: 0.1" );
                }

                if (gamepad2.dpad_right) {

                    clamp.setPosition(0.0);
                    sleep(100);
                    telemetry.addData("front servo closed", "clawposition: 0.1" );
                }
/*
                // Gamepad 2 Controls

                // Left stick y - to move arm up or down
                arm.setPower(-gamepad2.left_stick_y*0.66);



                // a - arm target position

//                if (gamepad2.a) {
                //                  arm.setTargetPosition(1);
                //                arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                //              arm.setPower(0);
                //            sleep(100);
                //      }

                // x - to move back servo down
                if (gamepad2.x) {

                    leftConstruction.setPosition(0.35);
                    rightConstruction.setPosition(0.43);
                    telemetry.addData("back servos down", "servoposition: 0,0" );
                }
q
                // y - to move back servo up
                if (gamepad2.y) {
                    leftConstruction.setPosition(1);
                    rightConstruction. setPosition(1);
                    telemetry.addData("back servos up", "servoposition: 0.95" );
                }
*/
                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
                telemetry.update();
            }
        }

    }
}
