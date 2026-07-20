package lesson6;

import java.util.*;

public class Phonebook {

    private Map<String, List<String>> phoneMap;
    public Phonebook() {
        this.phoneMap = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (phoneMap.containsKey(surname)) {
            List<String> phones = phoneMap.get(surname);
            phones.add(phoneNumber);
            System.out.println("✅ Добавлен номер " + phoneNumber + " для фамилии " + surname);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            phoneMap.put(surname, phones);
            System.out.println("✅ Добавлена новая запись: " + surname + " → " + phoneNumber);
        }
    }

    public List<String> get(String surname) {
        if (phoneMap.containsKey(surname)) {
            return phoneMap.get(surname);
        } else {
            System.out.println("❌ Фамилия \"" + surname + "\" не найдена в справочнике");
            return new ArrayList<>();
        }
    }

    public void printPhones(String surname) {
        List<String> phones = get(surname);

        if (phones.isEmpty()) {
            System.out.println("📭 У фамилии \"" + surname + "\" нет номеров");
        } else {
            System.out.println("📞 Телефонные номера для фамилии \"" + surname + "\":");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + phones.get(i));
            }
        }
    }

    public boolean removePhone(String surname, String phoneNumber) {
        if (phoneMap.containsKey(surname)) {
            List<String> phones = phoneMap.get(surname);
            boolean removed = phones.remove(phoneNumber);

            if (removed) {
                System.out.println("🗑️  Номер " + phoneNumber + " удален для фамилии " + surname);
                if (phones.isEmpty()) {
                    phoneMap.remove(surname);
                    System.out.println("ℹ️  Запись для фамилии \"" + surname + "\" полностью удалена");
                }
                return true;
            } else {
                System.out.println("❌ Номер " + phoneNumber + " не найден для фамилии " + surname);
                return false;
            }
        } else {
            System.out.println("❌ Фамилия \"" + surname + "\" не найдена");
            return false;
        }
    }

    public boolean removeSurname(String surname) {
        if (phoneMap.containsKey(surname)) {
            phoneMap.remove(surname);
            System.out.println("🗑️  Запись для фамилии \"" + surname + "\" удалена");
            return true;
        } else {
            System.out.println("❌ Фамилия \"" + surname + "\" не найдена");
            return false;
        }
    }

    public boolean containsSurname(String surname) {
        return phoneMap.containsKey(surname);
    }

    public Set<String> getAllSurnames() {
        return phoneMap.keySet();
    }

    public int getSize() {
        return phoneMap.size();
    }

    public int getTotalPhonesCount() {
        int total = 0;
        for (List<String> phones : phoneMap.values()) {
            total += phones.size();
        }
        return total;
    }

    public void printAll() {
        System.out.println("\n========== ТЕЛЕФОННЫЙ СПРАВОЧНИК ==========");
        System.out.println("Всего записей: " + getSize());
        System.out.println("Всего номеров: " + getTotalPhonesCount());
        System.out.println("-------------------------------------------");

        if (phoneMap.isEmpty()) {
            System.out.println("📭 Справочник пуст");
        } else {
            List<String> sortedSurnames = new ArrayList<>(phoneMap.keySet());
            Collections.sort(sortedSurnames);

            for (String surname : sortedSurnames) {
                List<String> phones = phoneMap.get(surname);
                System.out.println("📌 " + surname + " (" + phones.size() + " номеров):");
                for (String phone : phones) {
                    System.out.println("    → " + phone);
                }
                System.out.println("-------------------------------------------");
            }
        }
        System.out.println("==========================================\n");
    }


    public static void main(String[] args) {
        System.out.println("========== ТЕЛЕФОННЫЙ СПРАВОЧНИК ==========\n");

        Phonebook phonebook = new Phonebook();
        System.out.println("✅ Создан пустой телефонный справочник");
        System.out.println();

        System.out.println("=== ДОБАВЛЕНИЕ ЗАПИСЕЙ ===\n");

        phonebook.add("Иванов", "+7-999-123-45-67");
        phonebook.add("Петров", "+7-999-234-56-78");
        phonebook.add("Сидоров", "+7-999-345-67-89");
        phonebook.add("Иванов", "+7-999-456-78-90");
        phonebook.add("Иванов", "+7-999-567-89-01");
        phonebook.add("Петров", "+7-999-678-90-12");
        phonebook.add("Кузнецов", "+7-999-789-01-23");
        System.out.println();

        System.out.println("=== ПОИСК НОМЕРОВ ===\n");

        System.out.println("🔍 Поиск для фамилии 'Иванов':");
        List<String> ivanovPhones = phonebook.get("Иванов");
        System.out.println("Найдено номеров: " + ivanovPhones.size());
        for (String phone : ivanovPhones) {
            System.out.println("  → " + phone);
        }
        System.out.println();

        System.out.println("🔍 Поиск для фамилии 'Сидоров':");
        List<String> sidorovPhones = phonebook.get("Сидоров");
        System.out.println("Найдено номеров: " + sidorovPhones.size());
        for (String phone : sidorovPhones) {
            System.out.println("  → " + phone);
        }
        System.out.println();

        System.out.println("🔍 Поиск для фамилии 'Смирнов':");
        List<String> smirnovPhones = phonebook.get("Смирнов");
        System.out.println("Найдено номеров: " + smirnovPhones.size());
        System.out.println();

        System.out.println("=== ВЫВОД НОМЕРОВ С ФОРМАТИРОВАНИЕМ ===\n");
        phonebook.printPhones("Иванов");
        System.out.println();
        phonebook.printPhones("Петров");
        System.out.println();
        phonebook.printPhones("Смирнов");
        System.out.println();

        phonebook.printAll();

        System.out.println("=== УДАЛЕНИЕ НОМЕРОВ ===\n");
        phonebook.removePhone("Иванов", "+7-999-456-78-90");
        System.out.println();
        phonebook.printPhones("Иванов");
        System.out.println();

        System.out.println("=== УДАЛЕНИЕ ВСЕЙ ЗАПИСИ ===\n");
        phonebook.removeSurname("Кузнецов");
        System.out.println();
        phonebook.printPhones("Кузнецов");
        System.out.println();

        System.out.println("=== ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ ===\n");
        System.out.println("Есть ли фамилия 'Иванов'? " + phonebook.containsSurname("Иванов"));
        System.out.println("Есть ли фамилия 'Смирнов'? " + phonebook.containsSurname("Смирнов"));
        System.out.println();
        System.out.println("Все фамилии в справочнике: " + phonebook.getAllSurnames());
        System.out.println();
        System.out.println("Количество записей (фамилий): " + phonebook.getSize());
        System.out.println("Общее количество номеров: " + phonebook.getTotalPhonesCount());
        System.out.println();

        System.out.println("=== ИТОГОВЫЙ СПРАВОЧНИК ===\n");
        phonebook.printAll();

        System.out.println("✅ Программа завершена успешно!");
    }
}

