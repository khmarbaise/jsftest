package com.soebes.jsftest;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.soebes.jsftest.domain.Version;

/**
 * @author Karl Heinz Marbaise
 */
@ManagedBean(name = "versionManager")
@SessionScoped
public class VersionManager implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4251591106093578483L;

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
        return "version";
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
