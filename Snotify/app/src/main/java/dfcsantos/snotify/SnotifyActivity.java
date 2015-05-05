package dfcsantos.snotify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class SnotifyActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		startService(getIntent().<Intent>getParcelableExtra("SEND_MESSAGE").setAction("http://open.spotify.com/track/1SXBC7gcwQNLzn9THgigxk"));
		finish();
	}

}
