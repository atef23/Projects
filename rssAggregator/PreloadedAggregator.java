import student.web.*;

/**.
 *  Tests preloaded aggregator
 * 
 *  @author  atef ajs09
 *  @version 2010.09.23
 */
public class PreloadedAggregator
    extends RssAggregator
{
    /**.
     * Creates a new PreloadedAggregator 
     */
    public PreloadedAggregator()
    {
        super();    // The inherited constructor runs first
        setKeyword("Obama");
        addFromFeed(new RssFeed("http://rss.cnn.com/rss/cnn_topstories.rss"));
        addFromFeed(new RssFeed("http://rss.news.yahoo.com/rss/topstories"));
    }
}


