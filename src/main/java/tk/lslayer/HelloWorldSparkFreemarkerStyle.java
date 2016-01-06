package tk.lslayer;


import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreemarkerStyle {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration(new Version("2.3"));
		configuration.setClassForTemplateLoading(HelloWorldSparkFreemarkerStyle.class, "/");
        Spark.get("/hw", new Route() {
            public Object handle(Request request, Response response) throws Exception {
            	StringWriter writer = new StringWriter();
            	Template template = configuration.getTemplate("index.ftl");
            	Map<String, Object> indexMap = new LinkedHashMap<String, Object>();
            	indexMap.put("name", "Freemaker");
            	template.process(indexMap, writer);
            	System.out.println(writer);
                return writer;
            }
        });

	}

}
