package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoempleadorww", "/web.tipoempleadorww"})
public final  class tipoempleadorww extends GXWebObjectStub
{
   public tipoempleadorww( )
   {
   }

   public tipoempleadorww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoempleadorww.class ));
   }

   public tipoempleadorww( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoempleadorww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoempleadorww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Tipo Empleador";
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

