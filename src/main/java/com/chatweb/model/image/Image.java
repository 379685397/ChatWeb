package com.chatweb.model.image;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * An object containing either a URL or a base 64 encoded image.
 * <p>
 * https://beta.openai.com/docs/api-reference/images
 */
@Data
public class Image {
    /**
     * The URL where the image can be accessed.
     */
    String url;


    /**
     * Base64 encoded image string.
     */
    @JSONField(name = "b64_json")
    String b64Json;
}
