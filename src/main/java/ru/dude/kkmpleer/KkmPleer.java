package ru.dude.kkmpleer;

import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class KkmPleer {

    private static int volume = -50;
    private static int bpm = 0;
    private static String musicString = "";

    public static void main(String[] args) throws Exception {

        Options options = new Options();

        options.addOption(Option.builder("f").longOpt("file").desc("file with music").numberOfArgs(1).required(true).build());
        options.addOption(Option.builder("v").longOpt("volume").desc("volume").numberOfArgs(1).required(false).build());


        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);


            if (cmd.getOptionValue("v") != null) {
                volume = Integer.parseInt(cmd.getOptionValue("v"));
            }

            parseFile(cmd.getOptionValue("f"));

        }catch (Exception ex){
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "kkmPleer", options );
            throw ex;
        }



        APlayable pleer = new MockPleer();

        pleer.init();
        pleer.setVolume(volume);

        double duration = 60 * 1000f / bpm;

        for (String one : musicString.split(",")) {
            pleer.parsePlay(one, duration);
        }


        pleer.close();
    }

    private static void parseFile(String filePath) throws Exception {
        File file = new File(filePath);

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String line = br.readLine().trim().toUpperCase();
                if (line.startsWith("BPM:")) {
                    bpm = Integer.parseInt(line.substring("BPM:".length()).trim());
                } else {
                    throw new Exception("Incorrect format");
                }

                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line).append(",");
                }
                musicString = sb.toString().trim();

                br.close();
            }

        }
    }

}
