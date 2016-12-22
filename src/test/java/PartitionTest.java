import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;
import org.finra.hiveqlunit.resources.ResourceFolderResource;
import org.finra.hiveqlunit.rules.SetUpHql;
import org.finra.hiveqlunit.rules.TestDataLoader;
import org.finra.hiveqlunit.rules.TestHiveServer;
import org.finra.hiveqlunit.script.MultiExpressionScript;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PartitionTest {
    @ClassRule
    public static TestHiveServer hiveServer = new TestHiveServer();

    @Rule
    public static TestDataLoader loader = new TestDataLoader(hiveServer);

    @Rule
    public static SetUpHql prepSrc =
            new SetUpHql(
                    hiveServer,
                    new MultiExpressionScript(
                            new ResourceFolderResource("/create_events_table_by_partition.hql")
                    )
            );

    @Test
    public void testPartitionValidRange() {
        HiveContext sqlContext = hiveServer.getHiveContext();
        Row[] results = sqlContext.sql("SELECT * FROM events").collect();
        assertEquals(2, results.length);
        assertEquals("UAT-ORG161", results[0].getString(0));
        assertEquals(161, results[0].getInt(1));
        assertEquals("dropped", results[0].getString(6));
    }
}
