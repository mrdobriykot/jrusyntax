import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "cypher",
        version = "0.0.1",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        description = "This is a realisation of Caesar Cipher algorithm",
        header = "Caesar Cipher",
        optionListHeading = "%nOptions are:%n",
        footerHeading = "%nCopyright",
        footer =  "%nDeveloped by Evgenii Korin for JRU%n",
        commandListHeading = "%nSubcommands are: %n",
        subcommandsRepeatable = true,
        subcommands = {
            Crypt.class
        }
)

public class MainCommand implements Callable<Integer> {


    public static void main(String[] args) {
        int exitStatus = new CommandLine(new MainCommand()).execute(
                "crypt", "-p=C:\\repos\\mrdobriykot\\java\\CryptoAnalyzer\\input.txt",
        "-ep=C:\\repos\\mrdobriykot\\java\\CryptoAnalyzer\\output.txt", "-s=5");
        System.exit(exitStatus);
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }


}
