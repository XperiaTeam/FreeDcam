package com.troop.freedcam.themenubia.menu.childs;

import android.content.Context;
import android.view.LayoutInflater;

import com.troop.freedcam.themenubia.R;
import com.troop.freedcam.ui.AppSettingsManager;
import com.troop.freedcam.ui.I_PreviewSizeEvent;
import com.troop.freedcam.ui.menu.themes.classic.menu.ExpandableGroup;
import com.troop.freedcam.ui.menu.themes.classic.menu.childs.VideoProfileExpandableChild;

/**
 * Created by troop on 23.03.2015.
 */
public class NubiaVideoProfilChild extends VideoProfileExpandableChild {
    public NubiaVideoProfilChild(Context context, I_PreviewSizeEvent previewSizeEvent, ExpandableGroup group, String name, AppSettingsManager appSettingsManager, String settingsname) {
        super(context, previewSizeEvent, group, name, appSettingsManager, settingsname);
    }

    @Override
    protected void inflateTheme(LayoutInflater inflater) {
        inflater.inflate(R.layout.expandable_childs_nubia, this);
    }
}
