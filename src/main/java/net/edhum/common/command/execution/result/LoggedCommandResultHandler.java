package net.edhum.common.command.execution.result;

public class LoggedCommandResultHandler implements CommandResultHandler {

    @Override
    public void handleResult(CommandResult result) {
        // TODO: 09/07/2021 Log les commandes et logs celles ayant échoué dans un fichier séparé
        /*switch (result) {
            case SUCCESS -> System.out.println("SUCCESS !");
            case FAILURE -> System.out.println("FAILURE !");
        }*/
    }
}
