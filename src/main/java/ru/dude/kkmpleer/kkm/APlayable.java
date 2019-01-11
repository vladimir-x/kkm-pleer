package ru.dude.kkmpleer.kkm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class APlayable {

    public abstract void init() throws Exception;

    public abstract void setVolume(float value) throws Exception;

    public abstract void play(double frequency, int durationMs) throws Exception;

    public abstract void close() throws Exception;


    private Map<String, Double> charNotes = new LinkedHashMap<>();


    private Map<String, Character> lastOctave = new HashMap<>();


    public APlayable() {
                     // до          ре           ми    фа          соль           ля          си
        String[] N = { "C_", "C#_", "D_", "D#_", "E_", "F_", "F#_", "G_", "G#_", "A_", "A#_", "B_",};

        for (int oct = 0; oct < 10; ++oct) {
            for (int i = 0; i < N.length; ++i) {
                //A9 = ля 440 A4
                int d = (oct - 4) * N.length + (i -9);
                double exp = ((double) d) / 12d;
                double frequency = 440d * Math.pow(2d, exp);
                String ocavaStr = String.valueOf(oct);
                String note = N[i].replace("_", ocavaStr);
                charNotes.put(note, frequency);
                if (note.contains("#")) {
                    String nextNote = i + 1 < N.length ? N[i + 1] : N[0];
                    String thisBemole = nextNote.charAt(0) + "b" + ocavaStr;
                    charNotes.put(thisBemole, frequency);
                } else {
                    String thisBekar = N[i].charAt(0) + "n" + ocavaStr;
                    charNotes.put(thisBekar, frequency);
                }
            }
        }

        // Сделал через wait!!! минимум для атола "G#2" , "A0" для моковой
    //    charNotes.put("", charNotes.get("G#2"));
    //    charNotes.put(" ", charNotes.get("G#2"));
    //    charNotes.put("silent", charNotes.get("G#2"));
    }

    public void parsePlay(String noteUnparsed, double durationMs) throws Exception {

        noteUnparsed = noteUnparsed.trim();

        // одновременные ноты A3-A4 (пока не поддерживаются)
        String[] sametime = noteUnparsed.split("-");
        if (sametime.length > 1) {
            System.out.println("warn: " + noteUnparsed + " not supported. Used last note");
            noteUnparsed = sametime[sametime.length - 1];
        }

        // длительность ноты A3/2
        String[] p = noteUnparsed.split("/");
        String oneNote = p[0].trim();
        int d = (int)durationMs;
        if (p.length > 1) {
            double k = Double.valueOf(p[1]);
            if (k != 0) {
                d = (int)(durationMs / k);
            }
        }

        // воспроизведение предыдущей ноты
        if (oneNote.length() > 0) {
            String clearNote = oneNote.substring(0, 1);

            Character clearOct = oneNote.charAt(oneNote.length() - 1);
            if (Character.isDigit(clearOct)) {
                // октава указана
                lastOctave.put(clearNote, clearOct);
            } else {
                //октава не указана, надо взять последнюю такую октаву
                if (lastOctave.containsKey(clearNote)) {
                    oneNote = oneNote + lastOctave.get(clearNote);
                }
            }
        }

        play(oneNote, d);
    }

    public void play(String note, int durationMs) throws Exception {

        if (note.trim().equals("") || note.trim().equals("silent")){
            silenceWait(durationMs);
        }else  if (charNotes.containsKey(note)) {
            play(charNotes.get(note), durationMs);
            //System.out.println("play: " +note + " " +charNotes.get(note));
        } else {
            System.out.println("warn: note " + note + " unknown");
        }
    }

    private void silenceWait(int durationMs){

        try {
            Thread.sleep(durationMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Map<String, Double> getCharNotes() {
        return charNotes;
    }
}
