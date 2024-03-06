public class Zakaznik {
    private static int nextID = 1;
    private final int id;
    private String jmeno;

    public Zakaznik(String jmeno) {
        this.id = nextID++;
        this.jmeno = jmeno;
    }

    public int getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }
}