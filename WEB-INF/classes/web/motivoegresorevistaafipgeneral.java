package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.motivoegresorevistaafipgeneral", "/web.motivoegresorevistaafipgeneral"})
public final  class motivoegresorevistaafipgeneral extends GXWebObjectStub
{
   public motivoegresorevistaafipgeneral( )
   {
   }

   public motivoegresorevistaafipgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivoegresorevistaafipgeneral.class ));
   }

   public motivoegresorevistaafipgeneral( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivoegresorevistaafipgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivoegresorevistaafipgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Motivo Egreso Revista Afip General";
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

