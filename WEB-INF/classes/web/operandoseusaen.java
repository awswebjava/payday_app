package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.operandoseusaen", "/web.operandoseusaen"})
public final  class operandoseusaen extends GXWebObjectStub
{
   public operandoseusaen( )
   {
   }

   public operandoseusaen( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( operandoseusaen.class ));
   }

   public operandoseusaen( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new operandoseusaen_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new operandoseusaen_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Operando Se Usa En";
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

