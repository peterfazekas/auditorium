package hu.auditorium;

import hu.auditorium.datalogger.AuditoriumLogger;
import hu.auditorium.datalogger.Logger;
import hu.auditorium.dataread.AuditoriumFileReader;
import hu.auditorium.dataread.Reader;
import hu.auditorium.model.Position;
import hu.auditorium.service.Auditorium;
import hu.auditorium.service.Console;
import hu.auditorium.service.DataParser;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class App {
    private Auditorium auditorium;
    private Reader file;
    private Logger log;
    private DataParser data;
    private Console console;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public App() {
        log = new AuditoriumLogger("szabad.txt");
        file = new AuditoriumFileReader();
        data = new DataParser(file.read("foglaltsag.txt"), file.read("kategoria.txt"));
        auditorium = new Auditorium(data.parser());
        console = new Console();
    }

    private void run(){
        System.out.print("2. feladat: Adjon meg egy szék pozíciót [sor oszlop]: ");
        Position position = console.getPosition();
        System.out.println(auditorium.isSeatOccupied(position));
        System.out.println("3. feladat: " + auditorium.getAudienceStatistic());
        System.out.println("4. feladat: " + auditorium.getMaxCategoryId());
        System.out.println("5. feladat: " + auditorium.getTotalPriceOfSoldTickets());
        System.out.println("6. feladat: " + auditorium.countSingleFreeSeats());
        log.printAllLine(auditorium.getFreeSeatCategoryMap());
    }
}
