package com.utils;


import com.Pagerank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PageRankUtils {

    public static final String CLEAN_GRAPH = "MATCH (n)\n" +
            "DETACH DELETE n";

    public static final String CREATE_GRAPH = "CREATE\n" +
            "(sh1:SuperHero{Name:\"Ant-Man\"}) ,\n" +
            "(sh2:SuperHero{Name:\"Aquaman\"}) ,\n" +
            "(sh3:SuperHero{Name:\"Batman\"}) ,\n" +
            "(sh4:SuperHero{Name:\"Black Panther\"}) ,\n" +
            "(sh5:SuperHero{Name:\"Black Widow\"}) ,\n" +
            "(sh6:SuperHero{Name:\"Captain America\"}) ,\n" +
            "(sh7:SuperHero{Name:\"Captain Marvel\"}) ,\n" +
            "(sh8:SuperHero{Name:\"Flash\"}) ,\n" +
            "(sh9:SuperHero{Name:\"Green Arrow\"}) ,\n" +
            "(sh10:SuperHero{Name:\"Green Lantern\"}) ,\n" +
            "(sh11:SuperHero{Name:\"Hawkgirl\"}) ,\n" +
            "(sh12:SuperHero{Name:\"Hawkman\"}) ,\n" +
            "(sh13:SuperHero{Name:\"Hulk\"}) ,\n" +
            "(sh14:SuperHero{Name:\"Iron Man\"}) ,\n" +
            "(sh15:SuperHero{Name:\"Nick Fury\"}) ,\n" +
            "(sh16:SuperHero{Name:\"Quicksilver\"}) ,\n" +
            "(sh17:SuperHero{Name:\"Scarlet Witch\"}) ,\n" +
            "(sh18:SuperHero{Name:\"Spider-Man\"}) ,\n" +
            "(sh19:SuperHero{Name:\"Star-Lord\"}) ,\n" +
            "(sh20:SuperHero{Name:\"Superman\"}) ,\n" +
            "(sh21:SuperHero{Name:\"Thor\"}) ,\n" +
            "(sh22:SuperHero{Name:\"Wasp\"}) ,\n" +
            "(sh23:SuperHero{Name:\"Wonder Woman\"}) ,\n" +
            "(pe1:Person{Name:\"Barry Allen\"}) ,\n" +
            "(pe2:Person{Name:\"Bruce Banner\"}) ,\n" +
            "(pe3:Person{Name:\"Bruce Wayne\"}) ,\n" +
            "(pe4:Person{Name:\"Clark Kent\"}) ,\n" +
            "(pe5:Person{Name:\"Diana Prince\"}) ,\n" +
            "(pe6:Person{Name:\"Hall Jordan\"}) ,\n" +
            "(pe7:Person{Name:\"Henry Pym\"}) ,\n" +
            "(pe8:Person{Name:\"Janet Van Dyne\"}) ,\n" +
            "(pe9:Person{Name:\"Natasha Romanoff\"}) ,\n" +
            "(pe10:Person{Name:\"Nicholas Joseph Fury\"}) ,\n" +
            "(pe11:Person{Name:\"Oliver Jonas Queen\"}) ,\n" +
            "(pe12:Person{Name:\"Peter Jason Quill\"}) ,\n" +
            "(pe13:Person{Name:\"Peter Parker\"}) ,\n" +
            "(pe14:Person{Name:\"Pietro Maximoff \"}) ,\n" +
            "(pe15:Person{Name:\"T'Challa\"}) ,\n" +
            "(pe16:Person{Name:\"Tony Stark\"}) ,\n" +
            "(pe17:Person{Name:\"Wanda Maximoff \"}) ,\n" +
            "(lo1:Location{Name:\"Alabama\"}) ,\n" +
            "(lo2:Location{Name:\"Asgard\"}) ,\n" +
            "(lo3:Location{Name:\"Brooklyn\"}) ,\n" +
            "(lo4:Location{Name:\"California\"}) ,\n" +
            "(lo5:Location{Name:\"Europe\"}) ,\n" +
            "(lo6:Location{Name:\"Filadelfia\"}) ,\n" +
            "(lo7:Location{Name:\"Georgia\"}) ,\n" +
            "(lo8:Location{Name:\"Greece\"}) ,\n" +
            "(lo9:Location{Name:\"Long Island\"}) ,\n" +
            "(lo10:Location{Name:\"Louisiana\"}) ,\n" +
            "(lo11:Location{Name:\"Maine\"}) ,\n" +
            "(lo12:Location{Name:\"Missouri\"}) ,\n" +
            "(lo13:Location{Name:\"New Jersey\"}) ,\n" +
            "(lo14:Location{Name:\"New York\"}) ,\n" +
            "(lo15:Location{Name:\"Ohio\"}) ,\n" +
            "(lo16:Location{Name:\"Russia\"}) ,\n" +
            "(lo17:Location{Name:\"Wakanda\"}) ,\n" +
            "(u1:Universe{Name:\"DC Comics\"}) ,\n" +
            "(u2:Universe{Name:\"Marvel Comics\"}) ,\n" +
            "(g1:Gender{Name:\"Male\"}) ,\n" +
            "(g2:Gender{Name:\"Female\"}) ,\n" +
            "(a1:Ability{Name:\"Agility\"}) ,\n" +
            "(a2:Ability{Name:\"Aquatic Breathing\"}) ,\n" +
            "(a3:Ability{Name:\"Archery\"}) ,\n" +
            "(a4:Ability{Name:\"Fly\"}) ,\n" +
            "(a5:Ability{Name:\"Intelligence\"}) ,\n" +
            "(a6:Ability{Name:\"Magic\"}) ,\n" +
            "(a7:Ability{Name:\"Power Ring\"}) ,\n" +
            "(a8:Ability{Name:\"Rescale\"}) ,\n" +
            "(a9:Ability{Name:\"Speed\"}) ,\n" +
            "(a10:Ability{Name:\"Supersenses\"}) ,\n" +
            "(a11:Ability{Name:\"Superstrength\"}) ,\n" +
            "(v1:Villian{Name:\"Joker\"}) ,\n" +
            "(v2:Villian{Name:\"Lex Luthor\"}) ,\n" +
            "(v3:Villian{Name:\"Bane\"}) ,\n" +
            "(v4:Villian{Name:\"Darkseid\"}) ,\n" +
            "(v5:Villian{Name:\"Siniestro\"}) ,\n" +
            "(v6:Villian{Name:\"Lobo\"}) ,\n" +
            "(v7:Villian{Name:\"Deathstroke\"}) ,\n" +
            "(v8:Villian{Name:\"Harley Quinn\"}) ,\n" +
            "(v9:Villian{Name:\"Catwoman\"}) ,\n" +
            "(v10:Villian{Name:\"Braniac\"}) ,\n" +
            "(v11:Villian{Name:\"Flash Rebirth\"}) ,\n" +
            "(v12:Villian{Name:\"Bizarro\"}) ,\n" +
            "(v13:Villian{Name:\"Grodd\"}) ,\n" +
            "(v14:Villian{Name:\"Black Manta\"}) ,\n" +
            "(v15:Villian{Name:\"Zod\"}) ,\n" +
            "(v16:Villian{Name:\"Cheetah\"}) ,\n" +
            "(v17:Villian{Name:\"Abomination\"}) ,\n" +
            "(v18:Villian{Name:\"Viper\"}) ,\n" +
            "(v19:Villian{Name:\"Ultron\"}) ,\n" +
            "(v20:Villian{Name:\"Venom\"}) ,\n" +
            "(v21:Villian{Name:\"Green Goblin\"}) ,\n" +
            "(v22:Villian{Name:\"Thanos\"}) ,\n" +
            "(v23:Villian{Name:\"Loki\"}) ,\n" +
            "(v24:Villian{Name:\"Red Skull\"}) ,\n" +
            "(v25:Villian{Name:\"Doctor Doom\"}) ,\n" +
            "(sh1)-[:FRIEND_OF{Weight:1}]->(sh22),\n" +
            "(sh2)-[:FRIEND_OF{Weight:1}]->(sh3),\n" +
            "(sh3)-[:FRIEND_OF{Weight:1}]->(sh20),\n" +
            "(sh4)-[:FRIEND_OF{Weight:1}]->(sh6),\n" +
            "(sh5)-[:FRIEND_OF{Weight:1}]->(sh6),\n" +
            "(sh6)-[:FRIEND_OF{Weight:1}]->(sh14),\n" +
            "(sh7)-[:FRIEND_OF{Weight:1}]->(sh15),\n" +
            "(sh8)-[:FRIEND_OF{Weight:1}]->(sh9),\n" +
            "(sh9)-[:FRIEND_OF{Weight:1}]->(sh8),\n" +
            "(sh10)-[:FRIEND_OF{Weight:1}]->(sh20),\n" +
            "(sh11)-[:FRIEND_OF{Weight:1}]->(sh10),\n" +
            "(sh12)-[:FRIEND_OF{Weight:1}]->(sh11),\n" +
            "(sh13)-[:FRIEND_OF{Weight:1}]->(sh21),\n" +
            "(sh14)-[:FRIEND_OF{Weight:1}]->(sh18),\n" +
            "(sh15)-[:FRIEND_OF{Weight:1}]->(sh7),\n" +
            "(sh16)-[:FRIEND_OF{Weight:1}]->(sh17),\n" +
            "(sh17)-[:FRIEND_OF{Weight:1}]->(sh16),\n" +
            "(sh18)-[:FRIEND_OF{Weight:1}]->(sh14),\n" +
            "(sh20)-[:FRIEND_OF{Weight:1}]->(sh3),\n" +
            "(sh21)-[:FRIEND_OF{Weight:1}]->(sh13),\n" +
            "(sh22)-[:FRIEND_OF{Weight:1}]->(sh1),\n" +
            "(sh23)-[:FRIEND_OF{Weight:1}]->(sh3),\n" +
            "(sh1)-[:FRIEND_OF{Weight:1}]->(sh13),\n" +
            "(sh3)-[:FRIEND_OF{Weight:1}]->(sh23),\n" +
            "(sh4)-[:FRIEND_OF{Weight:1}]->(sh5),\n" +
            "(sh5)-[:FRIEND_OF{Weight:1}]->(sh13),\n" +
            "(sh6)-[:FRIEND_OF{Weight:1}]->(sh5),\n" +
            "(sh8)-[:FRIEND_OF{Weight:1}]->(sh3),\n" +
            "(sh13)-[:FRIEND_OF{Weight:1}]->(sh14),\n" +
            "(sh14)-[:FRIEND_OF{Weight:1}]->(sh6),\n" +
            "(sh15)-[:FRIEND_OF{Weight:1}]->(sh6),\n" +
            "(sh20)-[:FRIEND_OF{Weight:1}]->(sh2),\n" +
            "(sh21)-[:FRIEND_OF{Weight:1}]->(sh14),\n" +
            "(sh23)-[:FRIEND_OF{Weight:1}]->(sh20),\n" +
            "(sh20)-[:FRIEND_OF{Weight:1}]->(sh8),\n" +
            "(sh20)-[:FRIEND_OF{Weight:1}]->(sh23),\n" +
            "(sh20)-[:FRIEND_OF{Weight:1}]->(sh9),\n" +
            "(sh14)-[:FRIEND_OF{Weight:2}]->(sh21),\n" +
            "(sh14)-[:FRIEND_OF{Weight:3}]->(sh13),\n" +
            "(sh14)-[:FRIEND_OF{Weight:4}]->(sh17),\n" +
            "(sh14)-[:FRIEND_OF{Weight:5}]->(sh5),\n" +
            "(sh2)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh8)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh10)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh7)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh3)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh20)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh12)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh11)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh9)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh23)-[:PART_OF{Since:1}]->(u1),\n" +
            "(sh6)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh13)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh15)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh14)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh19)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh18)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh5)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh21)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh22)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh1)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh17)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh4)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh16)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v1)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v2)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v3)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v4)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v5)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v6)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v7)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v8)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v9)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v10)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v11)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v12)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v13)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v14)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v15)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v16)-[:PART_OF{Since:1}]->(u1),\n" +
            "(v17)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v18)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v19)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v20)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v21)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v22)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v23)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v24)-[:PART_OF{Since:1}]->(u2),\n" +
            "(v25)-[:PART_OF{Since:1}]->(u2),\n" +
            "(sh2)-[:LIVE_IN{since:10}]->(lo11),\n" +
            "(sh8)-[:LIVE_IN{since:8}]->(lo12),\n" +
            "(sh10)-[:LIVE_IN{since:7}]->(lo4),\n" +
            "(sh7)-[:LIVE_IN{since:6}]->(lo7),\n" +
            "(sh3)-[:LIVE_IN{since:6}]->(lo6),\n" +
            "(sh20)-[:LIVE_IN{since:5}]->(lo14),\n" +
            "(sh12)-[:LIVE_IN{since:5}]->(lo10),\n" +
            "(sh11)-[:LIVE_IN{since:5}]->(lo10),\n" +
            "(sh9)-[:LIVE_IN{since:5}]->(lo4),\n" +
            "(sh23)-[:LIVE_IN{since:5}]->(lo8),\n" +
            "(sh6)-[:LIVE_IN{since:6}]->(lo3),\n" +
            "(sh13)-[:LIVE_IN{since:5}]->(lo15),\n" +
            "(sh15)-[:LIVE_IN{since:7}]->(lo1),\n" +
            "(sh14)-[:LIVE_IN{since:5}]->(lo9),\n" +
            "(sh19)-[:LIVE_IN{since:5}]->(lo12),\n" +
            "(sh18)-[:LIVE_IN{since:6}]->(lo14),\n" +
            "(sh5)-[:LIVE_IN{since:4}]->(lo16),\n" +
            "(sh21)-[:LIVE_IN{since:10}]->(lo2),\n" +
            "(sh22)-[:LIVE_IN{since:5}]->(lo13),\n" +
            "(sh1)-[:LIVE_IN{since:6}]->(lo14),\n" +
            "(sh17)-[:LIVE_IN{since:5}]->(lo5),\n" +
            "(sh4)-[:LIVE_IN{since:9}]->(lo17),\n" +
            "(sh16)-[:LIVE_IN{since:5}]->(lo5),\n" +
            "(sh2)-[:IS]->(g1),\n" +
            "(sh8)-[:IS]->(g1),\n" +
            "(sh10)-[:IS]->(g1),\n" +
            "(sh7)-[:IS]->(g1),\n" +
            "(sh3)-[:IS]->(g1),\n" +
            "(sh20)-[:IS]->(g1),\n" +
            "(sh12)-[:IS]->(g1),\n" +
            "(sh11)-[:IS]->(g2),\n" +
            "(sh9)-[:IS]->(g1),\n" +
            "(sh23)-[:IS]->(g2),\n" +
            "(sh6)-[:IS]->(g1),\n" +
            "(sh13)-[:IS]->(g1),\n" +
            "(sh15)-[:IS]->(g1),\n" +
            "(sh14)-[:IS]->(g1),\n" +
            "(sh19)-[:IS]->(g1),\n" +
            "(sh18)-[:IS]->(g1),\n" +
            "(sh5)-[:IS]->(g2),\n" +
            "(sh21)-[:IS]->(g1),\n" +
            "(sh22)-[:IS]->(g2),\n" +
            "(sh1)-[:IS]->(g1),\n" +
            "(sh17)-[:IS]->(g2),\n" +
            "(sh4)-[:IS]->(g1),\n" +
            "(sh16)-[:IS]->(g1),\n" +
            "(sh1)-[:KWOWN_AS]->(pe7),\n" +
            "(sh3)-[:KWOWN_AS]->(pe3),\n" +
            "(sh4)-[:KWOWN_AS]->(pe15),\n" +
            "(sh5)-[:KWOWN_AS]->(pe9),\n" +
            "(sh8)-[:KWOWN_AS]->(pe1),\n" +
            "(sh9)-[:KWOWN_AS]->(pe11),\n" +
            "(sh10)-[:KWOWN_AS]->(pe6),\n" +
            "(sh13)-[:KWOWN_AS]->(pe2),\n" +
            "(sh14)-[:KWOWN_AS]->(pe16),\n" +
            "(sh15)-[:KWOWN_AS]->(pe10),\n" +
            "(sh16)-[:KWOWN_AS]->(pe14),\n" +
            "(sh17)-[:KWOWN_AS]->(pe17),\n" +
            "(sh18)-[:KWOWN_AS]->(pe13),\n" +
            "(sh19)-[:KWOWN_AS]->(pe12),\n" +
            "(sh20)-[:KWOWN_AS]->(pe4),\n" +
            "(sh22)-[:KWOWN_AS]->(pe8),\n" +
            "(sh23)-[:KWOWN_AS]->(pe5),\n" +
            "(sh2)-[:HAS{Number:10}]->(a2),\n" +
            "(sh8)-[:HAS{Number:9}]->(a9),\n" +
            "(sh10)-[:HAS{Number:10}]->(a7),\n" +
            "(sh7)-[:HAS{Number:9}]->(a11),\n" +
            "(sh3)-[:HAS{Number:8}]->(a5),\n" +
            "(sh20)-[:HAS{Number:10}]->(a11),\n" +
            "(sh12)-[:HAS{Number:7}]->(a4),\n" +
            "(sh11)-[:HAS{Number:7}]->(a4),\n" +
            "(sh9)-[:HAS{Number:7}]->(a3),\n" +
            "(sh23)-[:HAS{Number:8}]->(a11),\n" +
            "(sh6)-[:HAS{Number:7}]->(a1),\n" +
            "(sh13)-[:HAS{Number:10}]->(a11),\n" +
            "(sh15)-[:HAS{Number:6}]->(a5),\n" +
            "(sh14)-[:HAS{Number:8}]->(a5),\n" +
            "(sh19)-[:HAS{Number:6}]->(a1),\n" +
            "(sh18)-[:HAS{Number:7}]->(a10),\n" +
            "(sh5)-[:HAS{Number:7}]->(a10),\n" +
            "(sh21)-[:HAS{Number:10}]->(a11),\n" +
            "(sh22)-[:HAS{Number:6}]->(a8),\n" +
            "(sh1)-[:HAS{Number:6}]->(a8),\n" +
            "(sh17)-[:HAS{Number:9}]->(a6),\n" +
            "(sh4)-[:HAS{Number:7}]->(a1),\n" +
            "(sh16)-[:HAS{Number:8}]->(a9),\n" +
            "(sh1)<-[:ENEMY_OF{Weight:2}]-(v22),\n" +
            "(sh2)<-[:ENEMY_OF{Weight:9}]-(v14),\n" +
            "(sh3)<-[:ENEMY_OF{Weight:10}]-(v1),\n" +
            "(sh4)<-[:ENEMY_OF{Weight:8}]-(v22),\n" +
            "(sh5)<-[:ENEMY_OF{Weight:8}]-(v22),\n" +
            "(sh6)<-[:ENEMY_OF{Weight:6}]-(v18),\n" +
            "(sh7)<-[:ENEMY_OF{Weight:5}]-(v7),\n" +
            "(sh8)<-[:ENEMY_OF{Weight:7}]-(v13),\n" +
            "(sh9)<-[:ENEMY_OF{Weight:5}]-(v9),\n" +
            "(sh10)<-[:ENEMY_OF{Weight:9}]-(v5),\n" +
            "(sh11)<-[:ENEMY_OF{Weight:5}]-(v16),\n" +
            "(sh12)<-[:ENEMY_OF{Weight:4}]-(v21),\n" +
            "(sh13)<-[:ENEMY_OF{Weight:8}]-(v22),\n" +
            "(sh14)<-[:ENEMY_OF{Weight:8}]-(v19),\n" +
            "(sh15)<-[:ENEMY_OF{Weight:8}]-(v22),\n" +
            "(sh16)<-[:ENEMY_OF{Weight:4}]-(v24),\n" +
            "(sh17)<-[:ENEMY_OF{Weight:8}]-(v22),\n" +
            "(sh18)<-[:ENEMY_OF{Weight:9}]-(v20),\n" +
            "(sh20)<-[:ENEMY_OF{Weight:6}]-(v1),\n" +
            "(sh21)<-[:ENEMY_OF{Weight:4}]-(v23),\n" +
            "(sh22)<-[:ENEMY_OF{Weight:7}]-(v22),\n" +
            "(sh23)<-[:ENEMY_OF{Weight:3}]-(v15),\n" +
            "(sh1)<-[:ENEMY_OF{Weight:7}]-(v19),\n" +
            "(sh3)<-[:ENEMY_OF{Weight:7}]-(v8),\n" +
            "(sh4)<-[:ENEMY_OF{Weight:7}]-(v19),\n" +
            "(sh5)<-[:ENEMY_OF{Weight:8}]-(v19),\n" +
            "(sh6)<-[:ENEMY_OF{Weight:8}]-(v24),\n" +
            "(sh8)<-[:ENEMY_OF{Weight:9}]-(v11),\n" +
            "(sh13)<-[:ENEMY_OF{Weight:5}]-(v25),\n" +
            "(sh14)<-[:ENEMY_OF{Weight:10}]-(v22),\n" +
            "(sh15)<-[:ENEMY_OF{Weight:7}]-(v19),\n" +
            "(sh20)<-[:ENEMY_OF{Weight:9}]-(v15),\n" +
            "(sh21)<-[:ENEMY_OF{Weight:9}]-(v22),\n" +
            "(sh23)<-[:ENEMY_OF{Weight:4}]-(v16),\n" +
            "(sh20)<-[:ENEMY_OF{Weight:9}]-(v2),\n" +
            "(sh20)<-[:ENEMY_OF{Weight:5}]-(v6),\n" +
            "(sh20)<-[:ENEMY_OF{Weight:7}]-(v12),\n" +
            "(sh6)<-[:ENEMY_OF{Weight:9}]-(v22),\n" +
            "(sh6)<-[:ENEMY_OF{Weight:8}]-(v19)";

    public static final String GRAPH_PROJECTION = "CALL gds.graph.create(\n" +
            "  'myGraph',\n" +
            "  'SuperHero',\n" +
            "  'FRIEND_OF',\n" +
            "  {\n" +
            "    relationshipProperties: 'Weight'\n" +
            "  }\n" +
            ")";

    public static final String GRAPH_DELETE = "CALL gds.graph.drop" +
            "('myGraph') YIELD graphName;";

    public static final String GRAPH_ESTIMATE = "CALL gds.pageRank.write." +
            "estimate('myGraph', {\n" +
            "  writeProperty: 'SuperHero',\n" +
            "  maxIterations: 20,\n" +
            "  dampingFactor: 0.85\n" +
            "})\n" +
            "YIELD nodeCount, relationshipCount, bytesMin, bytesMax, requiredMemory";

    public static final String STREAM_ORDERBY = "CALL gds.pageRank." +
            "stream('myGraph')\n" +
            "YIELD nodeId, score\n" +
            "RETURN gds.util.asNode(nodeId).Name AS name, score\n" +
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

    public static void estimateGraph() {
        System.out.println("Presiona ENTER para obtener una estimación del grafo:");
        Pagerank.getInput().nextLine();
    }

    public static void streamGraph() {
        System.out.println("Presiona ENTER para obtener el ranking de paginas del grafo:");
        Pagerank.getInput().nextLine();
    }


}
