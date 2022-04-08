package com.example.carnetdevoyage.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.carnetdevoyage.R;
import com.example.carnetdevoyage.databinding.ActivityMapsBinding;
import com.example.carnetdevoyage.databinding.FragmentDashboardBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DashboardFragment extends Fragment implements OnMapReadyCallback {

    private FragmentDashboardBinding binding;
    SupportMapFragment supportMapFragment;



    private GoogleMap mMap;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.fragment_dashboard,container,false);
         supportMapFragment=  (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map1);
         supportMapFragment.getMapAsync(this);





        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Versailles = new LatLng(48.801408, 2.130122);
        mMap.addMarker(new MarkerOptions().position(Versailles).title("Marker in Versailles"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Versailles));

    }
}