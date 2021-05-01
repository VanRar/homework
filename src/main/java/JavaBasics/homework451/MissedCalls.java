package JavaBasics.homework451;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void add(LocalDateTime time, String phone) {
        missedCalls.put(time, phone);

    }

    public void clear() {
        missedCalls.clear();
    }


    public String toPrint(Contacts contacts) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список пропущенных вызовов::\n");
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            stringBuilder
                    .append(entry.getKey()).append("\t")
                    .append(contacts.searchContact(entry.getValue())).append("\n");
        }
        return stringBuilder.toString();
    }
}
