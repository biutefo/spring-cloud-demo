package com.best.microservice.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.best.microservice.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

	private static List<Person> personList = new LinkedList<>();

	@GetMapping("list")
	public ResponseEntity<List<Person>> getPersonList() {
		return ResponseEntity.ok(personList);
	}

	/**
	 * 新增person并返回最后一个person
	 */
	@PostMapping()
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		if (person != null) {
			personList.add(person);
		}
		return ResponseEntity
				.ok((personList.size() - 1) >= 0 ? personList.get(personList.size() - 1) : null);
	}

	/**
	 * 根据index查询用户
	 */
	@GetMapping("{index}")
	public ResponseEntity<Person> readPerson(@PathVariable Integer index) {
		if (!indexIsOk(index)) {
			//路径输入的index不合法
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.ok(personList.get(index));
	}

	/**
	 * 根据index确定要修改的用户，根据请求体内的参数修改person
	 * 返回被修改的用户的信息
	 */
	@PutMapping("{index}")
	public ResponseEntity<Person> updatePerson(@PathVariable Integer index,
			@RequestBody Person person) {
		if (!indexIsOk(index)) {
			//路径输入的index不合法
			return ResponseEntity.ok(null);
		}
		personList.set(index, person);
		return ResponseEntity.ok(person);
	}

	/**
	 * 根据index删除person
	 * 返回被删除的用户的信息
	 */
	@DeleteMapping("{index}")
	public ResponseEntity<Person> deletePerson(@PathVariable Integer index) {
		if (index==null||!indexIsOk(index)) {
			//路径输入的index不合法
			return ResponseEntity.ok(null);
		}
		/*
		只有int类型才会删除制定下标的元素，Integer不行。
		原因：
		int类型的参数java会把参数作为下标处理 返回值为删除的元素
		Integer类型的参数java会把参数作为元素处理 返回值为是否成功删除元素
		Person person = personList.get(index);
		boolean remove = personList.remove(index);
		*/
		return ResponseEntity.ok(personList.remove(index.intValue()));
	}

	public boolean indexIsOk(int index) {
		return index >= 0 && index < personList.size();
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		//System.out.println(list.get(-2));
		Person person = new Person();
		person.setMame("xin");
		person.setAge(22);
		String string = JSON.toJSONString(person);
		System.out.println(string);
	}
}
