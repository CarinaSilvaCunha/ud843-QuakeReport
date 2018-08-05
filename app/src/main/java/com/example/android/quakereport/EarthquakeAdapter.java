package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int arrayPosition, View incomingView, @NonNull ViewGroup parent) {

        // Assign the incoming view to a list view variable.
        View viewListItem = incomingView;

        // Check that earthquake item is not NULL.
        if (viewListItem == null) {
            viewListItem = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }

        // Assign the current earthquake in the ArrayList to a Earthquake variable.
        Earthquake currentEarthquake = getItem(arrayPosition);

        // Earthquake magnitude String manipulation.
        double magOrig = currentEarthquake.getEqMag();
        String formattedMagnitude = formatMagnitude(magOrig);

        // Earthquake location String manipulation.
        String locOrig = currentEarthquake.getEqLoc();
        String locOffset;
        String locPrimary;
        final String LOCATION_SEPARATOR = getContext().getString(R.string.location_separator);

        if (locOrig.contains(LOCATION_SEPARATOR)) {

            String[] parts = locOrig.split(Pattern.quote(LOCATION_SEPARATOR));
            locOffset = parts[0] + LOCATION_SEPARATOR;
            locPrimary = parts[1];
        } else {

            locOffset = getContext().getString(R.string.near_the);
            locPrimary = locOrig;
        }

        // Earthquake date manipulation.
        // Create a new Date object from the time of the earthquake.
        Date dateObject = new Date(currentEarthquake.getEqTime());

        // Format the date string (i.e. "Mar 3, 1984").
        String formattedDate = formatDate(dateObject);

        // Format the time string (i.e. "4:30PM").
        String formattedTime = formatTime(dateObject);

        // Find and set the text of the current Earthquake magnitude.
        TextView titleTextView1 = (TextView) viewListItem.findViewById(R.id.eq_mag);
        titleTextView1.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magCircle = (GradientDrawable) titleTextView1.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getEqMag());

        // Set the color on the magnitude circle
        magCircle.setColor(magnitudeColor);

        // Find and set the text of the current Earthquake location.
        TextView titleTextView2 = (TextView) viewListItem.findViewById(R.id.eq_loc_offset);
        titleTextView2.setText(locOffset.toUpperCase());

        // Find and set the text of the current Earthquake location.
        TextView titleTextView3 = (TextView) viewListItem.findViewById(R.id.eq_loc_primary);
        titleTextView3.setText(locPrimary);

        // Find and set the text of the current Earthquake date.
        TextView titleTextView4 = (TextView) viewListItem.findViewById(R.id.eq_date);
        titleTextView4.setText(formattedDate);

        // Find and set the text of the current Earthquake time.
        TextView titleTextView5 = (TextView) viewListItem.findViewById(R.id.eq_time);
        titleTextView5.setText(formattedTime);

        return viewListItem;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(getContext().getString(R.string.date_format));
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat(getContext().getString(R.string.time_format));
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {

        int magColor;
        int magRoundDown = (int) Math.floor(magnitude);

        switch (magRoundDown) {
            case 0:
            case 1:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magColor;
    }
}