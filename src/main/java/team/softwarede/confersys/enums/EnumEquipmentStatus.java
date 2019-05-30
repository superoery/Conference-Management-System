/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 * 用于设备表
 */
public enum EnumEquipmentStatus {

    AVAILABLE("可用"),
    REPAIRING("维护中"),
    LACK("缺乏");

    private final String description;

    EnumEquipmentStatus(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
}
