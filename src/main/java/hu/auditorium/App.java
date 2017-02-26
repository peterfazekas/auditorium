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

    private final Auditorium auditorium;
    private final Reader file;
    private final Logger log;
    private final DataParser data;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public App() {
        log = AuditoriumLogger.getInstance("szabad.txt");
        file = new AuditoriumFileReader();
        data = new DataParser(file.read("foglaltsag.txt"), file.read("kategoria.txt"));
        auditorium = new Auditorium(data.parser());
    }

    private void run(){
        System.out.print("2. feladat: Adjon meg egy szék pozíciót [sor oszlop]: ");
        Position position = data.getPosition();
        System.out.println(auditorium.isSeatOccupied(position));
        System.out.println("3. feladat: " + auditorium.getAudienceStatistic());
        System.out.println("4. feladat: " + auditorium.getMaxCategoryId());
        System.out.println("5. feladat: " + auditorium.getTotalPriceOfSoldTickets());
        System.out.println("6. feladat: " + auditorium.countSingleFreeSeats());
        log.printAllLine(auditorium.getFreeSeatCategoryMap());
    }
}
