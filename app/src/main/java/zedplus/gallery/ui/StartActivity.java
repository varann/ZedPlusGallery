package zedplus.gallery.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Map;

import zedplus.gallery.App;
import zedplus.gallery.R;
import zedplus.gallery.client.ApiClient;

/**
 * Created by asavinova on 18/09/16.
 */
@EActivity(R.layout.start)
public class StartActivity extends AppCompatActivity {

	@ViewById ListView listView;

	@AfterViews
	void afterViews() {

		final Map<Class<? extends ApiClient>, Integer> clientsMap = ApiClient.Implementations.getClients();
		final ArrayList<Integer> values = new ArrayList<>(clientsMap.values());

		ArrayAdapter adapter = new ArrayAdapter(this, R.layout.api_button) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				((TextView) view).setText(getString(values.get(position)));
				return view;
			}
		};
		adapter.addAll(values);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
				Class<? extends ApiClient> type = (Class<? extends ApiClient>) clientsMap.keySet().toArray()[position];
				((App) getApplication()).setClientType(type);
				GalleryActivity_.intent(StartActivity.this).start();
			}
		});

	}

}
