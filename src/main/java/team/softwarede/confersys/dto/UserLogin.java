/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Mity1299
 *
 */
public class UserLogin {
    
//    @Min(value = 1,message = "用户编号错误")  //@Min用于注释数字
	@NotBlank
    @Pattern(regexp = "^\\d{8}$", message = "用户编号由8位数字组成")
    private String userId;

//    @NotBlank // 对于Integer，NotBlank无效，NotNull有效
    @NotNull
    @Min(value = 1,message = "用户身份错误")
    private Integer identityId;


//    @NotNull(message = "密码为空") // 对于String，NotNull无效，NotBlank有效
    @NotBlank(message = "密码不能为空")
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    

    public Integer getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }
    

}
