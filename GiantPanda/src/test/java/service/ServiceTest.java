package service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.panda.sys.UserInfoService;
import com.panda.sys.po.UserInfo;
import com.panda.sys.po.UserRole;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-hibernate.xml"})
public class ServiceTest {
	@Resource UserInfoService userServ;
	@Test
	public void manyToOneAdd(){
		
		UserInfo user=new UserInfo("u1","9091");
		//userServ.saveNewUser(user);
		UserRole userrole=new UserRole("ur6",user,"678");
		userServ.saveUserRole(userrole);
		//这时候执行的是merge方法，而且userrole的userinfo配的也是merge级联，所以userinfo会级联，如果存在u1，会update一下userrole，如果不存在u1，会先insert一下userinfo，再updateuserrole
		//注意：如果此时ur6存在，但是user为一个不存在的u9，那么u9是脏数据，会抛出异常
		//userServ.deleteUserRole(userrole);
	}
	
	@Test
	public void oneToManyAdd(){
		UserInfo user=new UserInfo("u3","9090");
		UserRole userrole1=new UserRole("ur1",user,"123");
		UserRole userrole2=new UserRole("ur2",user,"123");
		UserRole userrole3=new UserRole("ur3",user,"123");
		user.getUserRoleList().add(userrole1);
		user.getUserRoleList().add(userrole2);
		user.getUserRoleList().add(userrole3);
		userServ.saveNewUser(user);
		//会先查询三个UserRole，如果不存在则insert，如果存在就看是否要更新，要就update
		//看来@OneToMay和@ManyToOne都级联，只要设置caccade就行，这里前提是主键都已经分配好，不知道uuid
		
	}
}
