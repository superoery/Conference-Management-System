/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.enums;

/**
 * @author Mity1299
 * 用于身份表
 */
public enum EnumIdentity {

    //普通学生
    STUDENT(1,"普通学生"),
    //班委
    COMMITTEE(2,"班委"),
    //教师
    TEACHER(3,"教师"),
    //助教
    ASSISTANT(4,"助教"),
    //管理员
    ADMIN(5,"管理员");
    
    private final String description;
    private final int value;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    EnumIdentity(int value,String description) {
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
