
package beans.member;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Prefs {

    private Boolean colorBlind;
    private String locale;
    private long minutesBeforeDeadlineToNotify;
    private long minutesBetweenSummaries;
    private Privacy privacy;
    private Boolean sendSummaries;

}
