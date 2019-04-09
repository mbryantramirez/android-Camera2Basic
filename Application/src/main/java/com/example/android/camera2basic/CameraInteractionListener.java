package com.example.android.camera2basic;

import java.io.File;

public interface CameraInteractionListener {

  void addCameraFragment();

  void goToTakeImageFragment();

  File getCameraFile();

  void saveCameraFile(File file);
}
