//import static org.junit.Assert.assertEquals;
//
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.hive.HiveContext;
//import org.finra.hiveqlunit.resources.LocalFileResource;
//import org.finra.hiveqlunit.resources.TextLiteralResource;
//import org.finra.hiveqlunit.rules.SetUpHql;
//import org.finra.hiveqlunit.rules.TestDataLoader;
//import org.finra.hiveqlunit.rules.TestHiveServer;
//import org.finra.hiveqlunit.script.MultiExpressionScript;
//import org.junit.Assert;
//import org.junit.ClassRule;
//import org.junit.Rule;
//import org.junit.Test;
//
//import java.io.*;
//
//public class SampleTest {
//
//    @ClassRule
//    public static TestHiveServer hiveServer = new TestHiveServer();
//
//    @Rule
//    public static TestDataLoader loader = new TestDataLoader(hiveServer);
//
//    @Test
//    public void testA() throws Exception {
//        HiveContext sqlContext = hiveServer.getHiveContext();
//        sqlContext.sql("drop table if exists sales");
//        sqlContext.sql("create table sales(saletime timestamp, shop string, amount int) row format delimited fields terminated by '\t' lines terminated by '\n'");
//        loader.loadDataIntoTable("sales", new LocalFileResource("src/test/resources/testdata.txt"), "");
//
//        sqlContext.sql("drop table if exists sales_by_shop");
//        sqlContext.sql(readHql("sample.hql"));
//
//        Row[] results = sqlContext.sql("SELECT shop,amount FROM sales_by_shop").collect();
//        assertEquals(3, results.length);
//
//        Row[] resultsA = sqlContext.sql("SELECT sum(amount) FROM sales_by_shop").collect();
//        Row[] resultsB = sqlContext.sql("SELECT sum(amount) FROM sales").collect();
//        assertEquals(resultsB[0].getLong(0), resultsA[0].getLong(0));
//    }
//
//    public static String readHql(String fname) throws IOException {
//        StringBuffer buf = new StringBuffer();
//        BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/" + fname)));
//        String str = br.readLine();
//        while(str != null) {
//            buf.append(str).append("\n");
//            str = br.readLine();
//        }
//        br.close();
//        return buf.toString();
//    }
//
//}
