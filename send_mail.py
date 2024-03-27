import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email import encoders
import re
import os

# Email configuration
smtp_server = '172.31.58.254'  # Replace with your SMTP server
smtp_port = 25  # Replace with the SMTP server's port (587 is common for TLS)
smtp_username = 'hossein.davoodi@vodafone.com'  # Replace with your SMTP username
smtp_password = ''  # Replace with your SMTP password
sender_email = 'hossein.davoodi@vodafone.com'
receiver_emails = ['hossein.davoodi@vodafone.com', 'mahmoud.elsharkawy@vodafone.com']  # List of recipient email addresses
subject = 'Hello from Python!'
message = 'This is a test email sent from Python.'

# Create a MIMEText object for the email message
msg = MIMEMultipart()
msg['From'] = sender_email
msg['To'] = ', '.join(receiver_emails)  # Combine recipient emails with commas
msg['Subject'] = subject
msg.attach(MIMEText(message, 'plain'))

# Attach a file
attachment_pattern = r'^.*ExecutionSummaryReport_.*.html$'  # Replace with the name of your file
attachment_dir = 'execution-summary/' # + attachment_filename  # Replace with the actual file path

for filename in os.listdir(attachment_dir):
    if re.match(attachment_pattern, filename):
        attachment_path = os.path.join(attachment_dir, filename)
        attachment = open(attachment_path, 'rb')
        part = MIMEBase('application', 'octet-stream')
        part.set_payload(attachment.read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition', f'attachment; filename= {filename}')
        msg.attach(part)

# Connect to the SMTP server and send the email
try:
    server = smtplib.SMTP(smtp_server, smtp_port)
    server.connect(smtp_server, smtp_port)
    server.ehlo()
    server.esmtp_features['auth'] = 'PLAIN'
    server.login(smtp_username, smtp_password)
    server.sendmail(sender_email, receiver_emails, msg.as_string())
    server.quit()
    print('Email sent successfully to multiple recipients!')
except Exception as e:
    print(f'Error: {str(e)}')
