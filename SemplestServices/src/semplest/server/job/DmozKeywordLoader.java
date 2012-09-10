package semplest.server.job;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class DmozKeywordLoader
{
	private static final Logger logger = Logger.getLogger(DmozKeywordLoader.class);
	
	public DmozKeywordLoader() throws Exception
	{
		new ClassPathXmlApplicationContext("Service.xml");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
	}
	
	public List<String> getNeededFiles(final String[] filesRaw)
	{
		final List<String> files = new ArrayList<String>();
		for (final String file : filesRaw)
		{
			if (file.endsWith(".2") ||
					file.endsWith(".3") ||
					file.endsWith(".4") ||
					file.endsWith(".2.m") ||
					file.endsWith(".3.m") ||
					file.endsWith(".4.m"))
			{
				files.add(file);
			}
		}
		return files;
	}
	
	public void engage() throws Exception
	{
		logger.info("Will truncate Keyword Data");
		SemplestDB.truncateKeywordData();
		logger.info("Truncated Keyword Data");
		final String dir = "Z:\\data\\dmoz\\multiwords\\crawl2MSNVolFiltered";
		final File dirFile = new File(dir);
		final String[] filesRaw = dirFile.list();
		final List<String> files = getNeededFiles(filesRaw);
		for (final String file : files)
		{
			processFile(dir, file);
		}
	}
	
	public void processFile(final String dir, final String file) throws Exception
	{
		final String fullFile = dir + "\\" + file;
		logger.info("[" + file + "]: processing");
		final List<String> lines = getContent(fullFile);
		logger.info("[" + file + "]: num lines extracted: " + lines.size());
		final Map<String, String> categoryVsKeywords = getMap(lines);
		final int batchSize = 1000;
		final List<Map<String, String>> batches = SemplestUtils.getBatches(categoryVsKeywords, batchSize);
		int counter = 0;
		for (final Map<String, String> batch : batches)
		{			
			SemplestDB.storeKeywordBatch(file, batch);
			counter += batch.size();
			logger.info("[" + file + "]: lines stored to db: " + counter);
		}
	}
	
	public Map<String, String> getMap(final List<String> lines)
	{
		final Map<String, String> categoryVsKeywords = new HashMap<String, String>();
		for (final String line : lines)
		{
			final int indexOfFirstColon = line.indexOf(":");
			final String key = line.substring(0,  indexOfFirstColon);
			final String value = line.substring(indexOfFirstColon, line.length());
			categoryVsKeywords.put(key, value);
		}
		return categoryVsKeywords;
	}
	
	public List<String> getContent(final String fileName) throws Exception
	{		
		final FileInputStream fstream;
		try
		{
			fstream = new FileInputStream(fileName);
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not find file [" + fileName + "]");
		}
		final DataInputStream in = new DataInputStream(fstream);
		final BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		final List<String> lines = new ArrayList<String>();
		int counter = 0;
		try
		{
			while ((line = br.readLine()) != null) 
			{
				++counter;
				if (counter % 10000 == 0)
				{
					logger.info("[" + fileName + "]: parsed " + counter + " lines");					
				}
				lines.add(line);
			}
		}
		catch (IOException e)
		{
			throw new Exception("Problem parsing file [" + fileName + "], the last line successfully read (if not null) is [" + line + "]");
		}
		try
		{
			in.close();
			fstream.close();
		}
		catch (IOException e)
		{
			logger.error("Problem closing DataInputStream.  Logging, but otherwise ignoring");
		}
		return lines;
	}
	
	public static void main(final String[] args) throws Exception
	{
		final long startTime = System.currentTimeMillis();
		logger.info("Start time: " + new Date());
		final DmozKeywordLoader loader = new DmozKeywordLoader();
		loader.engage();
		logger.info("Finish time: " + new Date());
		final long finishTime = System.currentTimeMillis();
		final long duration = finishTime - startTime;
		final long mins = duration / SemplestUtils.MINUTE;
		logger.info("Duration: " + mins + " mins");
		/*
		final DmozKeywordLoader loader = new DmozKeywordLoader();
		final List<String> lines = Arrays.asList("top/arts/music/vocal/singers/classical/baritones/eddy,_nelson:362 kindle+fire:18:378682 windows+phone:36:125709 home+page:9:104220 online+shopping:18:104157 movies+theaters:18:103636 watch+movies:36:89449 android+phones:18:86134 blu+ray:81:85901 android+tablets:18:80030 imdb+com:22:66250 movies+online:36:65442 photo+gallery:50:57241 newspaper+advertising:10:56460 phantom+opera:46:47129 walt+disney:8:45610 audio+books:18:42576 coming+soon:36:42361 new+year:8:38441 news+articles:12:32587 celebrity+news:18:30210 trailers+videos:8:29873 box+office:19:28339 new+moon:32:26053 digital+photography:18:25724 search+site:18:24956 search+videos:19:24742 new+dvd:18:22016 miami+beach:15:21271 message+boards:36:19932 books+magazines:25:19138 message+board:33:16900 bob+hope:8:16365 news+press:23:14014 movies+dvd:54:13408 movies+showtimes:18:13226 wireless+plans:18:12505 top+news:36:11825 privacy+policy:23:11248 home+search:18:11201 top+movies:36:10759 wonderful+world:8:10641 video+watch:18:10021 streaming+movies:18:9643 silent+night:8:9593 amazon+wireless:18:9463 find+out:8:9060 home+listings:18:8329 facebook+twitter:18:7754 dinah+shore:8:7688 falling+love:10:7350 iphone+app:18:6818 movie+news:18:5811 love+love:8:4848 contact+information:24:4421 hollywood+stars:9:4231 one+more:9:3757 ffff+text:69:3685 movie+guide:18:3592 buy+movies:54:3573 irish+eyes:16:3553 first+years:8:3452 come+back:18:3306 video+message:18:3235 news+videos:18:2927 episodes+clips:18:2806 independent+film:18:2783 complete+list:8:2774 rose+marie:49:2688 great+day:8:2686 danny+thomas:16:2460 instant+video:36:2394 ipad+app:18:2324 news+video:18:2224 still+night:24:2101 love+someone:9:2088 sign+cancer:8:1947 android+mobile:18:1822 evening+star:8:1788 merv+griffin:8:1726 game+love:8:1683 ann+blyth:12:1623 spike+jones:16:1612 app+android:36:1480 costume+makeup:9:1476 ten+thousand:8:1456 life+entertainment:8:1439 world+color:8:1426 see+more:56:1413 bronze+statue:8:1398 jeanette+macdonald:96:1375 iphone+ipad:18:1363 anchors+aweigh:8:1356 amazon+france:18:1292 walk+fame:12:1278 download+audio:18:1257 pretty+picture:9:1219 den+geek:11:1166 mobile+site:36:1064 make+mine:24:1060 desert+song:10:1011 quick+links:8:1007 year+eve:8:991 war+over:8:952 foreign+legion:16:937 ipad+android:18:916 list+people:40:904 series+episode:48:817 amazon+instant:18:804 stille+nacht:8:803 news+top:18:790 video+unlimited:18:788 create+list:8:744 center+world:8:740 nelson+eddy:130:706 amazon+affiliates:18:685 amazon+germany:18:674 student+tour:16:666 phone+app:18:653 news+news:18:652 out+print:9:638 hollywood+style:8:637 home+sweet:8:634 alan+young:16:628 best+series:18:585 great+performances:8:569 indian+love:28:554 bitter+sweet:19:535 telephone+operator:10:477 app+ipad:18:472 song+movie:8:468 press+room:18:448 hedda+hopper:9:439 spring+here:9:439 hollywood+forever:10:436 summer+movie:18:424 news+celebrity:18:393 art+department:24:389 two+different:8:388 red+shadow:8:369 mystery+guest:24:352 guide+see:10:328 soldiers+fortune:8:328 opera+carmen:8:318 ernie+ford:16:302 rss+advertising:18:300 job+type:16:300 related+news:8:272 related+videos:8:269 gaudeamus+igitur:8:257 men+entertainment:8:249 months+ago:10:245 demo+reel:20:245 memorial+cemetery:9:215 auld+lang:8:210 personal+quotes:9:207 ham+eggs:8:195 lux+video:9:188 morning+sunrise:8:180 hollywood+walk:9:179 names+companies:18:173 life+series:8:170 text+decoration:92:166 miracle+sound:17:157 dvd+blu:72:156 gene+raymond:17:149 advertising+contact:18:138 register+login:18:129 mobile+iphone:18:128 different+worlds:8:126 service+provided:18:121 man+street:8:120 lang+syne:8:120 site+index:18:111 india+online:18:111 post+list:8:109 community+message:18:105 show+soundtrack:8:100 amazon+italy:18:99 show+hide:8:98 stouthearted+men:32:97 help+movies:18:97 movies+amazon:18:95 dancing+lady:16:95 video+documentary:16:88 news+movie:18:87 prime+instant:18:82 decoration+none:46:81 videos+news:8:78 hollywood+palace:16:78 chocolate+soldier:32:77 goodbye+forever:8:74 videos+search:18:70 social+facebook:18:68 related+links:25:65 shortnin+bread:8:64 share+page:8:60 com+inc:20:60 waltons+series:8:60 naughty+marietta:47:57 iron+foundry:10:56 actors+hollywood:8:56 month+ago:8:55 blogs+videos:23:53 old+army:8:53 tell+man:8:53 online+amazon:18:52 day+wish:8:51 audible+download:18:51 browse+videos:18:51 music+documentary:16:49 imdb+trivia:18:47 italian+street:9:46 videos+edit:8:46 guide+home:18:46 broadway+hollywood:17:45 hollywood+usa:9:45 hero+new:8:44 show+himself:8:44 imdb+social:18:43 party+guy:8:43 actors+list:16:42 login+help:18:41 stars+series:8:41 gray+home:8:40 phones+app:18:39 unlimited+streaming:18:39 international+sites:18:38 eve+party:8:37 time+short:8:37 freedom+ring:17:37 dusty+road:8:35 miscellaneous+photographs:22:35 groups+clubs:24:35 voice+make:8:34 blossom+rock:9:34 ford+show:16:33 add+resume:10:33 app+kindle:18:32 sculptor+bronze:8:32 thomas+show:16:32 singer+today:8:30 series+news:18:30 act+iii:8:30 imdb+resume:37:30 office+mojo:18:30 imdb+italy:18:29 site+windows:18:29 usa+photos:8:29 paul+allison:8:28 tim+bell:8:28 leading+men:26:27 lists+lists:18:27 jump+soundtrack:8:27 archive+footage:17:27 clip+new:8:26 caisson+song:8:26 contact+jobs:18:25 love+call:28:25 young+show:16:25 elaborate+costume:9:24 show+series:120:24 himself+himself:8:24 see+full:13:24 color+series:8:24 mystery+life:35:23 present+girl:8:23 army+team:8:23 opera+ghost:8:22 film+guide:14:22 affiliates+amazon:18:22 shadows+moon:8:21 official+sites:32:21 street+song:9:21 met+angel:8:21 musical+history:8:21 list+related:8:21 music+chocolate:8:20 documentary+short:48:20 ghost+phantom:8:20 articles+blogs:23:20 little+cafe:16:20 southern+moon:9:20 sister+sites:26:20 news+history:8:20 karl+lang:8:19 mrs+bridge:8:19 created+months:8:19 press+clippings:26:18 film+summer:18:18 personal+quote:8:18 seeing+himself:9:18 imdb+mobile:36:18 see+again:10:17 apps+home:18:17 prince+peter:8:17 videos+trailer:18:17 quotes+bios:18:17 publicity+photo:14:16 imdb+app:18:16 link+color:23:16 beach+usa:9:16 hollywood+musical:9:16 knickerbocker+holiday:16:16 greatest+actors:8:16 phantom+unmasked:8:15 girl+golden:20:15 opera+recordings:10:15 history+stars:8:15 soundtrack+titles:8:15 know+personal:9:15 history+mgm:10:14 keywords+characters:18:14 more+trivia:8:14 world+documentary:8:14 episode+dated:72:14 hollywood+memorial:9:14 comedy+hour:16:14 home+iphone:18:14 carry+back:8:13 allison+rose:8:13 lane+girl:8:13 big+record:16:13 life+student:8:13 style+center:8:13 information+biography:23:13 section+street:9:13 apps+apps:18:13 see+rank:8:12 paul+hamell:8:12 boards+press:18:12 visited+color:23:12 earth+documentary:8:12 song+falling:8:12 dancing+musical:8:11 moon+created:8:11 buzz+app:18:11 hide+show:48:11 fire+windows:18:11 name+same:8:11 featured+news:18:11 cancer+home:8:11 forever+hollywood:9:11 lady+specialty:8:11 sullivan+show:16:11 record+series:16:11 little+gray:8:11 captain+richard:8:11 under+service:18:11 providence+island:9:11 singing+video:8:10 hour+series:16:10 geek+review:8:10 show+art:8:10 line+series:8:10 mgm+hollywood:9:10 wanting+make:8:10 home+updates:23:10 twitter+international:18:10 island+usa:9:10 holiday+revue:9:10 eddy+home:9:8 years+celebration:8:7", "top/arts/movies/titles/t/talk_of_angels:388 kindle+fire:19:378682 tom+cruise:1:150771 windows+phone:38:125709 civil+war:13:118449 online+shopping:19:104157 movies+theaters:19:103636 penelope+cruz:7:102127 watch+movies:38:89449 android+phones:19:86134 blu+ray:76:85901 android+tablets:19:80030 imdb+com:20:66250 movies+online:38:65442 united+kingdom:2:65078 photo+gallery:32:57241 english+spanish:2:45322 audio+books:19:42576 coming+soon:38:42361 video+clips:16:36654 news+articles:6:32587 celebrity+news:19:30210 trailers+videos:46:29873 love+story:5:28417 box+office:62:28339 digital+photography:19:25724 search+site:19:24956 search+videos:20:24742 new+dvd:19:22016 message+boards:38:19932 hair+stylist:2:18705 step+step:9:18302 message+board:32:16900 free+trial:2:15424 makeup+artist:5:13637 movies+dvd:57:13408 movies+showtimes:19:13226 wireless+plans:19:12505 learn+more:4:12473 top+news:38:11825 privacy+policy:19:11248 home+search:19:11201 top+movies:38:10759 news+article:2:10554 video+watch:19:10021 streaming+movies:19:9643 father+son:2:9473 amazon+wireless:19:9463 click+here:2:8690 home+listings:19:8329 one+thing:2:8261 official+site:4:8076 facebook+twitter:20:7754 sister+sister:1:7653 tobacco+shop:3:7284 release+date:2:7060 iphone+app:19:6818 movie+news:19:5811 fall+love:2:5399 contact+information:2:4421 dolby+digital:2:4229 movie+guide:20:3592 buy+movies:57:3573 polly+walker:12:3347 frances+mcdormand:6:3265 peter+king:2:3241 video+message:19:3235 sound+clips:15:3227 font+size:3:3141 news+videos:19:2927 movies+list:3:2905 little+bit:2:2882 episodes+clips:19:2806 independent+film:20:2783 create+character:3:2609 full+cast:53:2561 much+more:2:2560 motion+picture:2:2396 instant+video:38:2394 ipad+app:19:2324 aspect+ratio:3:2243 news+video:19:2224 plot+summary:45:2132 country+usa:2:2120 music+editor:2:2096 script+type:3:1979 post+production:2:1887 contact+details:2:1829 android+mobile:19:1822 killing+bono:7:1816 entertainment+industry:2:1810 database+managers:9:1618 franco+nero:8:1591 jose+manuel:2:1585 married+man:5:1559 sound+editor:3:1519 memorable+quotes:28:1489 app+android:38:1480 see+more:14:1413 iphone+ipad:19:1363 amazon+france:19:1292 cast+crew:53:1292 download+audio:19:1257 imdb+database:9:1194 blog+posts:2:1174 mobile+site:38:1064 sound+mixer:2:1044 executive+producer:3:1035 quick+links:3:1007 political+views:2:963 long+before:4:945 release+dates:38:935 bad+guys:1:924 ipad+android:19:916 vincent+perez:12:837 picture+rating:2:832 amazon+instant:19:804 news+top:19:790 video+unlimited:19:788 language+english:2:759 create+list:3:744 reading+newspaper:3:722 errors+omissions:9:722 ariadna+gil:4:707 amazon+affiliates:19:685 ireland+spain:4:675 amazon+germany:19:674 article+full:2:671 phone+app:19:653 news+news:19:652 history+alcohol:1:614 alcohol+drugs:2:603 best+series:19:585 woman+movie:2:582 movie+love:2:562 assistant+director:6:535 user+reviews:27:477 app+ipad:19:472 list+name:6:456 technical+specifications:5:456 press+room:19:448 summer+movie:19:424 imdb+pro:14:420 buy+amazon:16:416 news+celebrity:19:393 keyword+discovery:3:389 art+department:3:389 top+box:3:372 info+box:14:350 filming+locations:37:336 photos+videos:2:328 imdbpro+com:2:320 new+list:2:318 posters+photo:28:307 art+direction:2:305 business+company:4:303 rss+advertising:19:300 production+coordinator:3:285 related+news:2:272 related+videos:2:269 shop+philips:3:269 watch+trailer:2:259 irish+woman:7:258 months+ago:6:245 amazon+feedback:2:224 color+color:2:210 interaction+between:3:205 family+finds:4:202 parents+guide:22:186 page+created:2:174 names+companies:19:173 dvd+blu:76:156 foley+artist:2:156 drama+romance:5:153 talk+angels:40:152 report+problem:3:151 font+weight:4:144 advertising+contact:19:138 ratings+talk:2:135 register+login:19:129 mobile+iphone:19:128 more+home:2:125 service+provided:19:121 videos+full:14:119 clips+video:15:118 site+index:19:111 india+online:19:111 marisa+paredes:4:107 community+message:19:105 sex+nudity:2:104 amazon+italy:19:99 help+movies:19:97 external+links:15:96 office+business:37:95 movies+amazon:19:95 clips+photographs:1:89 top+links:14:87 news+movie:19:87 location+manager:4:85 prime+instant:19:82 seize+power:1:79 videos+news:2:78 company+contact:2:75 prev+next:2:72 videos+search:19:70 history+home:2:69 social+facebook:19:68 story+tale:1:65 related+links:13:65 edit+page:10:64 details+edit:5:62 share+page:3:60 com+inc:20:60 opening+weekend:3:58 month+ago:3:55 content+page:2:55 digital+color:2:54 online+amazon:19:52 political+unrest:5:52 user+ratings:35:51 audible+download:19:51 browse+videos:19:51 more+company:2:48 available+through:1:47 com+plot:3:47 imdb+trivia:19:47 spanish+civil:6:47 guide+home:19:46 photos+photos:2:46 imdb+social:19:43 wealthy+family:5:43 add+content:2:42 reviews+ratings:4:41 login+help:19:41 romantic+view:1:40 more+show:2:40 phones+app:19:39 usa+rating:2:39 people+found:10:39 unlimited+streaming:19:39 international+sites:19:38 story+told:1:38 full+summary:2:38 summary+plot:18:38 name+photos:2:37 page+report:9:37 modern+font:3:37 know+trivia:15:37 assistant+editor:3:36 jorge+juan:3:36 girl+played:2:35 win+time:1:35 miscellaneous+photographs:14:35 update+data:14:35 display+title:5:34 political+activist:6:34 finds+herself:4:34 here+free:2:33 kate+brien:3:33 sound+mix:2:32 app+kindle:19:32 back+paper:3:32 video+entertainment:1:31 country+date:1:31 faq+info:14:31 series+news:19:30 imdb+resume:38:30 list+titles:15:30 office+mojo:19:30 rating+ratings:2:30 spain+box:2:30 plot+synopsis:2:30 pictures+see:2:30 site+windows:19:29 imdb+italy:19:29 news+exclusive:2:28 awards+user:31:28 color+font:2:27 lists+lists:19:27 type+company:3:27 block+script:3:26 report+errors:9:26 watch+buy:2:26 character+page:3:26 imdb+talk:14:25 employee+contact:2:25 quotes+know:14:25 contact+jobs:19:25 watchlist+imdb:14:25 videos+learn:2:24 process+home:8:24 polaris+pictures:3:24 see+full:5:24 cast+cast:2:24 actors+directors:2:23 alternate+versions:15:23 step+process:9:23 technical+specs:36:22 affiliates+amazon:19:22 official+sites:50:21 lists+top:3:21 list+related:3:21 violence+gore:2:21 films+list:3:20 singing+boy:3:20 movies+seen:3:20 detailed+company:2:20 makes+more:1:19 falls+love:2:19 crew+company:28:19 film+based:2:19 created+months:6:19 film+summer:19:18 juan+jaime:3:18 imdb+mobile:38:18 update+button:9:18 war+spain:3:18 company+employee:2:18 videos+trailer:19:17 quotes+bios:19:17 apps+home:19:17 edit+history:7:17 update+list:2:17 imdb+app:19:16 add+edit:2:16 company+used:3:16 think+better:1:15 vote+history:2:15 mpaa+rated:3:15 romance+war:5:15 main+details:41:15 focus+puller:2:15 down+week:2:14 keywords+characters:19:14 home+iphone:19:14 representation+listings:2:13 synopsis+plot:18:13 apps+apps:19:13 attracted+married:4:13 ago+movies:3:13 never+see:2:13 usa+language:2:13 rossy+palma:8:13 hardly+word:1:12 director+nick:4:12 moya+construction:1:12 see+rank:2:12 gross+usa:3:12 boards+press:19:12 perez+franco:3:12 span+color:1:11 moon+created:3:11 fire+windows:19:11 featured+news:19:11 content+advisory:2:11 woman+comes:6:11 army+spanish:1:11 report+concerns:1:11 angels+box:1:11 genres+drama:2:11 links+release:2:11 second+unit:2:11 full+technical:2:11 title+trailer:2:11 rights+buy:14:11 under+service:19:11 show+detailed:2:11 buzz+app:19:11 create+edit:2:11 diego+quemada:2:11 margin+right:2:11 politically+motivated:3:10 lovers+running:1:10 wardrobe+assistant:1:10 imdb+charts:1:10 tusse+silberg:1:10 dancer+boy:1:10 twitter+international:19:10 date+october:2:10 francisco+rabal:5:10 story+young:6:10 office+opening:2:10 against+fascism:4:10 help+learn:2:10 lope+cruz:4:10 take+through:9:10 struggle+against:4:10 external+reviews:41:9 know+quotes:1:4");
		final Map<String, String> map = loader.getMap(lines);
		logger.info(SemplestUtils.getEasilyReadableString(map));*/
	}
}

