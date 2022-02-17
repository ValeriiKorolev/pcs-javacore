package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            Scanner scanner = new Scanner(System.in);
            String[] tasks = new String[]{"Спорт", "Уборка", "Магазин", "Прогулка", "Уроки", "Сон", "Кино", "Еда"};
            int action;
            String actionStr;
            int taskNumber;
            while (true) {
                System.out.println("1 Добавить задачу" + "\n"
                        + "2 Удалить задачу" + "\n"
                        + "0 Выход" + "\n");
                System.out.print("Выберите действие: ");
                action = scanner.nextInt();
                if (action == 0) break;

                for (int i = 0; i < tasks.length; i++) {
                    System.out.println(i + 1 + " " + tasks[i]);
                }
                System.out.print("Введите номер задачи: ");
                taskNumber = scanner.nextInt();
                actionStr = (action == 1) ? "ADD" : "REMOVE";
                out.println("{ \"type\": \"" + actionStr + "\", \"task\": \"" + tasks[taskNumber - 1] + "\" }");
                System.out.println(in.readLine());
            }
            out.println("0");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
