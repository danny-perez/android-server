package co.wolholland.kabbicompanionv2;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we
     * just add a marker near Africa.
     */
    private static final LatLng MELBOURNE = new LatLng(49.896217, 10.887134);
    private static final LatLng ADELAIDE = new LatLng(49.896853, 10.894130);
    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(MELBOURNE).title("Start").draggable(true).icon(BitmapDescriptorFactory.fromResource(R.drawable.pegman)));
        map.addMarker(new MarkerOptions().position(ADELAIDE).title("Finish").draggable(true));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(49.896881, 10.891083), 15));
        map.addPolyline((new PolylineOptions()).add(MELBOURNE, ADELAIDE)
                .color(Color.RED)
                .width(5f));
    }
}
