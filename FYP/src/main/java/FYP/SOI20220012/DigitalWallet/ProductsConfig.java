/**
 * 
 * I declare that this code was written by me, 20032049. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Cheng Xin Lin
 * Student ID: 20032049
 * Class: C372-4D-E62F-A
 * Date created: 2021-Nov-26 8:17:13 pm 
 * 
 */
package FYP.SOI20220012.DigitalWallet;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 20032049
 *
 */
@Configuration
public class ProductsConfig implements WebMvcConfigurer {
	// add resource handler helps to configure the upload path as a resource path
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		String dirName = "uploads/";

		Path uploadDir = Paths.get(dirName);
		String uploadPath = uploadDir.toFile().getAbsolutePath();

		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");

	}
}
