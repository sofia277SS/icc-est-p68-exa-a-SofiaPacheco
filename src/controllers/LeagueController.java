package controllers;

import models.League;

public class LeagueController {

    /**
     * FILA A - Implementar este metodo con Selection Sort ascendente.
     * Ordena el arreglo de ligas de menor a mayor segun getTotalActiveGoals().
     *
     * Nombre exacto requerido: sortSelectionAsc
     *
     * @param leagues Arreglo de ligas a ordenar
     * @return Arreglo ordenado
     */
    public League[] sortSelectionAsc(League[] leagues) {

        for (int i = 0; i < leagues.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; i < leagues.length; j++) {
                if (leagues[j].getTotalActiveGoals() < leagues[menor].getTotalActiveGoals()) {
                    menor = j;
                }
                League auxi = leagues[i];
                leagues[j] = leagues[menor];
                leagues[menor] = auxi;
            }

        }
        throw new UnsupportedOperationException("Metodo sortSelectionAsc no implementado");
    }

    /**
     * FILA B - Implementar este metodo con Insertion Sort descendente.
     * Ordena el arreglo de ligas de mayor a menor segun getTotalActiveGoals().
     *
     * Nombre exacto requerido: sortInsertionDesc
     *
     * @param leagues Arreglo de ligas a ordenar
     * @return Arreglo ordenado
     */
    public League[] sortInsertionDesc(League[] leagues) {
        // TODO: Implementar (solo si su fila es B)
        throw new UnsupportedOperationException("Metodo sortInsertionDesc no implementado");
    }

    /**
     * TODOS - Implementar busqueda binaria por goles activos totales.
     *
     * El arreglo recibido ya fue ordenado con el metodo de su fila.
     * Implemente la busqueda conforme al orden que aplico:
     * - Fila A: arreglo ascendente, use logica de busqueda ascendente.
     * - Fila B: arreglo descendente, use logica de busqueda descendente.
     *
     * Nombre exacto requerido: binarySearchByTotalActiveGoals
     *
     * @param leagues          Arreglo de ligas ya ordenado
     * @param totalActiveGoals Total de goles activos a buscar
     * @return La liga encontrada, o null si no existe
     */
    public League binarySearchByTotalActiveGoals(League[] leagues, int totalActiveGoals) {
        int bajo = 0;
        int alto = leagues.length - 1;
        League totalGoals;

        while (bajo <= alto) {
            int medio = (bajo + alto) / 2;
            if (leagues[medio] == totalActiveGoals) {
                return medio;
            }
            if (leagues[medio] < totalActiveGoals) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
            return null;
        }

        throw new UnsupportedOperationException("Metodo binarySearchByTotalActiveGoals no implementado");
    }

    /**
     * Imprime el arreglo de ligas en consola.
     *
     * @param leagues Arreglo de ligas a imprimir
     */
    public void printLeagues(League[] leagues) {
        for (League league : leagues) {
            System.out.println(league.getName());
            System.out.println(league.getTeams());
            System.out.println(league.getTotalActiveGoals());
        }
    }
}
