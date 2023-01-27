import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//每一局之前的启动
class preGamePreparation {
	//投掷元素骰子
	List<String> setElementDice() {
		List<String> eightelementdice = new ArrayList<>(Arrays.asList("风","岩","雷","草","水","火","冰","万能"));
		List<String> myelementdiceList = new ArrayList<>();
		Random rand = new Random();
		int loopnum = 0;
		//8遍循环
		while (loopnum <= 7) {
			loopnum += 1;
			int num = rand.nextInt(8);
			myelementdiceList.add(eightelementdice.get(num));
		}
		return myelementdiceList; //返回骰子列表
	}
	//重投
	List<String> reset(List<String> mydice) {
		//得到修改的索引数
		Scanner reader = new Scanner(System.in);
		String number = reader.nextLine();
		//一大堆列表和计数
		List<String> resetdice = new ArrayList<>(Arrays.asList(number.split(" "))); //重投索引序列号
	    List<String> eightelementdice = new ArrayList<>(Arrays.asList("风","岩","雷","草","水","火","冰","万能")); //固定元素表
	    int resetnumber = resetdice.size();
	    int reloopnum = 0;
	    Random rerand = new Random();
	    //有多少要重投就来几遍
	    while (reloopnum < resetnumber) {
	    	int rerandnum = rerand.nextInt(8);
	    	String rethrowString = eightelementdice.get(rerandnum);
	    	int reindex = Integer.parseInt(resetdice.get(reloopnum));
	    	mydice.set((reindex-1), rethrowString);
	    	reloopnum += 1;
	    }
		return mydice;//返回的是重投之后的完整骰子列表
	}
}


//玩家数据封装到类中存储（只是尝试）
class player01 {
	List<String> player01elementdiceList = new ArrayList<String>();//元素骰子
	List<String> player01RoleListList = new ArrayList<String>(Arrays.asList("凯亚","砂糖","菲谢尔"));//角色
	List<Integer> player01RoleHPList = new ArrayList<>(Arrays.asList(10, 10, 10));//角色初始血条
	int player01MainRoleString = 0;//出场角色编码
	Boolean player01ActionStatus;//行动状态
	static class kaiya {//仅仅收录普通攻击，其他回去做
		int fightnum = 2;
		List<String> diceList = new ArrayList<>(Arrays.asList("冰","随意","随意"));}
	static class shatang {
		int fightnum = 2;//这里是会挂风哒:<
		List<String> diceList = new ArrayList<>(Arrays.asList("风","随意","随意"));}
	static class feixieer {
		int fightnum = 2;
		List<String> diceList = new ArrayList<>(Arrays.asList("雷","随意","随意"));}
}
class player02 {
	List<String> player02elementdiceList = new ArrayList<>();
	List<String> player02RoleListList = new ArrayList<>(Arrays.asList("凯亚","砂糖","菲谢尔"));
	List<Integer> player01RoleHPList = new ArrayList<>(Arrays.asList(10, 10, 10));
	int player02MainRoleString = 0;
	Boolean player02ActionStatus;
	static class kaiya {
		int fightnum = 2;
		List<String> diceList = new ArrayList<>(Arrays.asList("冰","随意","随意"));}
	static class shatang {
		int fightnum = 2;
		List<String> diceList = new ArrayList<>(Arrays.asList("风","随意","随意"));}
	static class feixieer {
		int fightnum = 2;
		List<String> diceList = new ArrayList<>(Arrays.asList("雷","随意","随意"));}
}


//游戏阶段
class gameTime {
	//选择出场角色
	int chooseMainRole() {
		Scanner readerScanner2 = new Scanner(System.in);
		int rolenumber = Integer.parseInt(readerScanner2.nextLine());
		return (rolenumber-1);//返回值为整形、列表索引
	}
	
	//选择出场先后顺序
	void chooseActionStatues() {
		Random rerand = new Random();
		int actrandnum = rerand.nextInt(2);
		player01 p1 = new player01();
		player02 p2 = new player02();
		if (actrandnum == 1) {
			p1.player01ActionStatus = true;
			p2.player02ActionStatus = false;
			//System.out.println("1");
		}
		else if (actrandnum == 0) {
			p1.player01ActionStatus = false;
			p2.player02ActionStatus = true;
			//System.out.println("2");
		}
	}
	
	//瞎编攻击方法。攻击的本质：消耗元素骰子减生命值
	void fightTime(List<String> player01dice, List<String> player02dice) {
		player01 p1 = new player01();
		player02 p2 = new player02();
		//行动轮判断
		if (p1.player01ActionStatus == true) {
			//消耗玩家01的骰子
			System.out.println(player01dice);
			Scanner fightScanner = new Scanner(System.in);
			System.out.println("请玩家1输入消耗骰子");
			String chooseDiceNumber = fightScanner.nextLine();
			List<String> chooceDiceNumberList = new ArrayList<>(Arrays.asList(chooseDiceNumber.split(" ")));
			System.out.println("请玩家1输入技能编号");
			int skillnum = fightScanner.nextInt();
			int num = 0;
			int listlength = chooceDiceNumberList.size();
			//循环吃掉骰子
			while (num <= listlength) {
				int ordinary = Integer.parseInt(chooceDiceNumberList.get(num))-1-num;//索引只是试验
				chooceDiceNumberList.remove(ordinary);
				num += 1; //计数器改变
				System.out.println(chooseDiceNumber);
			if (skillnum == 1) {}
			else if (skillnum == 2) {}
			else {}
			}
		}
	}
}

public class main {
	
	public static void main(String[] args) {
		//创建开始测试类，测试方法(经过测试没有问题)
		//preGamePreparation ceshi = new preGamePreparation();
		//List<String> ceshi01 = ceshi.setElementDice();
		//System.out.println(ceshi01);
		//List<String> ceshi02 = ceshi.reset(ceshi01);
		//System.out.println(ceshi02);
		//创建游戏测试类
		//gameTime ceshi10 = new gameTime();
		//ceshi10.chooseMainRole();
		//System.out.println(ceshi10.chooseMainRole());
		//ceshi10.chooseActionStatues();
		//player01.kaiya ji = new player01.kaiya();//肯定得寄
		//System.out.println(ji.diceString);
		
		
	}

}
