package ru.dude.kkmpleer;

import javax.sound.sampled.*;
import java.util.HashMap;
import java.util.Map;

public class MockPleer extends APlayable {

    public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
    public static final int SECONDS = 2; //сгенерировано на 2 секунды звука. Чтобы было дольше - надо зациклить, но мне не пригодится.

    private Map<Double, byte[]> data = new HashMap<>();

    SourceDataLine line;

    @Override
    public void init() throws Exception {
        AudioFormat af = new AudioFormat(SAMPLE_RATE, 8, 1, true, true);
        line = AudioSystem.getSourceDataLine(af);
        line.open(af, SAMPLE_RATE);
        line.start();
    }

    @Override
    public void setVolume(float value) throws Exception {
        Control control = line.getControl(FloatControl.Type.MASTER_GAIN);
        control.getClass().getDeclaredMethod("setValue", float.class).invoke(control, value);

    }

    @Override
    public void play(double frequency, int durationMs) {

        if (!data.containsKey(frequency)) {
            data.put(frequency, calcSin(frequency));
        }

        int ms = Math.min(durationMs, SECONDS * 1000);
        int length = SAMPLE_RATE * ms / 1000;
        int count = line.write(data.get(frequency), 0, length);

    }

    @Override
    public void close() {

        line.drain();
        line.close();
    }


    private byte[] calcSin(double frequency) {
        byte[] sin = new byte[SECONDS * SAMPLE_RATE];
        for (int i = 0; i < sin.length; i++) {
            double period = (double) SAMPLE_RATE / frequency;
            double angle = 2.0 * Math.PI * i / period;
            sin[i] = (byte) (Math.sin(angle) * 127f);
        }
        return sin;
    }

}
