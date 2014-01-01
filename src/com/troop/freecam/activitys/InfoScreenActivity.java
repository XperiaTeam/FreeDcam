package com.troop.freecam.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.troop.freecam.R;
import com.troop.freecam.utils.DeviceUtils;

/**
 * Created by troop on 30.12.13.
 */
public class InfoScreenActivity extends LayoutActivity
{
    public CheckBox checkBoxOnScreen;

    //************************Text Views Add****************05-12-13
    protected TextView OnScreenBrightnessText;
    protected TextView OnScreenBrightnessValue;
    protected TextView OnScreenContrastText;
    protected TextView OnScreenContrastValue;
    protected TextView OnScreenEVText;
    protected TextView OnScreenEVValue;
    protected TextView OnScreenFlashText;
    protected TextView OnScreenFlashValue;
    protected TextView OnScreenEffectText;
    protected TextView OnScreenEffectValue;
    public TextView OnScreenFocusText;
    public TextView OnScreenFocusValue;
    protected TextView OnScreeISOText;
    protected TextView OnScreeISOValue;
    protected TextView OnScreeMeterText;
    public TextView OnScreeMeterValue;
    protected TextView OnScreenSaturationText;
    protected TextView OnScreeSaturationValue;
    protected TextView OnScreeSceneText;
    protected TextView OnScreeSceneValue;
    protected TextView OnScreenPictureText;
    protected TextView OnScreenPictureValue;
    protected TextView OnScreeSharpnessText;
    protected TextView OnScreenSharpnessValue;
    protected TextView OnScreenWBText;
    protected TextView OnScreenWBValue;

    //******************************************************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        onScreenText();
    }

    private void init()
    {
        checkBoxOnScreen = (CheckBox)findViewById(R.id.checkBoxOnscreen);
        checkBoxOnScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (checkBoxOnScreen.isChecked())
                {
                    showCurrentConfig();
                }
                else
                {
                    hideCurrentConfig();
                }
            }
        });
        onScreenText();
    }

    private void onScreenText()
    {
        try {
            OnScreenBrightnessText = (TextView) findViewById(R.id.textViewBrightnessText);
            OnScreenBrightnessValue = (TextView) findViewById(R.id.textViewBrightnessValue);
            OnScreenContrastText = (TextView) findViewById(R.id.textViewContrastText);
            OnScreenContrastValue = (TextView) findViewById(R.id.textViewContrastValue);
            OnScreenEVText = (TextView) findViewById(R.id.textViewEVText);
            OnScreenEVValue = (TextView) findViewById(R.id.textViewEvValue);
            OnScreenFlashText = (TextView) findViewById(R.id.textViewFlashtext);
            OnScreenFlashValue = (TextView) findViewById(R.id.textViewFlashValue);
            OnScreenEffectText = (TextView) findViewById(R.id.textViewEffetText);
            OnScreenEffectValue = (TextView) findViewById(R.id.textViewEffectValue);
            OnScreenFocusText = (TextView) findViewById(R.id.textViewFocusText);
            OnScreenFocusValue = (TextView) findViewById(R.id.textViewFocusValue);
            OnScreeISOText = (TextView) findViewById(R.id.textViewISOText);
            OnScreeISOValue = (TextView) findViewById(R.id.textViewISOValue);
            OnScreeMeterText = (TextView) findViewById(R.id.textViewMeterText);
            OnScreeMeterValue = (TextView) findViewById(R.id.textViewMeterValue);
            OnScreenSaturationText = (TextView) findViewById(R.id.textViewSatuText);
            OnScreeSaturationValue = (TextView) findViewById(R.id.textViewSatuValue);
            OnScreeSceneText = (TextView) findViewById(R.id.textViewSceneText);
            OnScreeSceneValue = (TextView) findViewById(R.id.textViewSceneValue);
            OnScreenPictureText = (TextView) findViewById(R.id.textViewPictureText);
            OnScreenPictureValue = (TextView) findViewById(R.id.textViewPictureValue);
            OnScreeSharpnessText = (TextView) findViewById(R.id.textViewSharpText);
            OnScreenSharpnessValue = (TextView) findViewById(R.id.textViewSharpValue);
            OnScreenWBText = (TextView) findViewById(R.id.textViewWBText);
            OnScreenWBValue = (TextView) findViewById(R.id.textViewWBValue);
        }
        catch (NullPointerException ex)
        {
        }
    }

    public void hideCurrentConfig ()
    {
        OnScreenBrightnessText.setVisibility(View.INVISIBLE);
        OnScreenBrightnessValue.setVisibility(View.INVISIBLE);
        OnScreenContrastText.setVisibility(View.INVISIBLE);
        OnScreenContrastValue.setVisibility(View.INVISIBLE);
        OnScreenEVText.setVisibility(View.INVISIBLE);
        OnScreenEVValue.setVisibility(View.INVISIBLE);
        OnScreenFlashText.setVisibility(View.INVISIBLE);
        OnScreenFlashValue.setVisibility(View.INVISIBLE);
        OnScreenEffectText.setVisibility(View.INVISIBLE);
        OnScreenEffectValue.setVisibility(View.INVISIBLE);
        OnScreenFocusText.setVisibility(View.INVISIBLE);
        OnScreenFocusValue.setVisibility(View.INVISIBLE);
        OnScreeISOText.setVisibility(View.INVISIBLE);
        OnScreeISOValue.setVisibility(View.INVISIBLE);
        OnScreeMeterText.setVisibility(View.INVISIBLE);
        OnScreeMeterValue.setVisibility(View.INVISIBLE);
        OnScreenSaturationText.setVisibility(View.INVISIBLE);
        OnScreeSaturationValue.setVisibility(View.INVISIBLE);
        OnScreeSceneText.setVisibility(View.INVISIBLE);
        OnScreeSceneValue.setVisibility(View.INVISIBLE);
        OnScreenPictureText.setVisibility(View.INVISIBLE);
        OnScreenPictureValue.setVisibility(View.INVISIBLE);
        OnScreeSharpnessText.setVisibility(View.INVISIBLE);
        OnScreenSharpnessValue.setVisibility(View.INVISIBLE);
        OnScreenWBText.setVisibility(View.INVISIBLE);
        OnScreenWBValue.setVisibility(View.INVISIBLE);
    }


    public void showCurrentConfig ()
    {
        OnScreenBrightnessText.setVisibility(View.VISIBLE);
        OnScreenBrightnessValue.setVisibility(View.VISIBLE);
        OnScreenContrastText.setVisibility(View.VISIBLE);
        OnScreenContrastValue.setVisibility(View.VISIBLE);
        OnScreenEVText.setVisibility(View.VISIBLE);
        OnScreenEVValue.setVisibility(View.VISIBLE);
        OnScreenFlashText.setVisibility(View.VISIBLE);
        OnScreenFlashValue.setVisibility(View.VISIBLE);
        OnScreenEffectText.setVisibility(View.VISIBLE);
        OnScreenEffectValue.setVisibility(View.VISIBLE);
        OnScreenFocusText.setVisibility(View.VISIBLE);
        OnScreenFocusValue.setVisibility(View.VISIBLE);
        OnScreeISOText.setVisibility(View.VISIBLE);
        OnScreeISOValue.setVisibility(View.VISIBLE);
        OnScreeMeterText.setVisibility(View.VISIBLE);
        OnScreeMeterValue.setVisibility(View.VISIBLE);
        OnScreenSaturationText.setVisibility(View.VISIBLE);
        OnScreeSaturationValue.setVisibility(View.VISIBLE);
        OnScreeSceneText.setVisibility(View.VISIBLE);
        OnScreeSceneValue.setVisibility(View.VISIBLE);
        OnScreenPictureText.setVisibility(View.VISIBLE);
        OnScreenPictureValue.setVisibility(View.VISIBLE);
        OnScreeSharpnessText.setVisibility(View.VISIBLE);
        OnScreenSharpnessValue.setVisibility(View.VISIBLE);
        OnScreenWBText.setVisibility(View.VISIBLE);
        OnScreenWBValue.setVisibility(View.VISIBLE);

    }

    public void showtext()
    {
        try
        {
            OnScreenBrightnessValue.setText(camMan.parametersManager.Brightness.Get());
            OnScreenContrastValue.setText(camMan.parametersManager.getParameters().get("contrast"));
            OnScreenSharpnessValue.setText(camMan.parametersManager.getParameters().get("saturation"));
            OnScreeSaturationValue.setText(camMan.parametersManager.getParameters().get("sharpness"));
            OnScreenEVValue.setText(camMan.parametersManager.getParameters().get("exposure-compensation"));
            OnScreenEffectValue.setText(camMan.parametersManager.getParameters().get("effect"));
            OnScreeISOValue.setText(camMan.parametersManager.getParameters().get("iso"));
            OnScreenFlashValue.setText(camMan.parametersManager.getParameters().get("flash-mode"));
            OnScreenFocusValue.setText(camMan.parametersManager.getParameters().get("focus-mode"));
            String size1 = String.valueOf(camMan.parametersManager.getParameters().getPictureSize().width) + "x" + String.valueOf(camMan.parametersManager.getParameters().getPictureSize().height);
            OnScreenPictureValue.setText(size1);
            OnScreeSceneValue.setText(camMan.parametersManager.getParameters().get("scene-mode"));
            OnScreenWBValue.setText(camMan.parametersManager.getParameters().get("whitebalance"));
            if (DeviceUtils.isOmap())
                OnScreeMeterValue.setText(camMan.parametersManager.getParameters().get("auto-exposure"));
        }
        catch (Exception ex)
        {

        }
    }
}
