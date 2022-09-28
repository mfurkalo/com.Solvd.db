/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package utils.interfaces;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:global.properties")
public interface IProperties extends Config {
    @Key("sqlDriver")
    String sqlDriver();

    @Key("url")
    String url();

    @Key("user")
    String user();

    @Key("password")
    String password();

    @Key("initialPoolSize")
    int initialPoolSize();

    @Key("maxPoolSize")
    int maxPoolSize();

    @Key("maxTimeout")
    int maxTimeout();
}
