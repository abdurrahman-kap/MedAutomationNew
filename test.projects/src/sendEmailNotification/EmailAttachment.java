package sendEmailNotification;

import java.util.Arrays;

public class EmailAttachment {

	private byte[] attachments;
	private String attachmentMimeType;
	private String transferEncoding;
	private String fileName;
	
	public EmailAttachment() {
	}
	
	
	/**
	 * @param attachment array of the attachment
	 * @param attachmentMimeType The MIME Type for the attachment
	 * @param fileName The name of the file attachment
	 * @param transferEncoding
	 */
	public EmailAttachment(byte [] attachments, String attachmentMimeType, String fileName,
			String transferEncoding) {
		super();
		this.attachments = attachments;
		this.attachmentMimeType = attachmentMimeType;
		this.fileName = fileName;
		this.transferEncoding = transferEncoding;
	}

	public byte[] getAttachment() {
		return attachments;
	}

	public void setAttachment( byte [] attachments) {
		this.attachments = attachments;
	}

	public String getAttachmentMimeType() {
		return attachmentMimeType;
	}

	public void setAttachmentMimeType(String attachmentMimeType) {
		this.attachmentMimeType = attachmentMimeType;
	}

	public String getTransferEncoding() {
		return transferEncoding;
	}

	public void setTransferEncoding(String transferEncoding) {
		this.transferEncoding = transferEncoding;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmailAttachment [attachment=");
		builder.append(Arrays.toString(attachments));
		builder.append(", attachmentMimeType=");
		builder.append(attachmentMimeType);
		builder.append(", transferEncoding=");
		builder.append(transferEncoding);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append("]");
		return builder.toString();
	}

}
