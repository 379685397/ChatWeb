package com.chatweb.model.moderation;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * An object containing the flags for each moderation category
 * <p>
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
@Data
public class ModerationCategories {

    public boolean hate;

    @JSONField(name = "hate/threatening")
    public boolean hateThreatening;

    @JSONField(name = "self-harm")
    public boolean selfHarm;

    public boolean sexual;

    @JSONField(name = "sexual/minors")
    public boolean sexualMinors;

    public boolean violence;

    @JSONField(name = "violence/graphic")
    public boolean violenceGraphic;
}
