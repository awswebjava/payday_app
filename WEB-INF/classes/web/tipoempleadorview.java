package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoempleadorview", "/web.tipoempleadorview"})
public final  class tipoempleadorview extends GXWebObjectStub
{
   public tipoempleadorview( )
   {
   }

   public tipoempleadorview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoempleadorview.class ));
   }

   public tipoempleadorview( int remoteHandle ,
                             ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoempleadorview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoempleadorview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Empleador View";
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

