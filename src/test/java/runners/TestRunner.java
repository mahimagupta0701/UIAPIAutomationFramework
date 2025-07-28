package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
glue = {"apistepdefinitions", "hooks"},
tags = "@debug", // 👈 Run only scenarios with annotation @debug
plugin = { "pretty", "html:target/cucumber-reports/cucumber.html" },
monochrome = true
)
public class TestRunner {}
