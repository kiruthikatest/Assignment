package com.kaleidofin.util;


import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;

import org.testng.Assert;

public class Config {
	
	
	  /** The config instance. */
    private static Config mConfigInstance = null;

    /** The file name. */
    private static String mFileName = "config.properties";

    /** The properties. */
    private static Properties mProperties = new Properties();

    //To get properties from config.properties
    /**
     * Gets the single instance of Config.
     *
     * @return single instance of Config
     */
    public static Config getInstance() {
        synchronized (Config.class) {

            if (mConfigInstance == null) {
                mConfigInstance = new Config(mFileName);
            }
            return mConfigInstance;
        }
    }

    /**
     * Instantiates a new config.
     *
     * @param fileName
     *            the file name
     */
    private Config(final String fileName) {
        readPropertiesFile(fileName);
    }

    /**
     * Gets the setting of the key that has been passed.
     *
     * @param key
     *            the key
     * @return the setting
     */
    public String getSetting(final String key) {
        return mProperties.getProperty(key);
    }

    /**
     * Method to read .properties file content.
     *
     * @param fileName
     *            the file name
     * @return the content of file in form of Properties Object
     */
    
    private Properties readPropertiesFile(final String fileName) {
        FileReader reader = null;
        try {
            final URL fileUrl = ClassLoader.getSystemClassLoader().getResource(fileName);
            if (fileUrl == null) {
                Assert.fail("file: " + fileName + " not found");
            }
            final String file = URLDecoder.decode(fileUrl.getPath(), "UTF-8");
            
            reader = new FileReader(file);
            mProperties.load(reader);
        } catch (final FileNotFoundException e) {
            Assert.fail("Input .propeties file: " + fileName + " not found");
        } catch (final IOException e) {
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (final Exception e) {
                Assert.fail("Exception while reading config.properties file, Please check the input path.");
            }
        }
        return mProperties;
    }
	

}
