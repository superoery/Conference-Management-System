/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 *
 */
public enum EnumUserAndGroup {
    USER("用户"),
    UGROUP("用户组");
    
    private final String description;

    EnumUserAndGroup(String description) {
        this.description = description;
        
    }

  
    public String getDescription() {
        return description;
    }
}
