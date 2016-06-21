import javax.inject.*;
import play.*;
import play.mvc.EssentialFilter;
import play.http.HttpFilters;
import play.mvc.*;

import filters.BaseFilter;

/**
 * This class configures filters that run on every request. This
 * class is queried by Play to get a list of filters.
 *
 * Play will automatically use filters from any class called
 * <code>Filters</code> that is placed the root package. You can load filters
 * from a different class by adding a `play.http.filters` setting to
 * the <code>application.conf</code> configuration file.
 */
@Singleton
public class Filters implements HttpFilters {

    private final Environment env;
    private final EssentialFilter baseFilter;

    @Inject
    public Filters(Environment env, BaseFilter baseFilter) {
        this.env = env;
        this.baseFilter = baseFilter;
    }

    @Override
    public EssentialFilter[] filters() {
        
      if (env.mode().equals(Mode.DEV)) {
          return new EssentialFilter[] { baseFilter };
      } else {
         return new EssentialFilter[] {};      
      }
    }
}