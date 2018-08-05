package com.example.android.quakereport;

public class Earthquake {

    /**
     * Earthquake magnitude.
     */
    private double eqMag;

    /**
     * Earthquake location.
     */
    private String eqLoc;

    /**
     * Earthquake time.
     */
    private long eqTime;

    /**
     * Earthquake URL.
     */
    private String eqUrl;

    /**
     * Create a new Earthquake object.
     *
     * @param mag  the magnitude of the earthquake.
     * @param loc  the location of the earthquake.
     * @param time the time of the earthquake.
     * @param url  the time of the earthquake.
     */
    public Earthquake(double mag, String loc, long time, String url) {
        eqMag = mag;
        eqLoc = loc;
        eqTime = time;
        eqUrl = url;
    }

    /**
     * Get the Earthquake magnitude.
     */
    public double getEqMag() {
        return eqMag;
    }

    /**
     * Get the Earthquake location.
     */
    public String getEqLoc() {
        return eqLoc;
    }

    /**
     * Get the Earthquake date.
     */
    public long getEqTime() {
        return eqTime;
    }

    /**
     * Get the Earthquake URL.
     */
    public String getEqUrl() {
        return eqUrl;
    }
}