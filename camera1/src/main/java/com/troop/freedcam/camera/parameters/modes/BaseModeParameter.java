package com.troop.freedcam.camera.parameters.modes;

import android.util.Log;

import com.troop.freedcam.camera.BaseCameraHolder;
import com.troop.freedcam.i_camera.parameters.AbstractModeParameter;

import java.util.HashMap;

/**
 * Created by troop on 17.08.2014.
 */
public class BaseModeParameter extends AbstractModeParameter {
    protected String value;
    protected String values;
    boolean isSupported = false;
    HashMap<String, String> parameters;
    BaseCameraHolder baseCameraHolder;
    protected boolean firststart = true;
    private static String TAG = BaseModeParameter.class.getSimpleName();

    public BaseModeParameter(HashMap<String, String> parameters, BaseCameraHolder cameraHolder, String value, String values)
    {
        super();
        this.parameters = parameters;
        this.value = value;
        this.values = values;
        this.baseCameraHolder = cameraHolder;
    }

    @Override
    public boolean IsSupported()
    {
        try
        {
            String tmp = parameters.get(values);
            if (!tmp.isEmpty())
                isSupported = true;
        }
        catch (Exception ex)
        {
            isSupported = false;
        }
        Log.d(TAG, "is Supported :" + isSupported);
        BackgroundSetIsSupportedHasChanged(isSupported);
        return isSupported;
    }

    public void SetValue(String valueToSet,  boolean setToCam)
    {
        if (valueToSet == null)
            return;
        String tmp = parameters.get(value);
        parameters.put(value, valueToSet);
        Log.d(TAG, "set "+value+" from " + tmp + " to "+ valueToSet);
        try {
            baseCameraHolder.SetCameraParameters(parameters);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            Log.e(TAG, "set " + value + " to " + valueToSet + " failed set back to: " + tmp);
            if (tmp == null)
                return;
            parameters.put(value, tmp);
            try {
                baseCameraHolder.SetCameraParameters(parameters);
            }
            catch (Exception ex2)
            {
                ex.printStackTrace();
                Log.e(TAG, "set " + value + " back to " + tmp + " failed");
            }
        }


        firststart = false;
    }



    public String GetValue()
    {
        return parameters.get(value);
    }

    public String[] GetValues()
    {
        return parameters.get(values).split(",");
    }
}
