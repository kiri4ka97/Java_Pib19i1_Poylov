import java.util.List;

public class Physician {
    public String code;
    public String secondName;
    public String firstName;
    public String middleName;
    public Post post;
    public List<Timetable> freeTimes;

    public Physician(String code, String secondName, String firstName, String middleName, Post post, List<Timetable> freeTimes) {
        this.code = code;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.post = post;
        this.freeTimes = freeTimes;
    }

    @Override
    public String toString() {
        return "Код: " + code + " " + secondName + " " + firstName + " " + middleName;
    }
}

