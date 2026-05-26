package test;

import controllers.LeagueController;
import models.League;
import validaciones.LeagueValidators;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

public class LeagueControllerTest {

    private LeagueController controller;
    private static final String FILA_ESTUDIANTE = cargarFilaEstudiante();

    private static String cargarFilaEstudiante() {
        try (BufferedReader reader = new BufferedReader(new FileReader("student.env"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("FILA_ESTUDIANTE=")) {
                    return linea.substring("FILA_ESTUDIANTE=".length()).trim();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    "ERROR: No se pudo leer el archivo student.env: " + e.getMessage());
        }
        return null;
    }

    private void invocarMetodoOrdenamiento(String nombreMetodo, League[] paraOrdenar) {
        try {
            Method metodo = LeagueController.class.getMethod(nombreMetodo, League[].class);
            metodo.invoke(controller, (Object) paraOrdenar);
        } catch (NoSuchMethodException e) {
            org.junit.jupiter.api.Assertions.fail(
                    String.format("ERROR: El metodo '%s(League[])' no existe en LeagueController.\n"
                            + "Debe implementar este metodo segun su fila asignada.", nombreMetodo));
        } catch (Exception e) {
            org.junit.jupiter.api.Assertions.fail(
                    String.format("ERROR al ejecutar el metodo '%s': %s",
                            nombreMetodo, e.getMessage()));
        }
    }

    private League invocarBusquedaBinaria(League[] ordenado, int value) {
        try {
            Method metodo = LeagueController.class.getMethod(
                    "binarySearchByTotalActiveGoals", League[].class, int.class);
            return (League) metodo.invoke(controller, ordenado, value);
        } catch (NoSuchMethodException e) {
            org.junit.jupiter.api.Assertions.fail(
                    "ERROR: El metodo 'binarySearchByTotalActiveGoals(League[], int)' "
                            + "no existe en LeagueController.");
            return null;
        } catch (Exception e) {
            org.junit.jupiter.api.Assertions.fail(
                    "ERROR al ejecutar busqueda binaria: " + e.getMessage());
            return null;
        }
    }

    @BeforeEach
    public void setUp() {
        controller = new LeagueController();

        if (FILA_ESTUDIANTE == null || FILA_ESTUDIANTE.trim().isEmpty()) {
            throw new RuntimeException(
                    "ERROR: Debe configurar FILA_ESTUDIANTE en student.env con su fila asignada (A o B).");
        }

        String fila = FILA_ESTUDIANTE.trim().toUpperCase();
        if (!fila.equals("A") && !fila.equals("B")) {
            throw new RuntimeException(
                    "ERROR: FILA_ESTUDIANTE debe ser A o B. Valor actual: " + FILA_ESTUDIANTE);
        }
    }

    @Test
    @DisplayName("Test 1: Validar getTotalActiveGoals() - Calculo de goles activos")
    public void testGetTotalActiveGoals() {
        java.security.CodeSource cs = League.class.getProtectionDomain().getCodeSource();
        if (cs != null) {
            String location = cs.getLocation().toString();
            if (location.contains("validadores-ligas")) {
                org.junit.jupiter.api.Assertions.fail(
                        "ERROR: La clase League esta siendo cargada del JAR de validadores, "
                                + "no de su propia implementacion.\n"
                                + "Debe crear e implementar src/models/League.java con el metodo getTotalActiveGoals().");
            }
        }
        League[] leagues = LeagueTestData.createLeagues();
        LeagueValidators.validarCalculoTotalActiveGoals(leagues);
    }

    @Test
    @DisplayName("Test 2: Validar metodo de ordenamiento segun fila asignada")
    public void testMetodoOrdenamiento() {
        String fila = FILA_ESTUDIANTE.trim().toUpperCase();

        League[] original = LeagueTestData.createLeagues();
        League[] paraOrdenar = LeagueValidators.copiarArreglo(original);

        if (fila.equals("A")) {
            invocarMetodoOrdenamiento("sortSelectionAsc", paraOrdenar);
            LeagueValidators.validarNoNulos(paraOrdenar);
            LeagueValidators.validarIntegridadDatos(original, paraOrdenar);
            LeagueValidators.validarOrdenamientoAscendente(paraOrdenar);

        } else if (fila.equals("B")) {
            invocarMetodoOrdenamiento("sortInsertionDesc", paraOrdenar);
            LeagueValidators.validarNoNulos(paraOrdenar);
            LeagueValidators.validarIntegridadDatos(original, paraOrdenar);
            LeagueValidators.validarOrdenamientoDescendente(paraOrdenar);
        }
    }

    @Test
    @DisplayName("Test 3: Validar busqueda binaria segun criterios de fila")
    public void testBusquedaBinariaPorFila() {
        String fila = FILA_ESTUDIANTE.trim().toUpperCase();

        League[] original = LeagueTestData.createLeagues();
        League[] paraOrdenar = LeagueValidators.copiarArreglo(original);

        if (fila.equals("A")) {
            // Fila A: sortSelectionAsc -> busqueda en orden ascendente
            invocarMetodoOrdenamiento("sortSelectionAsc", paraOrdenar);

            // Busqueda 1: 42 goles (Liga Pro Ecuador, existe)
            League resultado1 = invocarBusquedaBinaria(paraOrdenar, 42);
            LeagueValidators.validarBusquedaCompleta(paraOrdenar, 42, true, resultado1);

            // Busqueda 2: 55 goles (no existe)
            League resultado2 = invocarBusquedaBinaria(paraOrdenar, 55);
            LeagueValidators.validarBusquedaCompleta(paraOrdenar, 55, true, resultado2);

        } else if (fila.equals("B")) {
            // Fila B: sortInsertionDesc -> busqueda en orden descendente
            invocarMetodoOrdenamiento("sortInsertionDesc", paraOrdenar);

            // Busqueda 1: 67 goles (Premier League, existe)
            League resultado1 = invocarBusquedaBinaria(paraOrdenar, 67);
            LeagueValidators.validarBusquedaCompleta(paraOrdenar, 67, false, resultado1);

            // Busqueda 2: 40 goles (no existe)
            League resultado2 = invocarBusquedaBinaria(paraOrdenar, 40);
            LeagueValidators.validarBusquedaCompleta(paraOrdenar, 40, false, resultado2);
        }
    }
}
