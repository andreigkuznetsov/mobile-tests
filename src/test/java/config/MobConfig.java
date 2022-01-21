package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${environment}.properties"})
public interface MobConfig extends Config {

    String username();

    String password();

    String appUrl();

    String remoteUrl();

    String videoUrl();

    String realDeviceName();

    String pathToApp();

}
