package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sexosww", "/web.sexosww"})
public final  class sexosww extends GXWebObjectStub
{
   public sexosww( )
   {
   }

   public sexosww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sexosww.class ));
   }

   public sexosww( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sexosww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sexosww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Sexos";
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

