import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.dude.kkmpleer.kkm.APlayable;
import ru.dude.kkmpleer.kkm.MockPleer;

@Ignore
public class Test1 extends Assert {


    private void test(float duration, String song) throws Exception {
        APlayable pleer = new MockPleer();

        pleer.init();
        pleer.setVolume(-30);

        song = song.trim().replaceAll("\n", ",").replaceAll("-", ",");
        for (String one : song.split(",")) {
            pleer.parsePlay(one, duration);
        }

        pleer.close();
    }

    @Test
    public void mkTest() throws Exception {

        //Mortal Kombat theme v.2 +
        test(60 * 1000f / 215, "" +
                "A3,A3,C4,A3,D4,A3,E4,D4,C4,C4,E4,C4,G4,C4,E4,C4\n" +
                "G3,G3,B3,G3,C4,G3,D4,C4,F3,F3,A3,F3,C4,F3,C4,B3\n" +
                "A2,A3,C4,A3,D4,A,E4,D4,C3-C4,C,E4,C,G4,C,E4,C4\n" +
                "G2-G3,G,B3,G,C4,G,D4,C4,F3,F3,A3,F3,C4,F3,C4,B3\n" +
                "A3, /2,A3, /2,A3, /2,A3, /2,G3,C4\n" +
                "A3, /2,A3, /2,A3, /2,A3, /2,G3,E3\n" +
                "A3, /2,A3, /2,A3, /2,A3, /2,G3,C4\n" +
                "A3, /2,A3, /2,A3,A/2,A,A/2,A, \n" +
                "A3, /2,A3, /2,A3, /2,A3, /2,G3,C4\n" +
                "A3, /2,A3, /2,A3, /2,A3, /2,G3,E3\n" +
                "A3, /2,A3, /2,A3, /2,A3, /2,G3,C4\n" +
                "A3, /2,A3, /2,A3,A/2,A,A/2,A");


    }


    //  до          ре           ми    фа          соль            ля          си
    //{"C_", "C#_", "D_", "D#_", "E_", "F_", "F#_", "G_", "G#_" ,"A_", "A#_", "B_", };


    @Test
    public void myKillBillTest() throws Exception {

        test(60 * 1000f / 215f, "" +
                "B4, ,A4, ,B4,B4,A4, ,A4, , G4, ,A4,A4,G4, ,B4,/128,B4,A4,A4,B4,B4,A4, ,A4,A4,G4,G4,A4,A4,G4, ," +
                "A#4,A4,G4,A4, A#4,A4,G4,A4, A#4,A4,G4,A4, A#4," +
                "A4,A#4,C5,A#4, A4,A#4,C5,A#4,A4,A#4,C5,A#4, A4,A#4,C5, ," +
                "F5, ,D#5, ,F5,F5,D#5, ,F5, ,D#5, ,F5,F5,D#5, ,F5/0.25,D#5/0.25,F5/0.25,D#5/0.25,F5/0.125" +
                "/0.1"
        );
    }

    @Test
    public void myTerminatorTest() throws Exception {

        test(60 * 1000f / 30f, "" +
                "Eb4/16,Eb4/16, /16,  Eb4/16,Eb4/16, /16, Eb4/16,Eb4/16, /8, /4," +
                "Eb4/16,Eb4/16, /16,  Eb4/16,Eb4/16, /16, Eb4/16,Eb4/16, /8, /4," +
                "Eb5/16, F5/16,Gb5/8,Gb5/8,Gb5/4," +"Gb5/8,F5/8,Db5/8," + "Gb4/1, /4," +
                "Eb5/16, F5/16,Gb5/8,Gb5/8,Gb5/4," +"Gb5/8,F5/8,Db5/8, " +"Bb5/1, /4," +
                "Eb5/16, F5/16,Gb5/8,Gb5/8,Gb5/4," +"Gb5/8,F5/8,Db5/8," + "Ab4/1, /4," +
                "Gb4/1, /8, Eb4/8,Gb4/2," +
                "Eb4/16,Eb4/16, /16,  Eb4/16,Eb4/16, /16, Eb4/16,Eb4/16," +
                ""
        );
    }

    @Test
    public void myDydecTest() throws Exception {

        test(450f, "" +
                " /2,C#5/2,C5," + " /2,C#5/2,A4, /2,A4/2,G#4," + " /2,A4/2,F#4," + //2x  в оригинале
                " /2,C#5/2,C5/2,C#5," + "C#5/2,A4, /2,A4/2,G#4/2,C#5," + "A4/2,F#4," +
                " /2,C#5/2,C5/2,C#5/2,A4/2," + "C#5/2,G#4/2,C#5/2,F#4/2,C#5/2, F4/2,C#5/2,C#4/2,C#5/2," + "D4/2,C#5/2,F4/2,C#5/2,F#4/2,C#5/2,G#4/2,C#5/2,A4/2, " + "C#5/2,B4/2,C#5/2,/128,C#5, , /2," + //2x в оригинале
                " /2,C#5/2,C5/2,C#5/2," + " C5/2,A4/2,C#5/2, /2,A4/2,G#4/2,C#5/2," + "A#4/2,F#4/2,C#5/2, /2,F#3/4,F#3/4,F#3/2, A3/2, F#3/2, /2, F#3,"+
                " /1"
        );
    }

    @Test
    public void maxPayneMYTest() throws Exception {

        //Max Payne
        test(60 * 1000f / 150,
                "C3/0.4, C4/2,Eb4/2,F4,G4, " +
                        "C5/0.4,G4,Bb4/0.4,G4/2,Eb4\n" +
                        "B3/0.5, \n" +
                        "");
    }

    @Test
    public void maxPayneTest() throws Exception {

        //Max Payne
        test(60 * 1000f / 150,
                "C2-C3, , ,C5/2,Eb5/2,F5,G5,C6/0.66,G5/0.66\n" +
                        "Bb5/0.66,G5/2,E5,Bn1-B2-B4, , , ,Ab4,G4\n" +
                        "G2-G3-D5/0.66,G4/0.66,D5/0.66,E5/0.66\n" +
                        "C2-C3-B4/0.66,C5/0.66,E5,F5,G5,C6/0.66,G5/0.66\n" +
                        "Bb5/0.66,G5/2,Eb5,Bn1-B2-B4, , , , ,Ab4/2,G4/2\n" +
                        "G2-G3-D5/0.66,G4/0.66,D5/0.66,Eb5/0.66\n" +
                        "C2-C3, , ,C5-C6/2,Eb5-E6/2,F5-F6,G5-G6,C6-C7/0.66\n" +
                        "G5-G6/0.66,Bb5-B6/0.66,G5-G6/2,E5-E6\n" +
                        "Bn1-B2-B4-B5, , , ,Ab4-A5,G4-G5,G2-G3-D5-D6/0.66\n" +
                        "G4-G5/0.66,D5-D6/0.66,E5-E6/0.66,C2-C3-Bn4-B5/0.66\n" +
                        "C5-C6/0.66,E5-E6,F5-F6,G5-G6,C6-C7/0.66,G5-G6/0.66\n" +
                        "Bb5-B6/0.66,G5-G6/2,E5-E6,Bn1-B2-B4-B5, , , , \n" +
                        "A4-A5/2,G4-G5/2,G2-G3-D5-D6/0.66,G4-G5/0.66\n" +
                        "D5-D6/0.66,E5-E6/0.66,F2-F3-F4-F5, , ,F4-F5/2\n" +
                        "G4-G5/2,Ab4-A5,D5-D6,G2-G3-Bn4-B5/0.66,G4-G5/0.66\n" +
                        "Eb5-E6/0.66,D5-D6/0.66,F2-F3-F4-F5, , ,F4-F5/2\n" +
                        "G4-G5/2,Ab4-A5,D5-D6,G2-G3-C5-C6/0.66,Bn4-B5/0.66\n" +
                        "An4-A5/0.66,B4-B5/0.66\n" +
                        "C2-C3-G5-C6-Eb6-G6, , ,C5-C6/2,E5-E6/2,F5-F6\n" +
                        "G5-G6,C6-C7/0.66,G5-G6/0.66,Bb5-B6/0.66,G5-G6/2\n" +
                        "E5-E6,Bn1-B2-B5-D6-F6-G6, , , ,Ab4-A5,G4-G5\n" +
                        "G2-G3-D5-D6/0.66,G4-G5/0.66,D5-D6/0.66,E5-E6/0.66\n" +
                        "C2-C3-B5-C6-E6-G6/0.66,C5-C6/0.66,E5-E6,F5-F6\n" +
                        "G5-G6,C6-C7/0.66,G5-G6/0.66,Bb5-B6/0.66,G5-G6/2\n" +
                        "E5-E6,Bn1-B2-B5-D6-F6-G6, , , , ,A4-A5/2,G4-G5/2\n" +
                        "G2-G3-D5-D6/0.66,G4-G5/0.66,D5-D6/0.66,E5-E6/0.66\n" +
                        "C2-C3-C5-G5, , ,C5,D5,Eb5,C5,Ab5,G5,C5-G5-E5-C6\n" +
                        "D5-G5,E5-G5,B1-B2-B4-G5,D5-A5,D5-G5,D5,E5,F5\n" +
                        "G2-G3,A5,G5,D5-F5-G5-D6,E5,F5\n" +
                        "C2-C3-C5-G5, , ,C5,D5,Eb5,C5,Ab5,G5,C5-G5-E5-C6\n" +
                        "D5-G5,E5-G5,B1-B2-B4-G5,D5-A5,D5-G5,D5,E5,F5\n" +
                        "G2-G3,A5,G5,D5-F5-G5-D6,E5,F5\n" +
                        "C2-C3-C5-G5, , ,C5,D5,Eb5-C7,C5,Ab5,G5,C5-G5-E5-C6\n" +
                        "D5-G5,E5-G5,B1-B2-B4-G5,D5-A5,D5-G5,D5,E5,F5-D7\n" +
                        "G2-G3,A5,G5,D5-F5-G5-D6,E5,F5\n" +
                        "C2-C3-C5-G5, , ,C5,D5,Eb5-C7,C5,Ab5,G5,C5-G5-E5-C6\n" +
                        "D5-G5,E5-G5,B1-B2-B4-G5,D5-A5,D5-G5,D5,E5,F5-D7\n" +
                        "G2-G3,A5,G5,D5-F5-G5-D6,E5,F5/2, /3,F2/6,F3/6\n" +
                        "C4/6,Ab5,F4-F5,G4-G5,A4-A5,C5-C6,D5-D6/2, /3\n" +
                        "G2/6,G3-B5-B4/6,D4/6,B/0.66,G4-G5/0.66,Eb5-E6/0.66\n" +
                        "D5-D6/3, ,F2/6,F2-F4-F5/6,C4/6,A5, ,G4-G5,A4-A5\n" +
                        "C5-C6,D5-D6/2, /3,G2/6,G3-B5-B4/6,D4/6,B/0.66\n" +
                        "G4-G5/0.66,D4-D5/0.66,E4-E5/0.66,F2/6,F3/6,C4/6\n" +
                        "Ab5,F4-F5,G4-G5,A4-A5,C5-C6,D5-D6/2, /3,G2/6\n" +
                        "G3-B5-B4/6,D4/6,B/0.66,G4-G5/0.66,Eb5-E6/0.66\n" +
                        "D5-D6/2, ,A2/6,A3-F4-C5-F5/6,F, ,G4-G5,A4-A5\n" +
                        "C5-C6,D5-D6/2, /3,G2/6,G3-C5-C6/6,D4/6,B4/0.66\n" +
                        "B4-B5/0.66,An4-A5/0.66,B4-B5/0.66,C2-C3, , \n" +
                        "C5-C6/2,Eb5-E6/2,D5-F5-F6,Eb5-G5-G6\n" +
                        "C5-C6-C7,Ab5/2,G5-G6/2,G5,C5-G5-Bb5-B6,D5-G5/2\n" +
                        "G5-G6/2,E5-G5-E5-E6,Bn1-B2-B4-B5,D5-A5,D5-G5,D\n" +
                        "E5-A4-A5,F5-G4-G5,G2-G3-D5-D6,A5/2,G4-G5/2,G5\n" +
                        "D5-D6,E5/2,E6/2,F5,C2-C3-B4-B5/0.66,C5-C6/0.66\n" +
                        "C5-E5-E6,D5-F5-F6,E5-G5-G6,C5-C6-C7,A5/2,G5-G6/2\n" +
                        "G5,C5-G5-Bb5-B6,D5-G5/2,G5-G6/2,E5-G5-E6\n" +
                        "Bn1-B2-B4-B5,D5-A5,D-G5,D,E5,F5-A4-A5/2,G4-G5/2\n" +
                        "G2-G3-D5-D6,A5/2,G4-G5/2,G5,D5-D6,E5/2,E6/2,F5\n" +
                        "C2-C3, , ,C5/2,Eb5/2,F5,G5,C6/0.66,G5/0.66\n" +
                        "Bb5/0.66,G5/2,E5,Bn1-B2-B4, , , ,Ab4,G4\n" +
                        "G2-G3-D5/0.66,G4/0.66,D5/0.66,E5/0.66\n" +
                        "C2-C3-B4/0.66,C5/0.66,E5,F5,G5,C6/0.66,G5/0.66\n" +
                        "Bb5/0.66,G5/2,Eb5,Bn1-B2-B4, , , , ,Ab4/2,G4/2\n" +
                        "G2-G3-D5/0.66,G4/0.66,D5/0.66,Eb5, , , \n" +
                        "C2-C3, , , , ");
    }


    @Test
    public void sTest() throws Exception {
        test(200, "" +

                "G3-G4, , , , , , , \n" +
                "Eb3-E4, , , ,D3-D4, , , ,G3-G4, , , , , , , \n" +
                "E3-E4, , , ,D3-D4, , , ,G3-G4-Bb6,A6,G6,D6,B,A,G,D\n" +
                "E3-B3-E4-B6,A,G,D,D3-A3-D4-C7,B6,A6,B6,G3-G4-B6,A6\n" +
                "G6,D6,B,A,G,D,E3-B3-E4-B6,A,G,D,D3-A3-D4-C7,B6,A6\n" +
                "G6,G3-G4-B6,A6,G6,D6,B,A,G,D,E3-B3-E4-B6,A,G,D\n" +
                "D3-A3-D4-C7,B6,A6,B6,G3-G4-B6,A6,G6,D6,B,A,G,D\n" +
                "E3-B3-E4-B6,A,G,D,D3-A3-D4-C7,B6,A6,G6\n" +
                "G3-Bb3-G4-B6,A6,B3-G6,D6,B3-B6,A,B3-G,D\n" +
                "Eb3-B3-E4-B6,A6,B3-G6,D6,D3-B3-D4-C7,B6,B3-A6,B6\n" +
                "G3-B3-D4-G4-B6,A6,G3-B3-D4-G6,D6,G3-B3-D4-B6,A6\n" +
                "G3-B3-D4-G6,D6,E3-G3-B3-E4-B6,A6,E3-G3-B3-G6,D6\n" +
                "D#3-Dn3-F#3-A3-A#3-D4-C7,B6,D4-A3-F3-D#3-An6,G6\n" +
                "G3-Dn4-G4-D5-Bb5,G5,G3-G4,B5/2,G5/1.8\n" +
                "G3-G4-D5-B5/2,G5/1.8, ,G3-G4,B5/2,G5/1.8\n" +
                "Eb3-B3-E4-D5-B5/2,G5/1.8, ,E3-B3,B5/2,G5/1.8\n" +
                "D3-A3-D4-D5-B5/2,G5/1.8,B5/2,G/1.8,D3-A3-B5/2\n" +
                "G/1.8,B/2,G/1.8,G3-D4-G4-D5-B5/2,A5/1.8, ,G3-D4\n" +
                "B5/2,A/1.8,G3-D4-D5-B5/2,A5/1.8, ,G3-D4,B5/2\n" +
                "A5/1.8,E3-B3-E4-D5-B5/2,A5/1.8, ,E3-B3,B5/2,A5/1.8\n" +
                "D3-F#3-A3-D4-D5-B5/2,A5/1.8,F3-A3-D4-F4-B5/2\n" +
                "A5/1.8,A3-D4-F4-A4-B5/2,A5/1.8,D4-F4-A4-D5-B5/2\n" +
                "A5/1.8,G2-G3-Bb5-B6,G5-G6,D4-G4-B4,B5-B6/2\n" +
                "G5-G6/1.8,G2-G3-B5-B6/2,G5-G6/1.8,G-G5,D4-G4-B4\n" +
                "B5-B6/2,G5-G6/1.8,Eb2-E3-B5-B6/2,G5-G6/1.8,G-G5\n" +
                "E4-G4-B4-E5,B5-B6/2,G5-G6/1.8,D2-D3-B5-B6/2\n" +
                "G5-G6/1.8,B5-B6/2,G5-G6/1.8,D4-F#4-A4-D5-B5-B6/2\n" +
                "G5-G6/1.8,B5-B6/2,G5-G6/1.8,G2-G3-B5-B6/2\n" +
                "A5-A6/1.8,A-A5,D4-G4-B4,B5-B6/2,A5-A6/1.8\n" +
                "G2-G3-B5-B6/2,A5-A6/1.8,A-A5,D4-G4-B4,B5-B6/2\n" +
                "A5-A6/1.8,E2-E3-B5-B6/2,A5-A6/1.8,A-A5");
    }

    @Test
    public void furElliseTest() throws Exception {


        //Mortal Kombat theme v.2 +
        test(60 * 1000f / 200, "" +

                "E5/0.2,Eb,En,Eb,En,B4,D5,C5,A4-A2,E3,A3,C4,E4,A4\n" +
                "B-E2,E3,Ab3,E4,A4,B,C5-An2,E3,A3,E4,E5,Eb,En,Eb,En\n" +
                "B,D,C,A4-A2,E3,A3,C4,E4,A4,B-E2,E3,Ab3,E4,C5,B\n" +
                "An4-A2,E3,A3/0.5,E5,Eb,En,Eb,En,B,D,C,A4-A2,E3,A3\n" +
                "C4,E4,A4,B-E2,E3,Ab3,E4,A4,B,C5-An2,E3,A3,E4,E5,Eb\n" +
                "En,Eb,En,B,D,C,A4-A2,E3,A3,C4,E4,A4,B-E2,E3,Ab3,E4\n" +
                "C5,B,An4-A2,E3,A3,B,C,D,E5-C3,G,C4,G4,F5,E,D-G2,G3\n" +
                "B3,F4,E,D,C5-A2,E3,A3,E4,D,C,B4-E2,E3,E4,E,E5,E4\n" +
                "E5,E,E6,Eb5,En,Eb,En,Eb,En,B,D,C,A4-A2,E3,A3,C4,E4\n" +
                "A4,B-E2,E3,Ab3,E4,A4,B,C5-An2,E3,A3,E4,E5,Eb,En,Eb\n" +
                "En,B,D,C,A4-A2,E3,A3,C4,E4,A4,B-E2,E3,Ab3,E4,C5,B\n" +
                "An4-A2,E3,A3,B,C,D,E5-C3,G,C4,G4,F5,E,D-G2,G3,B3\n" +
                "F4,E,D,C5-A2,E3,A3,E4,D,C,B4-E2,E3,E4,E,E5,E4,E5,E\n" +
                "E6,Eb5,En,Eb,En,Eb,En,B,D,C,A4-A2,E3,A3,C4,E4,A4\n" +
                "B-E2,E3,Ab3,E4,A4,B,C5-An2,E3,A3,E4,E5,Eb,En,Eb,En\n" +
                "B,D,C,A4-A2,E3,A3,C4,E4,A4,B-E2,E3,Ab3,E4,C5,B\n" +
                "An4-A2,E3,A3,Bb3-C4-E4-C5,C4-A-F-C5,B-C4-G-E-C5-G4\n" +
                "C-F3,A,C4,A,C-F5,A/2,E5/2,E-F3,B,D-D4,B,D-B5,B3/2\n" +
                "A5/2,A-F,G5-E4,F5-B-G3-F3,E5-E4,D5-B-G-F,C5-E,B4-F\n" +
                "A3,A4-C4,A3,A4-C/2,G4/2,A-A3/2,B/2,C5-F,A,C4,A,D-C\n" +
                "Eb5-A,En-E3,A,C,E5-A,F5-D4-D3,A4-F3,C5-G3,E4,G,E\n" +
                "D5-G,F4/2,Bn/2,C-C4-E/2,G5/2,G4/2,G5/2,A/2,G/2\n" +
                "B-G4-F/2,G5/2,C5-G4-E/2,G5/2,D-G4-F-D4/2,G5/2\n" +
                "E5-C4-E4-G4/2,G5/2,C6/2,B5/2,A5-F3-A3/2,G/2,F5/2\n" +
                "D5/2,C5-G3-B3/2,G5/2,F/2,D/2,C-C4/2,G/2,G4/2,G5/2\n" +
                "A4/2,G/2,B4-G4-F4/2,G5/2,C5-G4-E/2,G5/2\n" +
                "D-G4-F-D4/2,G5/2,E5-C4-E4-G4/2,G5/2,C6/2,B5/2\n" +
                "A5-F3-A3/2,G/2,F5/2,E5/2,D5-G3-B3/2,G5/2,F/2,D/2\n" +
                "E-Ab-B/2,F/2,E/2,Eb/2,En/2,B4/2,E/2,Eb/2,En/2,B/2\n" +
                "E/2,Eb/2,En/0.33,B,E,Eb,En/0.33,B,E,Eb,En,Eb,En,Eb\n" +
                "En,Eb,En,Eb,En,B,D,C5,An4-A2,E3,A3,C4,E4,A4,B-E2\n" +
                "E3,Ab3,E4,A4,B,C5-An2,E3,A3,E4,E5,Eb,En,Eb,En,B,D\n" +
                "C,A4-A2,E3,A3,C4,E4,A4,B-E2,E3,Ab3,E4,C5,B,An4-A2\n" +
                "E3,A3/0.5,E5,Eb,En,Eb,En,B,D,C,A4-A2,E3,A3,C4,E4\n" +
                "A4,B-E2,E3,Ab3,E4,A4,B,C5-An2,E3,A3,E4,E5,Eb,En,Eb\n" +
                "En,B,D,C,A4-A2,E3,A3,C4,E4,A4,B-E2,E3,Ab3,E4,C5,B\n" +
                "An4-A2,E3,A3,B,C,D,E5-C3,G3,C4,G4,F,E,D-G2,G3,B3\n" +
                "F4,E,D,C5-A2,E3,A3,E4,D,C,B4-E2,E3,E4,E,E5,E4,E5,E\n" +
                "E6,Eb5,En,Eb,En,Eb,En,B,D,C,A4-A2,E3,A3,C4,E4,A4\n" +
                "B-E2,E3,Ab3,E4,A4,B,C5-An2,E3,A3,E4,E5,Eb,En,Eb,En\n" +
                "B,D,C,A4-A2,E3,A3,C4,E4,A4,B-E2,E3,Ab3,E4,C5,B\n" +
                "An2-A4,A2,A,A,A,A,A-E-G4-Bb-Db,A,A,A,A,A,A-Dn-F-A4\n" +
                "A2,A,A,A-Db-E5,A-Dn-F5,A-F-D-Ab4,An2,A,A,A-F-D-Ab4\n" +
                "An2,A-A4-C-E,A2,A,A,A,A,A-D2-D5-F4,A-D2,A-D,A-D\n" +
                "A-D-C-E4,A-D-Bn-D4,Eb2-A-C4-Gb-A4,A2-E,A-E,A-E\n" +
                "A-C-A4-E,A2-E,A-En-A4-C,A2-E,A-E-C5-E4,A-E2\n" +
                "Ab-E-B-D,A-E,An-A1-A4-C4,A2,A,A,A,A,A-E4-Gn-Bb-Db5\n" +
                "A,A,A,A,A,A-Dn-A4-F,A2,A,A,A-Db-E5,A-Dn-F5,A-D-F,A\n" +
                "A,A,A-D-F,A,B2-F-D,B,B,B,B,B,B-Eb-G,B,B,B,B-D-F4\n" +
                "B-C5-E4,B-B4-F-D4,B2,B,B,B-D-F-A4,B,Bn-D-F-Ab,B,B");


    }
}
