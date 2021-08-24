package core.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties",
        "classpath:local.properties"})
public interface Configuration extends Config {

    @Key("headless")
    Boolean headless();

    @Key("url.base")
    String url();

    @Key("browser")
    String browser();

    @Key("timeout")
    int timeout();

}
