/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2basic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.io.File;

public class CameraActivity extends AppCompatActivity implements CameraInteractionListener {

  private File lastPictureSaved;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);
    goToTakeImageFragment();
  }

  @Override
  public void addCameraFragment() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, Camera2BasicFragment.newInstance())
        .addToBackStack(null)
        .commit();
  }

  @Override
  public void goToTakeImageFragment() {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, TakeImageFragment.newInstance())
        .commit();
  }

  @Override
  public File getCameraFile() {
    return lastPictureSaved;
  }

  @Override
  public void saveCameraFile(File file) {
    lastPictureSaved = file;
  }


}
