package com.soebes.jsftest;

import java.util.ArrayList;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.soebes.jsftest.domain.Version;

/**
 * @author Karl Heinz Marbaise
 */
public class VersionManager {
    private static Logger LOGGER = Logger.getLogger(VersionManager.class);

    private Version version;
    private Version selectedVersion;
    
    private ArrayList<SelectItem> versionList = new ArrayList<SelectItem>();

    public VersionManager() {
        LOGGER.info("VersionManager::VersionManager()");
        
        for (int i=0; i<6;i++) {
            Version v = new Version(1,i,0);
            versionList.add(new SelectItem(v, v.toString()));
        }
    }

    public String action() {
        return "success";
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public ArrayList<SelectItem> getVersionList() {
        return versionList;
    }

    public void setVersionList(ArrayList<SelectItem> versionList) {
        this.versionList = versionList;
    }

    public Version getSelectedVersion() {
        return selectedVersion;
    }

    public void setSelectedVersion(Version selectedVersion) {
        this.selectedVersion = selectedVersion;
    }
    
}
