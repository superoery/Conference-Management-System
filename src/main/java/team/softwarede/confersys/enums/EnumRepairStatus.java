/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 * 用于设备报修表，报修状态
 */
public enum EnumRepairStatus {

    UNTREATED("未处理"),
    TREATED("已处理");

    private final String description;

    EnumRepairStatus(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }

    
    
}
