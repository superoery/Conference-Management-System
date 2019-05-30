/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 *
 */
public enum EnumRoleName {
    //会议组织者
    ORGANIZER(1,"会议组织者"),
    //管理员
    ADMIN(2,"管理员"),
    //普通用户
    NORMAL(3,"普通用户");
    
    private final int value;
    private final String description;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    EnumRoleName(int value,String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }
    

}
