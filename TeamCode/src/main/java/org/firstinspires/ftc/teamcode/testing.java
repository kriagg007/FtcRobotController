package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="testing", group="Linear Opmode")
public class testing extends Movement {
    private ElapsedTime runtime = new ElapsedTime();

        @Override
        public void runOpModeImpl() {
            // TODO Set up frontServo in movement

            waitForStart();
            runtime.reset();


            while(opModeIsActive()) {
                while(true) {


                    //servos
                    if(gamepad2.right_bumper) {
                        arm.setPower(0.5);
                        sleep(250);
                        arm.setPower(0.3);
                        sleep(250);
                        arm.setPower(0);
                    }

                    if(gamepad2.left_bumper){
                        arm.setPower(-0.5);
                        sleep(250);
                        arm.setPower(-0.5);
                        sleep(250);
                        arm.setPower(0);
                    }

                    if (gamepad2.b) {
                        clamp.setPosition(.8);
                        sleep(200);
                    }

                    if(gamepad2.dpad_up){
                        clamp.setPosition(.2);
                        sleep(200);
                    }

                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.update();

                    // Left trigger - to move left sideways
                    strafeRight(-gamepad1.right_trigger, 0);

                    // Right trigger - to move right sideways
                    strafeLeft(-gamepad1.left_trigger, 0);

                    /*shooter.setPower(1);*/

                    // Left stick y - to go forward or backward
                    double drive = gamepad1.left_stick_y;

                    // Right stick x - to turn left or right
                    double turn  = gamepad1.right_stick_x;


                    double leftPower    = Range.clip(drive + turn, -0.6, 0.6 5) ;
                    double rightPower   = Range.clip(drive - turn, -0.6, 0.6) ;

                    leftFront.setPower(leftPower);
                    leftBack.setPower(leftPower);
                    rightFront.setPower(rightPower);
                    rightBack.setPower(rightPower);

                }
            }

        }
    }


