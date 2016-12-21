import org.apache.commons.io.FileUtils;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;

public class FileResetRule implements TestRule {
    private File directory;

    public FileResetRule(File directory) {
        this.directory = directory;
    }

    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                //code here executes before test runs
                clearFiles();
                base.evaluate();
                //code here executes after test is finished
            }
        };
    }

    private void clearFiles() throws IOException {
        FileUtils.cleanDirectory(this.directory);
    }
}
