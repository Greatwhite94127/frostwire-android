/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011-2014, FrostWire(R). All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.frostwire.android.gui.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.frostwire.android.core.Constants;

public final class OSUtils {
    
    public static boolean isKindleFire() {
        return Build.MANUFACTURER.equals("Amazon")
                && (Build.MODEL.equals("Kindle Fire")
                    || Build.MODEL.startsWith("KF"));
    }
    
    public static String getOSName() {
        String osName = "Android";
        if (OSUtils.isKindleFire()) {
            osName = "Kindle Fire";
        }
        return osName;
    }

    public static boolean isGooglePlayDistribution() {
        return Constants.IS_GOOGLE_PLAY_DISTRIBUTION;
    }
    
    public static String getOSVersionString() {
        return Build.VERSION.CODENAME + "_" + Build.VERSION.INCREMENTAL + "_" + Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT;
    }
    
    public static String getOSNameAndVersionString() {
        return OSUtils.getOSName()+"-v"+OSUtils.getOSVersionString();
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        try {
            return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        } catch (Throwable t) {
            //let's assume the user is holding the device in its natural way if we fail to retrieve the current orientation
            return true;
        }
    }
}