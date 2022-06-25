package server.commands;

import com.sun.deploy.*;

import java.util.ArrayList;

public class HelpCommand extends AbstractCommand {

    public String execute () {
        ArrayList<String> reference = new ArrayList<>();
        reference.add("help : вывести справку по доступным командам\n");
        reference.add("info : вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов и т.д.)\n");
        reference.add("show : вывести в стандартный поток вывода все элементы коллекции " +
                "в строковом представлении\n");
        reference.add("add {element} : добавить новый элемент в коллекцию\n");
        reference.add("update id {element} : обновить значение элемента коллекции," +
                "id которого равен заданному\n");
        reference.add("remove_by_id id : удалить элемент из коллекции по его id\n");
        reference.add("clear : очистить коллекцию\n");
        reference.add("save : сохранить коллекцию в файл\n");
        reference.add("execute_script file_name : считать и исполнить скрипт из указанного файла." +
                " В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n");
        reference.add("exit : завершить программу (без сохранения в файл)\n");
        reference.add("add_if_min {element} : добавить новый элемент в коллекцию, " +
                "если его значение меньше, чем у наименьшего элемента этой коллекции\n");
        reference.add("remove_greater {element} : удалить из коллекции все элементы," +
                " превышающие заданный\n");
        reference.add("history : вывести последние 7 команд (без их аргументов)\n");
        reference.add("print_descending : вывести элементы коллекции в порядке убывания\n");
        reference.add("print_field_descending_mpaa_rating : вывести значения поля mpaaRating " +
                "всех элементов в порядке убывания\n");
        reference.add("print_field_descending_oscars_count : вывести значения поля oscarsCount всех элементов " +
                "в порядке убывания\n");
        return reference.toString();
    }
}
