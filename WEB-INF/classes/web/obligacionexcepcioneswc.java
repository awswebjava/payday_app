package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obligacionexcepcioneswc", "/web.obligacionexcepcioneswc"})
public final  class obligacionexcepcioneswc extends GXWebObjectStub
{
   public obligacionexcepcioneswc( )
   {
   }

   public obligacionexcepcioneswc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obligacionexcepcioneswc.class ));
   }

   public obligacionexcepcioneswc( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obligacionexcepcioneswc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obligacionexcepcioneswc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Obligacion Excepciones WC";
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

