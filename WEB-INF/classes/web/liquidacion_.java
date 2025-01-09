package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.liquidacion_", "/web.liquidacion_"})
public final  class liquidacion_ extends GXWebObjectStub
{
   public liquidacion_( )
   {
   }

   public liquidacion_( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( liquidacion_.class ));
   }

   public liquidacion_( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new liquidacion__impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new liquidacion__impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Liquidación";
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

