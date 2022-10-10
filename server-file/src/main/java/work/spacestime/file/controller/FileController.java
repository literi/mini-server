package work.spacestime.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import work.spacestime.core.http.HttpResult;
import work.spacestime.core.page.PageRequest;
import work.spacestime.file.model.SysFile;
import work.spacestime.file.service.FileService;



@RestController
//@RequestMapping("file")
public class FileController {
	
	   @Value("${files.upload.path}")
	    private String fileUploadPath;

	@Autowired
	private FileService FileService;
	
	
	
	@PostMapping(value="/save",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public HttpResult insert(@RequestPart("file") MultipartFile file,@RequestPart("json") SysFile sysFile) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        File uploadParentFile = new File(fileUploadPath);
        if(!uploadParentFile.exists()) {
            uploadParentFile.mkdirs();
        }
        String uuid = UUID.randomUUID().toString();
        File uploadFile = new File(fileUploadPath + uuid + suffix);
        file.transferTo(uploadFile);
        sysFile.setFilePath(uploadFile.getPath());
        sysFile.setUrl("http://127.0.0.1:18080/static/"+ uuid + suffix);
        sysFile.setType(suffix);
		return HttpResult.ok(FileService.insert(sysFile));
	}
	
	
	@PostMapping(value="/update")
	public HttpResult update(@RequestBody SysFile record) {
		return HttpResult.ok(FileService.updateByPrimaryKey(record));
	}

	@GetMapping(value="/delete")
	public HttpResult delete(@RequestParam(value="id", required=true)Long id) {
		return HttpResult.ok(FileService.deleteByPrimaryKey(id));
	}

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
//		return HttpResult.ok(FileService.findPage(pageRequest));

		return null;
	}
	
	
}