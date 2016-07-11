package nl.esciencecenter.e3dchem.kripodb;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.knime.core.node.CanceledExecutionException;
import org.knime.core.node.InvalidSettingsException;
import org.knime.core.node.workflow.UnsupportedWorkflowVersionException;
import org.knime.core.util.LockFailedException;
import org.knime.testing.core.TestrunConfiguration;

import nl.esciencecenter.e3dchem.knime.testing.TestFlowRunner;
import nl.esciencecenter.e3dchem.python.PythonWrapperTestUtils;

public class FragmentsBySimilarityWorkflowTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();
    private TestFlowRunner runner;
    private static File distances = new File(System.getProperty("java.io.tmpdir"), "distances.h5");

    @Before
    public void setUp() {
        TestrunConfiguration runConfiguration = new TestrunConfiguration();
        runConfiguration.setTestDialogs(true);
        runner = new TestFlowRunner(collector, runConfiguration);
    }

    @BeforeClass
    public static void setUpDatafiles() throws MalformedURLException, IOException {
        PythonWrapperTestUtils.materializeKNIMEPythonUtils();
        FileUtils.copyURLToFile(new URL("https://github.com/3D-e-Chem/kripodb/raw/master/data/distances.h5"), distances);
    }

    @AfterClass
    public static void cleanupDatafiles() {
        distances.delete();
    }

    @Test
    public void test_usingwebservice() throws IOException, InvalidSettingsException, CanceledExecutionException,
            UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
        File workflowDir = new File("src/knime/kripo-similar-fragments-test-ws");
        runner.runTestWorkflow(workflowDir);
    }

    @Test
    public void test_usinlocalfile() throws IOException, InvalidSettingsException, CanceledExecutionException,
            UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
        File workflowDir = new File("src/knime/kripo-similar-fragments-test-localmatrix");
        runner.runTestWorkflow(workflowDir);
    }

    @Test
    public void test_invalidsettings() throws IOException, InvalidSettingsException, CanceledExecutionException,
            UnsupportedWorkflowVersionException, LockFailedException, InterruptedException {
        File workflowDir = new File("src/knime/kripo-similar-fragments-test-invalidsettings");
        runner.runTestWorkflow(workflowDir);
    }

}
