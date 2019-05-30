/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 *
 */
public enum EnumSex {
    
    MALE("男"),
    FEMALE("女");

    private final String description;

    EnumSex(String description) {
        this.description = description;
        
    }

  
    public String getDescription() {
        return description;
    }
}
