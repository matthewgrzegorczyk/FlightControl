package pl.shatan;

import pl.shatan.radar.AirUnit;
import pl.shatan.radar.Radar;

import java.awt.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Program do "kontroli lotu". Dysponujemy radarem, na którym wyświetlana jest mapa (wczytywana z pliku), na radarze możemy umieścić dwa rodzaje obiektów reprezentowane przez odpowiednie znaki graficzne - naziemne (nie poruszają się) i samoloty (każdy jest opisany unikalnym numerem, samoloty możemy swobodnie przemieszczać). Powinien być sposób sprawdzania kolizji między obiektami, a także skalowania i przesuwania obrazu wyświetlanego na radarze.
 * Minimalne zakres funkcjonalności:
 * - wczytywanie i wyświetlanie (z uwzględnieniem skalowania i przesuwania) mapy (może być w formie tekstowej) wraz z obiektami (naziemnymi i samolotami)
 * - "ręczne" nanoszenie na mapę obiektów stałych
 * - losowe generowanie samolotów (w tym wysokości, kursu, prędkości) oraz symulacja (w fazach) ich ruchu
 * - wydawanie poleceń zmiany parametrów lotu samolotom
 * - wykrywanie niebezpiecznych zbliżeń między samolotami i kolizji
 */
public class Main {

    public static void main(String[] args) {
        /*
        Radar radar = new Radar();

        AirUnit airplane = new AirUnit();
        radar.addUnit(airplane);

        AirUnit airplane2 = new AirUnit(100, 0, 0);
        radar.addUnit(airplane2);

        System.out.println("Radar objects.");
        radar.getUnits().forEach(temp -> {
            System.out.println(temp);
            System.out.println(radar.getUnits().get(0).isClose(temp));
            System.out.println(radar.getUnits().get(0).distance(temp));
        });
        */

//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                BasicEx ex = new BasicEx();
//                ex.setVisible(true);
//            }
//        });
    }
}
