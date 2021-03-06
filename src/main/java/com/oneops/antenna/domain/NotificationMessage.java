/*******************************************************************************
 *  
 *   Copyright 2015 Walmart, Inc.
 *  
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  
 *******************************************************************************/
package com.oneops.antenna.domain;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.oneops.util.URLUtil;

public class NotificationMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private long cmsId;
    private String cloudName;
    private NotificationSeverity severity;
    private NotificationType type;
    private String source;
    private String subject;
    private String templateName;
    private String templateParams;
    private String text;
    private String nsPath;
    private Map<String, String> payload = new HashMap<String, String>();
    private long timestamp;
    private String environmentProfileName;
    private String adminStatus;
    private long manifestCiId;

    public Map<String, String> getPayload() {
        return payload;
    }

	public void putPayloadEntry(String name, String value) {
        this.payload.put(name, value);
    }

	public void putPayloadEntries(Map<String, String> payloadEntries) {
		this.payload.putAll(payloadEntries);
	}

    public String getNsPath() {
        return nsPath;
    }

    public void setNsPath(String nsPath) {
        this.nsPath = nsPath;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getCmsId() {
        return cmsId;
    }

    public void setCmsId(long cmsId) {
        this.cmsId = cmsId;
    }

    public NotificationSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(NotificationSeverity severity) {
        this.severity = severity;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateParams() {
        return templateParams;
    }

    public void setTemplateParams(String templateParams) {
        this.templateParams = templateParams;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEnvironmentProfileName() {
		return environmentProfileName;
	}

	public void setEnvironmentProfileName(String envProfile) {
		this.environmentProfileName = envProfile;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public long getManifestCiId() {
		return manifestCiId;
	}

	public void setManifestCiId(long manifestCiId) {
		this.manifestCiId = manifestCiId;
	}
	
	public String getCloudName() {
		return cloudName;
	}

	public void setCloudName(String cloudName) {
		this.cloudName = cloudName;
	}

	public void appendText(String notes) {
		StringBuilder sb = new StringBuilder();
		sb.append(text).append(notes);
		this.text = sb.toString();
	}

	/**
     * Get OneOps web url for this NotificationMessage.
     *
     * @return URL of relevant page inside OneOps web. Returns
     * null if the link can not be assembled due to unexpected
     * info in the field nsPath or fields
     */
    public URL getNotificationUrl() {
        return URLUtil.getNotificationUrl(this);
    }

    /**
     * Returns string representation od notification message
     *
     * @return notification message as string.
     */
    public String asString() {
        final StringBuilder sb = new StringBuilder("NotificationMessage{");
        sb.append("cmsId=").append(cmsId);
        sb.append(", severity=").append(severity);
        sb.append(", type=").append(type);
        sb.append(", source='").append(source).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", templateName='").append(templateName).append('\'');
        sb.append(", templateParams='").append(templateParams).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append(", nsPath='").append(nsPath).append('\'');
        sb.append(", payload=").append(payload);
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
}