package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.SubscribeVO;

public interface SubscribeService {
	int countList();
	List<SubscribeVO> getSubscribeList(HashMap map);
}
