# GuidanceChatBot
This bot reads special 'group sentences' to determine what predetermined reply to give. Complete instructions are at the top of GuidanceEmpty.java.

Example of a group sentence:
<the,a> <vegan> <diets> <are,is> <good,great,healthy>

A group is essentially just a list of words, so a group sentence would be a row of groups or word lists separated by a space.

if < (or a parenthesis like the C version) has a comma after it, then a word from that list or word group must necessarily be in the input phrase in order for the bot to choose a reply making it a "required word". At the end of each 'finders' array string is the number of required words needed in order for the code to output a reply. Only the "<," at the first level (there can be groups inside groups) is counted as a required word group.
Standalone words are also required words.

Another example of a complete/valid list of trees for finders array: 
<the> sun <is> <,shin+e<,s,ing>> <,bright<er>> 3

There are 3 required words in that line: sun, bright, and either shins, shines, shining, or shineing. Both bright and brighter are valid inputs because the "er" is surrounded with <> but without the special signifying comma making it optional. A "+" has this same principle applying to only the very next character. An input phrase of "sun shine bright" would not be accompanied with a reply because the "<,s,ing>" required word pair prevents "shine" or "shin" as options, leaving only
shins, shines, shining, and shineing as possibilities. Shin and shines would be options if the word pair was not required such as "<s,ing>".

More symbols and their purpose is outlined at the top of EmptyGuidance.java.

Let me know about overall improvements, issues, or any other relevant suggestions. This code is free to use and modify however you wish. I hope it convinces you to be vegan, as it's plain to see how the logic can now be and is hard coded.

Email: robecslab@gmail.com    
Discord: goodunderstander

Guidance.java currently runs on this discord server (and a few others): https://discord.gg/UcnKbXgk3D as Guidance#6620, and it can be invited to
other servers as well. Future goals include having Guidance as a Reddit chatbot as it should be millions of times more effective for the animals.

To run this java bot as a discord bot, maven must be installed. Follow the steps in https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html to create a valid directory structure, replacing the auto generated .java files with yours. Then in the code, replace everything up to the wordar(String) method with the contents of GuidanceDiscordBotify.txt and replace the pom.xml with the one provided here. In that same directory as the pom.xml, first run

mvn package

then

java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.Guidance

Replace "com.mycompany.app.Guidance" with your desired directory path as well as in the pom.xml, and enable gateway intent for the discord bot.
