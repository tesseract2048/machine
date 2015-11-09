# Requirement:
This server is for ticket machine:

Ticket machine is installed in every coach station for users to fetch coach ticket.
just like airport automatic ticket machine for passengers, for boarding check.
Ticket machine is consist of 3 parts:
Id card scanner, printer, and screen.

This server is for recording the id card information,
show the tickets' info which users bought in Qunar App or web site,
and print the ticket in the format of every station ticket mode, which could be quit different.


1. save the the id card information;
2. manage the machine configure.
3. Transform the ticket information from coach site server to client, act as a proxy.
4. manage the print mode in every station.
5. control the machine update.
6. administer the machine working state.

# graphs:
1. Lifecycle and data flowing graph:
http://www.gliffy.com/go/publish/9131607
2. System consist graph:
http://www.gliffy.com/go/publish/9130183
3. Time sheet for deploying:
http://www.gliffy.com/go/publish/9151245

# local environment:
1. mysql
serverMysql:
DownloadUrl : https://dev.mysql.com/downloads/file/?id=459286
We use mysql community 5.6.23 Homebrew version
password:  some_pass
userId: mms

2. lombok
We use lombok to save code scale.
intellij plugin:
https://github.com/mplushnikov/lombok-intellij-plugin#IntelliJ_Idea_plugin_project_for_project


