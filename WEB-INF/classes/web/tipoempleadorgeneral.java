package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoempleadorgeneral", "/web.tipoempleadorgeneral"})
public final  class tipoempleadorgeneral extends GXWebObjectStub
{
   public tipoempleadorgeneral( )
   {
   }

   public tipoempleadorgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoempleadorgeneral.class ));
   }

   public tipoempleadorgeneral( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoempleadorgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoempleadorgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Empleador General";
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
