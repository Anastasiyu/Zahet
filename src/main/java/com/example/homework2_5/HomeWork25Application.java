package com.example.homework2_5;

import com.example.homework2_5.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class HomeWork25Application {

	public static void main(String[] args) {
		SpringApplication.run(HomeWork25Application.class, args);
		Collection<User> users = new ArrayList<>();
		users.add(new User("Иван Иванов", 45));
		users.add(new User("Сергей Иванов",25));
		users.add(new User("Петр Иванов", 45));
		users.add(new User("Иван Иванов", 55));
		users.add(new User("Петр Иванов", 55));
		users.add(new User("Сергей Иванов",25));

		System.out.println("Список всех пользователей");
		System.out.println(users);
		System.out.println("_________________________________________________________________________________________");

		System.out.println("Сортировка пользователей по возрасту");
		Collections.sort(new ArrayList<>(), AgeComparator);
		System.out.println(users.stream().sorted(AgeComparator).collect(Collectors.toList()));

		System.out.println("_________________________________________________________________________________________");
		System.out.println("Сортировка пользователей по имени");
		Collections.sort(new ArrayList<>(), NameComparator);
		System.out.println(users.stream().sorted(NameComparator).collect(Collectors.toList()));

		System.out.println("_________________________________________________________________________________________");

		System.out.println("Список пользователей без дублей");
		System.out.println(distinct(users));
		System.out.println("_________________________________________________________________________________________");


		System.out.println("Самый старый пользователь");
			Collections.sort(new ArrayList<>(), AgeComparator);
			System.out.println(users.stream().max(AgeComparator));
		}
	//убрать дубликаты сравнение идет по методу equals

	public static Collection<User> distinct(Collection<User> users) {       //убрать дубликаты сравнение идет по методу equals
		return users.stream().distinct().collect(Collectors.toList());


	}
//	компоратор сортирует список объектов по возрасту
	public  static Comparator<User> AgeComparator = new Comparator<User>(){
	@Override
	public int compare(User a1, User a2) {
		return  a1.getAge() - a2.getAge();
	}
};
	//	компоратор сортирует список объектов по имени
	public  static Comparator<User> NameComparator = new Comparator<User>(){
		@Override
		public int compare(User e1, User e2) {
			return  e1.getName().compareTo(e2.getName());
		}
	};

}


