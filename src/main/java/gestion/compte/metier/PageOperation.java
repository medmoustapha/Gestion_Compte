package gestion.compte.metier;

import java.io.Serializable;
import java.util.List;

import gestion.compte.entities.Operation;

public class PageOperation implements Serializable{
	private List<Operation> operations;
	private int page;
	private int nombreOperation;
	private int totalOperation;
	private int totalPage;
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperation() {
		return nombreOperation;
	}
	public void setNombreOperation(int nombreOperation) {
		this.nombreOperation = nombreOperation;
	}
	public int getTotalOperation() {
		return totalOperation;
	}
	public void setTotalOperation(int totalOperation) {
		this.totalOperation = totalOperation;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	

}
