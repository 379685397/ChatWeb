package com.chatweb.comm;/**
 * 方法描述
 * <p></p>
 *
 * @author wzq 2023/3/7 14:13
 */

/**
 * <p></p>
 *
 * @author wzq 2023/3/7 14:13
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2023/3/7
 * @modify by reason:{方法名}:{原因}
 */
public class PathConstant {
    public static class MODEL {
        public static String MODEL_LIST = "/v1/models";
    }

    public static class COMPLETIONS {
        public static String CREATE_COMPLETION = "/v1/completions";
        public static String CREATE_CHAT_COMPLETION = "/v1/chat/completions";
        public static String CREATE_COMPLETION_id = "/v1/engines/{engine_id}/completions";
    }

    public static class IMAGES {
        public static String createImage = "/v1/images/generations";
        public static String createImageEdit = "/v1/images/edits";
        public static String createImageVariation = "/v1/images/variations";
    }
} 