package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${deviceHost}.properties"})
public interface MobConfig extends Config {

    String username();

    String password();

    String appUrl();

    String remoteUrl();

    String videoUrl();

    String deviceName();

    String pathToApp();

    String osVersion();

}
