package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.siradig_codigosgeneral", "/web.siradig_codigosgeneral"})
public final  class siradig_codigosgeneral extends GXWebObjectStub
{
   public siradig_codigosgeneral( )
   {
   }

   public siradig_codigosgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( siradig_codigosgeneral.class ));
   }

   public siradig_codigosgeneral( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new siradig_codigosgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new siradig_codigosgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "siradig_codigos General";
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

