package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.sucursal", "/web.sucursal"})
public final  class sucursal extends GXWebObjectStub
{
   public sucursal( )
   {
   }

   public sucursal( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( sucursal.class ));
   }

   public sucursal( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new sucursal_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new sucursal_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sucursal";
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

