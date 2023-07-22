package util;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.Getter;
import questions.EnvironmentInfo;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@Getter
public class MockHandler {
    public  static WireMockServer wireMockServer;


    public static void startMockingForAPI() {
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("api")) {
            wireMockServer = new WireMockServer(wireMockConfig().port(8089));
            wireMockServer.start();
        }
    }

    public static void stopMockingForAPI() {
        if (EnvironmentInfo.getRunProfile().toLowerCase().contains("api")) {
            wireMockServer.stop();
        }
    }


}
