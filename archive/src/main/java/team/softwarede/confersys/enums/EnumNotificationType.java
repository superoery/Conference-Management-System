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

    MEETING("新会议"),
    LEAVE("请假结果"),
    REPAIR("报修"),
    AUIDIT("审核结果");

    private final String description;

    EnumNotificationType(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
    
    public static EnumNotificationType valueOfDescription(String description) {
        EnumNotificationType enumNoteType = null;
        
        switch(description) {
            case "新会议":{
                enumNoteType = MEETING;
            }break;
            case "请假结果":{
                enumNoteType = LEAVE;
            }break;
            case "报修":{
                enumNoteType = REPAIR;
            }break;
            case "审核结果":{
                enumNoteType = AUIDIT;
            }break;
            default :{
                
            }break;
            
        }
        return enumNoteType;
    }
    
    
}
