public interface Receive {
    Recording receive(Patient patient, Physician physician, Reception reception, String description, Service service);
}
