# GuidanceChatBot
The purpose of this chat bot is to make the manual adding of responses and the reading of an input sentence easy and straighforward. 
Simply add a "row of trees" to the array labeled "finders", which is what the code reads and compares with an input sentence.

Example of a tree:
<good,great,healthy>
A tree is essentially just a list of words. A row of trees is just lists separated by a space.

if < has a comma after it, then a word from that list must necessarily be in the input making it a "required word". At the end of each finders array
string is the number of required words needed in order for the code to output a reply. Only the "<," at the first level is counted as a required word.
Standalone words are also required words.

An example of a complete/valid list of trees for finders array: 
<the> sun <is> <,bright<ly>> <,shin+e<,s,ing>> 3

There are 3 required words in that line: sun and bright. Both bright and brightly are valid inputs because the "ly", being a single value not required tree, means that "ly" can either be at the end of "bright" or not. A "+" has this same principle applying to only the next very character. An input phrase of "sun bright shine" would not be accompanied with a reply because the "<,s,ing>" required word pair prevents "shine" as an option and leaves only
shins, shines, shining, and shineing as possibilities. Shin and shines would be options if the word pair was not required such as "<s,ing>".

More symbols and their purpose is outlined at the top of the code.

Contact me about improvements, issues, or any other relevant suggestions or comments. This code is free to use and modify however you wish (please just
keep responses scientific, educational, kind, and just overall rational).
Let me know about the remarkable applications or other project ideas worth making with it!

Email: robecslab@gmail.com
Snapchat: o3epo
Discord: Dinkles#3425

Guidance.java currently runs on this server (and a few others): https://discord.gg/EMsakPt6
