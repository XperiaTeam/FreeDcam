package com.troop.freecamv2.camera.parameters;

import android.hardware.Camera;
import android.util.Log;

import com.troop.freecam.manager.camera_parameters.ParametersManager;
import com.troop.freecamv2.camera.BaseCameraHolder;
import com.troop.freecamv2.camera.parameters.manual.BrightnessManualParameter;
import com.troop.freecamv2.camera.parameters.manual.ContrastManualParameter;
import com.troop.freecamv2.camera.parameters.manual.ConvergenceManualParameter;
import com.troop.freecamv2.camera.parameters.manual.ExposureManualParameter;
import com.troop.freecamv2.camera.parameters.manual.FocusManualParameter;
import com.troop.freecamv2.camera.parameters.manual.SaturationManualParameter;
import com.troop.freecamv2.camera.parameters.manual.SharpnessManualParameter;
import com.troop.freecamv2.camera.parameters.manual.ShutterManualParameter;
import com.troop.freecamv2.camera.parameters.modes.AntiBandingModeParameter;
import com.troop.freecamv2.camera.parameters.modes.ColorModeParameter;
import com.troop.freecamv2.camera.parameters.modes.ExposureModeParameter;
import com.troop.freecamv2.camera.parameters.modes.FlashModeParameter;
import com.troop.freecamv2.camera.parameters.modes.ImagePostProcessingParameter;
import com.troop.freecamv2.camera.parameters.modes.IsoModeParameter;
import com.troop.freecamv2.camera.parameters.modes.PictureSizeParameter;

/**
 * Created by troop on 17.08.2014.
 */
public class CamParametersHandler implements I_ParameterChanged
{
    BaseCameraHolder cameraHolder;
    Camera.Parameters cameraParameters;


    public BrightnessManualParameter ManualBrightness;
    public SharpnessManualParameter ManualSharpness;
    public ContrastManualParameter ManualContrast;
    public SaturationManualParameter ManualSaturation;
    public ExposureManualParameter ManualExposure;
    public ConvergenceManualParameter ManualConvergence;
    public FocusManualParameter ManualFocus;
    public ShutterManualParameter ManualShutter;

    public ColorModeParameter ColorMode;
    public ExposureModeParameter ExposureMode;
    public FlashModeParameter FlashMode;
    public IsoModeParameter IsoMode;
    public AntiBandingModeParameter AntiBandingMode;
    public PictureSizeParameter PictureSize;
    public ImagePostProcessingParameter ImagePostProcessing;

    public I_ParametersLoaded OnParametersLoaded;

    boolean moreParametersToSet = false;

    SetParameterRunner setParameterRunner;

    public CamParametersHandler(BaseCameraHolder cameraHolder)
    {
        this.cameraHolder = cameraHolder;
    }

    public void GetParametersFromCamera()
    {
        cameraParameters = cameraHolder.GetCameraParameters();
    }

    public void SetParametersToCamera()
    {
        cameraHolder.SetCameraParameters(cameraParameters);
    }

    public void LoadParametersFromCamera()
    {
        cameraParameters = cameraHolder.GetCameraParameters();
        setParameterRunner = new SetParameterRunner();
        initParameters();
    }

    boolean supportManualWhiteBalance = false;
    public boolean getSupportWhiteBalance() { return supportManualWhiteBalance; }

    boolean supportFlash = false;
    public boolean getSupportFlash() { return  supportFlash;}

    boolean supportVNF = false;
    public boolean getSupportVNF() { return supportVNF;}

    boolean supportAfpPriorityModes = false;
    public boolean getSupportAfpPriority() { return supportAfpPriorityModes;}

    boolean supportIPP = false;
    public boolean getSupportIPP() { return supportIPP;}

    boolean supportZSL = false;
    public boolean getSupportZSL() { return supportZSL;}





    private void logParameters()
    {
        String[] paras =  cameraParameters.flatten().split(";");
        for(int i = 0; i < paras.length; i++)
            Log.d("freecam.CameraParametersHandler", paras[i]);
    }

    private void initParameters()
    {
        logParameters();
        ManualBrightness = new BrightnessManualParameter(cameraParameters, "","","");
        ManualContrast = new ContrastManualParameter(cameraParameters, "", "", "");
        ManualConvergence = new ConvergenceManualParameter(cameraParameters, "manual-convergence", "supported-manual-convergence-max", "supported-manual-convergence-min");
        ManualExposure = new ExposureManualParameter(cameraParameters,"","","");
        ManualFocus = new FocusManualParameter(cameraParameters,"","","");
        ManualSaturation = new SaturationManualParameter(cameraParameters,"","","");
        ManualSharpness = new SharpnessManualParameter(cameraParameters, "", "", "");
        ManualShutter = new ShutterManualParameter(cameraParameters,"","","");

        ColorMode = new ColorModeParameter(cameraParameters,this, "", "");
        ExposureMode = new ExposureModeParameter(cameraParameters,this,"","");
        FlashMode = new FlashModeParameter(cameraParameters,this,"","");
        IsoMode = new IsoModeParameter(cameraParameters,this,"","");
        AntiBandingMode = new AntiBandingModeParameter(cameraParameters,this, "antibanding", "antibanding-values");
        PictureSize = new PictureSizeParameter(cameraParameters,this, "", "");
        ImagePostProcessing = new ImagePostProcessingParameter(cameraParameters,this, "ipp", "ipp-values");

        if (OnParametersLoaded != null)
            OnParametersLoaded.ParametersLoaded();
    }

    @Override
    public void ParameterChanged()
    {
        if (!setParameterRunner.isRunning)
            setParameterRunner.run();
        else
            moreParametersToSet = true;

    }

    class SetParameterRunner implements Runnable
    {
        private boolean isRunning = false;

        @Override
        public void run()
        {
            isRunning = true;
            cameraHolder.SetCameraParameters(cameraParameters);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isRunning = false;
            if (moreParametersToSet)
            {
                moreParametersToSet = false;
                run();
            }
        }
    }
}