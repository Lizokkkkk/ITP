public class Contact {
    private String name;
    private String email;
    private String data;

    public Contact(String name, String email, String data) {
        this.name = name;
        this.email = email;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "; адрес электронной почты: " + email + "; дополнительные контактные данные: " + data + ";";
    }
}
