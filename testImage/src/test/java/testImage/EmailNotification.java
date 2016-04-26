package testImage;


import java.util.List;


public class EmailNotification 
{
	private List<String> toAddresses;
	private List<String> ccAddresses;
	private List<String> bccAddresses;
	private String fromAddress;
	private String subject;
	private String body;
	private BodyType bodyType;
	private List<EmailAttachment> attachments;
	private Priority priority;
	
	public EmailNotification(){}
	
	/**
	 * @param toAddresses List of recipient(s) email address
	 * @param fromAddress The address that will show as the sender of this message
	 * @param subject The subject line of the email
	 * @param body The body of the email in plain text or html
	 * @param bodyType BodyType Enum to represent plain text or html.
	 */
	public EmailNotification(List<String> toAddresses, String fromAddress,
			String subject, String body, BodyType bodyType) 
	{
		super();
		this.toAddresses = toAddresses;
		this.fromAddress = fromAddress;
		this.subject = subject;
		this.body = body;
		this.bodyType = bodyType;
	}
	
	public enum Priority {
		LOW("5"),
		NORMAL("3"),
		HIGH("1");
		
		private String value;
		
		Priority(String value) {
			this.value = value;
		}
		
		public String getValue() { return value;}
	}
	
	public enum BodyType {
		TEXT_PLAIN("text/plain"),
		HTML("text/html");
		
		private final String mimeType;
		
		BodyType(String mimeType) {
			this.mimeType = mimeType;
		}
		
		public String getMimeType() { return mimeType;}
	}

	public List<String> getToAddresses() {
		return toAddresses;
	}

	public void setToAddresses(List<String> toAddresses) {
		this.toAddresses = toAddresses;
	}

	public List<String> getCcAddresses() {
		return ccAddresses;
	}

	public void setCcAddresses(List<String> ccAddresses) {
		this.ccAddresses = ccAddresses;
	}

	public List<String> getBccAddresses() {
		return bccAddresses;
	}

	public void setBccAddresses(List<String> bccAddresses) {
		this.bccAddresses = bccAddresses;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public List<EmailAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<EmailAttachment> attachments) {
		this.attachments = attachments;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailNotificationTO [toAddresses=");
		builder.append(toAddresses);
		builder.append(", ccAddresses=");
		builder.append(ccAddresses);
		builder.append(", bccAddresses=");
		builder.append(bccAddresses);
		builder.append(", fromAddress=");
		builder.append(fromAddress);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", body=");
		builder.append(body);
		builder.append(", bodyType=");
		builder.append(bodyType.getMimeType());
		builder.append(", attachments=");
		builder.append(attachments);
		builder.append(", priority=");
		builder.append(priority);
		builder.append("]");
		return builder.toString();
	}
	
}
