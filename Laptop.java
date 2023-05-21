/*
Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объём ЖД
3 - Операционная система
4 - Цвет.
Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
*/

package JavaTop;

import java.util.*;

public class Laptop {
    public static List<Notebook> filterNotebooks(List<Notebook> notebooks, Map<String, Object> filters) {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean passesFilter = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                switch (key) {
                    case "ram":
                        int minRam = (int) value;
                        if (notebook.getRam() < minRam) {
                            passesFilter = false;
                        }
                        break;
                    case "storage":
                        int minStorage = (int) value;
                        if (notebook.getStorage() < minStorage) {
                            passesFilter = false;
                        }
                        break;
                    case "os":
                        String requiredOs = (String) value;
                        if (!notebook.getOs().equalsIgnoreCase(requiredOs)) {
                            passesFilter = false;
                        }
                        break;
                    case "color":
                        String requiredColor = (String) value;
                        if (!notebook.getColor().equalsIgnoreCase(requiredColor)) {
                            passesFilter = false;
                        }
                        break;
                }

                if (!passesFilter) {
                    break;
                }
            }

            if (passesFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}