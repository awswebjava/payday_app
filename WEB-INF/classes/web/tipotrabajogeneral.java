package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipotrabajogeneral", "/web.tipotrabajogeneral"})
public final  class tipotrabajogeneral extends GXWebObjectStub
{
   public tipotrabajogeneral( )
   {
   }

   public tipotrabajogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipotrabajogeneral.class ));
   }

   public tipotrabajogeneral( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipotrabajogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipotrabajogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Trabajo General";
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

