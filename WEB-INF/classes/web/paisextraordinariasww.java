package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.paisextraordinariasww", "/web.paisextraordinariasww"})
public final  class paisextraordinariasww extends GXWebObjectStub
{
   public paisextraordinariasww( )
   {
   }

   public paisextraordinariasww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( paisextraordinariasww.class ));
   }

   public paisextraordinariasww( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new paisextraordinariasww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new paisextraordinariasww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Pais Extraordinarias";
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

