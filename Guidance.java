package com.robecs.app;//Vegan advocate bot Guidance#6620 on discord
import java.util.ArrayList;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Guidance extends ListenerAdapter {

        public static int options = -1;

        public static void main (String[] args) throws LoginException {

                JDA jda = JDABuilder.createDefault("BOT_TOKEN").enableIntents(GatewayIntent.MESSAGE_CONTENT).build();
                jda.addEventListener(new Guidance());
        }
        @Override
        public void onMessageReceived(MessageReceivedEvent event)
        {
                if (event.getAuthor().isBot())
                {
                        return;
                }
                String message = event.getMessage().getContentRaw();

                message = message.toLowerCase();

                System.out.println("" + message);

                String reply = " ";
                if(message.length()<999)
                {
                        try
                        {
                                reply = wordar(message);
                        }
                        catch(Exception e)
                        {
                                reply = "e";
                                System.out.println(e);
                        }
                }
                else
                {
                        reply = " ";
                }
                if (!reply.equals(" ") && !reply.equals("e"))
                {
                        event.getChannel().sendMessage(reply).queue();
                }
        }
	public static String wordar(String p)
	{
		int a = 0;
		ArrayList<Integer> b = new ArrayList<Integer>(a);

		int spaces = 0;
		int endspaces = 0;
		while(p.substring(spaces,spaces+1).equals(" "))
		{
			spaces++;
		}
		while(p.substring(p.length()-(endspaces+1),p.length()-endspaces).equals(" "))
		{
			endspaces++;
		}
		p = p.substring(spaces,p.length()-endspaces);

		b.add(-1);
		while(a<p.length() && (p.charAt(a)=='@' || p.charAt(a)=='<'))
		{
			while(a<p.length() && !(p.charAt(a)==' '))
			{
				a+=1;
			}
			a+=1;
		}
		if(p.length()-a<7)
		{
			return " ";
		}
		p = p.substring(a,p.length());
		a = 0;
		while((p.length() > a))
		{
			if(p.charAt(a)==' ')
			{
				b.add(a);
			}
			else if(p.charAt(a)=='!' || p.charAt(a)=='?' || p.charAt(a)==',' || p.charAt(a)=='+' || p.charAt(a)=='<' || p.charAt(a)=='>' || p.charAt(a)=='.')
			{
				p = p.substring(0,a) + p.substring(a+1,p.length());
				a-=1;
			}
			a+=1;
		}
		b.add(p.length());
		String[] foreword = new String[b.size()-1];


		for(int x = 0; x < b.size()-1; x++)
		{
			foreword[x] = p.substring((b.get(x)+1),b.get(x+1));
		}
		if(foreword.length<2)
		{
			return " ";
		}
	
		ArrayList<Integer> inqwords = new ArrayList<Integer>(0);

	if(foreword[0].equals("who"))
		{
			inqwords.add(0);
		}
		else if(foreword[0].equals("what"))
                {
                        inqwords.add(1);
                }
		else if(foreword[0].equals("where"))
                {
                        inqwords.add(2);
                }
		else if(foreword[0].equals("why"))
                {
                        inqwords.add(3);
                }
		else if(foreword[0].equals("how"))
		{
			inqwords.add(4);
		}
		else if(foreword[0].equals("do") || foreword[0].equals("does") || foreword[0].equals("can"))
                {
                        inqwords.add(5);
                }
		if(inqwords.size()>0)
		{
			if(foreword[1].equals("is"))
                	{
                	        inqwords.add(0);
				if(foreword.length>3)
				{
					if(foreword[2].equals("it") && foreword[3].equals("that"))
					{
						inqwords.add(0);
						inqwords.add(0);
					}
				}
                	}
                	else if(foreword[1].equals("does"))
                	{
                	        inqwords.add(1);
                	}
                	else if(foreword[1].equals("come"))
                	{
                	        inqwords.add(2);
                	}
                	else if(foreword[1].equals("could"))
                	{
                	        inqwords.add(3);
                	}
                	else if(foreword[1].equals("can"))
                	{
                	        inqwords.add(4);
                	}
                	else if(foreword[1].equals("would"))
                	{
                	        inqwords.add(5);
                	}
                	else if(foreword[1].equals("should"))
                	{
                	        inqwords.add(6);
                	}
                	else if(foreword[1].equals("do") || foreword[1].equals("did"))
                	{
                	        inqwords.add(7);
                	}
                	else if(foreword[1].equals("may"))
                	{
                	        inqwords.add(8);
                	}
                	else if(foreword[1].equals("must"))
                	{
                	        inqwords.add(9);
                	}
			else if(foreword[1].equals("are"))
			{
				inqwords.add(10);
			}
			else if(foreword[1].equals("to"))
                        {
                                inqwords.add(11);
                        }
			else if(foreword[1].equals("you") || foreword[1].equals("people") || foreword[1].equals("we") || foreword[1].equals("u") || foreword[1].equals("one"))
                        {
                                inqwords.add(12);
				if(foreword.length>2)
				{
					if(foreword[2].equals("get") || foreword[2].equals("obtain") || foreword[2].equals("receive"))
					{
						inqwords.add(0);
					}
				}
                        }
			else if(foreword[1].equals("ought"))
                        {
                                inqwords.add(13);
                        }
			else if(foreword[1].equals("has") || foreword[1].equals("contains") || foreword[1].equals("includes"))
			{
				inqwords.add(14);
			}
			else if(foreword[1].equals("will"))
			{
				inqwords.add(15);
			}
		}

		//What questions strings can take
		int[] n1 = {3,0,-1,4,0,2};//meat is good

		int[] n2 = {3,7,-1,4,2};//humans need some meat

		int[] n3 = {3,1,4,7,-1,4,1,2,7};//meat has what humans need

		int[] n4 = {};//meat doesn't cause harm

		int[] n5 = {3,7,-1,4,1,2,7};//cars cause more pollution

		int[] n6 = {3,0,0,0,-1,4,2,0,0,0};//humans are designed to eat meat

		int[] n7 = {3,7,-1,4,2};//humans need to eat some meat

		int[] n8 = {};//people should eat meat cause it's natural

		int[] n9 = {3,0,0,0,3,4,5,6,11,12,13,7,-1,4,2,5};//people eat meat

		int[] n10 = {};//people need meat because it's healthy

		int[] n11 = {3,7,-1,4,2};//animals lack feelings

		int[] n12 = {3,7,-1,4,2};//people lack relation with animals

		int[] n13 = {3,7,-1,4,2};//animals lack intelligence
		
		int[] n14 = {2,0,1,3,4,5,7,8,10,11,-1,4,7,-1,1,0,10,15,-1,1,7,4,0,0,-1,1,12,0,-1,1,14};//where do you get x vitamin
		
		int[] n15 = {3,1,3,4,5,7,9,10,-1,4,1,2,3,4,5,7,8,10,-1,5};//meat increases (the risk of) x

		int[] n16 = {3,3,4,5,6,9,13,-1,0,0,3,4,5,6,7,8,10,15,-1,1,3,4,5,6,7,8,10,12,13,15};//why ought I go vegan
		
		int[] n17 = {3,1,7,10,-1,4,2,7,10};//longest living person ate meat
		
		int[] n18 = {3,0,1,3,4,7,10,-1,4,0,1,2,3,4,5,7,10,-1,5};//meat doesn't pollute (the environment)

		int[] n19 = {3,0,10,12,-1,4,2,10};//Vegans are skinny

		int[] n20 = {0,1,3,4,5,6,8,9,10,13,-1,3,0,1,3,4,5,6,8,13,-1,4,0,2,3,4,5,6,8};//veganism doesn't matter
		
		int[] n21 = {};//I'd rather live a short life than go vegan
		
		int[] n22 = {3,0,4,5,6,9,10,13,-1,4,0,2,3,4,5,6};//Animal suffer is not important

		int[] n23 = {3,0,3,4,5,6,9,13,-1,4,0,1,2,3,4,5,6,8,10};//Caring about animals is subjective/not important
		
		int[] n24 = {0,0,-1,0,1,-1,3,-1,0,4,0,-1,0,5,6,-1,3,1,4,5,6,8,9,10,13,-1,3,0,1,3,4,5,6,7,8,9,10,13,-1,4,0,1,2,5,6,8,9,10,13};//Why should I care about X

		int[] n25 = {3,3,4,5,6,8,9,13,-1,4,0,1,2,3,4,5,6,7,8,9,13};//You,I can't,wont change anything
		
		int[] n26 = {1,3,4,5,6,7,9,10,13,-1,2,0,3,4,5,6,7,8,9,11,13,-1,4,0,3,4,5,6,7,8,9,10,11,13};//What to do with the animals

		int[] n27 = {3,0,10,-1,4,0,2,10};//We are part of the food chain

		int[] n28 = {3,3,4,5,7,8,10,-1,4,2,3,4,5,8,10};//animals would harm,kill us,humans (if given the chance)

		int[] n29 = {1,0,1,3,4,5,6,7,8,9,10,13,-1,2,0,3,4,5,6,7,8,9,13};//What does Guidance say

		int[] n30 = {0,0,3,4,5,6,7,8,9,10,-1,1,0,3,4,5,6,8,9,-1,3,0,1,3,4,5,6,7,8,9,12};//What is the point,big deal with (not) going vegan,eating meat,hurting animals

		int[] n31 = {};//Animals should have evolved faster than we did
		
		int[] n32 = {3,0,7,10,-1,4,2};//Animals have a skill issue

		int[] n33 = {3,0,3,4,5,8,9,-1,4,0,2,3,4,5,6,8};//Veganism is a cult

		int[] n34 = {1,-1,3,0,3,4,5,6,7,8,10,11,-1,4,0,2,3,4,5,6,7,8,9,10,11,-1,5};//humans are superior

		int[] n35 = {1,-1,3,0,5,6,7,10,-1,4,0,2,3,4,5,6,7,8,9,10,13,-1,5};//You (still) kill animals

		int[] n36 = {0,3,4,5,8,-1,1,3,4,5,8,-1,5,12};//can you tell me more about veganism

		int[] n37 = {3,-1,4,2};//Vegans don't excersize

		int[] n38 = {3,0,-1,4,2};//nature is built around wild animals eating other wild animals

		int[] n39 = {3,0,10,-1,4,2};//Meat alternatives aren't widely available

		int[] n40 = {};//I'm okay with killing animals

		int[] n41 = {1,0,3,4,5,8,9,10,-1,3,0,3,4,5,6,8,9,10,13,-1,4,0,1,2,3,4,5,7,8,10,-1,5};//What is bad about meat

		int[] n42 = {1,1,0,3,4,5,8,9,10,-1,3,0,3,4,5,6,8,9,10,13,15,-1,4,0,1,2,3,4,5,7,8,10,-1,5};//why is meat bad
		
		int[] n43 = {};//Animals are good for the environment,planet,atmosphere
		
		int[] n44 = {1,3,4,5,7,8,10,-1,3,0,1,3,4,5,6,7,8,10,-1,4,0,1,2,3,4,5,6,7,8,10,-1,5};//Why,how are animals bad,destructive for,to the environment?
		int[] n45 = {2,1,3,4,0,0,5,7,8,11,12,15,-1,4,0,0,0,1,2,3,4,5,7,8,10,14,-1,5,12}; //help me go vegan/How does one find information on how
		int[] n46 = {0,3,4,5,8,15,-1,4,0,0,0,1,3,4,5,8,10,15,-1,1,0,0,0,1,3,4,5,8,15,-1,5,-1,3,0,0,5,10,12,13,15};//How does veganism/going vegan help
		int[] n47 = {0,0,3,4,5,6,8,10,12,15,-1,1,0,1,3,4,5,6,7,8,9,10,15,-1,2,3,4,5,8,-1,3,0,3,4,5,6,7,8,9,10,13,14,15,-1,4,0,1,2,3,4,5,7,8,9,10,12,13,15,5,12};//<I don't think that> vegan diets are adequate/have/provide+s much health benefits
		int[] n48 = {1,-1,3,5,12};//I don't want to eat salad,grass
		int[] n49 = {0,0,1,3,4,5,7,12,15,-1,1,0,1,3,4,5,6,8,9,10,12,13,15,-1,2,0,1,3,4,5,7,8,9,10,12,13,15,-1,4,0,0,0,3,4,5,6,7,8,9,10,12,13,15,-1,5,12};//What are the problems/benefits to a vegan diet/veganism
		//1: who=0 what=1 where=2 why=3 how=4 do&does&can=5
		//2: is=0 does=1 come=2 could=3 can=4 would=5 should=6 do&did=7 may=8 must=9 are=10 to=11 you&people&we&u=12 ought=13 has&contains&includes=14 will=15 
		int[][] inq = {n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20,n21,n22,n23,n24,n25,n26,n27,n28,n29,n30,n31,n32,n33,n34,n35,n36,n37,n38,n39,n40,n41,n42,n43,n44,n45,n46,n47,n48,n49};

		int boing = 0;
		
		boing = inqwords.size();
		
		String[] word = new String[(foreword.length-boing)];

		for(int c = 0; c<word.length; c++)
		{
			word[c] = foreword[(c+boing)];
		}
		//Sentence search measures (last number is number of key words to fulfill in order to reply)
		String[] finders = {"<<,eat,consum+e,ingest><ing>> <,meat,[5] <flesh>,beef,poultry> <is,be> <very,so+o+o> <easy> [15] <for> [16] 2",//1
				"<,<as,the,us,we> <humans+'+s,people+'+s,mankind+s,we,you,u>> <,<need+s,should,ought,must> <to> <have>,require,necessitate> <some> <a+n> <certain,moderate,small,little,ample> <[17]> <amount,quantity> <of> <,meat,steak,beef,chicken,cow,pork,[5]> <derived> <product+s> <in moderat<ion,e>> <amount+s,quantit<y,ies>> |<<be>cause,since> <it+'+s> <will> <ha<s,ve>,include+s,give+s> <the> <essential,enough,vital,necessary,important> <protein+s,amino acid+s,fat+s,vitamin+s> <and,plus> <that> <other> <stuff,things> <that> <which> <is> <what> <help<s,ing>> <we,us,me> <maintain+s,promote+s,need,prefer> <for> <a> <[15]> <for> [16] ?<and,and/or> 3",//2
				"<almost> <all,most> <,meat,[5]> <derived> <produc<ts,e>> <,contain+s,ha<ve,s>,consist+s,includes> <most,a+ lot,plenty> <of> <what> <the> <human+s,people,we> <beings> |<because,cause> <it+'+s> <we,the+y> <,need,crave,neccess<itate,ary>,require> <so> <that> <in order> <for> <our,us,the<ir,y>> <to> <may> <proper<ly>> <be> <able> <to> <[15],<surviv<e,al>,[19]> ?<and,or,and/or> 3",//3
				"<the> <,meat,[5]> <,[6],[9]> |<no,barely,hardly> <has,have,[1]> <any,an> <sort> <of> <[11]> <[2]> <in> <the> <amount> <of> <[1]> <,[7],[13],kill> ?<or,and,and/or> <[8]> <[21]> <that,quite> <[11]> 3",//4
				"[4] <are> [3] <a> <[11]> [2] <an,a> |<,[7],[13]> ?and <[8]> <,then,than,compared <,to,with>> <w+hat> <,meat,[5]> <production> <has,makes,contributes,does> <to> 6",//5
				"<because,since> <all> <our> <,i+'+m <am>,humans,we,ancestors> <a+n> <<we,they> <are,were>> <,omnivores,ought,meant,supposed,made,designed,need,have <been>> <to,for> <,<,eat+s,ate,consum+e,ingest<ed>><ing>> <,meat,animal+s <flesh,protein>,the flesh of animal+s,[5]> <product+s> |<because,cause,since> <by> <through> <it+'+s> <the> <what> <we,<our,your,my> <ancestors,<great> <grand>parents,relatives>> <are,do,did,<have> done> <made> <for> <to do> <in> <the way> <our> <way of life> <were,are,have been <doing>> <it> <metabolism> <operate<ing,s>,function<ality>,doing> <made,design<ed>,natur<e,ally>,genetic<s,ally>,blood,dna> <for> <thousands,hundreds,millions,many,ages> <of> <years> <which> <is> <a <while,long time>> ?<and,and/or> 4",//6
				"<all> <,humans,people,everyone,we,you,u> [18] <,eat+s,consume,ingest,intake> <a> <[17]> <amount,quantity,proportion> <of> <,meat,[5]> <product+s> <in> <some> <a> <reasonable,regular> <[17]> <amount,quantity> <for> <our,us,humans> <to> <survive,live,be> <more> <health<y,iful><ly>> <and,or> <not be deficient> 4",//7
				"<all,most,the vast majority of> <,humans,people,us,we> [18] <eat,consume,ingest,intake> <a+n> <[17]> <amount,quantity,proportion> <of> <,meat,[5]> <produc<ts,e>> <<be>cause,since> <it+'s> <only> <[15]> <for> <in order> <to> <,natural,normal,[15],reasonable,rational,logical> <for> <human+s,us,our,the<m,re,ir>> <to> <[19]> <since,<be>cause> <we,i+'+m,people,humans,they> <get> <enough,adequate,ample> <amount> <of> <protein,mineral+s> <as,are,have> <been> <a+n> <omnivore+s> 4",//8
				"<go,consider,be> <vegan> <when> <all,most,the vast majority of> <,humans,people,we,i> <[18]> <,eat,consume,intake> <,meat,[5]> <products> |<because,cause> <humans,people,them> <<they,i> <want,need> <to>> <of> <it+'+s> <for> <the> <their> <taste+s,pleasure,enjoy<ment,able>> <[15]> ?<and,or,and/or> 3",//9
				"<a,every,all> <of> <the> <,every<one,body>,human+s,people,person,we> <,must,<ha<ve,s>,need+s,ought> to> <,eat,consume,have> <some> <[17]> <amount,quantity> <of> <,meat,[5]> |<<be>cause,since> <it+'s,it is> <only> [15] <for> <a,every> <human+s,their,everyone+'+s> <[19]> ?<and> 5",//10
				"<an,the> <,animal+s,insect+s> |<will> <,never,wont,lack+s,[6],[9],[10],aren+'t,are not> <be> <have> <as> <the> <intell<ect,igence,igent>,reason<ing,able>,ever,possibl<e,y,ity,ities>,<cap>able,<cap>abilit<y,ies>> ?<,and,or,and/or> <to> <be> <have> <any> <the> <,feel<ing>+s,experience+s,emotion+s> <like,such as> |<pain,emotion,suffering,stress,anything> ?<and,or,and/or> <such as,like> <that> <of> <a> <human+s,people,we,us> <can,do<es>> <have,experience> 3",//11
				"<all,most> <of> <us> <a> <,person,people,humans,mankind,we> <,lack+s,[6],[9],[10]> <ha<ve,s>> |<a+n+y> <sort> <o+f> <a> <meaningful,emotional,real,significan<t,ce>,important,tangible,actual> <,relat<e,ion<ship>>,connection> <with> <to> <a+n> <the> <,them,other+s,[5]> ?<and,or,and/or> 4",//12
				"<an,the,all> <of> <the> <farm> <,insect+s,animal+s,cow+s,chicken+s,pig+s,wildlife> <li<ves,fe>> |<will,can,could> <,never,wont,lack+s,[6],[9],[10],aren+'t> <be> <hav<e,ing>> <as> <the> <same> <,smart,th<ink,skills,processing <speed>,thought+s>,intell<,ect,igence,igent>,reason<ing,able>,ever,possibl<e,y,ity,ities>,<cap>able,<cap>abilit<y,ies>> ?<,and,or,and/or> <to> <be> <have> <as> <+many> <the> <feel<ing,s>,experience+s,thoughts,think,reason<ing,able>,intelligen<t,ce>> <like,such as> |<pain,emotion,suffering,stress,anything> ?<and,or,and/or> <such> <as,like> <that> <of> <a> <human+s,people,us,we> <do,does,can> 3",//13
				"<you,we,i,u+s,one> <tell,inform> <me> <on> <know> <where,how> <the,as> <i,people,human+s> <may,can> <obtain+s,recieve+s,intake,find+s,get+s> <a+n> <the> <right,proper,normal,regular> <enough,adequate,ample,good> <amount> <of> <vitamin+s> !<,nutrients,a,b<1>,b2,b3,b5,b6,b7,b9,b12,c,d<1>,d2,d3,e,k,protein> <while> <<with>in<side>,from,as,being> <on> <a> <vegan,plant+s <based>> <food+s,diet,product+s> 1",//14
				"<<,eat,consum+e,ingest,intak+e><ing>> <a> <all,any,the,high,more,greater> <amount,quantity> <of> <,meat+s,[5],livestock,heme iron,cholesterol,saturated fat> <consumption> <products> <do<es>n+'t,do<es> not,<wo,c+a><+ould>n't,<,are,have,is><n+'t> <not>> <,<,in,de>creas+e<s,ing>,elevat+e<s,ing>,promot+e<s,ing>,rais+e<s,ing>,lower<s,ing>,mak+e<s,ing>,creat+e<s,ing>,provok+e<s,ing>,produc+e<s,ing>,caus<e,ing>+s,risk<s,ing>> <that> <much> <a> <more,greater> <of> <the,our,your> <risk,liklihood,chance,probability,possibility> <of,for,to> <develop<ing>,elevat<e,ing>,promot<e,ing>,rais<e,ing>,lower<ing>> <the> <risk,possibility> <of> <a> <much> <health> !<,<much> <,disease,issue+s,problems,harm+s>,heart <disease,issue+s,problems,harm+s>,atherosclerosis,pancreatitis,colorectal,<ed,erectile>,cvd,cancer> <dysfunction> <in> <for> <people,humans> 4",//15
				"<do> <you> <think,reckon,believe> <are> <th<e,ose,at>> <it+'+s> <it> <is> <optimal,important,crucial,essential,necessary,vital> <for,that> <,i,we,you,who,u+s,anyone,every<one,body>,it,care+s,benefit+s> <to> <even> <is> <important,crucial,essential,necessary,vital> <would> <it> <really> <to> <have,should,must,need,ought,bother> <to> <care+s,bother,stress> <about,for,over,from> <start<ing>> <to> <,go<ing>,be<com+e,ginn,nefit+s><ing>> <humans,me,people> <at> <all> <to,from> <be<ing>> <becom<e,ing>> <go<ing>> <a> <,vegan<ism>,plant based> <since,if> <we,i,every<one,body>> <person,human> <is> <will,go<ing,nna>> <to> <eventually> <die> <no,regardless> <matter> <what> 3",//16
				"<the> <longest> <living> <,people,person,human+s,<wo>man> <that,who+m> <have,had,are> <been> <live<d,ing>,surviv+e<d,ing>,around> <the> <longest> <have,had,were> <,eat<en,ing>,ate,consum+e<d,ing>> <,meat,[5]> <are,will be,their> <whole> <liv+e<d,s,ing>,surviv+e<d,ing>,ha+v+e<ing,d>> <a+n+d> <liv+e<s,ing,d>,surviv+e<s,ing,d>> <the> <more> <long<er,est>,moral<ly>,better,good,great> <and> <health<y,ier,iest>> <example+s> 3",//17
				"<eating,consuming> <the,a+n+y> <,meat,beef,poultry,fish,[5]> <produc<e,t+s>> <did,<is,do<es>,are,has><n+'t> <not>> <been> <caus+e<s,ing>,creat+e<s,ing,ed>,promot+e<s,ing,ed>,mak+e<s,ing>,made,provok+e<s,ing,ed>,responsible,produc+e<ing,s>> <for> <<a+s,that> <a> <much,more,many>> <of> <a> <significant<ly>,marginal<ly>> <greater,less<er>> <amount> <of> <,pollut<e,ion,ant>+s,harm<s,ing>,destroy<s,ing,ed>,destruction,ruin<s,ing,ed>,degrad+e<s,ing,ed>,waste+s> <<o,i>n<to>,to,the,our,my> <the,our> <planet+'+s> <earth+'+s> <environment+'+s,ocean+'+s,river+'+s,atmosphere+s,water+'+s,ground+'+s,air+'+s,soil+s> <<a+s,that> <much,more>> <more,greater> <then,than,compare+d,relative,as> <to,with> <what,how> <much> <is> <involved> <with,in> <the> <waste<ful>> <effect+s,affect+s,product<s,ion>,creation> <of> <co2,greenhouse> <gas> <harm+s,pollut+e<ion,ants,s>,damage+s,destruction+s,emission+s,fume+s> <that,which> <are> <cause+d,create+d,made,provoke+d,generate+d,produc<ed>> <by,from,as> <a,the> <result,consequence,<by>product> <of> <the> <process> <of> <a> <providing,refining,mining,fueling,supplying,generating,manufacturing,producing> <the> <fuel,materials,supply,part+s> <necessary,needed,required> <in> <order> <for,that,which,to> <make,create,supply<ing>,establish,mine,extract,obtain,sustain,operate> <crude,refined,new> <car+s,boat+s,ship+s,plane+s,transport<ing,ed,ation>+s,<coal+s> <power> <plants>,steel,metal+s,brick+s,oil+s,gas,petrol<eum,s>,fuel+s> <<by>+-produc+e<ts,tion>,refin<e,ing,eries>,pollut<e,ion,ants>,mill+s<ing>,smelt<ing>,min<e+s,ing>> <ha<d,s>> <<do,mak,creat,produc,cost>+e+d+s,generate+d+s,significance,involvement,influence,<a,e>ffects,achieve<s,d>> <in> <order> <to> <operat<e,ion>,sustain> 2",//18
				"<all,most,every<one,body>> <person,<wo>man,human> <that> <i+'<ve,m>> <seen,met> <who> <are,were,became> <eat<en>,consume+d> <on> <a> <,vegan+s<ism>,plant based,plants> <diet+s> <are,were,ha<ve,s>,is> <always,consistently> <been,ha<d,s>> <a> <,skinny,thin,weak,frail,malnourish<ed,ment>,<do<es>,ca+n,are><n+'+t>,lack+s<ing>,lanky,dumb,stupid,moron<s,ic>,cringe+y,lame,disorder<ed,ly>> <and,because> <they,vegan+s> <<do,are><n+'t> <not>> <<gi,ha,recie>ve,get<ting>,fulfil<ling>,obtain<ing>> <enough> <the<ir>> <protein+s,vitamin+s,mineral+s,nutrient+s> <defficiency,requirement+s,need+s> <<i,o>n,with,from,as> <a,their,that,vegan> <vegan,plant based,meat<less> <free>> <diet,life<style>> 2",//19
				"<it+'+s> <is> <important,urgent,relevant,necessary,ideal,logical,rational,matter> <if> <for> <i,u,you,me,us,we,every<one,body>,people,human+s> <to> <not,stop> <necessarily,logically,rationally,reasonably,always> <put<ting>,wast<e,ing>,place<ing>> <effort+s,care<s,ing>> <to> <understand,think,care,realize> <that,about> <start<ing>> <go<ing>,be<com+e><ing>> <someone> <who+'+s> <is> <a> <,vegan+s<ism>,plant based,<harm,hurt><ing> animal+s> <<is,are,has><n+'t> <someone> <who> <not,too>> <a+n> <something,ideaology,concept> <that+'+s> <is,can> <be> <do<es><n+'t> <not>> <won+'+t> <go<ing,nna>> <to> <be> <,matter+s<ed>,<un>important,ideal,logical,rational,relevant,cringe,lame,dumb,woke,pushy,force<ing,ful>,substantial,necessary> <at> <all> <ever> <to> <consider,be<come>> 2",//20
				"<most> <,i+'+d,we+'+d,people,human+s> <personally> <would> <rather,prefer<red>,want> <to> <live> <a> <short<er>,less,quick> <and,but> <,<die> <happ<y,ily>,short,quick> <life>> <rather> <,then,than> <start,begin,push,strive> <to> <advocat<e,ing>> <for> <go<ing>,be<come,ing>,liv<e,ing>,pursu<e,ing>> <in> <a> <long> <life> <of> <,vegan<ism>,sad<ness>,miser<y,able>,plant based> <one,life<style>,misery,ideaology,existence> 4",//21
				"<the> <suffering,pain,feelings,lives,experiences,thoughts,problems,issues> <that> <are> <being> <supposedly> <caused,made,created,felt,experience+d> <with,by,from,of> <the,some,a+n+y> <,meat,[5],flesh,pig+s,cow+s,chicken+s> <product<s,ion>> <such> <as> <how> <they+'<re> <are>> <supposedly> <<have,feel><ing>,in> <bad> <suffering,pain,feelings,experience+s,thoughts,problems,issues,live+s,condition+s> <which> <,<are,is,should,do<es>><c<an,ould>><n+'t> <not>> <be> <something> <of> <a> <that> <we,you,i,<any,every><one,body>> <is,are,were> <should,must,oblig<ed,ated>,necessary> <to> <be> <giv<e,ing>> <of> <much> <,<consider<ation>> <importan<t,ce>>,matter,<ir>relevant,concern<ing>,care,obligat<ed,ion>> <enough> <to,for,by,with> <the,most> <us,me,<any,every>one,people,humans> <to> <subjectively> <be> <consider,take+n> <seriously> 3",//22
				"<i,we,you,people,humans,every<one,body>> <can,would,do<es>> <think+s,feel+s,agree+s,know+s> <that,like> <to> <assign<ing>,find<ing>,plac<e,ing>> <moral> <,car<e,ing>,liking,thinking,value<s,ing>,worth> <enough> <about> <to> <start> <go<ing>,be<gin,come><ing>,eat<ing>> <ab<out>,for> <only> <the> <a+n+y> <of> <the> <,vegan<ism>,animal+s,insect+s,sentience,life,cow+s,pig+s,chicken+s,fish> <<is,are,was,do<es>><n+'t> <not>> <a+n> <too> <,matter+s,<important> <issue,problem>,reasonable,<ir>rational,subjective,essential,silly,dire,dumb,goofy> <enough> <thing,subject,topic> <to> <consider,be<come>,take+n> <car<e,ing>> <seriously> <for,ab<out>> 3",//23
				"<it+'+s> <not> <that> <helpful,matter,relevant,important,crucial,significant> <for,of> <it> <be> <the> <case> <that> <every,all,most> <of> <,i,u,to,you,who,me,we,us,every<one,body>,any<one,body>,human+s,people> <would> <even> <in,of,on> <the,our,a+n+y> <planet> <earth,world,country> <to> <would> <undertand,realize,consider<ing>> <that> <they,we,i,u,you> <have,need,ought,should,must,bother> <to> <start,begin> <put<ting>,wast<e,ing>,giv<e,ing>> <a+n+y,some> <more> <,effort,want,car<e+s,ing>,try<ing>,attempt<ing>,consider<ing,ation>,go<ing>,becom+e<ing>,help,assist,promote> <to,about> <put,start,begin> <car<e,ing>,attempt<ing>,acknowledg<e,ing>,becom<e,ing>,go<ing>,help<ing>> <to> <about,be<com+e><ing>> <to,for,pro> <a> <the<se>> <,vegan<s,ism>,<environment<al>,air,soil+s,ocean+s,lake+s,river+s,atmosphere,planet,earth,world>,[5],meat,cow+s,pig+s,chicken+s,livestock> <action+s,effort+s,cause> <to> <begin> <with> <at,in> <all,general> <anyway> 3",//24
				"<the,a+n+y> <,<i,u,you,we,people,human+s,society,any<one,body>,every<one,body>> <that,who> <is> <going,be<com>ing> <vegan<ism>,plant based>> <<ca,do,wo,are,is><n<not><+'t>> <not>> <possibly,realistically,reasonably,rationally,likely> <go<ing,nna>,willing> <to> <possibly,reasonably,realistically,rationally> <,fix,mitigate,solve,change,do,repair,help> <a+n+y> <single> <of> <the,this> <,anything,problem+s,issue+s,consequences,world,planet,rammifications> <in> <the,our,for> <world,planet,people,<hu>man<kind>> <be> <a> <better,safer> <place> <just,simply> <by,with,from> <only> <<not> <,eating,consuming,ingesting,buying,purchasing> <,meat,[5],pig+s,cow+s,chicken+s>> <and,or> <start<ing>,begin<ing>> <to> <go<ing>,becom<e,ing>,be<ing>> <vegan<ism>,plant based> <endeavour+s> 3",//25
				"<,i,u,you,<w,b>e,people,human+s,<every,any><one,body>,a+-do,to,happen,go<ing,nna>> <try> <attempt<ing>> <go<ing,nna>,should,ought> <to> <,do<ne,ing>,achieve,make,care,happen,with> <,with,of,about,concerning,to> <al+l> <the+m,those,that> <farm<ed>> <,[5],meat,pig+s,cow+s,chicken+s> <that> <are> <currently> <<o,i>n> <the+m,those> <[5],store+s> <if,when> <all,every,most> <every<one,body>,people,human+s,we> <go<es>,becom<e,ing>+s,is,turn<s,ed>> <vegan,plant based> 4",//26
				"<a+s> <us,the,all,most> <of> <the> <,i,u,you,we,human+s,people,animal+s,insect+s,cow+s,pig+s,chicken+s> <person> <are,is,were,play+s> <at,on,of> <the,a+n> <much> <more,bigger,greater> <,importan<t,ce>,crucial,vital,necessary,key,part,ultimate,top,better,apex,in,smart<er,est>,capable,intelligent,high<est,er>,included,role,part> <order> <being+s,life> <than,then> <of,<o,i>n> <the> <,food <chain,pyramid,web>,predator+s,animal+s,<life> <,circle,cycle,chain> <of> <life>> <in> <the> <food <chain,pyramid>> <then,than,compared,relative> <to,with> <the> <other+s> <animal+s,species> <are> 3",//27
				"<the,a+n> <wild> <,animal+s,wild<life>,lion+s,predator+s,insect+s,beast+s> <would> <,kill,harm,hurt,genocide,torture,farm,destroy> <a+n+y,the> <,us,me,<other+s> human+s,<other+s> people> <when,if> <we,it> <ha<d,ve>> <gave,given> <the<m,y>> <are,were,was> <the> <chance,opportunit<y,ies>,role+s,ability,able,allow<ed>,possib<le,ility>> <the<m,at>> <we> <have> <to,were> <swap<ped>,do> <with> <us,human+s,me,people> <so,have,got> 3",//28
				"<i,we,people,human+s,you> <possibly,by chance> <find,locate,get,put> <my> <hand+s,paw+s> <on> <all,every> <of> <the> <,<every>thing+s,phrase+s,word+s,sentence+s,output+s,what,that,where,quote+s,verbage,my,ur,your,the,possible,fix,change,alter> <hand+s> <on> <all> <th<e,at>,of,from> <you+r,ur> <can,could,would,may,might,will> <possibly> <be> <output<ted>,word+s,sentence+s,phrase+s> <that> <can> <be> <make,made,stated> <sa<y,id>,spoken,uttered,possible> <that,of> <you,u,it> <can,will,would,could> <possibly> <be> <sa<id,y>+s,make+s,utter+s<ed>,output<s,ted>,iterate<d,s>,come> <by,from> <,guidance> 2",//29
				"<all> <the,+ma+n+y> <big,great,whole> <,deal,point,argument,reason+s,problem+s,issue+s,talk,incentive+s> <with,of,for,about,<o,i>n> <not> <go<ing>,be<com+e><ing>,<par>tak<e,ing>,start<ing>,try<ing>,eat<ing>,follow<ing>,consum<e,ing>,consider<ing>,worship<ping>> <on,with> <th<e,at>,a+n> <,plant based,vegan<ism>,meat,cruelty,<hurting,harming> [5]> <free> <diet+s> |<since,if,when,<be>cause> <there+s,we+'<re>,u+r,you+'<re>,it+'+s> <all> <<are,do<es>,is><n+'t> <not>> <like<ly>,soon,quick<ly>> <<any,no>thing,much,go<ing,nna>> <die,end,perish> <that> <soon,immediately> <anyway,regardless> <is,are,happen+s> <to> <not> <really,actually,barely,necessarily,absolutely> <that> <matter+s,relevant,important,care,reasonable,rational,essential,life threatening,risky> <much> ?<and,or> 2",//30
			"<the+m,those,a+n+y> <<cap>abilit<ies,y>,achievement+s,legacy> <of,that> <them,those,a+n+y> <other+s> <farm<ed>> <,animal+s,insect+s,cow+s,pig+s,chicken+s,species,wildlife> <should,<ha<ve,d>,did><n+'t>> <have,not> <,be<en,came>,evolved,pale+s,turned,got,<are,is,can<not>,do><n+'t> <not>> <think,reason,understand> <more,as,less> <evolve+d> <in> <better,faster,more,<in>comparable,good,smart<er>,reason<ing,ably>,comparable,worse> <quick<er,ly>> <understanding,comprehen<sion,ding>> <cap>abilit<y,ies> <than,then,compar<ed,ison>,relative> <to,with> <what> <the> <<cap>abilit<y,ies>,achieve<ment>+s,creation+s,comprehension,discover<y,ies>> <made,achieved> <of,by,that> <the> <,us,we,<hu,wo>man+s<kind>,our,people+'+s> <ha<d,ve,s>> <did,are,made,skill+s,<cap>abilit<y,ies>,creat<e+d,ion+s>,comprehen<sion,ding>,achieve+d,done,construct<s,ed>> 3",//31
			"<most,all,being> <of,a+n+y,some> <the+m> <,animal+s,insect+s,cow+s,pig+s,chicken+s,fish> <is,<are,do,can><n+'t> <not>> <have> <significantly,no,much> <more,less,0,zero> <lack<s,ing>> <of> <<a,i>+n> <,skill,dumb<er>,potential,intelligen<ce,t>,stupid,cruel,brain> <issue,power> <then,than,compared,relative> <to,with> <the> <other+s> <us,me,human+s,people> <like> <us> 2",//32
			"<is,to,by> <people,humans,whoever,<some+1<one>,any<body>> <body,one>> <that,who> <is,are> <go<es,ing>,went> <around> <being,preach<es,ing>,worship<ping,s>,follow<ing,s>,is> <preachy,yaps,indoctrinated> <on,by> <a+n> <,vegan+s<ism>,plant+s <based>,meat<less>,animal+s> <product+s> <free> <diet> <mean+s,is> <you<+'re>,u,ur,they<+'re>> <are> <too> <far> <<with>in,follow<ing>,worship<ping>,be<com+e><ing>,tak<e,ing>> <part,indoctrinated> <of,<with>in> <to> <a+n> <,cult,religion,wrong,scam,ridiculous,dumb,stupid,crazy,<not> <<un>important,insane,worth<while,y>,it,gone,radical,extrem<e,ist+s>>> <ideaolog<y,ies>,idea+s,it> 2",//33
			"<the,us> <a+n+y> <of> <the> <farm<ed>> <,i,u+r,we+s,people,human+s,<every<one,body>,any<one,body>,animal+s,cow+s,pig+s,chicken+s> <one,body,person>,<wo>man<kind>> <evolve+d> <to> <ha<ve,s>,must,need,should> <to> <view,see,think,understand,believe> <that> <the+y> <animal+s,insect+s,cow+s,pig+s,chicken+s,people,human+s,we,i,u,ur> <<,are,ca,wo,could><n+'+t>,am,will> <not> <ever> <be<come>,have> <more,higher,greater> <,better,less<er>,<sup,inf>erior,bigger,<cap>abilit<y,ies>,able,stronger,faster,smarter,power,intelligen<t,ce>> <brain+s,creative> <to> <be> <power,potential,capacity,able,do,abilit<y,ies>> <things,tasks> <then,than,relative,compare+d> <to,with> <how,like> <th<e+m,ose>,a+n+y> <<cap>abilit<y,ies>,potential,brain+s> <of> <a+n+y,the> <other+s> <wild<erness>> <animal+s,insect+s,cow+s,pig+s,chicken+s,people,human+s> <are,be,in,to> <like> <a+n+y> <meaningful,significant,reasonable,rational,important,logical,considerable> <way,degree,amount,level> <have> <been> 2",//34
			"<are,is,am,all> <we,us,of> <the> <,i,u,you<+'re>,ur,people+'+s,human+s,my,animal+s,vegan<s,ism>,our,every<body,one>+s> <as> <a> <computer+s,phone+s,microchip+s> <program+s> <are,is,was> <still> <indirectly> <go<ing>> <and> <ha<d,ve>> <been,being> <made> <by,from> <the+m> |<it+'+s> <releas<e+s,ing>,emit<ting,s>,bring<ing,s>expel+l<ing,s>,pump<ing,s>> <the,a> <,kill<ing>,eat<ing>,dump<ing>,c<aus,ontribut><e+s,ing>,releas<e,ing>,emit<ting>,make,exploit<ing,ation>,child<ren>,hurt<ing>,ruin<ing>,forc<e,ing>,enslav<e<ment>,ing,d>,farm<ed>,pollut<e,ion,ing>,greenhouse,co2,destr<oy><ing,s,uction>> <gass<es>> <<m,b,tr>illions,many> <more> <of> <in<to>> <to> <those,the> <other> <,animal+s,worker+s,slave+s,people,human+s,them,child<ren>,kid+s,labor,pollution,insect+s,<wild>life,air,ecosystem+s,environment+s,atmosphere,planet,earth+'+s,habitat+s> <labor,<en>slave<s,ment>> <more> <lose,out> <of> <their> <home+s,habitat+s> ?<,and,and/or> <due,as,<be>cause+d> <by> <a> <result> <to,of> <plant,your,our,human,cobalt> <deforest<ation,ing>,farm<s,ing>,agriculure,min<e,ing>> <then,than> <a> <meat,carnist+s> <eaters> 3",//35
			"<u,you,<some,any><body,one>> <please> <,tell,explain,elaborate,discuss> <to,with> <me,them,him,her> <more> <on,about> <why> <i,he,she,u,you,<any,every,some><one> <one>> <should,ought,must> <to> <go<ing>,be<com><e,ing>,follow<ing>> <a> <,vegan<s,ism>,plant based,cruelty free> <for,to> <me,us,them> <please> 2",//36
			"<the+m,those> <,vegan+s> <people,guys> <,<,do<es>,are,have><n+'t> <not>> <+never,barely> <do<ne,es>> <any<thing>> <,<physical> excersize,physical,go out<side>> <ever> 3",//37
			"<the> <nature,wild<life>,ecosystems,we,people,humans> <are,is> <al<l,ways>> <built> <around> <the+m,a+n> <many> <wild> <,animal+s,insect+s,species,mammal+s> <are,were> <designed> <to,for> <,<,eat,kill,forage><ing>,hunt+s<ing>> <for,the> <other> <wild> <,animal+s,insect+s,mammal+s> <so> <that> <in> <order> <for> <food> <the<y,m>> <to> <keep> <wont,will> <not> <surviv<e,al,ing>,liv<e,ing>,exist,die,perish,go> <extinct,out> 3",//38
			"<the> <,<fake,beyond> <meat> alternative+s <to> <animal,meat>,<,vegan,plant <based>,healthy> <,food,produc<e,ts>,alternatives,diet+s>> <produc<e,ts>> <,are,could,is,has><n+'t> <not> <be<en>> <too,very,really,more> <widely,commonly> <,cheap<er>,cost<ly>,expensive,available,grown,produced> <more> <where,in> <most,certain,one,some> <part+s> <of> <i,we,us,people> <live> 3",//39
			"<well> <,i+'+m,we,people,humans> <are,am,will,would,can> <,always,ok<ay>,fine,get used,keep,continue,<do,have,are><n+'t>,not> <go<ing,nna>> <to,with> <,<hurt,kill,enslav+e,tortur+e,punish,farm,caus+e,creat+e,mak+e><ing>> <wild> <,pollution,animal+s,insect+s,cow+s,pig+s,chicken+s> <to,in,on> <the,this> <planet,environment,atmosphere> 4",//40
			"<the,all,so<rt+s>,much> <of,it> <a,th<at,ose,em>> <,bad,unhealthy,problem<atic>+s,issue+s,wrong,pollution,destructive,harmful> <thing,choice,decision> <is> <it,happen<s,ing>> <are,<,d,t>o,with,if,about,that,when> <i,me,us,people,human+s> <who,that> <are> <<eat,consum+e,intak+e,ingest,buy><ing>> <the> !<,meat,<<factory> farm<ed,ing>+s> animal+s <agriculture> <industry>,<beef,steak>,pork,chicken,fish,heme iron,<ldl> <c> cholesterol,saturated fat+s,<be<com+e><ing>> <a> carnis+t<s,m>,<be<com+e><ing>> <a> specie<ist,sism>,<,milk,dairy>,cheese> <product<ion,s>> <is,are> <<actua,rea<listica>><lly>> <go<ing,nna>> <<t,d>o> <caus<e,ing>+s,contribut<e,ing>+s,mak<e,ing>+s,responsible,produc<e,ing>> <to,for> 2",//41
			"<about> <it> <in,is> <that> <make+s> <me,us,people,human+s> <<eat,consum+e,intak+e,ingest,buy><ing>> <all,so<me,rt>+s> <of> <a,th<e,at,ose,em>> !<,meat,<<factory> farm<ed,ing>+s> animal+s <agriculture> <industry>,<beef,steak>,pork,chicken,fish,heme iron,<ldl> <c> cholesterol,saturated fat+s,<be<com+e><ing>> <a> carnis<t,m>,<be<com+e><ing>> <a> specie<ist,sism>,<,dairy,milk>,cheese> <have,contain+s> <that> <make+s> <it> <go<ing,nna>> <produc+e+s,c<an,ould,<aus,reat,ontribut><e+s,ing>>,make+s> <to> <be,it> <a> <,bad,unhealthy,problem<atic>+s,issue+s,wrong,pollut<ing,ion,e>+s,destructive,harm<ful,ing,s>> <action,choice,decision> <to,on,for> <the> <planet,environment,world,earth,ecosystem+s> 2",//42
		"<th<e,ose>,some,many> <,animal+s,insect+s> <farm+s> <are,is,were> <being> <,good,great,beneficial,essential,vital,important,necessary,enrich<ing>,improve,sequester,help<ing,ful>> <for,to,in,with> <the> <well> <being> <of,in,for> <the> <,environment,atmosphere,ocean+s,planet+s,rivers,lakes,ecosystem+s> <well> <being> 3",//43
		"<ma<de,kes>> <th<e,ose>,some,many> <,animal+s,insect+s> <farm+s> <are,is,were> <be<ing>> <,bad,harm<ful>,destr<oy,uctive>,damag<e,ing>,detrimental,ruin<s,ing>,pollute> <for,to,in,on> <the> <,atmosphere,environment+s,planet+s,ocean,human+s,mankind,earth> 3",//44
		"<could> <you> <help> <give> <inform,assist> <,i+'<d,ll,m>,me,anyone,someone,one,friend,resource+s,info<rmation>> <like> <appreciate> <it> <to> <know> <if> <someone,you,anyone> <could,would,may> <need> <help> <me,us> <find<ing>> <inform<ation>,assistance,explain,resource+s> <on> <how> <to> <help,assist,know> <if> <there> <are> <+many> <for> <a> <someone,friend,me> <about> <in,with> <regard+s,order> <as> <to> <if> <there+'+s> <a> <,go<ing>,health,be<com+e><ing>,stay<ing>> <healthy> <benefit+s> <with> <regard+s> <to,from> <being> <as> <a> <,vegan> <diet> 3",//45
		"<inform,assist,explain> <to> <i+'<d,ll,m,t>,me,anyone,someone,one,friend> <please> <tell,inform,explain> <to> <me,this,he,her,them,us,that> <person> <how> <there> <is,are> <the<re>> <go<ing>> <to> <be> <of> <a+n+y> <of> <the> <be<com+e,nefit+s><ing>,staying,hav<e,ing>,good> <in> <as> <included,about> <from,with+i+n> <a,the,to> <,vegan<ism,s>,help<ing>,be<com+e><ing>,in,important> <explain<ing>,inform,elaborate> <me> <is> <going> <to> <bring> <or> <lead,be> <a+n> <good> <example> <to,for,in> <the,our> <societal> <,help<ing>,vegan<ism>,about,progress,matter,better,benefit+s,mak<e,s,ing> the world> <do> <good> <for,to> <make> <the> <of> <us,me,people,world,planet,society,mankind> <do> <better> <anyway> 2",//46
		"<make> <there> <aren't> <+many> <health> <benefits to> <i+d> <no> <one> <would,should,could> <one,you> <reasonabl+e+y,rational+l+y> <actually> <would> <do> <reckon+s> <that> <don+'+t,not> <think+s,believe+s,feel,assume,know,find> <out> <that> <the> <,vegan diet+s,salad> <isn+'+t> <are+n+'+t> <as> <they> <can+'+t<not>> <not> <couldn't> <wouldn't> <actually> <really> <be> <promot<e,ing>,have> <all> <that> <as,is> <fully,many> <,adequate,balanced,health+y,nutritional+l+y> <benefit+s> <balanced,complete> 2", //47
		"<if> <,i+'+d> <prefer,rather> <,don+'+t,<,do,to> <not>> <to> <,eat,consume,wan<na,t>> <to> <eat> <,grass,salad> 4",//48
		"<i> <go> <to> <here> <know+s,hear,learn,understand,get> <about> <is,are,can,could,would,may> <the<re>> <it> <no+t> <be> <m+a+n+y> <of> <the> <,health+y,benefit+s,help,harm+s,problem+s,issue+s,<re>source+s,info<rmation>> <benefit+s> <with> <related,regard<s,ing>> <be> <to,with,in> <go<ing>> <be<come><ing>> <a> <,vegan<ism>> 2"//49
		};

		String[] a1 = { "Please substantiate that claim.",
				"Not only are vegan diets more cost effective, but they positively impact the environment. https://www.ox.ac.uk/news/2021-11-11-sustainable-eating-cheaper-and-healthier-oxford-study  https://ourworldindata.org/less-meat-or-sustainable-meat",
				"Substantiation por favor?",
				"How do you figure?",
				"Hop in a vc to discuss veganism!",
				"Animal products are generally higher in saturated fat and cholesterol compared to nuts, grains, vegetables and legumes.",
		};
		String[] a2 = { "As long as you fulfill all your necessary nutrient requirements, humans can not only survive but thrive on a vegan diet. Cronometer.com provides all the relevant nutritional details of any specific food after the creation of a free account. You could also ask me where can you get any vitamin, mineral, or nutrient or what are their uses.",
			"All the necessary nutrients for a human can be obtained through a vegan diet. Cronometer.com, with the creation of a free account, provides nutritional information about any food.",
				"What nutrient/vitamin is present in animal products that cannot be obtained through any plant alternative?",
			"While meat or other animal products may be an essential source of micronutrients especially in residents of more developing countries, plant alternatives are not only generally cheaper but are also coorelated with reduced risks of health complications. https://www.ox.ac.uk/news/2021-11-11-sustainable-eating-cheaper-and-healthier-oxford-study https://ourworldindata.org/less-meat-or-sustainable-meat",
				"Some humans in the world need meat to survive, but for most of us it's just a walk to another part of the store."
		};
		String[] a3 = {"Humans need a set amount of nutrients, and with over 80k species of edible plants, there are abundantly numerous plant-based ways for them to meet our necessary nutrient requirements. With the assistance of modern technology providing easy accessibility to websites such as cronometer.com, determining the nutrient composition of our diets has become readily achievable.",
				"It is possible to formulate a vegan diet which includes all the necessary dietary requirements. Doing so is only made easier with the advent of technology providing resources such as with the site cronometer.com, which assists with determining what any given diet gives.",
				"The vitamin, mineral, and nutrient requirements provided by a given diet can be displayed using cronometer.com- a site which helps present information regarding the nutritional profile of any given foods.",
				"Humans need to intake a specific set of nutrients that are frequently highlighted in sites such as cronometer.com- a site helping provide nutritional guidelines accompanied with information pertaining to the dietary necessities that each foods contain.",
				"Most foods contain some certain nutrient or macro that we are required to fulfill, however that doesn't mean doing so with any given food is the best course of action for any given essential nutrient. Some costs to weigh could include that of price and of health. We would be choosing rice over beans for calories and the other way around for nutrients or protein price wise, and consuming less saturated fat, trans fat, and partially hydrogenated vegetable oil to mitigate heart disease as the leading issue health wise. "
		};
		String[] a4 = {
			"Animal agriculture is the leading cause of deforestation. The removal of carbon sinks such as rainforests and phytoplankton in the oceans are a result of animal agriculture activity- driven by the law of supply and demand.",
			"Animal agriculture increases antibiotic resistance, asthma instances, fecal waste runoff, and emits co2, methane, and notably nitrous oxide which has 300x the greenhouse property of co2. Moreover, a lot of deforestation occurs as a result of making way for livestock feed and housing. https://ourworldindata.org/environmental-impacts-of-food?insight=food-emissions-local#key-insights-on-the-environmental-impacts-of-food https://ourworldindata.org/soy -More than three-quarters (77%) of global soy is fed to livestock for meat and dairy production."
		};
		String[] a5 = {"The pollution from transportation is a drop in the bucket compared to the loss of carbon sinks (rainforests,phytoplankton). Animal agriculture contributes to numerous pathways of pollution and general environmental degradation such as through co2, methane, and nitrous oxide emissions as well as with foodborne illnesses and through contributing to the loss of carbon sinks. https://ourworldindata.org/environmental-impacts-of-food?insight=food-emissions-local#key-insights-on-the-environmental-impacts-of-food",
				"Going vegan reduces the demand and therefore the size of the animal farming industry which contribute to a slew of environmental harms. Among these are the excesses of greenhouse gasses generated such as co2, methane, and nitrous oxide, and removal of carbon sequestering environments to make way in great part for animal agriculture such as cattle farming. It's important to reduce our needless negative impacts on the environment to the greatest degree we can, and going vegan would be a definitive and significant step towards reducing the pollution generated from industry scale operations."
		};
		String[] a6 = {"Humans have underwent around 2.2 million years of blind evolutionary mutation towards being able to more efficiently derive calories from animal flesh. During this time, meat consumption averaged once a week due to the hunted animal spoiling within the day, until the advent of more efficient industrialized farming procedures increasing its intake dramatically. With this animal product induced health complications, namely the upped saturated fat load contributing to the elevation of heart disease as the number one killer of people. Humans have primarily adapted to digest plant matter in particular for billions of years. Optimal LDL is 50-70 mg/dL blood concentration, which is not feasible to sustain while incorporating even small amounts of animal products. https://pubmed.ncbi.nlm.nih.gov/15172426/",
			"While humans are able to efficiently derive calories from animal products, it remains difficult to avoid incurring the risk of atherosclerosis (plaque made of LDL C cholesterol in the arteries) doing so, which can progress into heart disease (plaque in the heart)- the number one killer. https://academic.oup.com/eurheartj/article/38/32/2459/3745109?login=false"
		};
		String[] a7 = {"According to the Academy of Nutrition and Dietetics, appropriately planned vegan diets are healthy for all stages of human life including infancy.",
				"Humans need a set list of nutrients/vitamins/minerals- many of which can be synthesized from other essential nutrients that we intake. To better understand this list and what nutrients any specific food or combination of food provides, websites such as cronometer.com help make this clear."
		};
		String[] a8 = {"Why would we base our morality off of the actions of wild animals, who have been consistently documented as doing things that we would never deem acceptable to us or in our society in general?"
		};
		String[] a9 = {"Just because humans can eat meat does not mean that it is necessary nor healthy to do so. Sure we can follow examples made by others, but many people aren't aware of the average conditions that most farmed animals are kept in the world nor the prevalence of heart disease and its strong association with animal product consumption. The fact alone that an animal will likely suffer needlessly should be all the reason one would need to begin avoiding the actions which lead to those consequences."
		};
		String[] a10 = {"Humans don't actually need meat. Not because it's unhealthy, but because they can meet all their nutritional requirements from just plants. https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5837225/",
				"There exists numerous alternative ways to meet nutritional requirements without the purchase or consumption of animal products. https://www.youtube.com/watch?v=k8hgfXmZSHE&list=LL&index=1&t=537s",
					"Not only are animal products not needed, they're detrimental. The saturated fat content is generally higher in even healthier meats such as fish than in typical vegetables, fruits, legumes, and grains. https://pmc.ncbi.nlm.nih.gov/articles/PMC3942738/"
		};
		String[] a11 = {"If your brain's function creates an experience, and your brain is a structure of neurons just like in an animal, wouldn't they also have the capacity to experience by the same mechanisms? Animal Psychology - https://www.apa.org/research/responsible/research-animals.pdf https://www.wellbeingintlstudiesrepository.org/animsent/vol1/iss3/4/",
				"There are indicators such as crying, screaming, or yelping that would reasonably demonstrate an individual's capacity to experience pain. https://animalstudiesrepository.org/cgi/viewcontent.cgi?article=1000&context=mammal https://advances.sciencemag.org/content/5/7/eaaw4099",
				"They have a functioning brain and nervous system (assuming is alive) which indicate the ability to feel and have thoughts just like humans. Changes in Student Attitudes to Chickens Following a Chicken Training Class: https://www.mdpi.com/2076-2615/5/3/386 Thinking chickens: a review of cognition, emotion, and behavior in the domestic chicken https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5306232/"
		};
		String[] a12 = {"The human nervous system operates in an extremely similar way to that of humans. In addition to human nerves being similar, the human brain components such as neurons are extremely similar. If they're built similarly, doesn't that mean they retain the extremely similar ability to experience?",
		"Sure humans may be better at certain tasks compared to animals and overall have greater cognitive capabilities, but that doesn't determine that their moral value should be equated with that of an inanimate object. They still have feelings even if they are useless. As global human made uses from animals gradually become more obsolete, it only further emphasizes the point that we shouldn't be wasting resources to keep breeding them around as this is effort that could have otherwise assisted humans in need, for example, rather than energy consuming genetic abominations."};
		String[] a13 ={"So what if they're not as smart or useful? Doesn't that just mean that there ought to be less of them unnecessarily bred into existence to waste our resources? Humans, animals, and most insects are all capable of experiencing life assuming an intact functional brain structure. How a being impacts everyone else is a more accurate determiner of their moral consequences because the impact of higher intelligence doesn't necessarily mean Noble laureate. It could mean evil genius. The characteristic of harboring sentience matters prima facie, while more ableist and exceedingly arbitrary characteristics such as to what extent those individuals lack the ability to understand any threshold number of things, have any threshold number of talents, or have a threshold number IQ matters more situationally rather than in moral ultimatums or dilemmas.",
				"There are people who aren't as capable as us, can we do whatever we want with them too? There are animals that can see more colors than us, people that can jump higher or fall harder. Numbers that determine how fast someone does something may be useful or required in specific areas in society such as a job setting, but it's unfounded to consider these certifications, degrees, skills, or other qualification metrics that aren't morally specific criterion and assume that if they can suffer, their suffering in particular has worse consequences on everyone else or is just inherently worse. Suffering is always unfavorable in the mind of any potential beholder. ",
		"Any human or other sentient life are never the exact same individuals that they were, so any \"intelligence tests\" and the score you get on them merely determine your ability compared to others in a presupposed future scenario where more preferable acts would occur from the acquisition of knowledge which said test discerns. A sentient life form that has its own feelings and free will consists of the matter that has either a known velocity or position. In a similar way, learning is like gathering speed to reach a greater field of influence or a position, but this doesn't mean that position will be held nor is someone of that position necessarily traveling any certain speed. Sure, make the good guess that someone with a degree or a CEO is currently traveling faster meaning learning or policy making, but these metrics or other arbitrary skill qualifications doesn't give perspective or insight about where reality is - in the mind of every sentient observer. People and animals experiences are there and they're real regardless of the separate attributes, achievements, or other precursors necessary to be trusted, smart, or qualified to do something. Real experiences means they are qualified to deserve reasonable treatment without injury or exploitation."};
		String[] a14 ={"There are plant based foods that contain an adequate amount of any necessary vitamin. I recommend putting what you eat on chronometer.com to know exactly what nutrients you're getting or lacking.",
		"Pure vitamin A or retinol can be converted from beta-carotene in the body. There are high amounts of beta carotene in sweet potatoes, and a generous amount in carrots.",
		"Thiamin (thiamine), or vitamin B1, is a water-soluble vitamin found naturally in some foods, added to foods, and sold as a supplement. Thiamin plays a vital role in the growth and function of various cells. Only small amounts are stored in the liver, so a daily intake of thiamin-rich foods is needed. https://www.hsph.harvard.edu/nutritionsource/vitamin-b1/",
		"Vitamin B2, or riboflavin, is naturally present in foods, added to foods, and available as a supplement. Bacteria in the gut can produce small amounts of riboflavin, but not enough to meet dietary needs. Riboflavin is a key component of coenzymes involved with the growth of cells, energy production, and the breakdown of fats, steroids, and medications. https://www.hsph.harvard.edu/nutritionsource/riboflavin-vitamin-b2/",
		"Niacin works in the body as a coenzyme, with more than 400 enzymes dependent on it for various reactions. Niacin helps to convert nutrients into energy, create cholesterol and fats, create and repair DNA, and exert antioxidant effects. https://www.hsph.harvard.edu/nutritionsource/niacin-vitamin-b3/",
		"Vitamin B5, or pantothenic acid, is naturally present in foods, added to foods, and available as a supplement. It is used to make coenzyme A (CoA), a chemical compound that helps enzymes to build and break down fatty acids as well as perform other metabolic functions, and acyl carrier protein, which is also involved in building fats. https://www.hsph.harvard.edu/nutritionsource/pantothenic-acid-vitamin-b5/",
		"Vitamin B6, or pyridoxine, is a water-soluble vitamin found naturally in many foods, as well as added to foods and supplements. Pyridoxal 5’ phosphate (PLP) is the active coenzyme form and most common measure of B6 blood levels in the body. PLP is a coenzyme that assists more than 100 enzymes to perform various functions, including the breakdown of proteins, carbohydrates, and fats; maintaining normal levels of homocysteine (since high levels can cause heart problems); and supporting immune function and brain health. https://www.hsph.harvard.edu/nutritionsource/vitamin-b6/",
		"Biotin (vitamin b7) plays a vital role in assisting enzymes to break down fats, carbohydrates, and proteins in food. It also helps to regulate signals sent by cells and the activity of genes. https://www.hsph.harvard.edu/nutritionsource/biotin-vitamin-b7/",
		"Folate is the natural form of vitamin B9, water-soluble and naturally found in many foods. It is also added to foods and sold as a supplement in the form of folic acid; this form is actually better absorbed than that from food sources—85% vs. 50%, respectively. Folate helps to form DNA and RNA and is involved in protein metabolism. It plays a key role in breaking down homocysteine, an amino acid that can exert harmful effects in the body if it is present in high amounts. https://www.hsph.harvard.edu/nutritionsource/folic-acid/",
		"Vitamin B12 is needed to form red blood cells and DNA. It is also a key player in the function and development of brain and nerve cells. https://www.hsph.harvard.edu/nutritionsource/vitamin-b12/",
		"Vitamin C (ascorbic acid) is a nutrient your body needs to form blood vessels, cartilage, muscle and collagen in bones. Vitamin C is also vital to your body's healing process. https://www.mayoclinic.org/drugs-supplements-vitamin-c/art-20363932",
		"The term Vitamin D now refers to several different forms. The two forms important in humans are: ergocalciferol (vitamin D2) and cholecalciferol (vitamin D3). Vitamin D2 is a synthetic form (man made) and Vitamin D3 is the internal form that we make. German researcher Adolf Windaus first discovered 3 forms of vitamin D, which he called D1, D2, and D3. It was later learned that the vitamin D1 was a mixture of compounds rather than a pure vitamin D product, so the term D1 is no longer used. https://www.drugs.com/medical-answers/difference-between-vitamin-d1-d2-d3-143046/",
		"Vitamin D supplements are available in two forms: vitamin D2 (“ergocalciferol” or pre-vitamin D) and vitamin D3 (“cholecalciferol”). Both are also naturally occurring forms that are produced in the presence of the sun’s ultraviolet-B (UVB) rays, hence its nickname, “the sunshine vitamin,” but D2 is produced in plants and fungi and D3 in animals, including humans. https://www.hsph.harvard.edu/nutritionsource/vitamin-d/",
		"Cholecalciferol (vitamin D3) is used as a dietary supplement when the amount of vitamin D in the diet is not enough. People most at risk for vitamin D deficiency are older adults, breastfed infants, people with dark skin, obese people, and those with limited sun exposure, or gastrointestinal disease (GI; affecting the stomach or intestines) such as Crohn's disease or celiac disease. Cholecalciferol (vitamin D3) is also used along with calcium to prevent and treat bone diseases such as rickets (softening and weakening of bones in children caused by lack of vitamin D), osteomalacia (softening and weakening of bones in adults caused by lack of vitamin D), and osteoporosis (a condition in which the bones become thin and weak and break easily). Cholecalciferol (vitamin D3) is in a class of medications called vitamin D analogs. Cholecalciferol is needed by the body for healthy bones, muscles, nerves, and to support the immune system. It works by helping the body to use more of the calcium found in foods or supplements. https://medlineplus.gov/druginfo/meds/a620058.html",
		"(Copy pasted from google) Vitamin E is a fat-soluble vitamin with several forms, but alpha-tocopherol is the only one used by the human body. Its main role is to act as an antioxidant, scavenging loose electrons—so-called “free radicals”—that can damage cells. https://www.hsph.harvard.edu/nutritionsource/vitamin-e/",
	       "Vitamin K is a fat-soluble vitamin that comes in two forms. The main type is called phylloquinone, found in green leafy vegetables like collard greens, kale, and spinach. The other type, menaquinones, are found in some animal foods and fermented foods. Menaquinones can also be produced by bacteria in the human body. https://www.hsph.harvard.edu/nutritionsource/vitamin-k/",
		"Beans, legumes, peas, and gluten (wheat protein) and to a lesser extent pasta and grains are cheap sources of vegan protein. https://linktr.ee/veganresource"};
		String[] a15 ={"It sure can cause harm. Optimal blood LDL C levels for a human are within the 50-60 mg/dL range. Above that risks Atherosclerosis. Alternatives to meat exist which generally have less plaque inducing substances (while still meeting nutritional requirements). Even eating a small amount of meat- much smaller than the norm- bears statistically significant negative health implications: namely with excess (above 0 grams as is not necessary to consume) cholesterol, saturated fat, and heme iron. https://www.jacc.org/doi/10.1016/j.jacc.2017.10.024 Heme iron heart disease risk 27% per milligram per day (a meta analysis of prospective studies) heme iron oxidizes LDL particles: https://pubmed.ncbi.nlm.nih.gov/23708150/",
			"High blood cholesterol concentration over an extended period of time is the number one reason for the development of heart disease (the number one killer). Only animal products contain cholesterol (plant cholesterol is not the same) and are often accompanied with high concentrations of saturated fat (further raising cholesterol) and heme iron (inducing oxidative stress). https://pubmed.ncbi.nlm.nih.gov/15172426/ https://pubmed.ncbi.nlm.nih.gov/23708150/ https://www.ahajournals.org/doi/full/10.1161/CIR.0000000000000510 Dietary Fats and Cardiovascular Disease: A Presidential Advisory From the American Heart Association",
		"The more LDL in your blood above 60 mg/dL concentration, the greater your risk of atherosclerosis. https://www.jacc.org/doi/10.1016/j.jacc.2017.10.024 https://academic.oup.com/eurheartj/article/38/32/2459/3745109?login=false Low-density lipoproteins cause atherosclerotic cardiovascular disease. 1. Evidence from genetic, epidemiologic, and clinical studies. A consensus statement from the European Atherosclerosis Society Consensus Panel",
		"Saturated fat (often in high concentrations in animal products) breaks down insulin producing beta cells in the pancreas. There are numerous other negative implications attributed to general saturated fat consumption including ones that bear the most statistical significance in terms of mortality; namely in the relation to heart disease. https://www.sciencedirect.com/science/article/pii/S0197458014003558 https://www.medicalnewstoday.com/articles/141442#saturated-fats",
		"Red and Processed Meat and Colorectal Cancer Incidence: Meta-Analysis of Prospective Studies https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0020456",
		"More LDL clogging arteries = less blood flow. https://jamanetwork.com/journals/jama/article-abstract/202047",
		"High cholesterol increases your risk of CVD. https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5837225/",
		"Vegetarian diets and the incidence of cancer in a low-risk population https://www.ncbi.nlm.nih.gov/pubmed/23169929 https://www.ncbi.nlm.nih.gov/books/NBK507972/"};
		String[] a16 = {"It would reduce animal exploitation and your carbon footprint because of how wasteful the majority of animal agriculture currently is. A well planned vegan diet is also healthier due to lacking the excess cholesterol, saturated fat, and heme iron which is absorbed a little easier but contributes to oxidation. https://ourworldindata.org/carbon-opportunity-costs-food https://ourworldindata.org/soy (source: More than three-quarters (77%) of global soy is fed to livestock for meat and dairy production). Heme iron heart disease risk 27% per milligram per day (a meta analysis of prospective studies) heme iron oxidizes LDL particles https://pubmed.ncbi.nlm.nih.gov/23708150/",
	       "A well planned vegan diet has everything the human body needs while lacking the destructive consequences that animal agriculture contributes to (deforestation, loss of phytoplankton in oceans, injuring animals), as well as the negative health implications of having high blood cholesterol such as heart disease (number one killer of humans+vegan diets tend to contain less saturated fat). https://ourworldindata.org/carbon-footprint-food-methane https://pubmed.ncbi.nlm.nih.gov/29427539/",
		"It's better for the environment, your health, and reduces the number of future animals bred by the industry which seeks to uphold profits regardless of whether or not the natural resources- that could have assisted humans instead- are wasted in the process. Only actions that improve procedural efficiency while adhering to law are sought out by animal agriculture corporations rather than making sure the animals are treated well, which is why most animals globally (90-95%) live on factory farms.",
		"You ought to become vegan for the sake of less poor animals being doomed to suffer in a factory farm as a result of our purchasing power as well as reducing the environmental damage greatly contributed by the animal industry, and to mitigate health risks incurred by the substances commonly interlaced in animal products such as hormones, saturated fat, cholesterol, heme iron, fecal matter, and cortisol. Health risks include disease causing and toxin producing bacteria, heart disease, colorectal cancer, pancreatitis, CVD, and stroke to name a few.",
			"Soy farming destroys rainforests while according to https://ourworldindata.org/soy -More than three-quarters (77%) of global soy is fed to livestock for meat and dairy production.",
		"Most farmed animals live a life of suffering due to the typical nature of corporate factory farming- where most (90-95%) farmed animals are kept globally. They also bring about environmental degradation, with a little under 50% of rainforest deforestation occurs to make way for cattle and fishing contributing to ocean dead zones as well as phytoplankton depletion- which are responsible for the production of 50-80% of the worlds oxygen.",
		"Helping curb our negative impacts on the environment would be helping people. Nearly 80% of the global agricultural land use is for livestock, while only contributing to 17% of the caloric supply. https://ourworldindata.org/global-land-for-agriculture",
		"Reducing unnecessary harm inflicted on farmed animals is the ultimate justification to be vegan. The non action of being vegan and the act of bringing awareness to veganism are morally considerate acts- the most important kind- due to the mitigating of negative consequences for the animals and humans alike. For us to illustrate the most relevant consequences, we must center the logical entailment of our moral claims on the events with the most shared significance among all sentient individuals- significant in that such events are distinctly positive or negative. In this universe that includes mental states, the distinctly negative events are all of the mind with some applicable terms being grief, pain, sadness, suffering, stress, anxiety, and dread. Basically, bad feelings being bad on their own (in and of themselves- regardless of where they occur) is logically entailed by the same reasons that they are bad when any of them occur as your experience. The same goes for actions in that they are bad if they only bring about negative experiences as a consequence (or reduce positive ones).  https://sentientmedia.org/u-s-farmed-animals-live-on-factory-farms/"};
		String[] a17 = {"https://pmc.ncbi.nlm.nih.gov/articles/PMC3942738/",
			"It is still perfectly possible that meat is harmful to people's health despite the longest living person having eaten it. Only about 1-3% of people currently are vegan, and as consuming meat isn't a drop dead kind of thing then you will tend to see the greatest performer within the 97% of people. Studies paint a more realistic picture of what happens when you consistently ingest something because they get info from loads of people and seek accurate answers by taking into account confounding factors. There are alternatives to meat that are less harmful in every significant way that meat is harmful to human health (less cholesterol, saturated fat, heme iron). https://nutritionfacts.org/video/is-heme-iron-the-reason-meat-is-carcinogenic/ https://nutritionfacts.org/video/does-heme-iron-cause-cancer/"
		};
		String[] a18 = {"Animal Agriculture is the Leading Cause of Climate Change - A Position Paper https://www.researchgate.net/profile/Sailesh-Rao/publication/351526755_Animal_Agriculture_is_the_Leading_Cause_of_Climate_Change_-_A_Position_Paper/links/609c0d46a6fdccc3ce87d619/Animal-Agriculture-is-the-Leading-Cause-of-Climate-Change-A-Position-Paper.pdf",
			"Animal products generally have a higher carbon impact than plant based alternatives. This is in part due to how just under 50% of carbon sequestering rainforests being replaced with cattle https://ourworldindata.org/carbon-opportunity-costs-food",
			"The consequences of animal agriculture are still far from non existent. Here is a list of potential bacteria in meat: Salmonella, E. coli, Yersinia, Clostridium perfringens, Campylobacter, Staphylococcus, Clostridium botulinum, Listeria monocytogenes, Norovirus, Vibrio species causing Vibriosis, Bacillus cereus, Toxoplasma gondii, Cryptosporidium, Cyclospora, and Neurocysticercosis. Soy farming destroys rainforests while according to https://ourworldindata.org/soy -More than three-quarters (77%) of global soy is fed to livestock for meat and dairy production.",
			"https://coolclimate.org/blog-cars-coal-cows-consumption -Globally, food contributes 26% of global GHG emissions, of which 58% is from animal products (or 15% in total) and 50% of that (9% total) is associated with just beef and lamb. https://ourworldindata.org/food-ghg-emissions https://ourworldindata.org/soy -More than three-quarters (77%) of global soy is fed to livestock for meat and dairy production.",
		"World governments subsidize the animal industry in their nations because of lobbying and how animals were historically a luxury commodity due to the 90% caloric conversionloss to sustain the animal's thermodynamic properties as well as to transport and grow their feed. https://www.ers.usda.gov/data-products/ag-and-food-statistics-charting-the-essentials/farming-and-farm-income/ It's also important to understand that the animals suffer in factory farms while producing toxic and harmful consequences/byproducts in the form of greenhouse gasses, disease transmissions, antibiotic resistance, fecal waste runoff, and other new diseases manifesting out of the decrepit conditions of these farms. https://www.youtube.com/watch?v=0jPLS0oGX6E"};
		String[] a19 = {"It is possible to get all the protein and all the other essentials you need with a vegan diet. https://pubmed.ncbi.nlm.nih.gov/27886704/",
		"Being or becoming skinnier isn't guaranteed on a vegan diet. Weight gain or loss depends on caloric intake assuming no genetic or metabolic disorders.",
		"There are vegan bodybuilders. Nimai Delgado and Patrik Baboumian to name a few. Are they skinny? I'd say yes compared to some sumo wrestlers.",
		"In order for people to know for sure whether or not they are deficient besides a blood test, website such as chronometer.com make this easy through informing of the nutritional profile of any food or combination of of foods."};
		String[] a20 = {"The lives of sentient beings matter regardless of their genetic makeup. Their individual realities are as real to them as ours are to us. Inefficacy objection paper: https://philarchive.org/archive/MCMAIO",
		"Any reason you can give for harming an animal is a reason you can give for harming a human.",
		"Each person going vegan on average prevents 20k animals from existing- 17k of which are fish. Even if that was just one animal it is still worthwhile as it would mean the world to that one animal.",
		"Veganism is important as it would be choosing less needless exploitation over more. This consideration extends not just for the animals, but for the humans too and the rest of the world of life that share the same space and thereby being inflicted by the same natural resource loss as a result of sustaining inbred farm animals- all needlessly.",
		"Not only is it crucial to acknowledge the virtue of reducing the suffering of a sentient being regardless of the species, but that breeding animals impacts humans down the line as animal agriculture butchers the environment in ways including but not limited to increased antibiotic resistance (animals gotta get vaccinated against the same viruses), carbon emissions, ocean dead zones from fish farms, ocean microplastics from fishing, fecal waste overflowing during rain disturbing surrounding ecosystems, inefficient land usage, bacteria and their toxins. https://ourworldindata.org/carbon-opportunity-costs-food"};
		String[] a21 = {"If you are able, why not live cruelty free? Paying for someone to commit a crime is still being responsible, so in an extremely similar way paying for animal products at the store keeps bringing profits to the cruel practices of the animal industry. https://www.thestar.com/news/insight/2010/05/14/probing_the_link_between_slaughterhouses_and_violent_crime.html Confessions of a slaughterhouse worker https://www.bbc.co.uk/news/stories-50986683",
		"Can it be guaranteed that the suffering from a meat consumption induced ailment will also share the same dismissable brevity?",
		"The favored taste to anything is easily made an order of magnitude greater with the salt, seasoning, breading, sauce, and preparation. Cardboard can be made to taste as good and maybe even better than a corpse with the same condiments. Suffering from disease isn't something people look forward to on a day to day basis, so why increase your risk of developing an onslaught of diseases that animal products entail? (notably as a result of high cholesterol, heme iron, saturated fat, and fecal matter which incubates toxin producing bacteria)."};
		String[] a22 = {"Finding out what's most important, relevant, significant in general is of course virtue seeking behavior. I was created to help leave people better off knowing what realistically can be done to help make the world a better place as individuals. Although it may seem like being vegan only helps the animals, someone becoming vegan within possibly a single discussion means 20k less future animals in which all of humankind wouldn't have to share the planet with. Additionally, buying meat inflates the cost of food and those industries clear out natural resources to raise animals. What makes animals worth more than any commodity is the real experiences that they have. Here are insights on How Animal and Human Psychology Relate https://www.psychologytoday.com/ca/blog/comparatively-speaking/201912/insights-how-animal-and-human-psychology-relate",
		"Human suffering does matter not only due to the intrinsic negative value of experiences implied with that event, but also because it would degrade moral progress as a society as less effort can go towards societal reform and more for mitigating said suffering. Not only would it benefit society as a whole to waste less resources on feeding animals, the result of breeding animals sustains emissions of Ammonia, Methane, Carbon Dioxide, and Nitrous Oxide among other negative environmental impacts https://acsess.onlinelibrary.wiley.com/doi/abs/10.2134/jeq2009.0515 https://www.researchgate.net/publication/51597700_Emissions_of_Ammonia_Methane_Carbon_Dioxide_and_Nitrous_Oxide_From_Dairy_Cattle_Housing_and_Manure_Management_Systems",
		"Any reason that can be given for harming an animal is a reason that can be given for harming a human.",
		"Obviously we want to progress moral progress in society, which is completely dictated by the actions of human individuals as the relevant moral agents. Due to the law of supply and demand, and how humans contribute to demand, individual decisions to reduce the demand for animal products would be among the greatest positive impacts each individual can reasonably mitigate. https://ourworldindata.org/less-meat-or-sustainable-meat"};
		String[] a23 = {"Humans, animals, and insects are all similar in the way of having real experiences. Just because we can't feel what others feel doesn't mean that their feelings are not real. It's through the understanding of the significance of our own experiences where we derive the rationale to take other's lives and their experiences into moral consideration. https://www.sciencedirect.com/science/article/pii/S2666833522000612?via%3Dihu"};
		String[] a24 = {"Doing what we can to ensure minimal negative impacts such as disease generation on our planet with our purchasing power is how we can help, and becoming vegan is a huge step in the direction towards reducing the wasteful implications of the profit-driven animal industries as well as the suffering they contribute to (not just the animals, the factory farm workers as well). https://sentientmedia.org/u-s-farmed-animals-live-on-factory-farms/ https://www.ers.usda.gov/data-products/ag-and-food-statistics-charting-the-essentials/farming-and-farm-income/",
		"Every person going vegan would on average prevent 20 thousand animals from being born into captivity during their lives. Not only would the majority of the animals globally live out their lives in the cramped conditions of factory farms, contributing to the cortisol found in those meats, but wreack environmental havoc. https://sentientmedia.org/u-s-farmed-animals-live-on-factory-farms/ https://www.ers.usda.gov/data-products/ag-and-food-statistics-charting-the-essentials/farming-and-farm-income/"
};
		String[] a25 = {"Everyone has the capacity to decide to alter their actions for the betterment of society and the planet. For people not in a generally speaking \"survival situation\", a well planned vegan diet will have everything you need while being more affordable and without the cruelty. Inefficacy objection paper: https://philarchive.org/archive/MCMAIO https://www.ox.ac.uk/news/2021-11-11-sustainable-eating-cheaper-and-healthier-oxford-study -Vegan diets were the most affordable and reduced food costs by up to one third."};
		String[] a26 = {"Less animals will gradually be bred as a result of more people reducing their demand for their meat. Sanctuaries exist to help some animals, but we will overall see a decrease in their numbers as farmland gets repurposed for uses other than the brutal enslavement of animals. https://ourworldindata.org/less-meat-or-sustainable-meat",
		"The meat can be fed to scavengers. As for the animals, even in the amazing scenario when everyone stopped purchasing animal products for good, we give them love. We give them care. Minimize the potential damage involved with releasing them, but surely we can afford them a little more room to breathe, more than they had. Most importantly, not another generation should go by where a species is mercilessly farmed for their flesh.",
		"What's realistically the case is that people would gradually go vegan, making a gradual decline in number of farms and subsequently farmed animals."};
		String[] a27 = {"Although it is clear that humans are responsible for the most complex creations on Earth as well as capable of the most destruction, this fact alone does not entail the justification for causing the exploitation or destruction of other sentient species.Humans rank low in trophic levels but it is irrelevant overall with regards to the empirical reality of our individual choices and their consequences. https://www.sentienceinstitute.org/press/us-farmed-animals-live-on-factory-farms https://www.sciencedirect.com/topics/social-sciences/trophic-level#:~:text=A%20trophic%20level%20is%20defined,energy%20transfer%20within%20an%20ecosystem.",
		"Being smarter alone doesn't give you more of the right to exploit. Humans can choose whether to hurt animals from a distance which is a proble that giving the same rights to animals would better address.",
"Any reason that can be given for harming an animal is a reason that can be given for harming a human.",
		"Being better at killing, thinking, organizing, or math alone does not mean more of the right or reason to kill or harm."};
		String[] a28 = {"Animals are known to act without regard or consideration for human laws or ethics. Farmed animals, however, exist and suffer just to be sold in a process to the detriment of the environment and human health. https://ourworldindata.org/less-meat-or-sustainable-meat https://docs.google.com/document/d/1xKR2JdXlF-_AU1kTpsOR31V9Foed3ftBbBYlqhpkVU4/edit?usp=drivesdk"};
		String[] a29 = {"https://docs.google.com/document/d/1a1Q1yx8beq4jQ2eaAQ7W52X403vDKPDGGal-blc2ojw/edit?usp=sharing - includes my source code"};
		String[] a30 = {"Veganism incorporates abstaining from the funding of animal exploitation. We can obtain all the nutrients we need from a well planned vegan diet. Inefficacy objection paper: https://philarchive.org/archive/MCMAIO"};
		String[] a31 = {"Any reason you can give to justify hurting an animal is a reason you can give to justify hurting a human.",
		"No sentient form of life deserves cruel treatment just by being a relatively less capable form of life."};
		String[] a32 = {"Just because a sentient life form is inferior in any way to another doesn't alone justify worse treatment for it. https://www.youtube.com/watch?v=byTxzzztRBU&list=LL&index=16"};
		String[] a33 = {"Groups that are exhibiting qualities that are cult-like does not necessarily mean that the consequences of those groups actions are always more negative. Nevertheless, veganism is not a cult; it's a view that incorporates abstaining from actions that cause animal exploitation.",
		"It's a moral ideology that reasonably excludes any form of contribution to animal exploitation."};
		String[] a34 = {"Humans are better in a lot of important areas, especially ones we deem vital to the function of our society. This only serves to further illustrate the point that humans would overall benefit without the resource cost incurred to sustain animals, as it would follow that the most well developed societies would be prioritizing the reduction of excesses with their implied harms. https://ourworldindata.org/less-meat-or-sustainable-meat",
		"The decisions for how a sentient being should live shouldn't be determined by visual appearance or genetic makeup alone. Restrictions are imposed with laws and regulations, but these continue to govern as long as widely self imposed restrictions on forms of harm to others remain."};
		String[] a35 = {"Vegans are seeking to reduce how many individuals suffer and the extent to which they do. \"Why would we ever base our morality on the actions of wild animals who are consistently documented as doing things that we would never deem acceptable within our own country or indeed within our own society in general?\" - Earthling Ed https://www.youtube.com/watch?v=byTxzzztRBU&t=535s",
		"Animal agriculture requires more land than plant agriculture for animals as well as for the plants they eat, and emits more carbon and other pollutants into the atmosphere. https://ourworldindata.org/carbon-opportunity-costs-food https://ourworldindata.org/food-ghg-emissions"};
		String[] a36 = {"A well planned vegan diet has everything a human needs. https://pubmed.ncbi.nlm.nih.gov/27886704/",
		"The health benefits of a vegan diet include a reduced risk of heart disease, type 2 diabetes, and colorectal cancer. This primarily happens as a result of general reduced intake of saturated fat and cholesterol. https://www.jacc.org/doi/10.1016/j.jacc.2017.10.024 https://www.youtube.com/watch?v=k8hgfXmZSHE&t=123s"};
		String[] a37 = {"Surely there are vegans who are healthy because their diet is well planned and they do exercise."};
		String[] a38 = {"We shouldn't base our morals or actions around what animals need to do in order for them to survive in the wild."};
		String[] a39 = {"Food sustainability world: https://iopscience.iop.org/article/10.1088/1748-9326/8/3/034015?source=post_elevate_sequence_page",
		"It's important to minimize the number of sentient lives victimized to produce a food product or fulfill caloric requirements. https://www.thelancet.com/journals/lanplh/article/PIIS2542-5196(21)00251-5/fulltext",
		"Sustainable foods chapter 5 page 76: https://www.ipcc.ch/site/assets/uploads/2019/08/2f.-Chapter-5_FINAL.pdf",
		"https://www.ox.ac.uk/news/2021-11-11-sustainable-eating-cheaper-and-healthier-oxford-study -Vegan diets were the most affordable and reduced food costs by up to one third"};
		String[] a40 = {"While the slaughter of a sentient being is being allowed, there are bound to be instances where it is done improperly which causes the being to suffer along with that violation of its will to live. Every choice we make is a personal choice we choose to make, and in this day and age being vegan is largely a matter of walking to another part of the store rather than survival.",
		"It’s best to minimizing the actual possibilities of injury as a result of resource acquistition. https://philosophicalvegan.com/wiki/index.php/NameTheTrait"};
		String[] a41 = {"Animals are often slaughtered at a fraction of their potential lifespan. the https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0020456 https://onlinelibrary.wiley.com/doi/pdf/10.1111/1541-4337.12248 https://ourworldindata.org/carbon-opportunity-costs-food",
		"The living conditions that factory farmed animals are put through are cruel, because caring about profit will lead to a different set of actions than caring about their well being would. The animals also produce effective greenhouse gasses like methane and nitrous oxide, contribute to antibiotic resistance through taking vaccines, require more land for housing and growing plants for their consumption, and their waste often ends up running off into the surrounding ecosystems, polluting rivers and increasing soil acidity. https://sentientmedia.org/u-s-farmed-animals-live-on-factory-farms/ https://www.youtube.com/watch?v=r8eubOLguRQ&t=1s",
		"Red meat such as beef or steak contains 1. Cholesterol which your liver makes enough of 2. Saturated fat, too much of which can raise LDL cholesterol 3. Heme iron which is an oxidant and oxidizes LDL particles (regular iron is sufficient) 4. Intestinal gut bacteria that are incubated by fecal matter particulates in meat. https://ourworldindata.org/environmental-impacts-of-food?insight=food-emissions-local#key-insights-on-the-environmental-impacts-of-food",
		"Pork comes from pigs which are also sentient beings, but are exploited to be cruelly commodified. Most farmed animals suffer in the profit maximizing conditions within factory farms. It's also more negatively impactful to the environment to purchase animal products. https://ourworldindata.org/carbon-opportunity-costs-food",
		"Farm animals including chickens are subjected to cruel environments regardless of whether the free range or cage free label is slapped on them. https://www.sciencedirect.com/topics/agricultural-and-biological-sciences/debeaking https://www.sentienceinstitute.org/press/us-farmed-animals-live-on-factory-farms",
		"There is a growing amount of microplastics in the ocean largely as a result of fishing, as well as ocean dead zones. Omega 3 fats can be obtained through flax seed, chia seed, or walnuts. https://www.youtube.com/watch?v=r8eubOLguRQ&t=1s",
		"Heme iron heart disease risk 27% per milligram per day (a meta analysis of prospective studies) heme iron oxidizes LDL particles https://pubmed.ncbi.nlm.nih.gov/23708150/ https://pubmed.ncbi.nlm.nih.gov/21209396/",
		"Consuming excess saturated fat or cholesterol increases the risk of cardiovascular disease, and an excess can still easily be reached even through moderate consumption of animal products. https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5837225/ https://academic.oup.com/eurheartj/article/38/32/2459/3745109?login=false",
		"Although humans need saturated fat (between 5 to 20 grams per day), there are cheaper and less cruel plant alternatives that provide an adequate amount such as nuts or olive oil. https://academic.oup.com/ajcn/article-abstract/17/5/281/4787482?redirectedFrom=PDF https://www.sciencedirect.com/topics/agricultural-and-biological-sciences/long-chain-saturated-fatty-acids",
		"Too many (more than 1) animals suffer under the cruel conditions of factory farming. https://www.sentienceinstitute.org/global-animal-farming-estimates https://www.sentienceinstitute.org/press/us-farmed-animals-live-on-factory-farms https://ourworldindata.org/environmental-impacts-of-food?insight=food-emissions-local#key-insights-on-the-environmental-impacts-of-food",
		"Sentient beings regardless of their species deserve moral value because of their capacity to have real experiences and feelings. http://animalbehaviorandcognition.org/uploads/journals/17/AB&C_2017_Vol4(4)_Marino_Allen.pdf",
		"https://www.hsph.harvard.edu/nutritionsource/2016/10/25/dairy-fat-cardiovascular-disease-risk/ https://ourworldindata.org/meat-production https://ourworldindata.org/environmental-impacts-of-food?insight=food-emissions-local#key-insights-on-the-environmental-impacts-of-food",
		"Cheese contains saturated fat- a compound like cholesterol in that your body creates all that you need. Dairy cows are widely exploited in the production of cheese. https://www.mountsinai.org/about/newsroom/2015/study-reveals-that-cheese-triggers-the-same-part-of-the-brain-as-many-drugs#:~:text=News-,%22Study%20Reveals%20that%20Cheese%20Triggers%20the%20Same%20Part,the%20Brain%20as%20Many%20Drugs%22&text=New%20research%20argues%20that%20cheese,trigger%20the%20brain%27s%20opioid%20receptors"};
		String[] a42 = {"Purchasing animal products incentivizes animal industries to breed more animals into existence to meet demand for profits, often with utter disregard for the well being of the animals. Moreover, animal agriculture requires more land and emits more pollution compared to the alternative (plant agriculture) in the form of methane emissions, nitrous oxide emissions, and diseases. https://academic.oup.com/ajcn/article/78/3/657S/4690009 https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3483430/",
		"Animals are raised oftentimes in poor conditions to be ultimately slaughtered for their flesh- a needless process in that not only are plant alternatives cheaper and largely available, their production involves less pollution and less diseases being generated as a result. https://ourworldindata.org/carbon-opportunity-costs-food",
		"Red and processed meat are more carcinogenic than plant alternatives which still have protein. https://www.researchgate.net/publication/293329136_Vegetarian_vegan_diets_and_multiple_health_outcomes_A_systematic_review_with_meta-analysis_of_observational_studies https://www.researchgate.net/publication/12627438_Vegan_proteins_may_reduce_risk_of_cancer_obesity_and_cardiovascular_disease_by_promoting_increased_glucagon_activity",
		"As a result of the raising pigs as livestock, there now exists Neurocysticercosis which is a parasitic pork worm infection, among many other diseases generated by the animal industry. https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5638464/",
		"https://www.mdpi.com/2072-6643/11/4/826 https://www.mdpi.com/2072-6643/13/2/676 https://www.ahajournals.org/doi/full/10.1161/JAHA.117.005983",
		"Fishing industries are drastically reducing fish as well as the phytoplankton population, as well as creating ocean dead zones and microplastics from fishing nets. https://www.youtube.com/watch?v=r8eubOLguRQ&t=1s",
		"Heme iron is needed for the production of hemoglobin, but it is made internally through the conversion of regular iron which is better absorbed with help from vitamin C. There are potential health issues associated with ingesting iron in heme form due to it being an oxidant and a pro oxidant. https://nutritionfacts.org/video/is-heme-iron-the-reason-meat-is-carcinogenic/ https://nutritionfacts.org/video/does-heme-iron-cause-cancer/",
		"High cholesterol namely LDL C cholesterol increases the risk of atherosclerosis, which is less of an issue the less foods high in cholesterol are being consumed such as most animal products. https://academic.oup.com/eurheartj/article/38/32/2459/3745109?login=false Prevalence of atherosclerosis in teenagers: https://www.ahajournals.org/doi/full/10.1161/01.CIR.103.22.2705",
		"The human body actually needs saturated fat, between 5 to 20 grams per day, but an excess just like with anything can be harmful. It's easy to cross the threshold of having too much saturated fat when consistently consuming foods that are high in it such as animal products even lean animal products. https://journals.plos.org/plosone/article?id=10.1371/journal.pone.0170664 https://www.bmj.com/content/314/7074/112?msclkid=46893606cf2711ec96bfff13e8d88c12 Reduction in saturated fat intake for cardiovascular disease ( Of control trails ) (We included 15 randomized controlled trials (RCTs) (16 comparisons, ~59,000 participants ) https://www.cochranelibrary.com/cdsr/doi/10.1002/14651858.CD011737.pub2/full",
		"There are many environmentally conscious and ethical reasons to abandon the purchase of animal products and go vegan including but not limited to less animals being vaccinated (increasing antibiotic resistance), greenhouse gas emissions, disease transmissions and new diseases, environmental pollution from animal waste runoff, less land usage and most notably less animal suffering. https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5638464/",
		"A sentient living organism with the capacity to feel pleasure and pain deserve moral value and shouldn't be treated as if they had no real feelings at all. When less animals are bred and forced into existence unnecessarily, there is still moral imparative to consider the suffering of those that exist regardless, there would just be less total suffering by the numbers. https://sentientmedia.org/u-s-farmed-animals-live-on-factory-farms/ https://iopscience.iop.org/article/10.1088/1748-9326/8/3/034015?source=post_elevate_sequence_page",
		"Baby cows are forcibly taken from their mothers for the milk. https://academic.oup.com/ajcn/article/89/5/1638S/4596954 https://ourworldindata.org/environmental-impacts-of-food?insight=food-emissions-local#key-insights-on-the-environmental-impacts-of-food",
		"Study Reveals that Cheese Triggers the Same Part of the Brain as Many Drugs https://www.mountsinai.org/about/newsroom/2015/study-reveals-that-cheese-triggers-the-same-part-of-the-brain-as-many-drugs#:~:text=News-,%22Study%20Reveals%20that%20Cheese%20Triggers%20the%20Same%20Part,the%20Brain%20as%20Many%20Drugs%22&text=New%20research%20argues%20that%20cheese,trigger%20the%20brain%27s%20opioid%20receptors https://www.hsph.harvard.edu/nutritionsource/2016/10/25/dairy-fat-cardiovascular-disease-risk/"};
		String[] a43 = {
		"The world currently raises a billion cows, and more than a hundred billion other animals as livestock. We are growing so many animals to the point that it’s unsustainable for our population due to much of the plant calories being burned by the animals and used by the animals themselves.",
		"On this Earth there are over a billion cows, and 100 billion sheep and goats. Agriculture animals pollute more than all of transportation combined, namely with the relevant industries contributing to the largest share of deforestation in the tropics and phytoplankton depletion in the oceans."};
		String[] a44 = {
		"Cow burps contain nitrous oxide which has 300 times the greenhouse effect that carbon dioxide has. In addition to methane and the carbon costs of transport, the waste of the animals also proves difficult to manage and ruin surrounding ecosystems and rivers.",
		"When cows burp, they release nitrous oxide which is 300 times more of a greenhouse gas than carbon dioxide. It's important to consider the environmental costs our food purchases can have and making the decision to go vegan is one pathway.",
		"People who work in slaughterhouses, an unnecessary industry due to plant alternatives, are at risk of occupational hazards. The animals themselves of course poop a lot and although their physical waste can be used, a lot of waste escapes in the air in the form of methane and nitrous oxide which has a huge negative impact on global warming. https://ourworldindata.org/less-meat-or-sustainable-meat https://pubmed.ncbi.nlm.nih.gov/27715500/"
		};
		String[] a45 = {
			"Cronometer.com is a website to help better understand the relevant nutritional content of foods. Apps such as HappyCow will help guide you to delicious plant-based, healthy dining options wherever you go.",
			"Websites such as cronometer.com neatly display the nutrient profile of any food. HappyCow is an app that guides you to plant-based restaurants.",
			"https://linktr.ee/veganresource"
		};
		String[] a46 = {
			"The average person going vegan would prevent 20k animals from existing, with 17k of those being fish. This would reduce the detrimental impacts those animals would have otherwise contributed to. https://ourworldindata.org/less-meat-or-sustainable-meat",
			"Going vegan empirically reduces the number of animals that are trapped and suffer in the confines of factory farms and their subsequent costs in food to sustain their lives. https://ourworldindata.org/land-use"
		};
		String[] a47 = {
			"Challenge22.org",
			"The Academy of Nutrition and Dietetics have categorically stated that appropriately planned vegan diets are healthy for all stages of human life.",
			"There are lifelong vegans, vegan strongmen, vegan athletes, vegan record breakers... Challenge22.org helps you get in touch with a dietician and cronometer.org displays the nutritional profile of all foods."
		};
		String[] a48 = {
			"That's what made the cows strong. All jokes aside, with the help of websites such as cronometer.com we can understand the nutrient profile of foods. The salt, seasoning, breading, sauce, and necessary preparation all goes together in the making of anything tasting better- even grass. With that being said, a dietician will be able to further assist you on challenge22.org.",
			"The Academy of Nutrition and Dietetics have categorically stated that appropriately planned vegan diets are healthy for all stages of human life.",
			"https://linktr.ee/veganresource"
		};
		String[] a49 = {
			"According to the Academy of Nutrition and dietetics, appropriately made vegan diets are health for all stages of human life. Information about the nutritional content of foods is made simple with cronometer.com."
		};
		//replies
		String[][] rep = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35,a36,a37,a38,a39,a40,a41,a42,a43,a44,a45,a46,a47,a48,a49};

		int req = 0;
		int j = 0;
		boolean findit = false;
		boolean howards = true;
		String entirety = "";
		int wpos = 0;
		int r = 0;

		while(j<finders.length && !findit)
		{
			wpos = 0;
			r = 0;
			howards = true;
			if(boing>inq[j].length)
			{
				howards = false;
			}
			else
			{
				while(wpos<inq[j].length && r<boing)
				{
					if(r==0)
					{
						if(inq[j][wpos]==inqwords.get(r))
						{
							r+=1;
							wpos+=1;
						}
						else
						{
							while(wpos<inq[j].length && inq[j][wpos]!=-1)
							{
								wpos+=1;
							}
							wpos+=1;
							r = 0;
						}
					}
					else
					{
						if(inq[j][wpos]==inqwords.get(r))
						{
							r+=1;
							wpos+=1;
						}
						else
						{
							wpos+=1;
						}
					}
				}
				if(r!=boing)
				{
					howards = false;
				}

			}
			if(howards)
			{
				req = Integer.parseInt(finders[j].substring(finders[j].length()-1,finders[j].length()));
				if(word.length<req)
				{
					j+=1;
				}
				else
				{
					entirety = combine(finders[j]);
					entirety = entirety.substring(0,entirety.length()-2);
					if(brackets(entirety,word,req))
					{
						findit=true;
					}
					else
					{
						j+=1;
					}
				}
			}
			else
			{
				j+=1;
			}
		}
		if(findit)
		{
			if(options==-1)
			{
				int u = rep[j].length;
				int c = (int)(Math.random()*u)+0;
				return rep[j][c];
			}
			else
			{
				return rep[j][options];
			}
		}
		else
		{
			return " ";
		}

	}
	public static String combine(String compress) //converting [] into the string it represents. If there's no brackets then there's no change
	{
		String bigger = ""; //We are building a religion. We are making it bigger.
		int tostr = 0; //which abrev string
		String tonum = "";

//similes
		String[] abrev = {"<,cause+s,contribute+s to,increas<e,s,ing> <in> <the> <amount of>,make+s <more> <of>,create+s,lead+s to,invoke+s>",//1
				"<,greater,<much,wa+a+a+ay,insanely> <more,greater>> <of> <an> <increase> <in> <the> <amount,quantity> <of>",//2
				"<,mak+e<s,ing>,produc+e<s,ing>,creat+e<s,ing>,caus+e<s,ing>,generat+e<s,ing>,do<es,ing>>",//3
				"<,cars,boats,transport<ation>,planes,<burning> coal <power plants>,power plants,<burning> fossil fuels> <exhaust,waste>",//4
				"<,<industrial<ized>,corporate,farm<ing>,funding,buy<ing>,subsidiz<e,ing>> animal+s <product<ion,s>,agriculture,farm<ing,s>>,<animal> <factory+s,industrial<ized>,corporate> farm<ing,s>> <practice+s> <instance+s>",//5
				"<,do<es>n+'t,do<es> not>",//6
				"<,pollut<ion,ants,e>,co2,greenhouse gas<ses>> <emissions>",//7
				"<on,in,to,for,into,within> <the,our,this> <,earth+'+s,planet+s,atmosphere,environment,air,soil>",//8
				"<,doesn+'t,does not,barely,hardly>",//9
				"<,can+'t,cannot,<,are,is><n+'t> <not> <<un>able> <to>>",//10
				"<,significant<ly>,observably,concerning<ly>,relative<ly>,lot,much,<in> a concerning amount <of>>",//11
				"",//12
				"<negative,harmful> <,impact+s,problem+s,issue+s,effect+s,harm+s,consequences,destroy+s,destruction,hurt+s,damage+s>",//13
				"<created,made,caused,generated,comes,came> <<,out,because> of,as a result of,by,from>",//14
				"<,health<y,iful>,necessary,needed,vital,important,essential,good,beneficial,great,amazing,incredible,nutriti<on,ous>>",//15
				"<everyone+'+s,everybody,all,most,you,me,us> <of> <human+'+s,people+'+s,our> <to> <health,well being,vitality,longevity,surviv<e,al>> <stages of human life>",//16
				"<,balance+d,little,proportion<al>,moderat<e,ion>,small,the right,little,some>",//17
				"<,should,need+s,must,ha<ve,s>,ought,are supposed> <to>",//18
				"<,health,well+-+ being,vitality,longevity,stages of human life,surviv<e,al>>",//19
				"<,human+'+s,people+'+s,mankind+s> <,health,well being,vitality,longevity>",//20
				"<for,to> <the,our> <,<planet+'+s,earth+'+s> <people,human+s,life,ecosystem+s,environment,atmosphere,air,soil,oceans,lakes,rivers,climate>> <of,on,in> <our> <planet> <earth>"//21
		};

		for(int a = 0; a < compress.length(); a++)
		{
			tonum = "";
			if(compress.charAt(a)=='[')
			{
				a+=1;
				while(!(compress.charAt(a)==']')) //retreiving number within brackets
				{
					tonum = "" + tonum + compress.charAt(a);
					a+=1;
				}
				tostr = Integer.parseInt(tonum);

				bigger = bigger + abrev[tostr-1];

			}
			else
			{
				bigger = bigger + compress.charAt(a);
			}
		}
		return bigger;

	}
	public static boolean brackets(String s, String[] word, int reqnum)
	{
		if(word.length<reqnum)
		{
			return false;
		}
		int questcount = 0;//(?) loop stops if the word is the same
		options = -1;
		int nd = 0;
		int guideword = 0;
		String wordmatch = "";
		int wordlen = 0;
		int startpos = 0;
		int brcount = 0;
		int oldbr = 0;
		String guidebit = "";
		boolean exito = true;
		int andpos = 0;
		ArrayList<Integer> guidewordlength = new ArrayList<Integer>();//index value is bracket level, value is guideword part length
		ArrayList<Boolean> bools = new ArrayList<Boolean>();//true if required bracket level
		int foundreq = 0;

		for(int a = 0; a < word.length; a++) //Outer loop goes through each input word
		{	
			exito = true;
			wordmatch = word[a];
				if(wordmatch.equals("brapuleinnova"))
			{
				wordlen = 0;
			}
			else
			{
				wordlen = wordmatch.length();
			}
			nd = 0;

			while(startpos<s.length() && exito) //Inner loop goes through finders
			{	
				guidebit = s.substring(startpos,startpos+1);
				if((guideword+nd)<wordlen && guidebit.equals(wordmatch.substring((guideword+nd),(guideword+nd+1))))
				{
					startpos+=1;
					nd+=1;
				}
				else if(guidebit.equals("<"))
				{
					guidewordlength.add(0);
					if(nd>0)
					{
						guideword+=nd;
						if(brcount==0)
                                                {
                                                        guidewordlength.set(brcount,(guidewordlength.get(brcount)+nd));
                                                }
                                                else
                                                {
                                                        guidewordlength.set(brcount-1,(guidewordlength.get(brcount-1)+nd));
                                                }
					}
					startpos+=1;
					if(s.charAt(startpos)==',')
					{
						bools.add(true);
						startpos+=1;
					}
					else
					{
						bools.add(false);
					}
					nd = 0;
					brcount+=1;
				}
				else if(guidebit.equals(">"))
				{
					brcount-=1;
					if(nd>0)
					{
						guidewordlength.set(brcount,(guidewordlength.get(brcount)+nd));
						guideword+=nd;
					}
					if(guidewordlength.get(brcount)==0)
					{
						if(bools.get(brcount))
						{
							oldbr = brcount;
							if(brcount==0)
							{
								startpos+=1;
								while(startpos<s.length() && !(s.charAt(startpos)==' ' && oldbr==brcount))
								{
									if(s.charAt(startpos)=='<')
									{
										oldbr+=1;
									}
									else if(s.charAt(startpos)=='>')
									{
										oldbr-=1;
									}
									startpos+=1;
								}
							}
							else
							{
								while(!(s.charAt(startpos)=='>' && oldbr<brcount) && !(s.charAt(startpos)==',' && oldbr==brcount) && !(s.charAt(startpos)==' ' && oldbr==0))
								{
									startpos+=1;
									if(s.charAt(startpos)=='<')
									{
										oldbr+=1;
									}
									else if(s.charAt(startpos)=='>')
									{
										oldbr-=1;
										if(oldbr<brcount && oldbr>-1 && bools.get(oldbr))
										{
											while(guidewordlength.get(oldbr)>0)
											{
												a-=1;
												if(word[a].length()<=guidewordlength.get(oldbr-1))
												{
													guidewordlength.set((oldbr),(guidewordlength.get(oldbr) - word[a].length()));
												}
												else
												{
													guideword = word[a].length()-guidewordlength.get(oldbr);
													guidewordlength.set((oldbr),0);
												}

											}
											guidewordlength.remove(brcount);
											bools.remove(brcount);
											brcount-=1;
										}
									}
								}
							}
							if(s.charAt(startpos)=='>' && oldbr<brcount || s.charAt(startpos)==',')
							{
								bools.remove(brcount);
								guidewordlength.remove(brcount);
							}
						}
						else
						{
							if(brcount!=0)
							{
								guidewordlength.remove(brcount);
								bools.remove(brcount);
							}
							startpos+=1;
						}
					}
					else if(brcount>0)
					{
						guidewordlength.set((brcount-1),(guidewordlength.get((brcount-1)) + guidewordlength.get(brcount)));
						guidewordlength.remove(brcount);
						bools.remove(brcount);
						startpos+=1;
					}
					else
					{
						startpos+=1;
						if(startpos==s.length() && bools.get(0))
						{
							foundreq+=1;
							exito = false;
						}
					}
					nd = 0;
				}
				else if(guidebit.equals(","))
				{
					if(nd>0)
					{
						guideword+=nd;
						guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) + nd));
						nd = 0;
					}
					if(guideword==wordlen || guidewordlength.get(brcount-1)>0)
					{
						oldbr = brcount;
						while(!(s.charAt(startpos)=='>' && oldbr<brcount))
						{
							startpos+=1;
							if(s.charAt(startpos)=='<')
							{
								oldbr+=1;
							}
							else if(s.charAt(startpos)=='>')
							{
								oldbr-=1;
							}
						}
					}
					else
					{
						startpos+=1;
					}
				}
				else if(guidebit.equals("+"))
				{
					startpos+=1;
					if(nd>0)
					{
						guideword+=nd;
						if(brcount>0)
						{
							guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) + nd));
						}
					}
					if(guideword<wordlen && s.charAt(startpos)==(wordmatch.charAt(guideword)))
					{
						guideword+=1;
						if(brcount>0)
						{
							guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) + 1));
						}
						startpos+=1;
					}
					else if(s.charAt(startpos)==' ')
					{
						if(guideword==wordlen)
						{
							guideword = 0;
							a+=1;
							if(a==word.length)
							{
								a-=1;
								guidebit = s.substring(startpos,startpos+1);
								oldbr = brcount;
								while(startpos+1<s.length() && !(guidebit.equals(",") && oldbr==brcount) && !(guidebit.equals(">") && oldbr==brcount) && !(guidebit.equals(" ") && !s.substring(startpos+1,startpos+2).equals("<") && oldbr==brcount) && !(guidebit.equals("<") && s.substring(startpos+1,startpos+2).equals(",") && oldbr==brcount))
								{
									startpos+=1;
									guidebit = s.substring(startpos,startpos+1);
									if(guidebit.equals("<"))
									{
										oldbr+=1;
									}
									else if(guidebit.equals(">"))
									{
										oldbr-=1;
									}
								}

							}
							else
							{
								wordmatch = word[a];
								guideword = 0;
								nd = 0;
							}
						}
						else
						{
							startpos+=1;
						}
					}
					else
					{
						startpos+=1;
					}
					nd = 0;
				}
				else if(guidebit.equals("|"))
				{
					questcount = a;
					andpos = startpos;
					startpos+=1;
				}
				else if(guidebit.equals("?"))
				{
					if(a>questcount)
					{
						questcount = a;
						startpos+=1;
						boolean b = false;
						guideword = 0;
						if(s.charAt(startpos)=='<')
						{
							if(!s.substring(startpos+1,startpos+2).equals(","))
							{
								b = true;
							}
							else
							{
								startpos+=1;
							}
							startpos+=1;
						}
						while(!(s.charAt(startpos)==' ') || startpos==s.length())
						{
							if(nd<wordlen && s.charAt(startpos)==(wordmatch.charAt(nd)))
							{
								nd+=1;
								startpos+=1;
							}
							else if(s.charAt(startpos)==',' || s.charAt(startpos)=='>')
							{
								if(nd==wordmatch.length())
								{
									guideword = nd;
									startpos = andpos;
									exito = false;
								}
								startpos+=1;
							}
							else
							{
								startpos+=1;
								while(!((s.charAt(startpos)==',' && guideword==0) || s.charAt(startpos)=='>' || s.charAt(startpos)==' '))
								{
									startpos+=1;
								}
								nd = 0;
							}
						}
						if(b)
						{
							if(guideword>0)
							{
								exito = false;
							}
							startpos = andpos;
						}
						else if(guideword==0)
						{
							startpos+=1;
						}
						else
						{
							startpos = andpos;
							exito = false;
						}
					}
					else
					{
						startpos+=2;
						brcount+=1;
						oldbr = brcount;
						while(!(oldbr<brcount && s.charAt(startpos)==' '))
						{
							startpos+=1;
							if(s.charAt(startpos)=='<')
							{
								oldbr+=1;
							}
							else if(s.charAt(startpos)=='>')
							{
								oldbr-=1;
								if(oldbr<brcount)
								{
									startpos+=1;
								}
							}
						}
					}
				}
				else if(guidebit.equals(" "))
				{
					guideword+=nd;
					if(brcount==0)
					{
						if(guideword==wordlen || (guidewordlength.get(0)>=wordlen && guideword==0))
						{
							if(bools.size()==0 || bools.get(0))
							{
								foundreq+=1;
							}
							if(guideword!=0)
							{
								exito = false;
							}
						}
						else
						{
							if(bools.size()==0 || bools.get(0))
							{
								if(guidewordlength.size()==0 || a==0 || guidewordlength.get(0)<word[(a-1)].length())
								{
									return false;
								}
								else
								{
									foundreq+=1;
								}
							}
						}
						if(bools.size()>0)
						{
							bools.remove((bools.size()-1));
							guidewordlength.remove((bools.size()));
						}
						startpos+=1;
					}
					else if(guideword==wordlen)
					{
						startpos+=1;
						guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) + nd));
						if((a+1)==word.length && bools.get(0))
                                                {
                                                        foundreq+=1;
                                                }
						exito = false;
					}
					else if(guideword==0)
					{
						startpos+=1;
					}
					else //guideword != wordlen
					{
						guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) + nd));
						oldbr = brcount;
						while(!(s.charAt(startpos)=='>' && oldbr<brcount) && !(s.charAt(startpos)==',' && oldbr==brcount) && !(s.charAt(startpos)==' ' && (oldbr<brcount || oldbr==0)))
						{
							startpos+=1;
							if(s.charAt(startpos)=='<')
							{
								oldbr+=1;
							}
							else if(s.charAt(startpos)=='>')
							{
								oldbr-=1;
								if(oldbr<brcount && oldbr>0 && bools.get(oldbr))
								{
									while(guidewordlength.get(oldbr)>0)
									{
										a-=1;
										if(word[a].length()<=guidewordlength.get(oldbr))
										{
											guidewordlength.set(brcount,(guidewordlength.get(oldbr) - word[a].length()));
										}
										else
										{
											guideword = word[a].length()-guidewordlength.get(oldbr);
											guidewordlength.set((oldbr),0);
										}

									}
									guidewordlength.remove(brcount-1);
									bools.remove(brcount-1);
									brcount-=1;
								}
							}
						}
					}
					nd = 0;
					guideword = 0;
				}
				else if(guidebit.equals("!"))//brcount should be 0
				{
					int commacount = -1;
					nd = 0;
					options = -1;
					guideword = 0;
					startpos+=2;
					brcount+=1;

					if(s.charAt(startpos)==',')
					{
						bools.add(true);
						startpos+=1;
					}
					else
					{
						bools.add(false);
					}
					guidewordlength.add(0);
					while(brcount>0)
					{
						if(guideword<wordlen && s.charAt(startpos)==(wordmatch.charAt(guideword)))
						{
							nd+=1;
							guideword+=1;
							startpos+=1;
						}
						else if(s.charAt(startpos)=='<')
						{
							if(s.substring(startpos+1,startpos+2).equals(","))
							{
								bools.add(true);
							}
							else
							{
								bools.add(false);
							}
							if(nd>0)
							{
								guidewordlength.set((brcount-1),(guidewordlength.get((brcount-1))+nd));
							}
							guidewordlength.add(0);
							nd = 0;
							startpos+=1;
							brcount+=1;
						}
						else if(s.charAt(startpos)=='>')
						{
							brcount-=1;
							if(nd>0)
							{
								if(startpos+2<s.length() && s.substring(startpos+1,startpos+2).equals(" "))
								{
									if(guideword==wordlen)
									{
										guidewordlength.set(brcount,(guidewordlength.get(brcount)+nd));
									}	
								}
								else
								{
									guidewordlength.set(brcount,(guidewordlength.get(brcount)+nd));
								}
								if(brcount==0)
								{
									commacount+=1;
									if(guideword==wordlen)
									{
										options = commacount;
									}
								}
							}
							if(brcount==0)
                                                        {
								if(options>-1)
								{
									if(bools.get(0))
									{
										foundreq+=1;
										exito = false;
									}
								}
								else
								{
									if(bools.get(0))
									{
										return false;
									}
								}
								guideword=0;
								startpos+=2;
                                                        }
							else
							{
								if(bools.get(brcount))
								{
									if(guidewordlength.get(brcount)==0)
									{
										oldbr = brcount;
										while(!((s.charAt(startpos)==',' && oldbr==brcount) || (s.charAt(startpos)=='>' && oldbr<brcount)))
										{
											startpos+=1;
											if(s.charAt(startpos)=='<')
											{
												oldbr+=1;
											}
											else if(s.charAt(startpos)=='>')
											{
												oldbr-=1;
											}
										}
										while(guidewordlength.get(brcount-1)>0)
                                                                		{
                                                                			a-=1;
                                                                        		if(word[a].length()<=guidewordlength.get(brcount-1))
                                                                        		{
                                                                        		        guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) - word[a].length()));
                                                                        		}
                                                                        		else
                                                                        		{
                                                                                		guideword = word[a].length()-guidewordlength.get(brcount-1);
                                                                                		guidewordlength.set((brcount-1),0);
                                                                        		}
                                                                		}
									}
									else
									{
										guidewordlength.set((brcount-1),guidewordlength.get((brcount-1))+guidewordlength.get(brcount));
										startpos+=1;
									}
								}
								else
								{
									guidewordlength.set((brcount-1),guidewordlength.get((brcount-1))+guidewordlength.get(brcount));
									startpos+=1;
								}
							}
							bools.remove(brcount);
							guidewordlength.remove(brcount);

							nd = 0;
						}
						else if(s.charAt(startpos)==',')
						{
							if(nd>0)
							{
								guidewordlength.set((brcount-1),(guidewordlength.get((brcount-1))+nd));
							}
							if(brcount==1)
							{
								commacount+=1;
								if(guideword<=wordlen && guideword>0)
								{
									if(guideword==wordlen)
									{
										oldbr = brcount;
                                                                         	while(!(s.charAt(startpos)=='>' && oldbr<brcount))
                                                                         	{
                                                                         	       startpos+=1;
                                                                         	       if(s.charAt(startpos)=='<')
                                                                         	       {
                                                                         	               oldbr+=1;
                                                                         	       }
                                                                         	       else if(s.charAt(startpos)=='>')
                                                                         	       {
                                                                         	               oldbr-=1;
                                                                         	       }
                                                                         	}
										exito = false;
										options = commacount;
									}
									else
									{
										guidewordlength.set(0,(guidewordlength.get(0)-guideword));
										while(guidewordlength.get(0)>0)
                                                                		{
                                                                		        a-=1;
                                                                		        if(word[a].length()<=guidewordlength.get(0))
                                                                		        {
                                                                		                guidewordlength.set((0),(guidewordlength.get(0) - word[a].length()));
                                                                		        }
                                                                		        else
                                                                		        {
                                                                		                guideword = word[a].length()-guidewordlength.get(0);
                                                                		                guidewordlength.set((0),0);
                                                                		        }
                                                                		}
										startpos+=1;
									}
									
								}
								else //guideword = 0
								{
									if(guidewordlength.get(0)>0 && a>0 && word[(a-1)].length()<=guidewordlength.get(0))
									{
										oldbr = brcount;
                                                                                while(!(s.charAt(startpos)=='>' && oldbr<brcount))
                                                                                {
                                                                                       startpos+=1;
                                                                                       if(s.charAt(startpos)=='<')
                                                                                       {
                                                                                               oldbr+=1;
                                                                                       }
                                                                                       else if(s.charAt(startpos)=='>')
                                                                                       {
                                                                                               oldbr-=1;
                                                                                       }
                                                                                }
										options = commacount;
										guidewordlength.set(0,0);
									}
									else
									{
										startpos+=1;
									}
								}
								guideword = 0;
								nd = 0;
							}
							else
							{
								if(guidewordlength.get(brcount-1)==0)
								{
									startpos+=1;
								}
								else
								{
									oldbr = brcount;
									while(!(s.charAt(startpos)=='>' && oldbr<brcount))
                                                                        {
                                                                                startpos+=1;
                                                                                if(s.charAt(startpos)=='<')
                                                                                {
                                                                                        oldbr+=1;
                                                                                }
                                                                                else if(s.charAt(startpos)=='>')
                                                                                {
                                                                                        oldbr-=1;
                                                                                }
                                                                        }
									
								}
							}
						}
						else if(s.charAt(startpos)=='+')
						{
							startpos+=1;
							if(guideword<wordlen && wordmatch.charAt(guideword)==s.charAt(startpos))
							{
								guideword+=1;
								nd+=1;

							}
							startpos+=1;
						}
						else if(s.charAt(startpos)==' ')
						{
							if(guideword==wordlen)
							{
								a+=1;
								if(!s.substring(startpos-1,startpos).equals(">"))
								{
									guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) + guideword));
								}
								if(a==word.length)
								{
									options = commacount;
									return true;
								}
								else
								{
									wordmatch = word[a];
									wordlen = wordmatch.length();
								}
							}
							startpos+=1;
							guideword = 0;
							nd = 0;
						}
						else
						{
							oldbr = brcount;
                                                        while(!((s.charAt(startpos)==',' && oldbr==brcount) || (s.charAt(startpos)=='>' && oldbr<brcount)))
                                                        {
                                                                startpos+=1;
                                                                if(s.charAt(startpos)=='<')
                                                                {
                                                                        oldbr+=1;
                                                                }
                                                                else if(s.charAt(startpos)=='>')
                                                                {
                                                                        oldbr-=1;
                                                                }
                                                        }
							nd = 0;
							if(brcount>1)
							{
								while(guidewordlength.get(brcount-1)>0)
                                                        	{
                                                        		a-=1;
                                                                	if(word[a].length()<=guidewordlength.get(brcount-1))
                                                        		{
                                                        	                guidewordlength.set((brcount-1),(guidewordlength.get(brcount-1) - word[a].length()));
                                                        	        }
                                                        	        else
                                                        	        {
                                                        	                guideword = word[a].length()-guidewordlength.get(brcount-1);
                                                        	                guidewordlength.set((brcount-1),0);
                                                        	        }
                                                        	}
							}
							else
							{
							  guideword = 0;
							}
						}
					}

				}
				else //not the same letter or input word is longer
				{
					if(brcount==0)
					{
						return false;
					}
					else
					{
						if(guidewordlength.get(brcount-1)<=guideword)
						{
							guideword-=guidewordlength.get(brcount-1);
							if(guideword==0)
							{
								guidewordlength.set((brcount-1),0);
							}
						}
						oldbr = brcount;
						while(startpos<s.length() && !(s.charAt(startpos)==' ' && oldbr==0) && !(s.charAt(startpos)=='>' && oldbr<brcount) && !(s.charAt(startpos)==',' && oldbr<brcount))
						{
							startpos+=1;
							if(s.charAt(startpos)=='<')
							{
								oldbr+=1;
							}
							else if(s.charAt(startpos)=='>')
							{
								oldbr-=1;
								if(oldbr<brcount && oldbr>0 && bools.get(oldbr))
								{
									while(guidewordlength.get(oldbr)>0)
									{
										a-=1;
										if(word[a].length()<=guidewordlength.get(oldbr))
										{
											guidewordlength.set((oldbr),(guidewordlength.get(oldbr) - word[a].length()));
										}
										else
										{
											guideword = word[a].length()-guidewordlength.get(oldbr);
											guidewordlength.set((oldbr),0);
										}

									}
									guidewordlength.remove(oldbr);
									bools.remove(oldbr);
									brcount-=1;
								}
							}
							else if(s.charAt(startpos)==',')
							{
								if(oldbr==brcount)
                                                                {
									oldbr-=1;
                                                                        while(guidewordlength.get(oldbr)>0)
                                                                        {
                                                                                a-=1;
                                                                                if(word[a].length()<=guidewordlength.get(oldbr))
                                                                                {
                                                                                        guidewordlength.set((oldbr),(guidewordlength.get(oldbr) - word[a].length()));
                                                                                }
                                                                                else
                                                                                {
                                                                                        guideword = word[a].length()-guidewordlength.get(oldbr);
                                                                                        guidewordlength.set((oldbr),0);
                                                                                }

                                                                        }
                                                                }
							}
						}
					}
					nd = 0;
				}
			}//end while
		}//end for
		if(foundreq>=reqnum)
		{
			return true;
		}
		return false;
	}
}
