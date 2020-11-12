package com.walgreens.goforwardestimateapp.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.DecoderException;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.walgreens.goforwardestimateapp.exporter.FeaturesExcelFileExporter;
import com.walgreens.goforwardestimateapp.models.ProjectDetails;
import com.walgreens.goforwardestimateapp.repository.IProjectsRepository;
import com.walgreens.goforwardestimateapp.vo.Features;
import com.walgreens.goforwardestimateapp.vo.ProjectDetailsVO;

@Controller
public class DownloadController {
	@Autowired
	private IProjectsRepository iProjectsRepository;

	@GetMapping("/download")
	public void downloadExcelFile(@Param("featureList1")ProjectDetailsVO projectDetailsVo, HttpServletResponse response) throws IOException, DecoderException {
		
		ProjectDetails projectDetails = iProjectsRepository.findById((long)3).get();
		
		System.out.println("********Controller download*******\n");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=EstimationSheet.xlsx");
		ByteArrayInputStream inputStream = FeaturesExcelFileExporter.exportFeaturesToExcel(projectDetails);
		IOUtils.copy(inputStream, response.getOutputStream());
		
		
	}
	 
	
}
