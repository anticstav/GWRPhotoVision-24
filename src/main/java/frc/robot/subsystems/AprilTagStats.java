// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AprilTagStats extends SubsystemBase {
  /** Creates a new AprilTagStats. */

  // CHANGE AT RSC WHEN YOU GET THE NAME!!!!!!!!!!
  PhotonCamera camera = new PhotonCamera("Microsoft_LifeCam_HD-3000");
  public AprilTagStats() {}

  @Override
  public void periodic() {
    // code assumes that roll == 0
    // gets the latest camera image
    var result = camera.getLatestResult();
    if (result.hasTargets()) { // does the image have any viable targets?
      PhotonTrackedTarget target = result.getBestTarget(); // if it does, get the most identifiable target
      // get the stats from it
      double yaw = target.getYaw();
      double pitch = target.getPitch();
      Transform3d camToTarget = target.getBestCameraToTarget();
      // print it out
      System.out.println("Yaw: " + yaw);
      System.out.println("Pitch: " + pitch);
      System.out.println("Camera's X distance from target: " + camToTarget.getX()); // gets horizontal distance
      System.out.println("Camera's Y distance from target: " + camToTarget.getY()); // gets the rotated value of the target
      System.out.println("Camera's Z distance from target: " + camToTarget.getZ()); // gets the elevation of the target COMPARED TO the camera
    }
  }
}
