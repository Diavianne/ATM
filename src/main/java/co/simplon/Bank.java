package co.simplon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//public class Bank {
//    public boolean authenticateUser(String userId, String pin) {
//        return true;
//    }
//}

public class Bank {
    private Map<String, String> userAccounts = new HashMap<>();

    public Bank() {
        loadUserAccounts("path/to/user_accounts.csv");
    }

    private void loadUserAccounts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userAccounts.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String userId, String pin) {
        return pin.equals(userAccounts.get(userId));
    }
}
