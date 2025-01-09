package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.familiawc", "/web.familiawc"})
public final  class familiawc extends GXWebObjectStub
{
   public familiawc( )
   {
   }

   public familiawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( familiawc.class ));
   }

   public familiawc( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new familiawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new familiawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "familia WC";
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

