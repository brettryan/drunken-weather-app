# Drunken Weather

Demo spring MVC + knockout.js application displaying simple weather conditions.


## Configuring

In order to perform queries against OpenWeatherMap you will need to first obtain
an application key. Signing up to [OpenWeatherMap](https://openweathermap.org)
first will be required. You can then obtain your key through the API Keys section
of the OpenWeatherMap interface.

Once you have your key you will need to set it in `src/main/resources/weather.user.config.properties`.
This file does not exist in the repository and is excluded from committing. Add
the following to your `weather.user.config.properties` file replacing the app id
with the one you have obtained.

```properties
weather.api.owm.appid=76b1302fb5c7ce6ad1382ccb17d6703c
```

## Running

You can get up and executing either the `jetty:run` goal.

Jetty is a light weight servlet container that is the fastest way to getting
things running. When you issue the following maven goal, you wil be able to
access the application through [http://localhost:8080/](http://localhost:8080/).

```bash
mvn jetty:run
```

Once successfully started the following output will be produced.

    [INFO] Started Jetty Server

![Up and Running](https://raw.githubusercontent.com/brettryan/drunken-weather-app/master/doc/images/up-and-running.png)

