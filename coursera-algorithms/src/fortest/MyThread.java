package fortest;

public  class MyThread implements Runnable {

	/**
	 * @param args
	 */
	private int a=20000;
	
	public void run(){
		while(a>0)
		{
			System.out.println(a--);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread nc=new MyThread();
		MyThread nb=new MyThread();
		MyThread na=new MyThread();
		new Thread(nc).start();
		new Thread(nb).start();
		new Thread(na).start();
		
	}

}
