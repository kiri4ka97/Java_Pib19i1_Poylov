public class Patient {
    public String code;
    public String secondName;
    public String firstName;
    public String middleName;
    public String address;
    public String phoneNumber;
    public String policyId;
    public MedicalCard card;

    public Patient(String code, String secondName, String firstName, String middleName, String address, String phoneNumber, String policyId, MedicalCard card) {
        this.code = code;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.policyId = policyId;
        this.card = card;
    }

    @Override
    public String toString() {
        return "Код: " + code + " " + secondName + " " + firstName + " " + middleName + " " + card;
    }
}
