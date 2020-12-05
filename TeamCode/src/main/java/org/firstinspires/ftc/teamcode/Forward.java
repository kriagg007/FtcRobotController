package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Forward", group="Linear Opmode")


public class Forward extends Movement {
    private ElapsedTime runtime = new ElapsedTime();

   @Override public void runOpModeImpl() {

        waitForStart();
        runtime.reset();
        clamp.setPosition(0.8);
        sleep(1000);
        goForward(.3,  2350);
        goForward(0, 1000);
       clamp.setPosition(0.8);
       sleep(500);
       arm.setPower(0.5);
       sleep(200);
       arm.setPower(0.3);
       sleep(200);
       arm.setPower(0);
       clamp.setPosition(0.0);
       sleep(500);
       clamp.setPosition(0.0);


        telemetry.addData("Status", "Stop Program");
        telemetry.update();



    }
}