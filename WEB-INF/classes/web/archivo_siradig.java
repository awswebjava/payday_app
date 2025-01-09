package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.archivo_siradig", "/web.archivo_siradig"})
public final  class archivo_siradig extends GXWebObjectStub
{
   public archivo_siradig( )
   {
   }

   public archivo_siradig( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( archivo_siradig.class ));
   }

   public archivo_siradig( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new archivo_siradig_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new archivo_siradig_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "archivo_siradig";
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

