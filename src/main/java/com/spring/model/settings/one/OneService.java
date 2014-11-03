package com.spring.model.settings.one;

import org.springframework.stereotype.Service;

import com.spring.config.generic.service.settingsService;

@Service
public class OneService extends settingsService<One> {

	public OneService() {
		super(One.class);
	}

}
