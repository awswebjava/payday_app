package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisbase_calculoww", "/web.paisbase_calculoww"})
public final  class paisbase_calculoww extends GXWebObjectStub
{
   public paisbase_calculoww( )
   {
   }

   public paisbase_calculoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisbase_calculoww.class ));
   }

   public paisbase_calculoww( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisbase_calculoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisbase_calculoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Base de cálculo";
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

