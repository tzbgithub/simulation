package cn.edu.tju.simulation.handler;

import java.util.List;

import cn.edu.tju.simulation.controller.Controller;
import cn.edu.tju.simulation.user.MobilityModel;
import cn.edu.tju.simulation.wirelessnetwork.SameTypeWirelessNetwork;

/**
 * 
 * @author Wenkai Li ,School of Computer Science and Technology ,Tianjin University 
 *
 */
public class Pretreatment {
	
	public static void process(){
		Controller controller = Controller.getInstance();
		
		//����������жȲ���
		SameTypeWirelessNetwork BSs = controller.getWirelessNetworkGroup().BS;
		for(int i = 0 ;i<BSs.getAmount();i++){
			BSs.getNetwork(i).fluctuatePopularity();;
		}
		
		//�û��������жȲ���
		List<MobilityModel> users = controller.getUsers().getSimpleUsers();
		for(int j = 0 ;j<users.size();j++){
			users.get(j).fluctuatePopularity();
		}

		//���ɶ���
		controller.getStateQueue().generateStateQueue();
	}
}
