package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.siradig_codigosww", "/web.siradig_codigosww"})
public final  class siradig_codigosww extends GXWebObjectStub
{
   public siradig_codigosww( )
   {
   }

   public siradig_codigosww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( siradig_codigosww.class ));
   }

   public siradig_codigosww( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new siradig_codigosww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new siradig_codigosww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " siradig_codigos";
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

