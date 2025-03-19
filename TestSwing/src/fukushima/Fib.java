package fukushima;

public class Fib implements Runnable {
	public final static int WORKING = -1;
	public final static int STOP = -9999;
	private int ans;
	private int index = 0;
	private boolean stop_flag = false;
	private int stage;
	private ICallback call = null;
	public void stop() {
		stop_flag = true;
	}
	public Fib(int n, ICallback call) {
		index = n;
		this.call = call;
	}
	private int fib(int n, int level) {
		if (n <= 2 || stop_flag) return 1;
		if (level == 3) {
			stage++;
			if (call != null) call.callback(ans, stage);
		}
		return fib(n - 1, level + 1) + fib(n - 2, level + 1);
	}
	@Override
	public void run() {
		ans = WORKING;
		stop_flag = false;
		ans = fib(index, 0);
		if (stop_flag) ans = STOP;
		if (call != null) call.callback(ans, stage);
	}
}
