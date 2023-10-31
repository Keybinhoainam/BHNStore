package B19DCCN445.service;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import B19DCCN445.exception.StorageException;
import B19DCCN445.exception.StoreFileNotFoundException;



public interface StorageService {

	void init() throws StorageException;

	void delete(String storedFilename) throws IOException;

	Path load(String filename);

	Resource loadAsResource(String filename) throws StoreFileNotFoundException;

	void store(MultipartFile file, String storedFilename) throws StorageException;

	String getStoredFilename(MultipartFile file, String id);


}
