/*
 * Copyright (C) 2016 FireHound
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.fh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.R;

import org.cyanogenmod.internal.logging.CMMetricsLogger;

public class Info extends SettingsPreferenceFragment {

    public static final String TAG = "Info";

    private static final String KEY_FH_SHARE = "share";

    Preference mSourceUrl;
    Preference mGoogleUrl;
    Preference mDeveloperUrl;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.fh_info);

        mSourceUrl = findPreference("fh_source");
        mGoogleUrl = findPreference("fh_google_plus");
        mDeveloperUrl = findPreference("fh_developer");
    }

    @Override
    protected int getMetricsCategory() {
        // todo add a constant in MetricsLogger.java
        return CMMetricsLogger.MAIN_SETTINGS;
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mSourceUrl) {
            launchUrl("https://github.com/FireHound");
        } else if (preference == mGoogleUrl) {
            launchUrl("https://plus.google.com/communities/114615598909452601377");
        } else if (preference == mDeveloperUrl) {
            launchUrl("https://github.com/PMS22");
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(intent);
    }

}
