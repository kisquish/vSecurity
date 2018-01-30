package org.ptc.webapp.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.ptc.webapp.dto.Operation;
import org.ptc.webapp.service.FinanceOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinanceOperationsImp implements FinanceOperations {

	FinanceOperations financeOpsService;

	public FinanceOperationsImp() {
		// For Spring
	}

	public FinanceOperationsImp(FinanceOperations financeOperations) {
		setFinanceOperations(financeOperations);
	}

	@Autowired
	public void setFinanceOperations(FinanceOperations financeOperations) {
		this.financeOpsService = financeOperations;
	}

	@Override
	public List<Operation> findAllOfOperations() {

		List<Operation> allListOperations = new ArrayList<>();
		Path path = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		try {
			path = Paths.get(System.getenv("FINANCE"), "Read-Only-PTC.finance");
			
			Stream<String> lines = Files.lines(path);
			lines.forEach(line -> {
				Operation op = new Operation();
				String[] entries = line.split(";");
				op.setName(entries[1]);
				try {
					op.setDate(formatter.parse(entries[4]));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				op.setDescription(entries[3]);
				op.setAmount(Double.parseDouble(entries[2]));

				allListOperations.add(op);
			});
			lines.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allListOperations;
	}
}
