package org.sunjane.weekly;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Registration {

	public static void main1(String[] args) {
		// no map to student
		List<Student> students = new ArrayList<Student>();
		List<Long> offices = new ArrayList<Long>();
		Scanner in = new Scanner(System.in);
		String[] conf = in.nextLine().trim().split(" ");
		int N = Integer.parseInt(conf[0]); // number of students
		int M = Integer.parseInt(conf[1]); // number of offices
		int K = Integer.parseInt(conf[2]); // k time units to move outside
		for (int i = 0; i < N; i++) {
			Student student = new Student(in.nextLine().trim());
			students.add(student);
		}
		// init current office time
		for (int i = 0; i < M; i++) {
			offices.add(0L);
		}
		
		
		Queue<Event> events = new PriorityQueue<Event>(N, new Comparator<Event>() {
				public int compare(Event a, Event b) {
					if (a.time < b.time) {
						return -1; 
					} else if (a.time == b.time && a.no < b.no) {
						return -1;
					} else {
						return 1;
					}
				}

		});
		for (int i = 0; i < N; i++) {
				Student student = students.get(i);
				student.index++;
				Event event = new Event(i, student.time + K, 
						student.offices.get(student.index));
				events.add(event);
//				insertEvent(events, event);
//				student.offices.set()
			
		}
		
		while (!events.isEmpty()) {
			Event event = events.poll();
			Student student = students.get(event.no);
			Long startServiceTime = Math.max(event.time, offices.get(event.office));
			Long endServiceTime = startServiceTime + student.spendTime.get(student.index);
			offices.set(event.office, endServiceTime);
			Long nextOfficeTime = endServiceTime + K;
//			student.time = K + event.time
			student.index++;
			if (student.index == student.total) {
				student.time = endServiceTime;
			} else {
				Event e = new Event(event.no, nextOfficeTime, student.offices.get(student.index));
				events.add(e);
//				insertEvent(events, e);
			}
		}
		for (Student student : students) {
			System.out.println(student.time);
		}
		
	}
	

	private static void insertEvent(List<Event> events, Event event) {
		int len = events.size();
		int index = 0;
		for (int i = len - 1; i >= 0; i--) {
			Event e = events.get(i);
			if (e.time < event.time) {
				index = i + 1; 
				break;
			} else if (e.time == event.time && e.no < event.no) {
				index = i + 1;
				break;
			}
		}
		events.add(index, event);
	}
	
	
}
//here event means inserting into queue 
	class Event {
		long time;
		int no;
		int office; // indicate in which office
		Event(int no, long time, int office) {
			this.time = time;
			this.no = no;
			this.office = office;
		}
		
	}
	
	class Student {
		String no;
		long time;
		ArrayList<Integer> offices;
		ArrayList<Integer> spendTime;
		int index; // current in which office in order 
		int total; // total number of offices to visit
		
		Student(String in) {
			String[] str = in.split(" ");
			no = str[0];
			time = Long.parseLong(str[1]);
			index = -1;
			total = Integer.parseInt(str[2]);
			offices = new ArrayList<Integer>();
			spendTime = new ArrayList<Integer>();
			for (int i = 0; i < total; i++) {
				offices.add(Integer.parseInt(str[3 + 2 * i]) - 1);
				spendTime.add(Integer.parseInt(str[4 + 2 * i]));
			}
		}
	}

