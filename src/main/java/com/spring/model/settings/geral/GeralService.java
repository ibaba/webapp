package com.spring.model.settings.geral;

import org.springframework.stereotype.Service;

import com.spring.config.generic.service.settingsService;

@Service
public class GeralService extends settingsService<Geral> {

	public GeralService() {
		super(Geral.class);
	}

}
