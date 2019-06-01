/**
* 
* @author Mity1299
*/
package team.softwarede.confersys.mapper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import team.softwarede.confersys.Application;
import team.softwarede.confersys.entity.Identity;
import team.softwarede.confersys.enums.EnumIdentity;
import team.softwarede.confersys.enums.EnumRoleName;

/**
 * @author Mity1299
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class IdentityMapperTest {

    @Autowired
    IdentityMapper identityMapper; 
    
    @Test
    public void initIdentity() {
        
        Identity IStudent = new Identity();
        
        Identity IAssistant = new Identity();
        Identity ICommittee = new Identity();
        Identity ITeacher = new Identity();
        
        Identity IAdmin = new Identity();
        
        IStudent.setId(EnumIdentity.STUDENT.getValue());
        IStudent.setIdentity(EnumIdentity.STUDENT.getDescription());
        IStudent.setRoleId(EnumRoleName.NORMAL.getValue());
        
        IAssistant.setId(EnumIdentity.ASSISTANT.getValue());
        IAssistant.setIdentity(EnumIdentity.ASSISTANT.getDescription());
        IAssistant.setRoleId(EnumRoleName.ORGANIZER.getValue());
        ICommittee.setId(EnumIdentity.COMMITTEE.getValue());
        ICommittee.setIdentity(EnumIdentity.COMMITTEE.getDescription());
        ICommittee.setRoleId(EnumRoleName.ORGANIZER.getValue());
        ITeacher.setId(EnumIdentity.TEACHER.getValue());
        ITeacher.setIdentity(EnumIdentity.TEACHER.getDescription());
        ITeacher.setRoleId(EnumRoleName.ORGANIZER.getValue());
        
        IAdmin.setId(EnumIdentity.ADMIN.getValue());
        IAdmin.setIdentity(EnumIdentity.ADMIN.getDescription());
        IAdmin.setRoleId(EnumRoleName.ADMIN.getValue());

        identityMapper.insert(IStudent);
        identityMapper.insert(IAssistant);
        identityMapper.insert(ICommittee);
        identityMapper.insert(ITeacher);
        identityMapper.insert(IAdmin);
        
        
    }

}
