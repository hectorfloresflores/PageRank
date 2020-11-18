package com;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.utils.PageRankUtils.CREATE_GRAPH;
import static com.utils.PageRankUtils.STREAM_ORDERBY;
import static com.utils.PageRankUtils.loadGraph;
import static com.utils.PageRankUtils.showMenuandGetConnection;


public class Pagerank
{

    public enum State {
        MENU,
        LOAD_GRAPH,
        CONNECT_DATABASE,
        EXIT
    }

    public static Scanner getInput() {
        return Input;
    }


    private static final Scanner Input = new Scanner(
            new BufferedReader(
                    new InputStreamReader(System.in)));
    private static Connection conn;

    private static State state = State.CONNECT_DATABASE;

    static void printQuery(ResultSet res) throws SQLException {
        int columnCount = res.getMetaData().getColumnCount();


        for (int ini = 1, pos = 0; ini <= columnCount; ini++) {
            System.out.print(res.getMetaData().getColumnName(ini) + "\t");
        }
        System.out.println();
        while (res.next()) {
            for (int ini = 1, pos = 0; ini <= columnCount; ini++) {
                System.out.print(res.getString(ini) + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) throws SQLException {

        while (state != State.EXIT) {
            switch (state) {
                case CONNECT_DATABASE:
                    conn = showMenuandGetConnection();
                    System.out.println("Conexión exitosa...");
                    state = State.LOAD_GRAPH;
                    break;
                case LOAD_GRAPH:
                    loadGraph();
                    try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(CREATE_GRAPH);
                        printQuery(rs);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    System.out.println("Grafo cargado exitosamente...");
                    state = State.LOAD_GRAPH;
                    break;
                case EXIT:
                    showMenuandGetConnection();
                    break;

            }
        }

        try (Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "Intel3142!")) {

            try (Statement stmt = con.createStatement()) {
                ResultSet rs = stmt.executeQuery(STREAM_ORDERBY);
                printQuery(rs);
            } catch (SQLException e) {
                System.out.println(e);
            }
            while(true) {

            }


        }


    }






}

