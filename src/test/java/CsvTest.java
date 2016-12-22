import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;
import org.finra.hiveqlunit.resources.LocalFileResource;
import org.finra.hiveqlunit.resources.ResourceFolderResource;
import org.finra.hiveqlunit.rules.SetUpHql;
import org.finra.hiveqlunit.rules.TearDownHql;
import org.finra.hiveqlunit.resources.TextLiteralResource;
import org.finra.hiveqlunit.rules.TestDataLoader;
import org.finra.hiveqlunit.rules.TestHiveServer;
import org.finra.hiveqlunit.script.MultiExpressionScript;
import org.finra.hiveqlunit.script.SingleExpressionScript;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class CsvTest {
    @ClassRule
    public static TestHiveServer hiveServer = new TestHiveServer();

    @Rule
    public static TestDataLoader loader = new TestDataLoader(hiveServer);

    @Rule
    public static SetUpHql prepSrc =
            new SetUpHql(
                    hiveServer,
                    new MultiExpressionScript(
                            new VariableConfigResource(
                                    new ResourceFolderResource("/create_event_table.hql")
                            ).addConfig("resources", new File("src/test/resources").getAbsolutePath())
                    )
            );


//    @Test
//    public void testSelectCountry() throws Exception {
//        HiveContext sqlContext = hiveServer.getHiveContext();
//        Row[] results = sqlContext.sql("SELECT * FROM country").collect();
//        assertEquals(251, results.length);
//    }

    @Test
    public void testSelectEvent() throws Exception {
        HiveContext sqlContext = hiveServer.getHiveContext();
        Row[] results = sqlContext.sql("SELECT requestid, profileid FROM event where product = 'pollinatorv3'").collect();
        assertEquals(1, results.length);
        assertEquals("644e0bef-3d02-4732-9da1-4d7341792afa", results[0].getString(0));
        assertEquals("fb87946e-40d2-401b-8221-b82ad1273df5", results[0].getString(1));
    }
}
