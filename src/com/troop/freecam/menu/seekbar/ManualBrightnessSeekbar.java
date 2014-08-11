package com.troop.freecam.menu.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;

import com.troop.freecam.camera.CameraManager;
import com.troop.freecam.controls.LandscapeSeekbarControl;
import com.troop.freecam.interfaces.IStyleAbleSliderValueHasChanged;

/**
 * Created by troop on 07.09.13.
 */
public class ManualBrightnessSeekbar extends LandscapeSeekbarControl
{
    public ManualBrightnessSeekbar(Context context) {
        super(context);
    }

    public ManualBrightnessSeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ManualBrightnessSeekbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        super.onProgressChanged(seekBar, progress, fromUser);
        if (cameraManager.parametersManager.getSupportWhiteBalance()) {
            cameraManager.parametersManager.Brightness.Set(progress);
            textView_currentValue.setText("Brightness: " + progress);
        }
    }

    @Override
    public void SetCurrentValue(int current) {
        super.SetCurrentValue(current);
        textView_currentValue.setText("Brightness: " + current);
    }
}