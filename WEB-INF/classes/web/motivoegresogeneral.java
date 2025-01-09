package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.motivoegresogeneral", "/web.motivoegresogeneral"})
public final  class motivoegresogeneral extends GXWebObjectStub
{
   public motivoegresogeneral( )
   {
   }

   public motivoegresogeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivoegresogeneral.class ));
   }

   public motivoegresogeneral( int remoteHandle ,
                               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivoegresogeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivoegresogeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Egreso General";
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

