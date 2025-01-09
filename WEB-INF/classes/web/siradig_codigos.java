package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.siradig_codigos", "/web.siradig_codigos"})
public final  class siradig_codigos extends GXWebObjectStub
{
   public siradig_codigos( )
   {
   }

   public siradig_codigos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( siradig_codigos.class ));
   }

   public siradig_codigos( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new siradig_codigos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new siradig_codigos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Códigos Siradig";
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

