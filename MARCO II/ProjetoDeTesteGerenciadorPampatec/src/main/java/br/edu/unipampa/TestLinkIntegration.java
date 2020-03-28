package br.edu.unipampa;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.TestCase;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import org.apache.http.client.utils.URIBuilder;
import testlink.api.java.client.TestLinkAPIClient;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class TestLinkIntegration {

    public static final String TESTLINK_KEY = PropertyReader.read("chaveEsther");
    public static final String TESTLINK_URL = "http://lesse.com.br/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
    public static final String TEST_PROJECT_NAME = "Gerenciador Pampatec - Grupo 08";
    public static final String TEST_PLAN_NAME = "Plano teste";
    public static final String BUILD_NAME = "versão8";

    public static void run() throws TestLinkAPIException, URISyntaxException, MalformedURLException {
        URL url = new URIBuilder().setScheme("http").setHost("lesse.com.br").setPath("/testlink/lib/api/xmlrpc/v1/xmlrpc.php").build().toURL();
        TestLinkAPI testLink = new TestLinkAPI(url, TESTLINK_KEY);
        TestCase testCase = testLink.getTestCase(4,1, 1);

        System.out.println(testCase.toString());
    }

    public static void updateResults(String testCaseName, String exception, String results) throws testlink.api.java.client.TestLinkAPIException {
        TestLinkAPIClient testLinkAPIClient = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
        testLinkAPIClient.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
    }

    public static void updateResults(String testCaseName, String exception, String results, String key) throws testlink.api.java.client.TestLinkAPIException {
        TestLinkAPIClient testLinkAPIClient = new TestLinkAPIClient(key, TESTLINK_URL);
        testLinkAPIClient.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
    }

    public static void main (String[] args) throws MalformedURLException, URISyntaxException {
        TestLinkIntegration.run();
    }

}