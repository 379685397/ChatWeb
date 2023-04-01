package com.chatweb.model.moderation;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * An object containing the scores for each moderation category
 * <p>
 * https://beta.openai.com/docs/api-reference/moderations/create
 */
@Data
public class ModerationCategoryScores {

    public double hate;

    @JSONField(name = "hate/threatening")
    public double hateThreatening;

    @JSONField(name = "hate/threatening")
    public double selfHarm;

    public double sexual;

    @JSONField(name = "hate/threatening")
    public double sexualMinors;

    public double violence;

    @JSONField(name = "violence/graphic")
    public double violenceGraphic;
}
