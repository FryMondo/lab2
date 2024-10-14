public class lab2 {

    public static void main(String[] args) {
        // Оголошення тексту типу String
        String text = "Сонце вже заходило; небо ставало темнішим. Вітерець дув з півдня, несучи з собою прохолоду. " +
                "Несподівано, перед ним з'явився кіт. Що ж робити: залишитися вдома чи все-таки піти на прогулянку?" +
                "Крок за кроком, він наближався до свого рішення...";
        try {
            // Викликаємо метод валідації
            validation.textValidation(text);

            // Виводимо текст в якому прибирається останній символ в слові, окрім слів в яких 1 символ
            System.out.println(delLetter.deleteLetter(text.trim()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class validation {
    // Перевірка чи текст не порожній
    public static void textValidation(String text) {
        if (text.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty string!");
        }
    }
}

class delLetter {
    public static String deleteLetter(String text) {
        // Створюємо масив із слів використовуючи RegEx
        // Текст розділяється на слова, а "розділювачем" є пробіл
        String[] words = text.split(" ");

        // Створюємо змінну для запису результату
        String result = "";

        // Циклом for-each проходимося по всім словам
        for (String word : words) {
            // Якщо слово складається з одного символу
            if (word.length() == 1) {
                result += word + " ";
                continue;
            }

            // Якщо речення закінчується на 3 крапки
            if (word.endsWith("...")) {
                result += word.substring(0, word.length() - 4) + "... ";
                continue;
            }

            // Якщо речення містить розділовий знак або "!", "?", "."
            char lastChar = word.charAt(word.length() - 1);
            if (lastChar == '.' || lastChar == '!' || lastChar == '?' || lastChar == ',' || lastChar == ';' ||
                    lastChar == ':') {
                result += word.substring(0, word.length() - 2) + lastChar + " ";
                continue;
            }

            // Для звичайних слів
            result += word.substring(0, word.length() - 1) + " ";
        }
        return result.trim();
    }
}
