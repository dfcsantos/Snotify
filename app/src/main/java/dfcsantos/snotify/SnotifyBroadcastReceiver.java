package dfcsantos.snotify;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SnotifyBroadcastReceiver extends BroadcastReceiver {

	private Activity activity;

	public SnotifyBroadcastReceiver(Activity snotifyActivity) {
		activity = snotifyActivity;
	}

	static final class BroadcastTypes {
		static final String SPOTIFY_PACKAGE = "com.spotify.music";
		static final String PLAYBACK_STATE_CHANGED = SPOTIFY_PACKAGE + ".playbackstatechanged";
		static final String QUEUE_CHANGED = SPOTIFY_PACKAGE + ".queuechanged";
		static final String METADATA_CHANGED = SPOTIFY_PACKAGE + ".metadatachanged";
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();

		if (action.equals(BroadcastTypes.METADATA_CHANGED)) {
			String trackId = intent.getStringExtra("id");
			String artistName = intent.getStringExtra("artist");
			String trackName = intent.getStringExtra("track");

			String uri = trackId.replace("spotify:track:", "http://open.spotify.com/track/");
			activity.startService(activity.getIntent().<Intent>getParcelableExtra("SEND_MESSAGE").setAction(artistName + " - " + trackName + " - " + uri));
		}
	}

}
