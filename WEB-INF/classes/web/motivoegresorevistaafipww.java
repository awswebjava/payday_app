package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.motivoegresorevistaafipww", "/web.motivoegresorevistaafipww"})
public final  class motivoegresorevistaafipww extends GXWebObjectStub
{
   public motivoegresorevistaafipww( )
   {
   }

   public motivoegresorevistaafipww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( motivoegresorevistaafipww.class ));
   }

   public motivoegresorevistaafipww( int remoteHandle ,
                                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new motivoegresorevistaafipww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new motivoegresorevistaafipww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Motivo Egreso Revista Afip";
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

