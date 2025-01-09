package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.siniestradoww", "/web.siniestradoww"})
public final  class siniestradoww extends GXWebObjectStub
{
   public siniestradoww( )
   {
   }

   public siniestradoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( siniestradoww.class ));
   }

   public siniestradoww( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new siniestradoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new siniestradoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Siniestrado";
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

