/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 * 用于通知表，通知类型
 */
public enum EnumNotificationType {

    MEETING("新会议信息"),
    LEAVE("请假结果"),
    REPAIR("报修");

    private final String description;

    EnumNotificationType(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
    
    
}
