import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "crypt",
        aliases = {"encrypt"},
        version = "0.0.1",
        mixinStandardHelpOptions = true,
        requiredOptionMarker = '*',
        description = "For crypt by Caesar Cipher algorithm",
        header = "Crypt using Caesar cypher",
        optionListHeading = "%nOptions are:%n",
        footerHeading = "%nCopyright",
        footer =  "%nDeveloped by Evgenii Korin for JRU%n"
)


public class Crypt implements Callable <Integer> {

    @CommandLine.Option(
            names = {"-p", "--path"},
            required = true,
            description = "path to file[s] you need to encrypt"
    )
    String path;

    @CommandLine.Option(
            names = {"-ep", "--epath"},
            required = true,
            description = "path to create encrypted file[s]"
    )
    String epath;

    @CommandLine.Option(
            names = {"-s", "--step"},
            required = true,
            description = "input step for encrypting"
    )
    int step;



    @Override
    public Integer call() throws Exception {
        Solution.crypt_data_from_file(path, epath, step, false);
        return 0;
    }
}
