package Chapter6_Generics_and_Collections.Questions;

import java.util.HashMap;
import java.util.Map;

public class Question5 {
    private Map accountTotals = new HashMap();
    private int retirementFund;

    public int getBalance(String accountName) {
        Integer total = (Integer) accountTotals.get(accountName);
        if (total == null)
            total = Integer.valueOf(0);
        return total.intValue();
    }
    public void setBalance(String accountName, int amount) {
        accountTotals.put(accountName, Integer.valueOf(amount));
    }
}
// This class is going to be updated to make use of appropriate generic types, with no changes in behaviour
// (for better or worse). Which of these steps could be performed? (Choose three)

// A. Replace line 7 with
        // private Map<String, int> accountTotals = new HashMap<String, int>();
// B. Replace line 7 with
        // private Map<String, Integer> accountTotals = new HashMap<String, Integer>();     --> CORRECT
// C. Replace line 7 with
        // private Map<String<Integer>> accountTotals = new HashMap<String, Integer>();
// D. Replace lines 11-14 with
        // int total = accountTotals.get(accountName);
            // if (total == null)
                // total = 0;
            // return total;
// E. Replace lines 11-14 with                                  --> CORRECT
        // Integer total = accountTotals.get(accountName);
            // if (total == null)
                // total = 0;
            // return total;
// F. Replace lines 11-14 with                                  --> That could return null
        // return accountTotals.get(accountName);
// G. Replace line 17 with
        // accountTotals.put(accountName, amount);
// H. Replace line 17 with                                      --> CORRECT
        // accountTotals.put(accountName, amount.intValue());
