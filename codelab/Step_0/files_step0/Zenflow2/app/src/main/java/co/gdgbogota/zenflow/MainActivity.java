package co.gdgbogota.zenflow;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;

import static co.gdgbogota.zenflow.SettingsUtil.SetAirplaneMode;


public class MainActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener {
    private SwitchCompat mAirplaneModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAirplaneModeSwitch = (SwitchCompat) findViewById(R.id.airplane_mode_switch );
        mAirplaneModeSwitch.setOnCheckedChangeListener(this);
        syncViews();
    }

    private void syncViews(){
        boolean airplaneMode = SettingsUtil.isAirPlaneModeEnabled(this);
        mAirplaneModeSwitch.setChecked(airplaneMode);
    }

    private void updateSetting(boolean enabled){
        SetAirplaneMode(this, enabled);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        updateSetting(isChecked);
    }

}
