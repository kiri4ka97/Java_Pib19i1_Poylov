import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main implements Receive {
    public static void main(String[] args) {
        List<Recording> recordings = new ArrayList<>();
        MedicalCard card = new MedicalCard();
        card.cardId = "1";
        Patient patient = new Patient("1", "Викторов", "Валентин", "Петрович", "ул1", "8800555", "124-234", card);
        MedicalCard card2 = new MedicalCard();
        card2.cardId = "2";
        Patient patient2 = new Patient("1", "Баринов", "Олег", "Владимирович", "ул1", "8800555", "124-234", card2);
        List<Timetable> times = new ArrayList<>();
        times.add(new Timetable(DateReception.FRIDAY, TimeReception.EIGHT, 1, true));
        times.add(new Timetable(DateReception.FRIDAY, TimeReception.NINE, 1, true));
        Physician physician = new Physician("1", "Павлов", "Виталий", "Петрович", Post.CARDIOLOGIST, times);
        System.out.println("Попытка записи пациента " + patient.toString() + " к врачу " + physician + ", на четверг, 8 утра");
        Reception reception = new Reception(DateReception.FRIDAY, TimeReception.EIGHT, 1, 2);
        recordings.add(new Main().receive(patient, physician, reception, "Боли в сердце", Service.INSPECTION));
        System.out.println();
        System.out.println("Попытка записи пациента " + patient2.toString() + " к врачу " + physician + ", на четверг, 8 утра");
        recordings.add(new Main().receive(patient2, physician, reception, "Кардиограмма", Service.ANALYSIS));
        System.out.println();

        reception.time = TimeReception.TEN;
        System.out.println("Попытка записи пациента " + patient2.toString() + " к врачу " + physician + ", на четверг, 10 утра");
        recordings.add(new Main().receive(patient2, physician, reception, "Кардиограмма", Service.ANALYSIS));
        System.out.println();

        reception.time = TimeReception.NINE;
        System.out.println("Попытка записи пациента " + patient2.toString() + " к врачу " + physician + ", на четверг, 9 утра");
        recordings.add(new Main().receive(patient2, physician, reception, "Кардиограмма", Service.ANALYSIS));
        recordings.removeAll(Collections.singleton(null));
        System.out.println();
        for (Recording recording : recordings) {
            System.out.println(recording.toString());
        }
    }

    @Override
    public Recording receive(Patient patient, Physician physician, Reception reception, String description, Service service) {
        for (Timetable timetable : physician.freeTimes) {
            if (timetable.date == reception.date && timetable.time == reception.time) {
                if (timetable.isFree) {
                    timetable.isFree = false;
                    System.out.println("Пациент " + patient.toString() + ", успешно записан к врачу " + physician.toString());
                    return new Recording(description, service, patient, physician);
                } else {
                    System.out.println("Не удалось записать пациента " + patient.toString() + ", к врачу " + physician.toString() + ", врач уже занят");
                    return null;
                }
            }
        }
        System.out.println("Врач не принимает на такое время");
        return null;
    }
}

