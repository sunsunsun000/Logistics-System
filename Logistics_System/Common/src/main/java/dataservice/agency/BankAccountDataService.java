/**
 * 2015年10月23日
 *author:
 *description:
 */
package dataservice.agency;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.BankAccountPO;

/**
 * @author 谭期友
 *
 */
public interface BankAccountDataService extends Remote{
	
	public static final String NAME="bankAccountDataService";
	/**
	 * 添加账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 账户
	 */
	public boolean add(BankAccountPO countpo)throws RemoteException;
	/**
	 * 删除账户
	 * @param name
	 * @return 操作是否成功
	 */
	public boolean delete(String name)throws RemoteException;
	/**
	 * 更新账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 操作是否成功
	 */
	public boolean updata(BankAccountPO countpo)throws RemoteException;
	/**
	 * 查询账户
	 * @param name
	 * @return 账户
	 */
	public BankAccountPO find(String keyword)throws RemoteException;
	
	/**
	 * 显示所有账户信息
	 * @return
	 */
	public ArrayList<BankAccountPO> showAll()throws RemoteException;
}