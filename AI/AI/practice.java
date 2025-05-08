package AI;
import java.util.*;
 class Processs{
	int pid, bt;
	Processs(int pid,int bt){
		this.pid = pid;
		this.bt= bt;
	}
}
public class practice{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int np = sc.nextInt();

		Processs[] processes = new Processs[np];

		for (int i = 0; i < np; i++) {
			int pid = sc.nextInt();
			int bt = sc.nextInt();

			processes[i] = new Processs(pid,bt);

		}

		Arrays.sort(processes,Comparator.comparingInt(p->p.bt));

		int[] wt = new int[np];
		int[] tat = new int[np];

		for(int i = 1 ; i < np ; i++){
			wt[i] = wt[i-1]+ processes[i-1].bt;
		}
		for(int i = 0; i<np; i++){
			tat[i] = processes[i].bt+ wt[i];
		}

	}


}


