package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.periodos", "/web.periodos"})
public final  class periodos extends GXWebObjectStub
{
   public periodos( )
   {
   }

   public periodos( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( periodos.class ));
   }

   public periodos( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new periodos_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new periodos_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "periodos";
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

