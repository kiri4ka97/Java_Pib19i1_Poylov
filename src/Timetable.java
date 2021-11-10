public class Timetable {
    public DateReception date; //День
    public TimeReception time; //Время
    public int cabinet; //Кабинет
    public boolean isFree; //Запись на приём (доступна/нет)

    public Timetable(DateReception date, TimeReception time, int cabinet, boolean isFree) {
        this.date = date;
        this.time = time;
        this.cabinet = cabinet;
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "date=" + date +
                ", time=" + time +
                ", cabinet=" + cabinet +
                ", isFree=" + isFree +
                '}';
    }
}
