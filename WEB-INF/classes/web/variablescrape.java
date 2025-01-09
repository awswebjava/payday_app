package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.variablescrape", "/web.variablescrape"})
public final  class variablescrape extends GXWebObjectStub
{
   public variablescrape( )
   {
   }

   public variablescrape( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( variablescrape.class ));
   }

   public variablescrape( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new variablescrape_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new variablescrape_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Variable Scrape";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

