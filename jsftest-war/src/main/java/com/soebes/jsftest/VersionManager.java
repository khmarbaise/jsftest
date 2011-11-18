package com.soebes.jsftest;

import org.apache.log4j.Logger;

import com.soebes.jsftest.domain.Version;


/**
 * @author Karl Heinz Marbaise
 */
public class VersionManager {
	private static Logger LOGGER = Logger.getLogger(VersionManager.class);

	private Version version;

	public VersionManager() {
		LOGGER.info("VersionManager::VersionManager()");
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
	
}
