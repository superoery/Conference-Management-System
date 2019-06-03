/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 *  用于会议表和会议申请表
 */
public enum EnumApplyStatusId {
    EXAMING("审核中"),//审核中
    SUCCEED("通过审核"),//通过审核
    FAILED("未通过审核"); //未通过审核
	

    private final String description;

    EnumApplyStatusId(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
}
