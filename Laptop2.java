package JavaTop;

import java.util.*;

public class Laptop2 {
    public static void main(String[] args) {
        ArrayList<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("MacBook Pro", 16, 512, "macOS", "Silver"));
        notebooks.add(new Notebook("Lenovo ThinkPad", 8, 256, "Windows", "Black"));
        notebooks.add(new Notebook("HP Spectre", 8, 256, "Windows", "Gold"));

        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите критерии фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ:");
                int minRam = scanner.nextInt();
                filters.put("ram", minRam);
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = scanner.nextInt();
                filters.put("storage", minStorage);
                break;
            case 3:
                System.out.println("Введите требуемую операционную систему:");
                String requiredOs = scanner.nextLine();
                filters.put("os", requiredOs);
                break;
            case 4:
                System.out.println("Введите требуемый цвет:");
                String requiredColor = scanner.nextLine();
                filters.put("color", requiredColor);
                break;
        }

        List<Notebook> filteredNotebooks = filterNotebooks(notebooks, filters);

        if (filteredNotebooks.isEmpty()) {
            System.out.println("Ноутбуки, удовлетворяющие условиям фильтра, не найдены.");
        } else {
            System.out.println("Результаты фильтрации:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook.getModel());
            }
        }
    }

    private static List<Notebook> filterNotebooks(ArrayList<Notebook> notebooks, Map<String, Object> filters) {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean matchesFilter = true;

            if (filters.containsKey("ram")) {
                int minRam = (int) filters.get("ram");
                if (notebook.getRam() < minRam) {
                    matchesFilter = false;
                }
            }

            if (filters.containsKey("storage")) {
                int minStorage = (int) filters.get("storage");
                if (notebook.getStorage() < minStorage) {
                    matchesFilter = false;
                }
            }

            if (filters.containsKey("os")) {
                String requiredOs = (String) filters.get("os");
                if (!notebook.getOs().equalsIgnoreCase(requiredOs)) {
                    matchesFilter = false;
                }
            }

            if (filters.containsKey("color")) {
                String requiredColor = (String) filters.get("color");
                if (!notebook.getColor().equalsIgnoreCase(requiredColor)) {
                    matchesFilter = false;
                }
            }

            if (matchesFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}

class Notebook {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Notebook(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}