/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Mity1299
 *
 */
public class UserLogin {
    
    @NotBlank
    @Min(value = 0,message = "用户编号错误")
    private String userId;

    @NotNull
    @Min(value = 0,message = "用户身份错误")
    private Integer identityId;


    @NotNull(message = "密码为空")
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
