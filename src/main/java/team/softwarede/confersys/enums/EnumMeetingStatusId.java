/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 *  用于会议表，会议审核状态
 */
public enum EnumMeetingStatusId {
    
    FAILED("审核未通过"),
    AUDITING("正在审核"),
    READY("审核通过未开始"),
    PROGREEING("正在进行"),
    END("已结束");

    private final String description;

    EnumMeetingStatusId(String description) {
        this.description = description;
        
    }

  
    public String getDescription() {
        return description;
    }
}
