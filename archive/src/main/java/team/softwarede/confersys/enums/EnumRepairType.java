/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 * 用于报修表，报修类型
 */
public enum EnumRepairType {

    REPAIRMENT("维修"),
    SUPPLEMENT("补充");

    private final String description;

    EnumRepairType(String description) {
        this.description = description;
        
    }

    public String getDescription() {
        return description;
    }
}
