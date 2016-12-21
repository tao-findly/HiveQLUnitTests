//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.hive.HiveContext;
//import org.finra.hiveqlunit.resources.LocalFileResource;
//import org.finra.hiveqlunit.resources.ResourceFolderResource;
//import org.finra.hiveqlunit.rules.SetUpHql;
//import org.finra.hiveqlunit.rules.TearDownHql;
//import org.finra.hiveqlunit.resources.TextLiteralResource;
//import org.finra.hiveqlunit.rules.TestDataLoader;
//import org.finra.hiveqlunit.rules.TestHiveServer;
//import org.finra.hiveqlunit.script.MultiExpressionScript;
//import org.finra.hiveqlunit.script.SingleExpressionScript;
//import org.junit.ClassRule;
//import org.junit.Rule;
//import org.junit.Test;
//
//
//import static org.junit.Assert.assertEquals;
//
//public class ProfileTest {
//    @ClassRule
//    public static TestHiveServer hiveServer = new TestHiveServer();
//
//    @Rule
//    public static TestDataLoader loader = new TestDataLoader(hiveServer);
//
//    @Rule
//    public static SetUpHql prepSrc =
//            new SetUpHql(
//                    hiveServer,
//                    new MultiExpressionScript(
//                            new ResourceFolderResource("/setup.sql")
//                    )
//            );
//
//    @Rule
//    public static TearDownHql cleanSrc =
//            new TearDownHql(
//                    hiveServer,
//                    new MultiExpressionScript(
//                            new ResourceFolderResource("/teardown.sql")
//                    )
//            );
//
//    @Test
//    public void testSelectProfile() throws Exception {
//        HiveContext sqlContext = hiveServer.getHiveContext();
//        loader.loadDataIntoTable("profile", new LocalFileResource("src/test/resources/profile.txt"), "");
//        Row[] results = sqlContext.sql("SELECT * FROM profile WHERE id = 'fb878fe5-d0d4-4e74-9da6-4bd541aba732'").collect();
//        assertEquals(1, results.length);
//    }
//
//    @Test
//    public void testCountInterest() throws Exception {
//        HiveContext sqlContext = hiveServer.getHiveContext();
//        loader.loadDataIntoTable("interest", new LocalFileResource("src/test/resources/interest.txt"), "");
//
//        Row[] results = sqlContext.sql("SELECT title, COUNT(*) FROM interest GROUP BY title").collect();
//        assertEquals(4, results.length);
//        assertEquals("Health", results[0].getString(0));
//        assertEquals(2, results[0].getLong(1));
//    }
//
//    @Test
//    public void testJoin() throws Exception {
//        HiveContext sqlContext = hiveServer.getHiveContext();
//        loader.loadDataIntoTable("profile", new LocalFileResource("src/test/resources/profile.txt"), "");
//        loader.loadDataIntoTable("interest", new LocalFileResource("src/test/resources/interest.txt"), "");
//        MultiExpressionScript script = new MultiExpressionScript(
//                new ResourceFolderResource("/insert_profile_interest.sql")
//        );
//        script.runScript(sqlContext);
//        Row[] results = sqlContext.sql("SELECT id, interestTitle FROM profile_interest WHERE id = 'fb87946e-40d2-401b-8221-b82ad1273df5'").collect();
//        assertEquals(3, results.length);
//    }
//}
