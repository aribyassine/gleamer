package com.example.gleamer

import com.example.gleamer.storage.StorageService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@CrossOrigin
@RequestMapping("/images")
class ImageController(val storageService: StorageService) {
    @PostMapping(produces = [MediaType.IMAGE_PNG_VALUE])
    fun hello(@RequestParam("image") image: MultipartFile): ByteArray {
        storageService.store(image)
        //image.
        return image.bytes;
    }
}