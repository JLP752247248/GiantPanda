package service;
import com.panda.base.util.MyLogUtil;
import com.panda.sys.UserInfoService;
import com.panda.sys.po.UserInfo;

public class AddUserThread  implements Runnable{
		UserInfoService userServ; 
		String methodName;
		AddUserThread(UserInfoService us){
			this.userServ=us;
		}
		@Override
		public void run() {
			UserInfo user=new UserInfo(5,"9091");
			MyLogUtil.writeToFile("controller");
			userServ.saveNewUser(user);
		}
		
	}