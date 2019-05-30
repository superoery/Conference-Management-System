/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 *用于会议室表
 */
public enum EnumMeetingRoomStatusId {

    FREE("空闲"),//空闲
    USING("使用中"),//使用中
    REPARING("维修中");//维修中
    
    private final String description;

    EnumMeetingRoomStatusId(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
}
