/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 * 用于通知表，通知类型
 */
public enum EnumNotificationSpType {

    REPAIR("报修"),
    LEAVE("请假"),
    BOOK("预约"),
    ALL("全部");
    

    private final String description;

    EnumNotificationSpType(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
    
    
    
}
