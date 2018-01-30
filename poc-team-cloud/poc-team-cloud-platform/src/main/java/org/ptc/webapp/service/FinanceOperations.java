package org.ptc.webapp.service;

import java.util.List;
import org.ptc.webapp.dto.Operation;

public interface FinanceOperations {

	List<Operation> findAllOfOperations();
}
