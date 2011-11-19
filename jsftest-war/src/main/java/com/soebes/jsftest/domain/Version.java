package com.soebes.jsftest.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ermöglicht die Nutzung einer Version die aus Major, Minor und Patch Anteilen
 * besteht. Optional ist auch die Angabe <code>-SNAPSHOT</code> möglich.
 * 
 * @author Karl Heinz Marbaise
 */
public class Version implements Comparable<Version> {


    /**
     * Angabe für eine Unbekannte Version.
     */
    public static final Version VERSION_UNKNOWN = new Version(0, 0, 0, false);

    private static final String SNAPSHOT = "-SNAPSHOT";

    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\d+)(\\.(\\d+)(\\.(\\d+))?)?((\\" + SNAPSHOT + "))?");

    private int major;
    private int minor;
    private int patch;

    private boolean snapshot;

    public Version(int major, int minor, int patch, boolean snapshot) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.snapshot = snapshot;
    }

    public Version(int major, int minor, int patch) {
        this(major, minor, patch, false);
    }

    public Version(int major, int minor) {
        this(major, minor, 0, false);
    }

    public Version(int major) {
        this(major, 0, 0, false);
    }

    public Version() {
        this(0, 0, 0, false);
    }

    /**
     * Konstruktor mit Versionsstring Muster <code>x[.y[.z]][-SNAPSHOT]</code>
     * 
     * @param versionString
     *            Der Versionsstring.
     */
    public Version(String versionString) {
        Matcher matcher = VERSION_PATTERN.matcher(versionString);
        if (matcher.matches()) {
            if (matcher.group(1) != null) {
                setMajor(Integer.valueOf(matcher.group(1)));
            }
            if (matcher.group(3) != null) {
                setMinor(Integer.valueOf(matcher.group(3)));
            }
            if (matcher.group(5) != null) {
                setPatch(Integer.valueOf(matcher.group(5)));
            }
            if (matcher.group(6) != null && matcher.group(6).equals(SNAPSHOT)) {
                setSnapshot(true);
            }
        } else {
            throw new IllegalArgumentException("Die Version '" + versionString + "' entspricht nicht dem Schemata x.y.z oder x.y.z-SNAPSHOT!");
        }
    }

    @Override
    public String toString() {
        if (isSnapshot()) {
            return major + "." + minor + "." + patch + SNAPSHOT;
        } else {
            return major + "." + minor + "." + patch;
        }
    }

    public final int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public final int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        this.patch = patch;
    }

    public void setSnapshot(boolean snapshot) {
        this.snapshot = snapshot;
    }

    public boolean isSnapshot() {
        return snapshot;
    }

    public boolean isGT(Version version) {
        if (this.compareTo(version) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGE(Version version) {
        if (this.compareTo(version) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLT(Version version) {
        if (this.compareTo(version) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLE(Version version) {
        if (this.compareTo(version) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + major;
        result = prime * result + minor;
        result = prime * result + patch;
        result = prime * result + (snapshot ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Version other = (Version) obj;
        if (major != other.major)
            return false;
        if (minor != other.minor)
            return false;
        if (patch != other.patch)
            return false;
        if (snapshot != other.snapshot)
            return false;
        return true;
    }

    /** {@inheritDoc} */
    public int compareTo(Version o) {
        if (this == o) {
            return 0;
        }

        if (getMajor() < o.getMajor()) {
            return -1;
        } else if (getMajor() > o.getMajor()) {
            return +1;
        } else {
            if (getMinor() < o.getMinor()) {
                return -1;
            } else if (getMinor() > o.getMinor()) {
                return +1;
            } else {
                if (getPatch() < o.getPatch()) {
                    return -1;
                } else if (getPatch() > o.getPatch()) {
                    return +1;
                } else {
                    if (isSnapshot() && !o.isSnapshot()) {
                        return -1;
                    } else if (!isSnapshot() && o.isSnapshot()) {
                        return +1;
                    }
                }
            }
        }
        return 0;
    }

}
