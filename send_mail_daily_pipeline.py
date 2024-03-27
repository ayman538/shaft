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
smtp_username = 'mohamed.ismail5@vodafone.com'  # Replace with your SMTP username
smtp_password = ''  # Replace with your SMTP password
sender_email = 'mohamed.ismail5@vodafone.com'
receiver_emails = ['lidia.ghaly@vodafone.com', 'wftestleads@vodafone.com', 'enno.ribbert@vodafone.com', 'alexander.bijelic@vodafone.com' , 'kholoud.aboelkasem@vodafone.com']  # List of recipient email addresses
subject = 'Daily Pipeline execution reports'
message = '<p>Dear All,</p><p>Please check the attached execution summary reports for each squad. <br>You can also find the consolidated report to have a high level overview of all the squads status combined.</p><p> And here is the summary for execution <br>Browser : BROWSER_TYPE</p><table border="1"><tr><th>Total TCs Number</th><th>Passed TCs Number</th><th>Failed TCs Number</th><th>Skipped TCs Number</th><th>Passing Rate %</th></tr><tr><td style="text-align: center">TOTAL_CASES_NUM</td><td style="text-align: center">TOTAL_PASSED_CASES</td><td style="text-align: center">TOTAL_FAILED_CASES</td><td style="text-align: center">TOTAL_SKIPPED_CASES</td><td style="text-align: center">PASSING_RATE</td></table><p>Thank you and best regards,<br>Web Factory Test Automation team<br></p>'
# Create a MIMEText object for the email message
msg = MIMEMultipart()
msg['From'] = sender_email
msg['To'] = ', '.join(receiver_emails)  # Combine recipient emails with commas
msg['Subject'] = subject
msg.attach(MIMEText(message, 'html'))

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
