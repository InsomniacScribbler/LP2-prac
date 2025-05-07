package AI;
import java.util.*;

class Process{
	int pid, bt;

	public Process(int pid, int bt) {
		this.pid = pid;
		this.bt = bt;
	}
}

public class jobScheduling {
	public static void main(String[] args) {
		Process[] processes = {
				new Process(1, 6),
				new Process(2, 8),
				new Process(3, 7),
				new Process(4, 3)
		};

		Arrays.sort(processes,Comparator.comparingInt(p-> p.bt));

		int n = processes.length;
		int[] waiting_time = new int[n];
		int[] tat = new int[n];
		waiting_time[0] = 0;

		for(int x = 1; x<n;x++){
			waiting_time[x] = processes[x-1].bt + waiting_time[x-1];
		}

		for (int i = 0; i < n; i++) {
			tat[i] = processes[i].bt + waiting_time[i];
		}
		System.out.println("PID\t\tBurst Time\t\tWaiting Time\tTurnaround Time");
		int totalWT = 0, totalTAT = 0;
		for (int i = 0; i < n; i++) {
			System.out.println(processes[i].pid + "\t\t\t" +
					processes[i].bt + "\t\t\t\t" +
					waiting_time[i] + "\t\t\t\t" +
					tat[i]);
			totalWT += waiting_time[i];
			totalTAT += tat[i];
		}

		System.out.printf("Average Waiting Time: %.2f\n", (float) totalWT / n);
		System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTAT / n);
	}
	}

