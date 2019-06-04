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

//    @NotBlank // 对于Integer，NotBlank无效，NotNull有效
    @NotNull
    @Min(value = 0,message = "用户身份错误")
    private Integer ideId;

//    @NotNull(message = "密码为空") // 对于String，NotNull无效，NotBlank有效
    @NotBlank(message = "密码为空")
    private String password;


    public Integer getIdeId() {
        return ideId;
    }

    public void setIdeId(Integer ideId) {
        this.ideId = ideId;
    }

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
    
    
    

}
