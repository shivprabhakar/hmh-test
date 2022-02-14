import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/Features/WebsiteTest.feature",
    glue = {"stepDefinitions"}

)
public class TestRunner extends AbstractTestNGCucumberTests{

}
