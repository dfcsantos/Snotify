package dfcsantos.snotify;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class SnotifyActivity extends ActionBarActivity {

	SnotifyBroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		receiver = new SnotifyBroadcastReceiver(this);

		IntentFilter filter = new IntentFilter();
		filter.addAction(SnotifyBroadcastReceiver.BroadcastTypes.METADATA_CHANGED);
		registerReceiver(receiver, filter);

		finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}

}
