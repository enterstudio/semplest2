package semplest.keywords.javautils;

import org.apache.log4j.Logger;

import semplest.keywords.scalautils.*;

/* Semplest Crawler
 * 
 * Crawl and collect text from urls in a distributed multi-threaded fashion
 * - Start as many worker threads on as many machines as you like to do the work
 * - Write your program and start it on your machine
 *   - Feed the program work to be done (it will distribute it to the workers)
 *   - Periodically collect results
 *
 * Detailed use: 
 * 
 * 1) Write your program
 *    Crawler c = new Crawler();
 *    c.add( String id, String space_separated_urls)
 *    ... do as many adds as you want 
 *    ... wait for a while
 *    String[] res = c.fetch
 *    ... store your results and fetch results again
 *    ... res = c.fetch()
 *    on each fetch, the crawler gives you all the reults it has computed so far
 *
 * 2) Compile it with the crawler library 
 *      javac -cp crawler.jar <your_program.java>
 *
 * 3) Start some worker threads (on different machines)
 *      java -cp <libraries> Worker <ip_of_your_machine> <number_threads> 
 *      where libraries are tagsoup-1.2.1.jar:crawler.jar:scala-library.jar 
 *      .. you can start as many workers as you wish with as many threads
 *      .. approximately 4 threads per core seems to work well 
 *
 * 4) Run your program
 *     java -cp <libraries> your_program
 */

// ------------
class Crawl
{

	private static final Logger logger = Logger.getLogger(Crawl.class);

	public static void main(String[] args) throws Exception
	{

		String ss = "http://www.google.com";
		int depth = 1;
		String urls = TextUtils.HTMLLinkString(ss, depth, "www.google.com");

		// start the crawler and add work (with an id to identify the work)
		Crawler c = new Crawler();
		c.add("parishilton", urls);

		try
		{
			Thread.sleep(30000);
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}

		// getch results periodically
		String[] results = c.fetch();

		System.out.println("Size of results: " + results.length);

		// each result is prefixed with the id
		for (String res : results)
			System.out.println(res);
	}
}
