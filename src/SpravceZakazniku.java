import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SpravceZakazniku extends AbstractTableModel {
    private List<Zakaznik> zakaznici = new ArrayList<>();

    public SpravceZakazniku () {
        zakaznici.addAll(List.of(
            new Zakaznik("Pepa"),
            new Zakaznik("Jirka"),
            new Zakaznik("Karel"),
            new Zakaznik("Pavel"),
            new Zakaznik("Jana"),
            new Zakaznik("Marie"),
            new Zakaznik("Eva"),
            new Zakaznik("Hana"),
            new Zakaznik("Lenka"),
            new Zakaznik("Petra")
        ));
    }

    public void pridejZakaznika(Zakaznik zakaznik) {
        zakaznici.add(zakaznik);
        fireTableDataChanged();
    }


    @Override
    public int getRowCount() {
        return zakaznici.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik zakaznik = zakaznici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zakaznik.getId();
            case 1:
                return zakaznik.getJmeno();
        }
        throw new RuntimeException("Požadavek na číslo sloupce:" + columnIndex);
    }
}
