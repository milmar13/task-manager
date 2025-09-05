/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author MakiMica
 */

public final class Config {
    
    private static final Config INSTANCE = new Config();
    private String dataPath = "src/main/resources/tasks.json";

    private Config() {}
    
    public static Config getInstance() {
        return INSTANCE;
    }

    public String getDataPath() {
        return dataPath;
    }
    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }
    
}

