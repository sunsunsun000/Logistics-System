package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.agency.BankAccountPO;
import dataservice.agency.BankAccountDataService;

public class BankAccountDataImpl  extends UnicastRemoteObject implements BankAccountDataService,Serializable {

	public BankAccountDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(BankAccountPO countpo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(BankAccountPO countpo) {
		// TODO Auto-generated method stub
		return false;
	}

	public BankAccountPO find(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<BankAccountPO> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

}