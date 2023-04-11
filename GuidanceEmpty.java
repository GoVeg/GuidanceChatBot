//Vegan advocate bot Guidance (System.out.print responses version) EMPTY TEMPLATE
//Numbers in brackets [] are substitution words
//comma means or
//space means and
//Carrot symbol separates equivalent words within slashes.
//Plus means the following letter can either be there or not.
//Greater than and less than signs can encompass multiple word options. If a comma immediately follows a greater than sign, the current word MUST be in the options.
//Question mark means loop back through the phrase if the word after question mark is next.
//Exclamation point means that whichever word in the following tree matches the current word results in a reply from the response array of that words index.
//Number at the end of each finders array string denotes how many words are required to match in order to output reply

import java.util.ArrayList;
import java.util.Scanner;

public class GuidanceEmpty {

	public static int options = -1;

	public static void main (String[] args) {
     		//Obtaining typed string
		String phrase = "";

		Scanner in = new Scanner(System.in);

		phrase = in.nextLine();
		
		phrase = phrase.toLowerCase();

		String reply = " ";
		if(phrase.length()<999)
		{
                	try
                	{
                	        reply = wordar(phrase);
                	}
                	catch(Exception e)
                	{
                	        reply = "e";
                	        e.printStackTrace();
                	}
		}
		else
		{
			reply = "tldr";
		}

                if (!reply.equals(" ") && !reply.equals("e"))
                {
                        System.out.println(reply);
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
		while(a<p.length() && (p.substring(a,a+1).equals("@") || p.substring(a,a+1).equals("<")))
		{
			while(a<p.length() && !p.substring(a,a+1).equals(" "))
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
			if(p.substring(a,a+1).equals(" "))
			{
				b.add(a);
			}
			else if(p.substring(a,a+1).equals("!") || p.substring(a,a+1).equals("?") || p.substring(a,a+1).equals(",") || p.substring(a,a+1).equals("+") || p.substring(a,a+1).equals("<") || p.substring(a,a+1).equals(">") || p.substring(a,a+1).equals("."))
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
				if(foreword.length>3)
                                {
                                        if(foreword[2].equals("you") || foreword[2].equals("people") || foreword[2].equals("we") || foreword[2].equals("i") || foreword[2].equals("u"))
                                        {
                                                inqwords.add(0);
                                                if(foreword[3].equals("get") || foreword[3].equals("obtain") || foreword[3].equals("receive") || foreword[3].equals("intake"))
                                                {
                                                        inqwords.add(0);
                                                }
                                        }
                                }
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
				if(foreword.length>3)
				{
					if(foreword[2].equals("you") || foreword[2].equals("people") || foreword[2].equals("we") || foreword[2].equals("i") || foreword[2].equals("u"))
                        		{
                                		inqwords.add(0);
                                	        if(foreword[3].equals("get") || foreword[3].equals("obtain") || foreword[3].equals("receive") || foreword[3].equals("intake"))
                                		{
                                			inqwords.add(0);
                                		}
                        		}
				}
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
			else if(foreword[1].equals("you") || foreword[1].equals("people") || foreword[1].equals("we") || foreword[1].equals("u"))
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
		}

		//What questions strings can take
		int[] n1 = {};
		//1: who=0 what=1 where=2 why=3 how=4 do&does&can=5
		//2: is=0 does=1 come=2 could=3 can=4 would=5 should=6 do&did=7 may=8 must=9 are=10 to=11 you&people&we&u=12 ought=13
		
		int[][] inq = {n1};

		int boing = inqwords.size();
		String[] word = new String[(foreword.length-boing)];

		for(int c = 0; c<word.length; c++)
		{
			word[c] = foreword[(c+boing)];
		}
		//Sentence search measures (last number is number of key words to fulfill in order to reply)
		String[] finders = {""};

		String[] a1 = {""};

		//replies
		String[][] rep = {a1};

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
				int c = (int)(Math.random()*u);
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

		//numbers in brackets corresponds with this arrays index
		String[] abrev = {""};

		for(int a = 0; a < compress.length(); a++)
		{
			tonum = "";
			if(compress.substring(a,a+1).equals("["))
			{
				a+=1;
				while(!compress.substring(a,a+1).equals("]")) //retreiving number within brackets
				{
					tonum = "" + tonum + compress.substring(a,a+1);
					a+=1;
				}
				tostr = Integer.parseInt(tonum);

				bigger = bigger + abrev[tostr-1];

			}
			else
			{
				bigger = bigger + compress.substring(a,a+1);
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
			wordlen = wordmatch.length();
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
							}//end else
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
