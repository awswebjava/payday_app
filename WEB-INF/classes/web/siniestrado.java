package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.siniestrado", "/web.siniestrado"})
public final  class siniestrado extends GXWebObjectStub
{
   public siniestrado( )
   {
   }

   public siniestrado( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( siniestrado.class ));
   }

   public siniestrado( int remoteHandle ,
                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new siniestrado_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new siniestrado_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Siniestrado";
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

