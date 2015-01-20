package co.gdgbogota.zenflow;

import android.content.Context;
import android.provider.Settings;

import static android.provider.Settings.Global.AIRPLANE_MODE_ON;

/**
 * Created by carlosrojas on 12/24/14.
 */
public class SettingsUtil {
    public static boolean isAirPlaneModeEnabled(Context context) {
        return Settings.System.getInt(context.getContentResolver(), AIRPLANE_MODE_ON,0) != 0;
    }

    public static void SetAirplaneMode(Context context, boolean enabled) {
        Settings.System.putInt(context.getContentResolver(), AIRPLANE_MODE_ON, enabled ? 1 : 0);
    }
}
