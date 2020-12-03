package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="testing", group="Linear Opmode")
public class testing extends IntakeClass {
    private ElapsedTime runtime = new ElapsedTime();

        @Override
        public void runOpModeImpl() {
            // TODO Set up frontServo in movement

            waitForStart();
            runtime.reset();


            while(opModeIsActive()) {
                while(true) {


                    // left bumper - to close claw (front servo)
                    if(gamepad1.a){
                        shooter.setPower(1);
                        while(gamepad1.a){
                            shooter.setPower(1);
                        }
                    }
                    else {
                        shooter.setPower(0);
                    }

                    if(gamepad1.b){
                        intake.setPower(1);
                        while(gamepad1.b){
                            intake.setPower(1);
                        }
                    }
                    else {
                        intake.setPower(0);
                    }

                    if(gamepad1.x){
                        hopper.setPower(1);
                        while(gamepad1.x){
                            hopper.setPower(1);
                        }

                    }
                    else {
                        hopper.setPower(0);
                    }


                    //servos
                    if (gamepad1.right_bumper) {
                        arm.setPower(0.2);
                        sleep(100);
                        arm.setPower(0);
                    }

                    if(gamepad1.left_bumper){
                        arm.setPower(-0.4);
                        sleep(100);
                        arm.setPower(0);
                    }

                    if (gamepad1.dpad_down) {
                        clamp.setPosition(.8);
                        sleep(200);
                    }

                    if(gamepad1.dpad_up){
                        clamp.setPosition(.2);
                        sleep(200);
                    }

                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.update();
                }
            }

        }
    }


