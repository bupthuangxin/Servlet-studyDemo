package com.hsp.model;

public class SendEmailThread extends Thread{
	public void run(){
		int i=0;
		try {
			while(true){
				Thread.sleep(5*1000);
				System.out.println("发出第"+(++i)+"封邮件");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
