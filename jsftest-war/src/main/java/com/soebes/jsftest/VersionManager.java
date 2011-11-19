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
    
    private ArrayList<SelectItem> versionList = new ArrayList<SelectItem>();

    public VersionManager() {
        LOGGER.info("VersionManager::VersionManager()");
        
        versionList.add(new SelectItem(new Version(1,0,0), "1.0.0"));
        versionList.add(new SelectItem(new Version(1,1,0), "1.1.0"));
        versionList.add(new SelectItem(new Version(1,2,0), "1.2.0"));
        versionList.add(new SelectItem(new Version(1,3,0), "1.3.0"));
        versionList.add(new SelectItem(new Version(1,4,0), "1.4.0"));
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

    
}
