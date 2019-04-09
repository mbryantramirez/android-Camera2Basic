package com.example.android.camera2basic;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class TakeImageFragment extends Fragment {

  private CameraInteractionListener cameraNavigationListener;
  private Button button;
  private ImageView imageView;

  public TakeImageFragment() {
    // Required empty public constructor
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof CameraInteractionListener) {
      cameraNavigationListener = (CameraInteractionListener) context;
    }
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_take_image, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    imageView = (ImageView) view.findViewById(R.id.saved_image_iv);
    button = (Button) view.findViewById(R.id.to_camera_fragment);
    button.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        cameraNavigationListener.addCameraFragment();
      }
    });
  }


  @Override
  public void onResume() {
    super.onResume();
    File file = cameraNavigationListener.getCameraFile();
    if (file != null) {
      Log.d(TakeImageFragment.class.getName(), "onStart: "+ file.getName());
      Picasso.get().load(file).into(imageView);
    }
  }

  public static TakeImageFragment newInstance() {
    Bundle args = new Bundle();
    TakeImageFragment fragment = new TakeImageFragment();
    fragment.setArguments(args);
    return fragment;
  }

}
