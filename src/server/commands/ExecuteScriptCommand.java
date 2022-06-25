package server.commands;

import server.serverCode.MovieManager;
import server.commands.*;
import java.io.*;


/**
 * Class for realizing command "execute_script"
 * @author Karina Zaytseva
 * @version 1.1
 */
public class ExecuteScriptCommand extends AbstractCommand {

    private MovieManager manager;
    /**
     * Constructor for this class
     *
     * @param manager - field for using opportunities of Collection Manager
     */
    public ExecuteScriptCommand(MovieManager manager) {
        this.manager = manager;

    }

    /**
     * Method for realizing this command
     * @param pathToFile - string representation of path to file which contain script
     * @return method executing status into a string representation
     */
    public String execute(String pathToFile) {
        try {
            System.out.println("WARNING. To avoid recursion, your file cannot contain execute script commands.");
            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            StringBuilder message = new StringBuilder();
            String[] finalUserCommand;
            String line;
            while ((line = reader.readLine()) != null) {
                // show 5 => ["show", "5"]
                finalUserCommand = line.trim().toLowerCase().split(" ", 2);
                switch (finalUserCommand[0]) {
                    case "help":
                        HelpCommand help = new HelpCommand();
                        message.append(help.execute()).append("\n");
                        break;
                    case "info":
                        InfoCommand info = new InfoCommand(manager);
                        message.append(info.execute()).append("\n");
                        break;
                    case "show":
                        ShowCommand show = new ShowCommand(manager);
                        message.append(show.execute()).append("\n");
                        break;
                    case "add":
                        AddCommand add = new AddCommand(manager);
                        message.append(add.execute()).append("\n");
                        break;
                    case "update_by_id":
                        UpdateByIdCommand update_by_id = new UpdateByIdCommand(manager);
                        message.append(update_by_id.execute(new Long(finalUserCommand[1]))).append("\n");
                        break;
                    case "remove_by_id":
                        RemoveByIdCommand remove_by_id = new RemoveByIdCommand(manager);
                        message.append(remove_by_id.execute(new Long(finalUserCommand[1]))).append("\n");
                        break;
                    case "clear":
                        ClearCommand clear = new ClearCommand(manager);
                        message.append(clear.execute()).append("\n");
                        break;
                    case "save":
                        SaveCommand save = new SaveCommand(manager);
                        message.append(save.execute()).append("\n");
                        break;
                    case "execute_script":
                        message.append("This script cannot to contain this command.").append("\n");
                        break;
                    case "exit":
                        ExitCommand exit = new ExitCommand();
                        exit.execute();
                        break;
                    case "max_by_oscars_count":
                        MaxByOscarsCountCommand maxByOscarsCountCommand = new MaxByOscarsCountCommand(manager);
                        message.append(maxByOscarsCountCommand.execute()).append("\n");
                        break;
                    case "print_descending":
                        PrintDescendingCommand printDescendingCommand = new PrintDescendingCommand();
                        message.append(printDescendingCommand.execute()).append("\n");
                        break;
                    case "remove_greater":
                        RemoveGreaterCommand removeGreaterCommand = new RemoveGreaterCommand();
                        message.append(removeGreaterCommand.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "remove_lower":
                        RemoveLowerCommand removeLowerCommand = new RemoveLowerCommand();
                        message.append(removeLowerCommand.execute(finalUserCommand[1])).append("\n");
                        break;
                    case "sum_of_oscars_count":
                        SumOfOscarsCountCommand sumOfOscarsCountCommand = new SumOfOscarsCountCommand(manager);
                        message.append(sumOfOscarsCountCommand.execute()).append("\n");
                    default:
                        message.append("Unknown command").append("\n");
                        break;
                }
            }
            reader.close();
            return message.toString();
            //return "Commands are ended.";
        } catch (FileNotFoundException fileNotFoundException) {
            return "File not found. Try again.";
        } catch (IOException ioException) {
            return "File reading exception. Try again.";
        }
    }
}
