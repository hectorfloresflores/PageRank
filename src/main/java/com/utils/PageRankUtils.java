package com.utils;


import com.Pagerank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PageRankUtils {

    public static final String CREATE_GRAPH = "CREATE\n" +
            "  (home:Page {name:'Home'}),\n" +
            "  (about:Page {name:'About'}),\n" +
            "  (product:Page {name:'Product'}),\n" +
            "  (links:Page {name:'Links'}),\n" +
            "  (a:Page {name:'Site A'}),\n" +
            "  (b:Page {name:'Site B'}),\n" +
            "  (c:Page {name:'Site C'}),\n" +
            "  (d:Page {name:'Site D'}),\n" +
            "\n" +
            "  (home)-[:LINKS {weight: 0.2}]->(about),\n" +
            "  (home)-[:LINKS {weight: 0.2}]->(links),\n" +
            "  (home)-[:LINKS {weight: 0.6}]->(product),\n" +
            "  (about)-[:LINKS {weight: 1.0}]->(home),\n" +
            "  (product)-[:LINKS {weight: 1.0}]->(home),\n" +
            "  (a)-[:LINKS {weight: 1.0}]->(home),\n" +
            "  (b)-[:LINKS {weight: 1.0}]->(home),\n" +
            "  (c)-[:LINKS {weight: 1.0}]->(home),\n" +
            "  (d)-[:LINKS {weight: 1.0}]->(home),\n" +
            "  (links)-[:LINKS {weight: 0.8}]->(home),\n" +
            "  (links)-[:LINKS {weight: 0.05}]->(a),\n" +
            "  (links)-[:LINKS {weight: 0.05}]->(b),\n" +
            "  (links)-[:LINKS {weight: 0.05}]->(c),\n" +
            "  (links)-[:LINKS {weight: 0.05}]->(d);";

    public static final String GRAPH_PROJECTION = "CALL gds.graph.create(\n" +
            "  'myGraph',\n" +
            "  'Page',\n" +
            "  'LINKS',\n" +
            "  {\n" +
            "    relationshipProperties: 'weight'\n" +
            "  }\n" +
            ")";

    public static final String GRAPH_ESTIMATE = "CALL gds.pageRank.write." +
            "estimate('myGraph', {\n" +
            "  writeProperty: 'pageRank',\n" +
            "  maxIterations: 20,\n" +
            "  dampingFactor: 0.85\n" +
            "})\n" +
            "YIELD nodeCount, relationshipCount, bytesMin, bytesMax, requiredMemory";

    public static final String STREAM_ORDERBY = "CALL gds.pageRank." +
            "stream('myGraph')\n" +
            "YIELD nodeId, score\n" +
            "RETURN gds.util.asNode(nodeId).name AS name, score\n" +
            "ORDER BY score DESC, name ASC";


    public static Connection showMenuandGetConnection() throws SQLException {
        System.out.println("********   Bienvenido a PageRank con Neo4J   ********");
        System.out.println();
        System.out.println("Introduce tu usuario de NEO4J o ENTER para default:");
        System.out.println("Usuario: ");
        String user = Pagerank.getInput().nextLine();
        user = user.equals("") ? "neo4j":user;
        System.out.println("Introduce tu contrasenia de NEO4J:");
        System.out.println("Contrasenia: ");
        String password = Pagerank.getInput().nextLine();

        return DriverManager.getConnection("jdbc:neo4j:bolt://localhost", user, password);

    }

    public static void loadGraph() {
        System.out.println("Presiona ENTER para cargar el grafo:");
        Pagerank.getInput().nextLine();
    }


}
