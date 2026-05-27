import models.League;
import models.Player;
import models.Team;
import controllers.LeagueController;

public class App {

        /**
         * Retorna el arreglo completo de ligas con sus equipos y jugadores.
         * Este metodo provee los datos utilizados por los tests automaticos.
         * NO modificar este metodo.
         *
         * Goles activos totales esperados por liga:
         * [0] Liga Pro Ecuador = 42
         * [1] Premier League = 67
         * [2] La Liga Espana = 58
         * [3] Serie A Italia = 35
         * [4] Bundesliga = 74
         * [5] Ligue 1 Francia = 29
         * [6] MLS USA = 51
         * [7] Liga MX Mexico = 46
         */
        public static League[] getLeagues() {

                // ===== Liga Pro Ecuador: total active goals = 42 =====
                Player[] barcelonaPlayers = {
                                new Player("Gonzalo Mastriani", 15, true),
                                new Player("Byron Castillo", 4, false),
                                new Player("Damian Diaz", 10, true)
                };
                Player[] emelecPlayers = {
                                new Player("Joao Rojas", 11, true),
                                new Player("Alexis Zapata", 5, false),
                                new Player("Ivan Caicedo", 6, true)
                };
                League ligaProEcuador = new League("Liga Pro Ecuador",
                                new Team[] { new Team("Barcelona SC", barcelonaPlayers),
                                                new Team("Emelec", emelecPlayers) });

                // ===== Premier League: total active goals = 67 =====
                Player[] cityPlayers = {
                                new Player("Erling Haaland", 30, true),
                                new Player("Phil Foden", 12, false),
                                new Player("Kevin De Bruyne", 8, true)
                };
                Player[] arsenalPlayers = {
                                new Player("Bukayo Saka", 18, true),
                                new Player("Gabriel Martinelli", 10, false),
                                new Player("Kai Havertz", 11, true)
                };
                League premierLeague = new League("Premier League",
                                new Team[] { new Team("Manchester City", cityPlayers),
                                                new Team("Arsenal", arsenalPlayers) });

                // ===== La Liga Espana: total active goals = 58 =====
                Player[] madridPlayers = {
                                new Player("Vinicius Jr", 22, true),
                                new Player("Luka Modric", 5, false),
                                new Player("Jude Bellingham", 15, true)
                };
                Player[] barcelonaFCPlayers = {
                                new Player("Robert Lewandowski", 14, true),
                                new Player("Pedri", 5, false),
                                new Player("Raphinha", 7, true)
                };
                League laLiga = new League("La Liga Espana",
                                new Team[] { new Team("Real Madrid", madridPlayers),
                                                new Team("FC Barcelona", barcelonaFCPlayers) });

                // ===== Serie A Italia: total active goals = 35 =====
                Player[] interPlayers = {
                                new Player("Lautaro Martinez", 16, true),
                                new Player("Henrikh Mkhitaryan", 6, false),
                                new Player("Marcus Thuram", 9, true)
                };
                Player[] juventusPlayers = {
                                new Player("Dusan Vlahovic", 10, true),
                                new Player("Federico Chiesa", 8, false),
                                new Player("Adrien Rabiot", 5, false)
                };
                League serieA = new League("Serie A Italia",
                                new Team[] { new Team("Inter Milan", interPlayers),
                                                new Team("Juventus", juventusPlayers) });

                // ===== Bundesliga: total active goals = 74 =====
                Player[] bayernPlayers = {
                                new Player("Harry Kane", 35, true),
                                new Player("Leroy Sane", 10, false),
                                new Player("Jamal Musiala", 18, true)
                };
                Player[] dortmundPlayers = {
                                new Player("Niclas Fullkrug", 12, true),
                                new Player("Marco Reus", 8, false),
                                new Player("Emre Can", 9, true)
                };
                League bundesliga = new League("Bundesliga",
                                new Team[] { new Team("Bayern Munich", bayernPlayers),
                                                new Team("Borussia Dortmund", dortmundPlayers) });

                // ===== Ligue 1 Francia: total active goals = 29 =====
                Player[] psgPlayers = {
                                new Player("Kylian Mbappe", 14, true),
                                new Player("Marco Asensio", 7, false),
                                new Player("Lee Kang-in", 8, true)
                };
                Player[] monacoPlayers = {
                                new Player("Wissam Ben Yedder", 7, true),
                                new Player("Aleksandr Golovin", 5, false),
                                new Player("Takumi Minamino", 5, false)
                };
                League ligue1 = new League("Ligue 1 Francia",
                                new Team[] { new Team("PSG", psgPlayers),
                                                new Team("Monaco", monacoPlayers) });

                // ===== MLS USA: total active goals = 51 =====
                Player[] miamiPlayers = {
                                new Player("Lionel Messi", 22, true),
                                new Player("Sergio Busquets", 3, false),
                                new Player("Luis Suarez", 12, true)
                };
                Player[] galaxyPlayers = {
                                new Player("Riqui Puig", 10, true),
                                new Player("Gabriel Pec", 7, false),
                                new Player("Marco Reus", 7, true)
                };
                League mls = new League("MLS USA",
                                new Team[] { new Team("Inter Miami", miamiPlayers),
                                                new Team("LA Galaxy", galaxyPlayers) });

                // ===== Liga MX Mexico: total active goals = 46 =====
                Player[] americaPlayers = {
                                new Player("Henry Martin", 18, true),
                                new Player("Jonathan Rodriguez", 9, false),
                                new Player("Alvaro Fidalgo", 10, true)
                };
                Player[] chivasPlayers = {
                                new Player("Roberto Alvarado", 12, true),
                                new Player("Alexis Vega", 8, false),
                                new Player("Isaac Brizuela", 6, true)
                };
                League ligaMX = new League("Liga MX Mexico",
                                new Team[] { new Team("Club America", americaPlayers),
                                                new Team("Chivas Guadalajara", chivasPlayers) });

                return new League[] {
                                ligaProEcuador,
                                premierLeague,
                                laLiga,
                                serieA,
                                bundesliga,
                                ligue1,
                                mls,
                                ligaMX
                };
        }

        public static void main(String[] args) {

                System.out.println(
                                "Bienvenido al sistema de ligas de futbol. Por favor configure su fila en student.env y ejecute los tests automaticos para validar su implementacion.");
                // TODO: Imprimir listado original
                // Ejemplo:
                System.out.println("Listado original:");
                LeagueController controller = new LeagueController();
                controller.printLeagues(getLeagues());
                System.out.println("Listado ordenado:");
                controller.sortSelectionAsc(getLeagues());
                System.out.println("Primera busqueda:");
                controller.binarySearchByTotalActiveGoals(getLeagues(), 42);
                System.out.println("Segunda busqueda:");
                controller.binarySearchByTotalActiveGoals(getLeagues(), 55);
                // TODO: Crear una copia del arreglo y aplicar el metodo de ordenamiento de su
                // fila
                // Fila A: controller.sortSelectionAsc(copia)
                // Fila B: controller.sortInsertionDesc(copia)

                // TODO: Imprimir listado ordenado
                // Ejemplo:
                // System.out.println("Listado ordenado:");
                // controller.printLeagues(copia);

                // TODO: Realizar busqueda 1 e imprimir si se encontro o no
                // Fila A: buscar 42 goles activos
                // Fila B: buscar 67 goles activos

                // TODO: Realizar busqueda 2 e imprimir si se encontro o no
                // Fila A: buscar 55 goles activos
                // Fila B: buscar 40 goles activos
        }
}
