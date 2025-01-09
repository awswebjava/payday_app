package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.art", "/web.art"})
public final  class art extends GXWebObjectStub
{
   public art( )
   {
   }

   public art( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( art.class ));
   }

   public art( int remoteHandle ,
               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new art_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new art_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "ART";
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

