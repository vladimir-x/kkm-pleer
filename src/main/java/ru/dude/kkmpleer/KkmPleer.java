package ru.dude.kkmpleer;

import org.apache.commons.cli.*;
import ru.dude.kkmpleer.kkm.APlayable;
import ru.dude.kkmpleer.kkm.Atol10Kkm;
import ru.dude.kkmpleer.kkm.MockPleer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class KkmPleer {

    private static int volume = -30;
    private static int bpm = 0;
    private static String musicString = "";
    private static KkmConfig kkmConfig = null;

    public static void main(String[] args) throws Exception {

        Options options = new Options();

        options.addOption(Option.builder("f").longOpt("file").desc("file with music").numberOfArgs(1).required(true).build());
        options.addOption(Option.builder("v").longOpt("volume").desc("volume. Default  " + volume).numberOfArgs(1).required(false).build());
        options.addOption(Option.builder("kkm").longOpt("kkm-type").desc("kkm model. Default: mock. Acceptable: mock, atol10. ").numberOfArgs(1).required(false).build());
        options.addOption(Option.builder("com").longOpt("com-speed").desc("comport:speed. Default: not use.").numberOfArgs(1).required(false).build());
        options.addOption(Option.builder("ip").longOpt("ip-port").desc("ip4:port. Default: not use.").numberOfArgs(1).required(false).build());

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);


            if (cmd.getOptionValue("v") != null) {
                volume = Integer.parseInt(cmd.getOptionValue("v"));
            }

            parseFile(cmd.getOptionValue("f"));
            kkmConfig = new KkmConfig(cmd.getOptionValue("kkm"),
                    cmd.getOptionValue("com"),
                    cmd.getOptionValue("ip")
            );

        }catch (Exception ex){
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "kkmPleer", options );
            throw ex;
        }

        APlayable pleer = createPlayer(kkmConfig);

        pleer.init();
        pleer.setVolume(volume);

        double duration = 60 * 1000f / bpm;

        for (String one : musicString.split(",")) {
            pleer.parsePlay(one, duration);
        }


        pleer.close();
    }

    private static APlayable createPlayer(KkmConfig config){
        if (config == null || config.type == null || config.type.trim().length()==0){
            return new MockPleer();
        }

        if (config.type.equals("atol10")){
            return new Atol10Kkm(config);
        }
        return new MockPleer();

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

        } else {
            throw new Exception("File " + filePath + " not exist!");
        }
    }

}
