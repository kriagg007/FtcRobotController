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

                    boolean armtrue = true;
                    boolean clamptrue = true;

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

                    if(armtrue) {
                        if (gamepad1.right_bumper) {
                            arm.setPosition(1);
                            sleep(200);
                            armtrue = false;
                        }
                    }

                    if(!armtrue) {
                        if(gamepad1.right_bumper){
                            arm.setPosition(0);
                            sleep(200);
                            armtrue = true;
                        }
                    }


                    if(clamptrue) {
                        if (gamepad1.left_bumper) {
                            clamp.setPosition(1);
                            sleep(200);
                            clamptrue = false;
                        }
                    }

                    if(!clamptrue) {
                        if(gamepad1.left_bumper){
                            clamp.setPosition(0);
                            sleep(200);
                            clamptrue = true;
                        }
                    }

                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.update();
                }
            }

        }
    }


