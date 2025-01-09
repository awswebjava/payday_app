package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.obrasocialww", "/web.obrasocialww"})
public final  class obrasocialww extends GXWebObjectStub
{
   public obrasocialww( )
   {
   }

   public obrasocialww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( obrasocialww.class ));
   }

   public obrasocialww( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new obrasocialww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new obrasocialww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Obra Social";
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

