package com.sorin.cloudcog;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import com.sorin.cloudcog.arduino.ArduinoGraphActivity;
import com.sorin.cloudcog.car.obd2.Obd2BluetoothChatActivity;
import com.sorin.cloudcog.car.view.CarMainFragmentActivitySilver;
import com.sorin.cloudcog.cosmpull.Login;
import com.sorin.cloudcog.cosmpush.CosmAndroidResourcesActivity;
import com.sorin.cloudcog.geolocation.GeoLocationActivity;
import com.sorin.cloudcog.ioio.IOIOGraphActivity;
import com.sorin.cloudcog.mqtt.push.MqttActivity;
import com.sorin.cloudcog.phone.PhoneMainFragmentActivity;

public class CloudcogMainActivity extends Activity {
	private ImageButton btnCarSensors;
	private ImageButton btnPhoneSensors;
	private ImageButton btnCloudPull;
	private ImageButton btnCloudPush;
	private ImageButton btnIOIO;
	private ImageButton btnMqTTService;
	private ImageButton btnOpenXc;
	private ImageButton btnArduino;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_main_view);
		// points to the defined animation in the anim_scale.xml file

		final Animation animAlpha = AnimationUtils.loadAnimation(this,
				R.anim.anim_alpha);
		final Animation animTranslateYDeltaUp = AnimationUtils.loadAnimation(
				this, R.anim.anim_translate_ydelta_up);
		final Animation animTranslateYDeltaDown = AnimationUtils.loadAnimation(
				this, R.anim.anim_translate_ydelta_down);
		final Animation animTranslateXDeltaLeft = AnimationUtils.loadAnimation(
				this, R.anim.anim_translate_xdelta_left);
		final Animation animTranslateXDeltaRight = AnimationUtils
				.loadAnimation(this, R.anim.anim_translate_xdelta_right);

		btnMqTTService = (ImageButton) findViewById(R.id.btnmqtt);
		btnArduino = (ImageButton) findViewById(R.id.btnarduino);
		btnIOIO = (ImageButton) findViewById(R.id.btnioio);
		btnOpenXc = (ImageButton) findViewById(R.id.btnopenxc);
		btnCarSensors = (ImageButton) findViewById(R.id.btncarsensors);
		btnPhoneSensors = (ImageButton) findViewById(R.id.btnphonesensors);
		btnCloudPull = (ImageButton) findViewById(R.id.btncloudpull);
		btnCloudPush = (ImageButton) findViewById(R.id.btncloudpush);

		btnIOIO.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animAlpha);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(CloudcogMainActivity.this,
								IOIOGraphActivity.class);
						startActivity(intent);
					}
				}, 410);
			}
		});

		btnArduino.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				arg0.startAnimation(animTranslateYDeltaDown);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(CloudcogMainActivity.this,
								ArduinoGraphActivity.class);
						startActivity(intent);

					}
				}, 440);

			}
		});

		btnCloudPush.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animTranslateYDeltaUp);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(CloudcogMainActivity.this,
								CosmAndroidResourcesActivity.class);
						startActivity(intent);
					}
				}, 430);
			}
		});

		btnCloudPull.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animTranslateYDeltaDown);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						/* Create an Intent that will start the Menu-Activity. */
						Intent intent = new Intent(CloudcogMainActivity.this,
								Login.class);
						intent.putExtra("flag", "true");
						CloudcogMainActivity.this.startActivity(intent);

					}

				}, 430);

			}

		});

		btnPhoneSensors.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animTranslateXDeltaRight);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(CloudcogMainActivity.this,
								PhoneMainFragmentActivity.class);

						startActivity(intent);
					}
				}, 410);
			}
		});

		btnCarSensors.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				arg0.startAnimation(animTranslateXDeltaLeft);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(CloudcogMainActivity.this,
								CarMainFragmentActivitySilver.class);
						CloudcogMainActivity.this.finish();
						startActivity(intent);

					}
				}, 410);

			}
		});

		btnOpenXc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animAlpha);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(CloudcogMainActivity.this,
								IOIOGraphActivity.class);
						startActivity(intent);
					}
				}, 410);
			}
		});
		btnMqTTService.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				arg0.startAnimation(animTranslateYDeltaDown);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent = new Intent(CloudcogMainActivity.this,
								MqttActivity.class);
						startActivity(intent);
					}
				}, 440);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app_main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		/**
		 * the following switch statement will execute based on chosen optio and
		 * will trigger the appropriate intents
		 */
		case R.id.action_geolocation:

			startActivity(new Intent(this, GeoLocationActivity.class));
			Toast.makeText(this, "Geolocation services", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.action_usb:
			startActivityForResult(
					new Intent(
							android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS),
					0);
			Toast.makeText(this, "Turn On/Off USB debugging",
					Toast.LENGTH_SHORT).show();

			break;
		case R.id.action_wifi:

			startActivityForResult(new Intent(
					android.provider.Settings.ACTION_WIFI_SETTINGS), 0);
			Toast.makeText(this, "Manage wifi connection", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.action_location:

			startActivityForResult(new Intent(
					android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS),
					0);
			Toast.makeText(this, "Manage Location sources", Toast.LENGTH_SHORT)
					.show();
			break;

		case R.id.action_bluetooth:
			startActivityForResult(new Intent(
					android.provider.Settings.ACTION_BLUETOOTH_SETTINGS), 0);
			Toast.makeText(this, "Manage bluetooth connections",
					Toast.LENGTH_SHORT).show();

			break;
		case R.id.action_cosm_web:
			Intent browserIntent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.cosm.com"));
			startActivity(browserIntent);
			Toast.makeText(this, "Access your personal Cosm account",
					Toast.LENGTH_SHORT).show();

			break;

		case R.id.action_cosm_push:
			startActivity(new Intent(this, CosmAndroidResourcesActivity.class));
			Toast.makeText(this, "Push live data to Cosm", Toast.LENGTH_SHORT)
					.show();

			break;

		case R.id.action_cosm_pull:

			Intent mainIntent = new Intent(CloudcogMainActivity.this,
					Login.class);
			mainIntent.putExtra("flag", "true");
			CloudcogMainActivity.this.startActivity(mainIntent);
			Toast.makeText(this, "Pull live data from Cosm", Toast.LENGTH_SHORT)
					.show();
			return true;
		default:

			break;
		}
		return true;
	}

}
