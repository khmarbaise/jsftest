package com.soebes.jsftest.domain;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

import com.soebes.jsftest.domain.Version;

/**
 * @author Karl Heinz Marbaise
 */
public class VersionTest {

    @Test
    public void initialisierungsTest() {
        Version v = new Version(1, 2, 3);
        assertThat(v.getMajor()).isEqualTo(1);
        assertThat(v.getMinor()).isEqualTo(2);
        assertThat(v.getPatch()).isEqualTo(3);
    }

    @Test
    public void initialisiereVonStringMajorMinorPatch() {
        Version v = new Version("1.23.244");
        assertThat(v.getMajor()).isEqualTo(1);
        assertThat(v.getMinor()).isEqualTo(23);
        assertThat(v.getPatch()).isEqualTo(244);
    }

    @Test
    public void initialisiereVonStringMajorMinor() {
        Version v = new Version("72.23");
        assertThat(v.getMajor()).isEqualTo(72);
        assertThat(v.getMinor()).isEqualTo(23);
        assertThat(v.getPatch()).isEqualTo(0);
    }

    @Test
    public void initialisiereVonStringMajor() {
        Version v = new Version("1");
        assertThat(v.getMajor()).isEqualTo(1);
        assertThat(v.getMinor()).isEqualTo(0);
        assertThat(v.getPatch()).isEqualTo(0);
    }

    @Test(expectedExceptions = { IllegalArgumentException.class })
    public void initialisiereVonStringMitFalschemMuster() {
        @SuppressWarnings("unused")
        Version v = new Version("1.23.xx");
    }

    @Test
    public void vergleicheNotEquals() {
        Version v100 = new Version(1, 0, 0);
        Version v101 = new Version(1, 0, 1);
        assertThat(v100).isNotEqualTo(v101);
    }

    @Test
    public void vergleicheAufEquals() {
        Version va = new Version(1, 0, 0);
        Version vb = new Version(1, 0, 0);
        assertThat(va).isEqualTo(vb);
    }

    @Test
    public void vergleicheMajorKleiner() {
        Version v100 = new Version(1, 0, 0);
        Version v200 = new Version(2, 0, 0);
        // 1.0.0 < 2.0.0 => compareTo() => -1
        assertThat(v100.compareTo(v200)).isEqualTo(-1);
    }

    @Test
    public void vergleicheMinorKleiner() {
        Version v100 = new Version(1, 0, 0);
        Version v110 = new Version(1, 1, 0);
        // 1.0.0 < 1.1.0 => compareTo() => -1
        assertThat(v100.compareTo(v110)).isEqualTo(-1);
    }

    @Test
    public void vergleichePatchKleiner() {
        Version v110 = new Version(1, 1, 0);
        Version v111 = new Version(1, 1, 1);
        // 1.1.0.compareTo(1.1.1) = -1
        assertThat(v110.compareTo(v111)).isEqualTo(-1);
    }

    @Test
    public void vergleicheMajorGroesse() {
        Version v100 = new Version(1, 0, 0);
        Version v200 = new Version(2, 0, 0);
        // 2.0.0 > 1.0.0 => compareTo() => +1
        assertThat(v200.compareTo(v100)).isEqualTo(+1);
    }

    @Test
    public void vergleicheMinorGroesse() {
        Version v100 = new Version(1, 0, 0);
        Version v110 = new Version(1, 1, 0);
        // 1.1.0 < 1.0.0 => compareTo() => +1
        assertThat(v110.compareTo(v100)).isEqualTo(+1);
    }

    @Test
    public void vergleichePatchGroesser() {
        Version v110 = new Version(1, 1, 0);
        Version v111 = new Version(1, 1, 1);
        // 1.1.1.compareTo(1.1.0) = +1
        assertThat(v111.compareTo(v110)).isEqualTo(+1);
    }

    @Test
    public void versionGTNegative() {
        Version v = new Version(1, 2, 0);
        Version v1 = new Version(1, 3, 0);
        assertThat(v.isGT(v1)).isFalse();
    }

    @Test
    public void versionGTPositive() {
        Version v = new Version(1, 2, 0);
        Version v1 = new Version(1, 3, 0);
        assertThat(v1.isGT(v)).isTrue();
    }

    @Test
    public void versionLTPositive() {
        Version v = new Version(1, 2, 0);
        Version v1 = new Version(1, 3, 0);
        assertThat(v.isLT(v1)).isTrue();
    }

    @Test
    public void versionLTNegative() {
        Version v = new Version(1, 2, 0);
        Version v1 = new Version(1, 3, 0);
        assertThat(v1.isLT(v)).isFalse();
    }

    @Test
    public void versionGE() {
        Version v = new Version(1, 2, 0);
        Version v1 = new Version(1, 3, 0);
        assertThat(v1.isGE(v)).isTrue();

        v = new Version(1, 2, 0);
        v1 = new Version(1, 2, 0);
        assertThat(v1.isGE(v)).isTrue();

        v = new Version(1, 2, 0);
        v1 = new Version(1, 2, 1);
        assertThat(v1.isGE(v)).isTrue();
        
        v = new Version(1, 2, 0);
        v1 = new Version(1, 2, 0);
        assertThat(v1.isGE(v)).isTrue();

        v = new Version(1, 2, 0);
        v1 = new Version(1, 1, 0);
        assertThat(v1.isGE(v)).isFalse();
    }

    @Test
    public void versionLE() {
        Version v = new Version(1, 2, 0);
        Version v1 = new Version(1, 3, 0);
        assertThat(v.isLE(v1)).isTrue();

        v = new Version(1, 2, 0);
        v1 = new Version(1, 2, 0);
        assertThat(v.isLE(v1)).isTrue();

        v = new Version(1, 2, 0);
        v1 = new Version(1, 2, 1);
        assertThat(v.isLE(v1)).isTrue();
        
        v = new Version(1, 2, 0);
        v1 = new Version(1, 2, 0);
        assertThat(v.isLE(v1)).isTrue();

        v = new Version(1, 2, 0);
        v1 = new Version(1, 1, 0);
        assertThat(v.isLE(v1)).isFalse();
    }

    @Test
    public void versionWithSnapShotXYZ() {
        Version v = new Version("1.2.3-SNAPSHOT");
        assertThat(v.getMajor()).isEqualTo(1);
        assertThat(v.getMinor()).isEqualTo(2);
        assertThat(v.getPatch()).isEqualTo(3);
        assertThat(v.isSnapshot()).isTrue();
    }

    @Test
    public void versionWithSnapShotXY() {
        Version v = new Version("1.2-SNAPSHOT");
        assertThat(v.getMajor()).isEqualTo(1);
        assertThat(v.getMinor()).isEqualTo(2);
        assertThat(v.getPatch()).isEqualTo(0);
        assertThat(v.isSnapshot()).isTrue();
    }

    @Test
    public void versionWithSnapShotX() {
        Version v = new Version("1-SNAPSHOT");
        assertThat(v.getMajor()).isEqualTo(1);
        assertThat(v.getMinor()).isEqualTo(0);
        assertThat(v.getPatch()).isEqualTo(0);
        assertThat(v.isSnapshot()).isTrue();
    }

    @Test
    public void printVersion() {
    	Version v = new Version(1,2,3);
    	assertThat(v.toString()).isEqualTo("1.2.3");
    	v = new Version(1,2,3,true);
    	assertThat(v.toString()).isEqualTo("1.2.3-SNAPSHOT");
    	v = new Version(1,0,0,true);
    	assertThat(v.toString()).isEqualTo("1.0.0-SNAPSHOT");
    }

    @Test
    public void vergleicheVersionMitSNAPSHOTVersion() {
    	Version v123SNAPSHOT = new Version(1,2,3, true);
    	Version v123 = new Version(1,2,3, false);
    	assertThat(v123SNAPSHOT.isLT(v123)).isTrue();
    	assertThat(v123SNAPSHOT.isLE(v123)).isTrue();
    	assertThat(v123.isGT(v123SNAPSHOT)).isTrue();
    	assertThat(v123.isGE(v123SNAPSHOT)).isTrue();
    	assertThat(v123.equals(v123SNAPSHOT)).isFalse();
    }
}