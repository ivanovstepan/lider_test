package utils;

import java.util.UUID;

public class ENV {

    public static final String yandexUrl;
    public static final String login;
    public static final String pass;
    public static final String code;

    public static final String googleUrl;
    public static final String reqresUrl;


    static {
        yandexUrl = Properties.getPropertyString("yandex.url");
        login = Properties.getPropertyString("yandex.login");
        pass = Properties.getPropertyString("yandex.pass");
        code = Properties.getPropertyString("yandex.code");

        googleUrl = Properties.getPropertyString("google.url");
        reqresUrl = Properties.getPropertyString("reqres.url");
    }

}
