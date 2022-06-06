package com.glushkovdenis.spring5recipeapp.service;

import com.glushkovdenis.spring5recipeapp.commands.UnitOfMeasureCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
