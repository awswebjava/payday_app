package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.zona", "/web.zona"})
public final  class zona extends GXWebObjectStub
{
   public zona( )
   {
   }

   public zona( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( zona.class ));
   }

   public zona( int remoteHandle ,
                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new zona_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new zona_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Zona";
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

