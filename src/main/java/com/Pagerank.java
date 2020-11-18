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

import static com.utils.PageRankUtils.*;


public class Pagerank
{

    public enum State {
        MENU,
        LOAD_GRAPH,
        GRAPH_ESTIMATE,
        CONNECT_DATABASE,
        ORDERBY,
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
                        ResultSet rs = stmt.executeQuery(CLEAN_GRAPH);
                        stmt.executeQuery(GRAPH_DELETE);
                        stmt.executeQuery(CREATE_GRAPH);
                        stmt.executeQuery(GRAPH_PROJECTION);
                        printQuery(rs);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    System.out.println("Grafo cargado exitosamente...");
                    state = State.GRAPH_ESTIMATE;
                    break;
                case GRAPH_ESTIMATE:
                    estimateGraph();
                    try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(GRAPH_ESTIMATE);
                        printQuery(rs);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    System.out.println("Estimacion exitosa...");
                    state = State.ORDERBY;
                    break;

                case ORDERBY:
                    streamGraph();
                    try (Statement stmt = conn.createStatement()) {
                        ResultSet rs = stmt.executeQuery(STREAM_ORDERBY);
                        printQuery(rs);
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                    System.out.println("Algoritmo de ranking aplicado correctamente...");
                    state = State.EXIT;
                    break;

                default:
                    state = State.EXIT;
                    break;

            }
        }

        System.out.println("Felicidades has cumplido con los siguientes entregables:");
        System.out.println("[-] Conectarte a tu base de datos NEO4J");
        System.out.println("[-] Crear tu grafo en la base de datos NEO4J");
        System.out.println("[-] Obtener una estimacion de recursos del algoritmo NEO4J");
        System.out.println("[-] Obtener un ranking de paginas con el algoritmo de NEO4J");

        conn.close();


    }






}

