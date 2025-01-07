import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class KinoxGUI extends JFrame {
    private JPanel myPanel;
    private JTextField textFieldTitel;
    private JTextField textFieldErscheinungsjahr;
    private JComboBox comboBoxGenre;
    private JComboBox comboBoxBewertung;
    private JCheckBox checkBox1;
    private JButton filterAnwendenButton;
    private JButton filmSpeichernButton;
    private JScrollPane scrollPane;
    private JComboBox comboBoxFilter;
    private JLabel iconLabel;
    private JTextArea textArea1;
    private JButton löschenButton;
    private JButton alleAnzeigenButton;
    private JTextField textFieldAnzahlFilme;

    ArrayList<Film> meineFilme = new ArrayList<>();

    public KinoxGUI() {
        setTitle("Kinox");
        setContentPane(myPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        initObjekte();
        initComboBoxFilter();


        filmSpeichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filmSpeichern();
            }
        });

        löschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int meldung = JOptionPane.showConfirmDialog(null, "Möchten Sie wirklich alle Filme löschen?", "ACHTUNG", JOptionPane.YES_NO_OPTION);

                if (meldung == JOptionPane.YES_OPTION) {
                    meineFilme.clear();
                    textArea1.setText("");
                    JOptionPane.showMessageDialog(null, "Alle Filme wurden erfolgreich gelöscht!", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
                    anzahlAktualisieren();
                }
            }
        });

        filterAnwendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterFilme();
            }
        });

        alleAnzeigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeigeAlleFilme();

            }
        });
    }

    public void initObjekte() {
        Film film1 = new Film("Titanic", "Drama", 1998, false, 5, 15.99);
        film1.berechnePreis();
        meineFilme.add(film1);

        Film film2 = new Film("Rocky", "Sport", 1998, false, 4, 14.99);
        film2.berechnePreis();
        meineFilme.add(film2);

        Film film3 = new Film("TopGun", "Action", 1998, true, 3, 13.99);
        film3.berechnePreis();
        meineFilme.add(film3);

        textArea1.append("Titel: Titanic" + "\n" + "Genre: Drama" + "\n" + "Erscheinungsjahr: 1998" + "\n" + "3D: false" + "\n"
                + "Bewertung: 5" + "\n" + "Preis: " + film1.getPreis() + "\n" + "---------------------" + "\n");

        textArea1.append("Titel: Rocky" + "\n" + "Genre: Sport" + "\n" + "Erscheinungsjahr: 1998" + "\n" + "3D: false" + "\n"
                + "Bewertung: 4" + "\n" + "Preis: " + film2.getPreis() + "\n" + "--------------------" + "\n");

        textArea1.append("Titel: TopGun" + "\n" + "Genre: Action" + "\n" + "Erscheinungsjahr: 1998" + "\n" + "3D: true" + "\n"
                + "Bewertung: 3" + "\n" + "Preis: " + film3.getPreis() + "\n" + "--------------------" + "\n");
    }

    public void initComboBoxFilter() {
        comboBoxFilter.addItem("Drama");
        comboBoxFilter.addItem("Sport");
        comboBoxFilter.addItem("Action");
        // Füge hier weitere Genres hinzu, falls nötig
    }

    public void filmSpeichern() {
        try {
            if (textFieldTitel.getText().isEmpty()) {
                throw new Exception("Bitte geben Sie einen Titel an!");
            }
            String titel = textFieldTitel.getText();

            if (textFieldErscheinungsjahr.getText().isEmpty()) {
                throw new Exception("Bitte geben Sie ein Erscheinungsjahr an!");
            }
            int erscheinungsjahr;
            try {
                erscheinungsjahr = Integer.parseInt(textFieldErscheinungsjahr.getText());
            } catch (NumberFormatException e1) {
                textFieldErscheinungsjahr.setText("");
                throw new Exception("Das Erscheinungsjahr muss eine gültige Zahl sein!");
            }

            String genre = comboBoxGenre.getSelectedItem().toString();
            int bewertung = Integer.parseInt(comboBoxBewertung.getSelectedItem().toString());
            boolean ist3D = checkBox1.isSelected();

            Film film = new Film(titel, genre, erscheinungsjahr, ist3D, bewertung, 0);
            film.berechnePreis();
            meineFilme.add(film);

            JOptionPane.showMessageDialog(null, "Film gespeichert!", "Hinweis", JOptionPane.INFORMATION_MESSAGE);

            textArea1.append("Titel: " + titel + "\n" +
                    "Genre: " + genre + "\n" +
                    "Erscheinungsjahr: " + erscheinungsjahr + "\n" +
                    "3D: " + ist3D + "\n" +
                    "Bewertung: " + bewertung + "\n" +
                    "Preis: " + film.getPreis() + "\n" + "--------------------\n");

            textFieldTitel.setText("");
            textFieldErscheinungsjahr.setText("");
            anzahlAktualisieren();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filterFilme() {
        String filterKriterium = comboBoxFilter.getSelectedItem().toString();
        textArea1.setText(""); // TextArea leeren

        for (Film film : meineFilme) {
            if (film.getGenre().equals(filterKriterium)) {
                textArea1.append("Titel: " + film.getTitel() + "\n" +
                        "Genre: " + film.getGenre() + "\n" +
                        "Erscheinungsjahr: " + film.getErscheinungsjahr() + "\n" +
                        "3D: " + film.isIst3D() + "\n" +
                        "Bewertung: " + film.getBewertung() + "\n" +
                        "Preis: " + film.getPreis() + "\n" + "--------------------\n");
            }
        }
    }

    public void zeigeAlleFilme() {
        textArea1.setText(""); // TextArea leeren

        for (Film film : meineFilme) {
            textArea1.append("Titel: " + film.getTitel() + "\n" +
                    "Genre: " + film.getGenre() + "\n" +
                    "Erscheinungsjahr: " + film.getErscheinungsjahr() + "\n" +
                    "3D: " + film.isIst3D() + "\n" +
                    "Bewertung: " + film.getBewertung() + "\n" +
                    "Preis: " + film.getPreis() + "\n" + "--------------------\n");
        }
    }

    public void anzahlAktualisieren(){
        int anzahl = meineFilme.size();
        textFieldAnzahlFilme.setText(String.valueOf(anzahl));
    }

    public static void main(String[] args) {
        new KinoxGUI();
    }
}
