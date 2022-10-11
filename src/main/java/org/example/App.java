package org.example;

import org.apache.commons.cli.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Options opts = new Options();
        opts.addOption("h", "hello", true, "Приветствие");
        opts.addOption("w", "world", true, "Кому");
        CommandLineParser parser = new DefaultParser();
        String hello = "Hello";
        String world = "world";
        try {
            CommandLine cli = parser.parse(opts, args);
            String optHello = cli.getOptionValue("h");
            if (optHello != null) hello = optHello;
            String optWorld = cli.getOptionValue("w");
            if (optWorld != null) world = optWorld;
        } catch (ParseException e) {
            HelpFormatter help = new HelpFormatter();
            help.printHelp("App", opts);
            return;
        }
        System.out.println( hello + " " + world + "!");
    }
}
