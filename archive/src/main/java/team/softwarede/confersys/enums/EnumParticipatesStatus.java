/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 *
 */
public enum EnumParticipatesStatus {
  
    LEAVE("请假"),
    ATTEND("出席");

    private final String description;

    EnumParticipatesStatus(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
}
