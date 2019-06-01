/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 * 用于通知表、与会人员关系表
 */
public enum EnumNotificationStatus {
    
    UNREAD("未读"),//审核中
    READ("已读");//通过审核
    

    private final String description;

    EnumNotificationStatus(String description) {
        this.description = description;
        
    }

  
    public String getDescription() {
        return description;
    }

}
